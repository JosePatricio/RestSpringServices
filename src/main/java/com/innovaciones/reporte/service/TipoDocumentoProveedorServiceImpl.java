/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.TipoDocumentoProveedorDAO;
import com.innovaciones.reporte.model.TipoDocumentoProveedor;
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
@ManagedBean(name = "tipoDocumentoProveedorService")
@ViewScoped
public class TipoDocumentoProveedorServiceImpl implements TipoDocumentoProveedorService, Serializable {

    private TipoDocumentoProveedorDAO tipoDocumentoProveedorDAO;

    public void setTipoDocumentoProveedorDAO(TipoDocumentoProveedorDAO tipoDocumentoProveedorDAO) {
        this.tipoDocumentoProveedorDAO = tipoDocumentoProveedorDAO;
    }

    @Override
    @Transactional
    public TipoDocumentoProveedor addTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor) {
        return tipoDocumentoProveedorDAO.addTipoDocumentoProveedor(tipoDocumentoProveedor);

    }

    @Override
    @Transactional
    public List<TipoDocumentoProveedor> getTipoDocumentoProveedores() {
        return tipoDocumentoProveedorDAO.getTipoDocumentoProveedores();
    }

    @Override
    @Transactional
    public TipoDocumentoProveedor getTipoDocumentoProveedorById(Integer id) {
        return tipoDocumentoProveedorDAO.getTipoDocumentoProveedorById(id);
    }

    @Override
    @Transactional
    public List<TipoDocumentoProveedor> getTipoDocumentoProveedoresByEstado(Integer estado) {
        return tipoDocumentoProveedorDAO.getTipoDocumentoProveedorsByEstado(estado);
    }

    @Override
    @Transactional
    public TipoDocumentoProveedor saveTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor) {
        return tipoDocumentoProveedorDAO.saveTipoDocumentoProveedor(tipoDocumentoProveedor);
    }

}
