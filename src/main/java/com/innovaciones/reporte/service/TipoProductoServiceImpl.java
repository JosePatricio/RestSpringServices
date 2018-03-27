/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.TipoProductoDAO;
import com.innovaciones.reporte.model.TipoProducto;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "tipoProductoService")
@ViewScoped
public class TipoProductoServiceImpl implements TipoProductoService, Serializable {

    private TipoProductoDAO tipoProductoDAO;

    public void setTipoProductoDAO(TipoProductoDAO tipoProductoDAO) {
        this.tipoProductoDAO = tipoProductoDAO;
    }

    @Override
    @Transactional
    public TipoProducto addTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoDAO.addTipoProducto(tipoProducto);

    }

    @Override
    @Transactional
    public List<TipoProducto> getTipoProductos() {
        return tipoProductoDAO.getTipoProductos();
    }

    @Override
    @Transactional
    public TipoProducto getTipoProductoById(Integer id) {
        return tipoProductoDAO.getTipoProductoById(id);
    }

    @Override
    @Transactional
    public TipoProducto getTipoProductoByCodigo(String codigo) {
        return tipoProductoDAO.getTipoProductoByCodigo(codigo);
    }
    
    @Override
    @Transactional
    public TipoProducto getTipoProductoByNombre(String nombre) {
        return tipoProductoDAO.getTipoProductoByNombre(nombre);
    }

    @Override
    @Transactional
    public List<TipoProducto> getTipoProductosByEstado(Integer estado) {
        return tipoProductoDAO.getTipoProductosByEstado(estado);
    }

    @Override
    @Transactional
    public TipoProducto saveTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoDAO.saveTipoProducto(tipoProducto);
    }

//    @Override
//    @Transactional
//    public List<TipoProducto> getTipoProductosLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException {
//        return tipoProductoDAO.getTipoProductosLazy(start, size, sortField, sortOrder, filters);
//    }

}
