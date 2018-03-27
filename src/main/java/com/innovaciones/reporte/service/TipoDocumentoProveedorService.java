/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.TipoDocumentoProveedor;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface TipoDocumentoProveedorService {

    public TipoDocumentoProveedor addTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor);

    public List<TipoDocumentoProveedor> getTipoDocumentoProveedores();

    public TipoDocumentoProveedor getTipoDocumentoProveedorById(Integer id);

    public List<TipoDocumentoProveedor> getTipoDocumentoProveedoresByEstado(Integer estado);
    
    public TipoDocumentoProveedor saveTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor) ;
}
