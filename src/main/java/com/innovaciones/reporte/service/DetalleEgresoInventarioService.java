/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.DetalleEgresoInventario;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface DetalleEgresoInventarioService {

    public DetalleEgresoInventario addDetalleEgresoInventario(DetalleEgresoInventario detalleEgresoInventario);

    public List<DetalleEgresoInventario> getDetalleEgresoInventarios();

    public DetalleEgresoInventario getDetalleEgresoInventarioById(Integer id);

    public DetalleEgresoInventario getDetalleEgresoInventarioByCodigo(String codigo);

    public List<DetalleEgresoInventario> getDetalleEgresoInventariosByEstado(Integer estado);
    
    public List<DetalleEgresoInventario> getDetalleEgresoInventarioByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado);
    
    public List<DetalleEgresoInventario> getDetalleEgresosInventarioByIdClienteSucursal(Integer idClienteSucursal);
    
}
