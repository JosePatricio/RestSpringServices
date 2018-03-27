/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DashboardDAO;
import com.innovaciones.reporte.model.DTO.DashboardDTO;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.innovaciones.reporte.model.DTO.dashboard.ResumenAsignacionesPorTecnicoDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenAsigncaionesPorSucDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenTipoVisitaDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "dashboardService")
@ViewScoped

public class DashboardServiceImpl implements DashboardService, Serializable {

    @Getter
    @Setter
    private DashboardDAO dashboardDAO;

    @Override
    @Transactional
    public List<DashboardDTO> getAsignacionesByMesAnioEstado(Integer mes, Integer anio, String estado) {
        return dashboardDAO.getAsignacionesByMesAnioEstado(mes, anio, estado);
    }

    @Override
    @Transactional
    public List<DashboardDTO> getAsignacionesReportesGroupTecnicoByMesAnioEstado(Integer mes, Integer anio, String estado) {
        return dashboardDAO.getAsignacionesReportesGroupTecnicoByMesAnioEstado(mes, anio, estado);
    }

    @Override
    @Transactional
    public List<ResumenAsignacionesPorTecnicoDTO> getAsignacionesGroupTecnicoByMesAnioEstado(Date fechaInicio, Date fechaFin, String estado) {
        Date fechaInicioMod = setFirstHourOfDay(fechaInicio);
        Date fechaFinMod = setLastHourOfDay(fechaFin);
        return dashboardDAO.getAsignacionesGroupTecnicoByMesAnioEstado(fechaInicioMod, fechaFinMod, estado);
    }

    @Override
    @Transactional
    public List<ResumenTipoVisitaDTO> getCountTipoVisita(Date fechaInicio, Date fechaFin) {
        Date fechaInicioMod = setFirstHourOfDay(fechaInicio);
        Date fechaFinMod = setLastHourOfDay(fechaFin);
        return dashboardDAO.getCountTipoVisita(fechaInicioMod, fechaFinMod);
    }

    @Override
    @Transactional
    public List<ResumenAsigncaionesPorSucDTO> getCountAsignacionesPorSucursal(String estado, Date fechaInicio, Date fechaFin) {
        Date fechaInicioMod = setFirstHourOfDay(fechaInicio);
        Date fechaFinMod = setLastHourOfDay(fechaFin);
        return dashboardDAO.getCountAsignacionesPorSucursal(estado, fechaInicioMod, fechaFinMod);
    }

    private Date setFirstHourOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
        return cal.getTime();
    }

    private Date setLastHourOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        return cal.getTime();
    }


}
