/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoProveedor;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface TipoProveedorDAO {

    public TipoProveedor addTipoProveedor(TipoProveedor tipoProveedor);

    public TipoProveedor saveTipoProveedor(TipoProveedor tipoProveedor);

    public List<TipoProveedor> getTipoProveedores();

    public TipoProveedor getTipoProveedorById(Integer id);

    public List<TipoProveedor> getTipoProveedoresByEstado(Integer estado);
}
