/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.CicloMantenimiento;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface CicloMantenimientoDAO {

    public CicloMantenimiento addCicloMantenimiento(CicloMantenimiento cicloMantenimiento);

    public CicloMantenimiento saveCicloMantenimiento(CicloMantenimiento cicloMantenimiento);

    public List<CicloMantenimiento> getCicloMantenimientos();

    public CicloMantenimiento getCicloMantenimientoById(Integer id);

    public CicloMantenimiento getCicloMantenimientoByCodigo(String codigo);

    public CicloMantenimiento getCicloMantenimientoByCicloIdEquipo(Integer valorCiclo, Integer idEquipo);

    public CicloMantenimiento getCicloMantenimientoByNombre(String nombre);

    public List<CicloMantenimiento> getCicloMantenimientosByEstado(Integer estado);

//    List<CicloMantenimiento> getCicloMantenimientosLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException;
}
