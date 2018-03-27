/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.CabeceraEgreso;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface CabeceraEgresoDAO {

    public CabeceraEgreso addCabeceraEgreso(CabeceraEgreso cabeceraEgreso);

    public List<CabeceraEgreso> getCabeceraEgresos(Integer idBodega, String tipo);

    public CabeceraEgreso getCabeceraEgresoById(Integer id);

    public CabeceraEgreso getCabeceraEgresoByCodigo(String codigo);

    public List<CabeceraEgreso> getCabeceraEgresosByEstado(String tipo, Integer estado);

    public Integer getCountEgresos(String tipo);
    
    public CabeceraEgreso actualizarStockSolicitado(Integer idCabeceraEgreso);
    
    public CabeceraEgreso actualizarStockEgresado(Integer idCabeceraEgreso);
    
    public CabeceraEgreso actualizarStockDevuelto(Integer idCabeceraEgreso);
    
    public CabeceraEgreso actualizarStockSolicitadoEgresado(Integer idCabeceraEgreso);

    //public Integer calcularNumIngresosEgresos(Integer idCabecera);
}
