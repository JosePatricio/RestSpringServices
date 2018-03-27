/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.CicloMantenimiento;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface CicloMantenimientoService {

    public CicloMantenimiento addCicloMantenimiento(CicloMantenimiento cicloMantenimiento);

    public List<CicloMantenimiento> getCicloMantenimientos();

    public CicloMantenimiento getCicloMantenimientoById(Integer id);

    public CicloMantenimiento getCicloMantenimientoByCodigo(String codigo);
    
    public CicloMantenimiento getCicloMantenimientoByCicloIdEquipo(Integer valorCiclo, Integer idEquipo);
    
    public CicloMantenimiento getCicloMantenimientoByNombre(String nombre);

    public List<CicloMantenimiento> getCicloMantenimientosByEstado(Integer estado);
    
    public CicloMantenimiento saveCicloMantenimiento(CicloMantenimiento cicloMantenimiento) ;

//    List<CicloMantenimiento> getCicloMantenimientosLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException;
}
