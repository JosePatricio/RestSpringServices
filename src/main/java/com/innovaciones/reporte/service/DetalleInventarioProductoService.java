/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.DetalleInventarioProducto;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface DetalleInventarioProductoService {

    public DetalleInventarioProducto addDetalleInventarioProducto(DetalleInventarioProducto detalleInventarioProducto);

    public List<DetalleInventarioProducto> getDetalleInventarioProductos();

    public DetalleInventarioProducto getDetalleInventarioProductoById(Integer id);

    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdDetalleInventario(Integer idDetalleInventarioProducto);

    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdDetalleInventario(Integer idDetalleInventarioProducto, Integer estado);

    public List<DetalleInventarioProducto> getDetalleInventarioProductosByEstado(Integer estado);

    public List<DetalleInventarioProducto> getDetalleInventarioProductoByProducto(Integer idBodega, Integer idProducto, Integer estado);

    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado);

    public DetalleInventarioProducto getBySerial(String serial);

    public List<DetalleInventarioProducto> getByIdProductoRepuestoReporte(Integer IdProductoRepuestoReporte);

    public List<DetalleInventarioProducto> getDetalleInventarioByIdBodega(Integer idBodega, Integer estado);
}
