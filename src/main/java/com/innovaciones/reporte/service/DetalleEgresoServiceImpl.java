/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DetalleEgresoDAO;
import com.innovaciones.reporte.model.DetalleEgreso;
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
@ManagedBean(name = "detalleEgresoService")
@ViewScoped
public class DetalleEgresoServiceImpl implements DetalleEgresoService, Serializable {

    private DetalleEgresoDAO detalleInventarioDAO;

    public void setDetalleEgresoDAO(DetalleEgresoDAO detalleInventarioDAO) {
        this.detalleInventarioDAO = detalleInventarioDAO;
    }

    @Override
    @Transactional
    public DetalleEgreso addDetalleEgreso(DetalleEgreso detalleInventario) {
        return detalleInventarioDAO.addDetalleEgreso(detalleInventario);
    }

    @Override
    @Transactional
    public List<DetalleEgreso> getDetalleEgresos() {
        return detalleInventarioDAO.getDetalleEgresos();
    }

    @Override
    @Transactional
    public DetalleEgreso getDetalleEgresoById(Integer id) {
        return detalleInventarioDAO.getDetalleEgresoById(id);
    }

    @Override
    @Transactional
    public DetalleEgreso getDetalleEgresoByCodigo(String codigo) {
        return detalleInventarioDAO.getDetalleEgresoByCodigo(codigo);
    }

    @Override
    @Transactional
    public List<DetalleEgreso> getDetalleEgresosByEstado(Integer estado) {
        return detalleInventarioDAO.getDetalleEgresosByEstado(estado);
    }

    @Override
    @Transactional
    public List<DetalleEgreso> getDetalleEgresoByIdCabeceraEgreso(Integer idCabeceraEgreso) {
        return detalleInventarioDAO.getDetalleEgresoByIdCabeceraEgreso(idCabeceraEgreso);
    }

    @Override
    @Transactional
    public List<DetalleEgreso> getDetalleEgresoByIdCabeceraEgresoEstado(Integer idCabeceraEgreso, Integer estado) {
        return detalleInventarioDAO.getDetalleEgresoByIdCabeceraEgresoEstado(idCabeceraEgreso, estado);
    }
        
}
