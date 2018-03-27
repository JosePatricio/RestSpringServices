/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.TipoProducto;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface TipoProductoService {

    public TipoProducto addTipoProducto(TipoProducto tipoProducto);

    public List<TipoProducto> getTipoProductos();

    public TipoProducto getTipoProductoById(Integer id);

    public TipoProducto getTipoProductoByCodigo(String codigo);
    
    public TipoProducto getTipoProductoByNombre(String nombre);

    public List<TipoProducto> getTipoProductosByEstado(Integer estado);
    
    public TipoProducto saveTipoProducto(TipoProducto tipoProducto) ;

//    List<TipoProducto> getTipoProductosLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException;
}
