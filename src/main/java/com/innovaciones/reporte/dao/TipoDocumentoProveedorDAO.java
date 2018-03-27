/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoDocumentoProveedor;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface TipoDocumentoProveedorDAO {

    public TipoDocumentoProveedor addTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor);

    public TipoDocumentoProveedor saveTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor);

    public List<TipoDocumentoProveedor> getTipoDocumentoProveedores();

    public TipoDocumentoProveedor getTipoDocumentoProveedorById(Integer id);

    public List<TipoDocumentoProveedor> getTipoDocumentoProveedorsByEstado(Integer estado);
}
