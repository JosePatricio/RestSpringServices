/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.CabeceraEgreso;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface CabeceraEgresoService {

    public CabeceraEgreso addCabeceraEgreso(CabeceraEgreso cabeceraEgreso);

    public List<CabeceraEgreso> getCabeceraEgresos(Integer idbodega, String tipo);

    public CabeceraEgreso getCabeceraEgresoById(Integer id);

    public CabeceraEgreso getCabeceraEgresoByCodigo(String codigo);

    public List<CabeceraEgreso> getCabeceraEgresosByEstado(String tipo, Integer estado);

    public String getCountEgresos(String tipo);
    
    public CabeceraEgreso actualizarStockSolicitado(Integer idCabecereaEgreso);
    
    public CabeceraEgreso actualizarStockEgresado(Integer idCabecereaEgreso);
    
    public CabeceraEgreso actualizarStockDevuelto(Integer idCabeceraEgreso);
    
    public CabeceraEgreso actualizarStockSolicitadoEgresado(Integer idCabecereaEgreso);
    

    //public Integer calcularNumIngresosEgresos(Integer idCabecera);
}
