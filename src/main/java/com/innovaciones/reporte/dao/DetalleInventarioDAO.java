/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleInventario;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface DetalleInventarioDAO {

    public DetalleInventario addDetalleInventario(DetalleInventario cabeceraInventario);

    public DetalleInventario saveDetalleInventario(DetalleInventario cabeceraInventario);

    public List<DetalleInventario> getDetalleInventarios();

    public DetalleInventario getDetalleInventarioById(Integer id);

    public DetalleInventario getDetalleInventarioByCodigo(String codigo);

    public List<DetalleInventario> getDetalleInventariosByEstado(Integer estado);
    
    public List<DetalleInventario> getDetalleInventarioByIdCabeceraInventario(Integer idCabeceraInventario);
    
    public List<DetalleInventario> getDetalleInventarioByIdCabeceraInventarioEstado(Integer idCabeceraInventario, Integer estado);
    
    public Integer getCountDetalleByCabecera(Integer idCabecera, Integer estado);
}
