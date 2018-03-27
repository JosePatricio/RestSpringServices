/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model.DTO;

import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Usuarios;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fernando-PC
 */
public class RutasDTO {

    private Usuarios tecnico;
    private Date fechaInicio;

    private List<AsignacionReparacion> asignaciones;

    public Usuarios getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuarios tecnico) {
        this.tecnico = tecnico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<AsignacionReparacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionReparacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
