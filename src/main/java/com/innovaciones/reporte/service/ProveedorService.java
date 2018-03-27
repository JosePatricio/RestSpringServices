/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.Proveedor;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface ProveedorService {

    public Proveedor addProveedor(Proveedor proveedor);

    public List<Proveedor> getProveedores();

    public Proveedor getProveedorById(Integer id);

    public List<Proveedor> getProveedoresByEstado(Integer estado);
    
    public Proveedor saveProveedor(Proveedor proveedor) ;
    
    public List<String> getCiudadesProveedores();
    
    public List<String> getBancosProveedores();
}
