/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DetalleInventarioDAO;
import com.innovaciones.reporte.model.DetalleInventario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fyaulema
 */
@Service
@ManagedBean(name = "detalleInventarioService")
@ViewScoped
public class DetalleInventarioServiceImpl implements DetalleInventarioService, Serializable {

    private DetalleInventarioDAO detalleInventarioDAO;

    public void setDetalleInventarioDAO(DetalleInventarioDAO detalleInventarioDAO) {
        this.detalleInventarioDAO = detalleInventarioDAO;
    }

    @Override
    @Transactional
    public DetalleInventario addDetalleInventario(DetalleInventario detalleInventario) {
        return detalleInventarioDAO.addDetalleInventario(detalleInventario);
    }

    @Override
    @Transactional
    public List<DetalleInventario> getDetalleInventarios() {
        return detalleInventarioDAO.getDetalleInventarios();
    }

    @Override
    @Transactional
    public DetalleInventario getDetalleInventarioById(Integer id) {
        return detalleInventarioDAO.getDetalleInventarioById(id);
    }

    @Override
    @Transactional
    public DetalleInventario getDetalleInventarioByCodigo(String codigo) {
        return detalleInventarioDAO.getDetalleInventarioByCodigo(codigo);
    }

    @Override
    @Transactional
    public List<DetalleInventario> getDetalleInventariosByEstado(Integer estado) {
        return detalleInventarioDAO.getDetalleInventariosByEstado(estado);
    }

    @Override
    @Transactional
    public List<DetalleInventario> getDetalleInventarioByIdCabeceraInventario(Integer idCabeceraInventario) {
        return detalleInventarioDAO.getDetalleInventarioByIdCabeceraInventario(idCabeceraInventario);
    }

    @Override
    @Transactional
    public List<DetalleInventario> getDetalleInventarioByIdCabeceraInventarioEstado(Integer idCabeceraInventario, Integer estado) {
        return detalleInventarioDAO.getDetalleInventarioByIdCabeceraInventarioEstado(idCabeceraInventario, estado);
    }
    
     @Override
    @Transactional
     public Integer getCountDetalleByCabecera(Integer idCabeceraInventario, Integer estado)
     {
         return detalleInventarioDAO.getCountDetalleByCabecera(idCabeceraInventario, estado);
     }

}
