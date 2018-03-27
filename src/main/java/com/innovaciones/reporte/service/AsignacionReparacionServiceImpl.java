/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.AsignacionReparacionDAO;
import com.innovaciones.reporte.model.AsignacionReparacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fernando
 */
@Service
@ManagedBean(name = "asignacionReparacionService")
@ViewScoped
public class AsignacionReparacionServiceImpl implements AsignacionReparacionService, Serializable {

    private AsignacionReparacionDAO asignacionReparacionDAO;

    @Override
    @Transactional
    public AsignacionReparacion addAsignacionReparacion(AsignacionReparacion marca) {
        return asignacionReparacionDAO.addAsignacionReparacion(marca);

    }

    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparaciones() {
        return asignacionReparacionDAO.getAsignacionReparaciones();
    }

    @Override
    @Transactional
    public AsignacionReparacion getAsignacionReparacionById(Integer id) {
        return asignacionReparacionDAO.getAsignacionReparacionById(id);
    }

    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesByEstado(String estado) {
        return asignacionReparacionDAO.getAsignacionReparacionesByEstado(estado);
    }

    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesNoEliminados() {
        return asignacionReparacionDAO.getAsignacionReparacionesNoEliminados();
    }

    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesByFechaByIdUsuario(Date fecha, Integer idUsuario) {
        return asignacionReparacionDAO.getAsignacionReparacionesByFechaByIdUsuario(fecha, idUsuario);
    }

    @Override
    @Transactional
    public AsignacionReparacion getAsignacionReparacionByIdReporte(Integer id) {
        return asignacionReparacionDAO.getAsignacionReparacionByIdReporte(id);
    }

    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparacionesFiltradasByTecnicosFechas(String listIdTecnicos, Date fechaInicioFiltro, Date fechaFinFiltro, boolean preasignacion) {
        return asignacionReparacionDAO.getAsignacionReparacionesFiltradasByTecnicosFechas(listIdTecnicos, fechaInicioFiltro, fechaFinFiltro, preasignacion);
    }

    @Override
    @Transactional
    public List<AsignacionReparacion> buscarAsignacionesPorFechas(Date fechaInicio, Date fechaFin, String estado) {
        return asignacionReparacionDAO.buscarAsignacionesPorFechas(fechaInicio, fechaFin, estado);
    }

    @Override
    @Transactional
    public List<AsignacionReparacion> getAsignacionReparaciones(int rows, int idCliente) {
        return asignacionReparacionDAO.getAsignacionReparaciones(rows, idCliente);
    }


    public AsignacionReparacionDAO getAsignacionReparacionDAO() {
        return asignacionReparacionDAO;
    }

    public void setAsignacionReparacionDAO(AsignacionReparacionDAO asignacionReparacionDAO) {
        this.asignacionReparacionDAO = asignacionReparacionDAO;
    }

}
