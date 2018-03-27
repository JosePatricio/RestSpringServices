/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.ProductoRepuestoReporte;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ProductoRepuestoReporteService {

    public ProductoRepuestoReporte add(ProductoRepuestoReporte producto);

    public List<ProductoRepuestoReporte> getAll();

    public ProductoRepuestoReporte getById(Integer id);

    public List<ProductoRepuestoReporte> getProductosRepuestoByIdProducto(Integer idProducto);

    public List<ProductoRepuestoReporte> getProductosRepuestoByIdProductoEstado(Integer idProducto, Integer estado);

    public ProductoRepuestoReporte getByIdProductoByIdRepuesto(Integer idProducto, Integer idRepuesto);

    public List<ProductoRepuestoReporte> getByIdDetalleCatalogoReporteByIdModelo(Integer id,Integer idProducto);

    public List<ProductoRepuestoReporte> getByEstado(boolean estado);

    public List<ProductoRepuestoReporte> getOtrosByModeloByEstado(Integer idModelo,Integer estado);
    
    public ProductoRepuestoReporte getProductoRepuestoByIdProducto(Integer idProducto);
}
