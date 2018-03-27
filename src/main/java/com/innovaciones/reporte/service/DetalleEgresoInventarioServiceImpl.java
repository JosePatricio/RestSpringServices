/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DetalleEgresoInventarioDAO;
import com.innovaciones.reporte.model.DetalleEgresoInventario;
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
@ManagedBean(name = "detalleEgresoInventarioService")
@ViewScoped
public class DetalleEgresoInventarioServiceImpl implements DetalleEgresoInventarioService, Serializable {

    private DetalleEgresoInventarioDAO detalleEgresoInventarioDAO;

    public void setDetalleEgresoInventarioDAO(DetalleEgresoInventarioDAO detalleEgresoInventarioDAO) {
        this.detalleEgresoInventarioDAO = detalleEgresoInventarioDAO;
    }

    @Override
    @Transactional
    public DetalleEgresoInventario addDetalleEgresoInventario(DetalleEgresoInventario detalleEgresoInventario) {
        return detalleEgresoInventarioDAO.addDetalleEgresoInventario(detalleEgresoInventario);

    }

    @Override
    @Transactional
    public List<DetalleEgresoInventario> getDetalleEgresoInventarios() {
        return detalleEgresoInventarioDAO.getDetalleEgresoInventarios();
    }

    @Override
    @Transactional
    public DetalleEgresoInventario getDetalleEgresoInventarioById(Integer id) {
        return detalleEgresoInventarioDAO.getDetalleEgresoInventarioById(id);
    }

    @Override
    @Transactional
    public DetalleEgresoInventario getDetalleEgresoInventarioByCodigo(String codigo) {
        return detalleEgresoInventarioDAO.getDetalleEgresoInventarioByCodigo(codigo);
    }

    @Override
    @Transactional
    public List<DetalleEgresoInventario> getDetalleEgresoInventariosByEstado(Integer estado) {
        return detalleEgresoInventarioDAO.getDetalleEgresoInventariosByEstado(estado);
    }

    @Override
    @Transactional
    public List<DetalleEgresoInventario> getDetalleEgresoInventarioByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado) {
        return detalleEgresoInventarioDAO.getDetalleEgresoInventarioByIdCabeceraEgreso(idCabeceraEgreso, estado);
    }

    @Override
    @Transactional
    public List<DetalleEgresoInventario> getDetalleEgresosInventarioByIdClienteSucursal(Integer idClienteSucursal) {
        return detalleEgresoInventarioDAO.getDetalleEgresosInventarioByIdClienteSucursal(idClienteSucursal);
    }

}
