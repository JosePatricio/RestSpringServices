/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Reporte;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ReporteDAO {

    public Reporte saveReporte(Reporte reporte);

    public Reporte updateReporte(Reporte reporte);

    public Reporte getReporteById(Integer idReporte);

    public List<Reporte> getReporteByUserByTipo(Integer idUsuario, String tipo, String subtipo);
}
