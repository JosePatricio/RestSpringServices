/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ProveedorDAO;
import com.innovaciones.reporte.model.Proveedor;
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
@ManagedBean(name = "proveedorService")
@ViewScoped
public class ProveedorServiceImpl implements ProveedorService, Serializable {

    private ProveedorDAO proveedorDAO;

    public void setProveedorDAO(ProveedorDAO proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }

    @Override
    @Transactional
    public Proveedor addProveedor(Proveedor proveedor) {
        return proveedorDAO.addProveedor(proveedor);

    }

    @Override
    @Transactional
    public List<Proveedor> getProveedores() {
        return proveedorDAO.getProveedores();
    }

    @Override
    @Transactional
    public Proveedor getProveedorById(Integer id) {
        return proveedorDAO.getProveedorById(id);
    }

    @Override
    @Transactional
    public List<Proveedor> getProveedoresByEstado(Integer estado) {
        return proveedorDAO.getProveedoresByEstado(estado);
    }

    @Override
    @Transactional
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorDAO.saveProveedor(proveedor);
    }

    @Override
    @Transactional
    public List<String> getCiudadesProveedores() {
        return proveedorDAO.getCiudadesProveedores();
    }

    @Override
    @Transactional
    public List<String> getBancosProveedores() {
        return proveedorDAO.getBancosProveedores();
    }

}
