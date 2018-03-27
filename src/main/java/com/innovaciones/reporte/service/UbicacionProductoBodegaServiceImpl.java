/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.*;
import com.innovaciones.reporte.model.UbicacionProductoBodega;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fyaulema
 */
@Service
@ManagedBean(name = "ubicacionProductoBodegaService")
@ViewScoped
public class UbicacionProductoBodegaServiceImpl implements UbicacionProductoBodegaService, Serializable {

    private UbicacionProductoBodegaDAO ubicacionProductoBodegaDAO;

    public void setUbicacionProductoBodegaDAO(UbicacionProductoBodegaDAO ubicacionProductoBodegaDAO) {
        this.ubicacionProductoBodegaDAO = ubicacionProductoBodegaDAO;
    }

    @Override
    @Transactional
    public UbicacionProductoBodega addUbicacionProducto(UbicacionProductoBodega ubicacionProductoBodega) {
        return ubicacionProductoBodegaDAO.addUbicacionProducto(ubicacionProductoBodega);

    }

    @Override
    @Transactional
    public UbicacionProductoBodega saveUbicacionProducto(UbicacionProductoBodega ubicacionProductoBodega) {
        return ubicacionProductoBodegaDAO.saveUbicacionProducto(ubicacionProductoBodega);
    }

    @Override
    @Transactional
    public List<UbicacionProductoBodega> getUbicacionesProducto() {
        return ubicacionProductoBodegaDAO.getUbicacionesProducto();
    }

    @Override
    @Transactional
    public UbicacionProductoBodega getUbicacionProductoById(Integer id) {
        return ubicacionProductoBodegaDAO.getUbicacionProductoById(id);
    }

    @Override
    @Transactional
    public List<UbicacionProductoBodega> getUbicacionesProductoByIdProducto(Integer idProducto) {
        return ubicacionProductoBodegaDAO.getUbicacionesProductoByIdProducto(idProducto);
    }

    @Override
    @Transactional
    public List<UbicacionProductoBodega> getUbicacionesProductoByIdBodega(Integer idBodega) {
        return ubicacionProductoBodegaDAO.getUbicacionesProductoByIdBodega(idBodega);
    }

    @Override
    @Transactional
    public List<UbicacionProductoBodega> getUbicacionesProductoByIdBodegaIdProducto(Integer idBodega, Integer idProducto, Integer estado) {
        return ubicacionProductoBodegaDAO.getUbicacionesProductoByIdBodegaIdProducto(idBodega, idProducto, estado);
    }

    @Override
    @Transactional
    public List<UbicacionProductoBodega> getUbicacionesProductoByEstado(Integer estado) {
        return ubicacionProductoBodegaDAO.getUbicacionesProductoByEstado(estado);
    }

//    @Override
//    @Transactional
//    public List<UbicacionProductoBodega> getUbicacionProductoBodegasLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException {
//        return ubicacionProductoBodegaDAO.getUbicacionProductoBodegasLazy(start, size, sortField, sortOrder, filters);
//    }
}
