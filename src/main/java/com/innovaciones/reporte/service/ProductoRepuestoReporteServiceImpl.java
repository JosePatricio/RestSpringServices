/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ProductoRepuestoReporteDAO;
import com.innovaciones.reporte.model.ProductoRepuestoReporte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "productoRepuestoReporteService")
@ViewScoped
public class ProductoRepuestoReporteServiceImpl implements ProductoRepuestoReporteService, Serializable {

    @Setter
    private ProductoRepuestoReporteDAO productoRepuestoReporteDAO;

    @Getter
    @Setter
    @ManagedProperty("#{detalleInventarioProductoService}")
    private DetalleInventarioProductoService detalleInventarioProductoService;

    @Override
    @Transactional
    public ProductoRepuestoReporte add(ProductoRepuestoReporte productoModelo) {
        return productoRepuestoReporteDAO.add(productoModelo);
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getAll() {
        return productoRepuestoReporteDAO.getAll();
    }

    @Override
    @Transactional
    public ProductoRepuestoReporte getById(Integer id) {
        return productoRepuestoReporteDAO.getById(id);
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getProductosRepuestoByIdProducto(Integer idProducto) {
        return productoRepuestoReporteDAO.getProductosRepuestoByIdProducto(idProducto);
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getProductosRepuestoByIdProductoEstado(Integer idProducto, Integer estado) {
        return productoRepuestoReporteDAO.getProductosRepuestoByIdProductoEstado(idProducto, estado);
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getByEstado(boolean estado) {
        return productoRepuestoReporteDAO.getByEstado(estado);
    }

    @Override
    @Transactional
    public ProductoRepuestoReporte getByIdProductoByIdRepuesto(Integer idProducto, Integer idRepuesto) {
        return productoRepuestoReporteDAO.getByIdProductoByIdRepuesto(idProducto, idRepuesto);
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getByIdDetalleCatalogoReporteByIdModelo(Integer id, Integer IdModelo) {
       
        System.out.println("getByIdDetalleCatalogoReporteByIdModelo  ID DETALLE " + id + " , idmodelo " + IdModelo);
        List<ProductoRepuestoReporte> list = productoRepuestoReporteDAO.getByIdDetalleCatalogoReporteByIdModelo(id, IdModelo);
        List<ProductoRepuestoReporte> result = new ArrayList<>();
        list.forEach((ProductoRepuestoReporte pr) -> {
            ProductoRepuestoReporte newProductoRepuestoReporte = new ProductoRepuestoReporte();
            newProductoRepuestoReporte = pr;
            newProductoRepuestoReporte.setStock(detalleInventarioProductoService.getByIdProductoRepuestoReporte(newProductoRepuestoReporte.getId()).size());
            result.add(pr);
        });
        System.out.println("TAMANIO DE LISTA  "+result.size());
        return result;
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getOtrosByModeloByEstado(Integer idModelo, Integer estado) {
        return productoRepuestoReporteDAO.getOtrosByModeloByIdDetalleCatalogoByEstado(idModelo, estado);
    }

    @Override
    @Transactional
    public ProductoRepuestoReporte getProductoRepuestoByIdProducto(Integer idProducto) {
        return productoRepuestoReporteDAO.getProductoRepuestoByIdProducto(idProducto);
    }

}
