/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleCicloMantenimiento;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface DetalleCicloDAO {

    public DetalleCicloMantenimiento addDetalleCiclo(DetalleCicloMantenimiento comboMantenimiento);

    public DetalleCicloMantenimiento getDetalleCicloByIdCicloIdProducto(Integer idCiclo, Integer idProducto);
    
    public List<DetalleCicloMantenimiento> getDetallesCicloByIdCiclo(Integer id, Integer estado);
    
    public List<DetalleCicloMantenimiento> getDetalleCiclosByEstado(Integer estado);

//    List<DetalleCiclo> getDetalleCiclosLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException;
}
