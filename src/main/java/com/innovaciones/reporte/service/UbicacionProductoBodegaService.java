/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.UbicacionProductoBodega;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface UbicacionProductoBodegaService {

    public UbicacionProductoBodega addUbicacionProducto(UbicacionProductoBodega ubicacionProductoBodega);

    public UbicacionProductoBodega saveUbicacionProducto(UbicacionProductoBodega ubicacionProductoBodega);

    public List<UbicacionProductoBodega> getUbicacionesProducto();

    public UbicacionProductoBodega getUbicacionProductoById(Integer id);

    public List<UbicacionProductoBodega> getUbicacionesProductoByIdProducto(Integer idProducto);

    public List<UbicacionProductoBodega> getUbicacionesProductoByIdBodega(Integer idBodega);

    public List<UbicacionProductoBodega> getUbicacionesProductoByIdBodegaIdProducto(Integer idBodega, Integer idProducto, Integer estado);

    public List<UbicacionProductoBodega> getUbicacionesProductoByEstado(Integer estado);

//    List<UbicacionProductoBodega> getUbicacionProductoBodegasLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException;
}
