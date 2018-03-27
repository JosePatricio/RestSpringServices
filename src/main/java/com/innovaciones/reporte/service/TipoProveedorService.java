/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.TipoProveedor;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface TipoProveedorService {

    public TipoProveedor addTipoProveedor(TipoProveedor tipoProveedor);

    public List<TipoProveedor> getTipoProveedores();

    public TipoProveedor getTipoProveedorById(Integer id);

    public List<TipoProveedor> getTipoProveedoresByEstado(Integer estado);
    
    public TipoProveedor saveTipoProveedor(TipoProveedor tipoProveedor) ;
}
