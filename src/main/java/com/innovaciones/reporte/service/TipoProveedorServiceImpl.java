/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.TipoProveedorDAO;
import com.innovaciones.reporte.model.TipoProveedor;
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
@ManagedBean(name = "tipoProveedorService")
@ViewScoped
public class TipoProveedorServiceImpl implements TipoProveedorService, Serializable {

    private TipoProveedorDAO tipoProveedorDAO;

    public void setTipoProveedorDAO(TipoProveedorDAO tipoProveedorDAO) {
        this.tipoProveedorDAO = tipoProveedorDAO;
    }

    @Override
    @Transactional
    public TipoProveedor addTipoProveedor(TipoProveedor tipoProveedor) {
        return tipoProveedorDAO.addTipoProveedor(tipoProveedor);

    }

    @Override
    @Transactional
    public List<TipoProveedor> getTipoProveedores() {
        return tipoProveedorDAO.getTipoProveedores();
    }

    @Override
    @Transactional
    public TipoProveedor getTipoProveedorById(Integer id) {
        return tipoProveedorDAO.getTipoProveedorById(id);
    }

    @Override
    @Transactional
    public List<TipoProveedor> getTipoProveedoresByEstado(Integer estado) {
        return tipoProveedorDAO.getTipoProveedoresByEstado(estado);
    }

    @Override
    @Transactional
    public TipoProveedor saveTipoProveedor(TipoProveedor tipoProveedor) {
        return tipoProveedorDAO.saveTipoProveedor(tipoProveedor);
    }

}
