/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.DashboardDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenAsignacionesPorTecnicoDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenAsigncaionesPorSucDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenTipoVisitaDTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface DashboardDAO {

    public List<DashboardDTO> getAsignacionesByMesAnioEstado(Integer mes, Integer anio, String estado);

    public List<DashboardDTO> getAsignacionesReportesGroupTecnicoByMesAnioEstado(Integer mes, Integer anio, String estado);
    
    public List<ResumenAsignacionesPorTecnicoDTO> getAsignacionesGroupTecnicoByMesAnioEstado(Date fechaInicio, Date fechaFin, String estado);

    List<ResumenTipoVisitaDTO> getCountTipoVisita(Date fechaInicio, Date fechaFin);

    List<ResumenAsigncaionesPorSucDTO> getCountAsignacionesPorSucursal(String estado, Date fechaInicio, Date fechaFin);
}
