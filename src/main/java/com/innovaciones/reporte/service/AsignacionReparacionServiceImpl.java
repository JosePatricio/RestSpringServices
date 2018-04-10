/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovaciones.reporte.dao.AsignacionReparacionDAO;
import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.model.ClienteSucursal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

/**
 *
 * @author Fernando
 */
@Service
@ManagedBean(name = "asignacionReparacionService")
@ViewScoped
public class AsignacionReparacionServiceImpl implements AsignacionReparacionService, Serializable {
    
    private AsignacionReparacionDAO asignacionReparacionDAO;
    
    @Getter
    @Setter
    @ManagedProperty("#{parametrosService}")
    private ParametrosService parametrosService;
    
    @Override
    @Transactional
    public AsignacionReparacion addAsignacionReparacion(AsignacionReparacion marca) {
        return asignacionReparacionDAO.addAsignacionReparacion(marca);
        
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparaciones() {
        return asignacionReparacionDAO.getAsignacionReparaciones();
    }
    
    @Override
    @Transactional
    public AsignacionReparacion getAsignacionReparacionById(Integer id) {
        return asignacionReparacionDAO.getAsignacionReparacionById(id);
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesByEstado(String estado) {
        return asignacionReparacionDAO.getAsignacionReparacionesByEstado(estado);
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesNoEliminados() {
        return asignacionReparacionDAO.getAsignacionReparacionesNoEliminados();
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesByFechaByIdUsuario(Date fecha, Integer idUsuario) {
        return asignacionReparacionDAO.getAsignacionReparacionesByFechaByIdUsuario(fecha, idUsuario);
    }
    
    @Override
    @Transactional
    public AsignacionReparacion getAsignacionReparacionByIdReporte(Integer id) {
        return asignacionReparacionDAO.getAsignacionReparacionByIdReporte(id);
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesFiltradasByTecnicosFechas(String listIdTecnicos, Date fechaInicioFiltro, Date fechaFinFiltro, boolean preasignacion) {
        return asignacionReparacionDAO.getAsignacionReparacionesFiltradasByTecnicosFechas(listIdTecnicos, fechaInicioFiltro, fechaFinFiltro, preasignacion);
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> buscarAsignacionesPorFechas(Date fechaInicio, Date fechaFin, String estado) {
        return asignacionReparacionDAO.buscarAsignacionesPorFechas(fechaInicio, fechaFin, estado);
    }
    
    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparaciones(int rows, int idCliente) {
        return asignacionReparacionDAO.getAsignacionReparaciones(rows, idCliente);
    }
    
    public AsignacionReparacionDAO getAsignacionReparacionDAO() {
        return asignacionReparacionDAO;
    }
    
    public void setAsignacionReparacionDAO(AsignacionReparacionDAO asignacionReparacionDAO) {
        this.asignacionReparacionDAO = asignacionReparacionDAO;
    }
    
    public boolean enviarNotificacion(AsignacionReparacion as) {
        try {
            
            String DEVICE_ID = parametrosService.getByParametro("DEVICE_ID_FIREBASE").getValor();
            String AUTH_KEY_FCM = parametrosService.getByParametro("AUTH_KEY_FCM").getValor();
            String FMCurl = "https://fcm.googleapis.com/fcm/send";
            
            AsignacionReparacion reparacion = new AsignacionReparacion();
            reparacion.setId(as.getId());
            
            Cliente cliente = new Cliente();
            cliente.setId(as.getIdClienteSucursal().getIdCliente().getId());
            cliente.setCiudad(as.getIdClienteSucursal().getIdCliente().getCiudad());
            cliente.setTelefono(as.getIdClienteSucursal().getIdCliente().getTelefono());
            cliente.setTelefono2(as.getIdClienteSucursal().getIdCliente().getTelefono2());
            cliente.setDireccion(as.getIdClienteSucursal().getDireccion());
            cliente.setRuc(as.getIdClienteSucursal().getIdCliente().getRuc());
            cliente.setCliente(as.getIdClienteSucursal().getIdCliente().getCliente());
            cliente.setEmail(as.getIdClienteSucursal().getIdCliente().getEmail());
            
            ClienteSucursal clienteSucursal = new ClienteSucursal();
            clienteSucursal.setId(as.getIdClienteSucursal().getId());
            
            clienteSucursal.setIdCliente(cliente);
            
            reparacion.setProducto(as.getProducto());
            reparacion.setIdClienteSucursal(clienteSucursal);
            
            reparacion.setIdTipoVisita(as.getIdTipoVisita());
            reparacion.setTipoNotificacion(as.getTipoNotificacion());
            reparacion.setSerial(as.getSerial());
            reparacion.setTipoReporte(as.getTipoReporte());
            reparacion.setEstado(as.getEstado());
            reparacion.setPrioridad(as.getPrioridad());
            reparacion.setFechaInicioAtencion(as.getFechaInicioAtencion());
            reparacion.setFechaFinAtencion(as.getFechaFinAtencion());
            reparacion.setHoraInicioAtencion(as.getHoraInicioAtencion());
            reparacion.setHoraFinAtencion(as.getHoraFinAtencion());
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonNotification = mapper.writeValueAsString(reparacion);
            
            System.out.println("OBJECTO " + jsonNotification);
            
            URL url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
            conn.setRequestProperty("Content-Type", "application/json");
            
            JSONObject data = new JSONObject();
            data.put("to", DEVICE_ID.trim());
            JSONObject info = new JSONObject();
            info.put("jsonNotification", jsonNotification); // Notification body

            data.put("data", info);
            // System.out.println(data.toString());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data.toString());
            wr.flush();
            wr.close();
            
            int responseCode = conn.getResponseCode();
            // System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Response: " + response); // <= ADD THIS

            mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.toString());
            String valor = root.path("success").asText().trim();
            
            return ("1".equals(valor));
            
        } catch (Exception e) {
            System.out.println("EL ERROR ESS " + e.getMessage());
        }
        
        return false;
    }
    
}
