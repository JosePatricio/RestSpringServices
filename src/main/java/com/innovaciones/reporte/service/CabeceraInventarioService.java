/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.CabeceraInventario;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface CabeceraInventarioService {

    public CabeceraInventario addCabeceraInventario(CabeceraInventario cabeceraInventario);

    public List<CabeceraInventario> getCabeceraInventarios(Integer idBodega);

    public CabeceraInventario getCabeceraInventarioById(Integer id);

    public CabeceraInventario getCabeceraInventarioByCodigo(String codigo);

    public List<CabeceraInventario> getCabeceraInventariosByEstado(Integer idBodega, Integer estado);
    
     public String getCountInventarios();
}
