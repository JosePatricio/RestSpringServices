/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model.DTO;

import java.io.Serializable;

/**
 *
 * @author fyaulema
 */
public class DashboardDTO implements Serializable {

    private Integer idUsuario;
    private String nombre;
    private Integer count;
    private String estado;
    private Integer dia;
    private Integer mesNumero;
    private String mesNombre;
    private Integer anio;
    private String tipoReporte;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMesNumero() {
        return mesNumero;
    }

    public void setMesNumero(Integer mesNumero) {
        this.mesNumero = mesNumero;
    }

    public String getMesNombre() {
        return mesNombre;
    }

    public void setMesNombre(String mesNombre) {
        this.mesNombre = mesNombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    @Override
    public String toString() {
        return "DashboardDTO{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", count=" + count + ", estado=" + estado + ", dia=" + dia + ", mesNumero=" + mesNumero + ", mesNombre=" + mesNombre + ", anio=" + anio + ", tipoReporte=" + tipoReporte + '}';
    }

}
