/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.DTO.ProductoDTO;
import com.innovaciones.reporte.model.Producto;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface ProductoService {

    public Producto addProducto(Producto producto);

    public List<ProductoDTO> getProductosDTOStockByEstado(Integer idBodega, Integer estado);

    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado);
    
    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado);

    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado);

    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado);

    public List<Producto> getProductosHijosByIdPadre(Integer idPadre);

    public List<Producto> getProductosHijosByIdAncestro(Integer idAncestro);
    
    public List<Producto> getOnlyProductos();

    public List<Producto> getOnlyProductosByCodigoCategoria(String codigoCategoria);

    public Producto getProductoById(Integer id);

    public List<Producto> getProductosByEstado(Integer estado);

    public List<Producto> getProductos();

    public List<Producto> getProductosCompatiblesByIdPadre(Integer idPadre, Integer estado);

    public Producto getProductoByCodigoFabricante(String codigo);

    public Producto getProductoBySerial(String serial);
}
