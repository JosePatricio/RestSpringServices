/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ReporteGenericoItems;
import com.innovaciones.reporte.model.ReporteMantenimiento;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ReporteGenericoItemsDAO {

    public ReporteGenericoItems save(ReporteGenericoItems reporteGenericoItem);

    public ReporteGenericoItems update(ReporteGenericoItems reporteGenericoItem);

    public void eliminar(ReporteGenericoItems reporteGenericoItem);

    public List<ReporteMantenimiento> getReporteMantenimientoByReporteId(Integer id);
    


}
