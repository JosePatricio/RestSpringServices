/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.ProductoDTO;
import com.innovaciones.reporte.model.Producto;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface ProductoDAO {

    public Producto addProducto(Producto producto);

    public List<ProductoDTO> getProductosDTOStockByEstado(Integer idBodega, Integer estado);

    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado);
    
    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado);
    
    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado);
    
     public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado);

    public List<Producto> getProductosByEstado(Integer estado);

    public Producto getProductoById(Integer idPadre);

    public Producto getProductoByCodigoFabricante(String codigo);

    public List<Producto> getProductos();

    public List<Producto> getProductosCompatiblesByIdPadre(Integer idPadre, Integer estado);

    public List<Producto> getProductosHijosByIdPadre(Integer idPadre);

    public List<Producto> getProductosHijosByIdAncestro(Integer idAncestro);

    public List<Producto> getOnlyProductos();
    
    public List<Producto> getOnlyProductosByCodigoCategoria(String codigoCategoria);
    
    public Producto getProductoBySerial(String serial);

}
