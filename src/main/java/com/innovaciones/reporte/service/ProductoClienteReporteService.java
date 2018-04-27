/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.ProductoClienteReporte;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ProductoClienteReporteService {

    public ProductoClienteReporte saveOrUpdateProductoClienteReporte(ProductoClienteReporte productoClienteReporte);

    public ProductoClienteReporte save(ProductoClienteReporte productoClienteReporte);

    public ProductoClienteReporte update(ProductoClienteReporte productoClienteReporte);

    public ProductoClienteReporte getByReportId(Integer ids);

    public ProductoClienteReporte getByUsuarioRuc(String ruc);

    public List<ProductoClienteReporte> getBySerial(String serial);

    public ProductoClienteReporte getByIdProductoCliente(Integer idProductoCliente);

    public List<ProductoClienteReporte> getByTipoReporte(String tipo);
}
