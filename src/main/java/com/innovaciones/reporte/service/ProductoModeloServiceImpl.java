/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ProductoModeloDAO;
import com.innovaciones.reporte.model.ProductoModelo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "productoModeloService")
@ViewScoped
public class ProductoModeloServiceImpl implements ProductoModeloService, Serializable {

    @Setter
    private ProductoModeloDAO productoModeloDAO;

    @Override
    @Transactional
    public ProductoModelo add(ProductoModelo productoModelo) {
        return productoModeloDAO.add(productoModelo);
    }

    @Override
    @Transactional
    public List<ProductoModelo> add(List<ProductoModelo> productoModelos) {
        return productoModeloDAO.add(productoModelos);
    }

    @Override
    @Transactional
    public List<ProductoModelo> getModelosByIdProducto(Integer idProducto) {
        return productoModeloDAO.getModelosByIdProducto(idProducto);
    }

    @Override
    @Transactional
    public List<ProductoModelo> getModelosByIdProductoEstado(Integer idProducto, Integer estado) {
        return productoModeloDAO.getModelosByIdProductoEstado(idProducto, estado);
    }

    @Override
    @Transactional
    public List<ProductoModelo> getByEstado(Integer estado) {
        return productoModeloDAO.getByEstado(estado);
    }

//    @Override
//    @Transactional
//    public List<ProductoModelo> getAll() {
//        return productoModeloDAO.getAll();
//    }
//
//    @Override
//    @Transactional
//    public ProductoModelo getById(Integer id) {
//        return productoModeloDAO.getById(id);
//    }
//
    @Override
    @Transactional
    public ProductoModelo getByIdProductoByIdModelo(Integer idProducto, Integer idModelo) {
        return productoModeloDAO.getByIdProductoByIdModelo(idProducto, idModelo);
    }
}
