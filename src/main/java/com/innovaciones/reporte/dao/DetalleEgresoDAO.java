/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleEgreso;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface DetalleEgresoDAO {

    public DetalleEgreso addDetalleEgreso(DetalleEgreso detalleEgreso);

    public List<DetalleEgreso> getDetalleEgresos();

    public DetalleEgreso getDetalleEgresoById(Integer id);

    public DetalleEgreso getDetalleEgresoByCodigo(String codigo);

    public List<DetalleEgreso> getDetalleEgresosByEstado(Integer estado);
    
    public List<DetalleEgreso> getDetalleEgresoByIdCabeceraEgreso(Integer idCabeceraEgreso);
    
    public List<DetalleEgreso> getDetalleEgresoByIdCabeceraEgresoEstado(Integer idCabeceraEgreso, Integer estado);
    
}
