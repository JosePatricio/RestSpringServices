/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ReporteMantenimiento;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ReporteMantenimientoDAO {

    public ReporteMantenimiento save(ReporteMantenimiento reporteMantenimiento);

    public ReporteMantenimiento update(ReporteMantenimiento reporteMantenimiento);

     public ReporteMantenimiento saveOrUpdate(ReporteMantenimiento reporteMantenimiento);
     
    public void eliminar(ReporteMantenimiento reporteMantenimiento);

    public void removeReporteMantenimiento(ReporteMantenimiento reporteMantenimiento);

    public List<ReporteMantenimiento> getReporteMantenimientoByReporteId(Integer id);

    public List<ReporteMantenimiento> getReporteMantenimientoByDetalleCatalogoId(Integer id);

}
