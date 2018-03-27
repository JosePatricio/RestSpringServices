/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model.DTO;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Fernando
 */
public class NotificacionDTO implements Serializable {

    @Getter
    @Setter
    private Integer count;
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String fechaInicio;
    @Getter
    @Setter
    private String horaInicio;
    @Getter
    @Setter
    private String fechaFin;
    @Getter
    @Setter
    private String horaFin;
    @Getter
    @Setter
    private String tecnico;
    @Getter
    @Setter
    private String cliente;
    @Getter
    @Setter
    private String tipoReporte;
    @Getter
    @Setter
    private String estadoNotificacion;
    @Getter
    @Setter
    private Integer prioridad;
    @Getter
    @Setter
    private String tipoNotificacion;
    @Getter
    @Setter
    private Integer idCliente;
    @Getter
    @Setter
    private Integer idClienteProducto;
    @Getter
    @Setter
    private Integer idTecnico;
    @Getter
    @Setter
    private Integer idReporte;
    @Getter
    @Setter
    private String tipoEquipo;
    @Getter
    @Setter
    private Integer idClienteSucursal;
    @Getter
    @Setter
    private String nombreSucursal;
    @Getter
    @Setter
    private String direccionSucursal;
    @Getter
    @Setter
    private String nombreContacto;
    @Getter
    @Setter
    private String celularContacto;
    @Getter
    @Setter
    private Integer idTipoVisita;
    @Getter
    @Setter
    private String tipoVisita;

    @Override
    public String toString() {
        return "NotificacionDTO{" + "count=" + count + ", id=" + id + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", fechaFin=" + fechaFin + ", horaFin=" + horaFin + ", tecnico=" + tecnico + ", cliente=" + cliente + ", tipoReporte=" + tipoReporte + ", estadoNotificacion=" + estadoNotificacion + ", prioridad=" + prioridad + ", tipoNotificacion=" + tipoNotificacion + ", idCliente=" + idCliente + ", idClienteProducto=" + idClienteProducto + ", idTecnico=" + idTecnico + ", idReporte=" + idReporte + ", tipoEquipo=" + tipoEquipo + '}';
    }

}
