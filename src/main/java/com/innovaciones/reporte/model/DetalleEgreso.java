/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.innovaciones.reporte.util.InicioGarantia;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author fyaulema
 */
@Entity
@Table(name = "detalle_egreso")
public class DetalleEgreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo", precision = 22)
    private Double costo;
    @Basic(optional = false)
    @Column(name = "total", nullable = false)
    private double total;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private Integer estado;
    @JoinColumn(name = "id_cabecera_egreso", referencedColumnName = "id")
    @ManyToOne
    private CabeceraEgreso idCabeceraEgreso;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "garantia", referencedColumnName = "id")
    @ManyToOne
    private Garantia garantia;
    @Column(name = "inicio_garantia")
    private InicioGarantia inicioGarantia;
    @Column(name = "fecha_personalizada")
    private Date fechaPersonalizada;
    @Column(name = "visitas_soporte")
    private Integer visitasSoporte;

    public DetalleEgreso() {
    }

    public DetalleEgreso(Integer id) {
        this.id = id;
    }

    public DetalleEgreso(Integer id, int cantidad, double total, Integer estado) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public CabeceraEgreso getIdCabeceraEgreso() {
        return idCabeceraEgreso;
    }

    public void setIdCabeceraEgreso(CabeceraEgreso idCabeceraEgreso) {
        this.idCabeceraEgreso = idCabeceraEgreso;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public InicioGarantia getInicioGarantia() {
        return inicioGarantia;
    }

    public void setInicioGarantia(InicioGarantia inicioGarantia) {
        this.inicioGarantia = inicioGarantia;
    }

    public Date getFechaPersonalizada() {
        return fechaPersonalizada;
    }

    public void setFechaPersonalizada(Date fechaPersonalizada) {
        this.fechaPersonalizada = fechaPersonalizada;
    }

    public Integer getVisitasSoporte() {
        return visitasSoporte;
    }

    public void setVisitasSoporte(Integer visitasSoporte) {
        this.visitasSoporte = visitasSoporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleEgreso)) return false;
        DetalleEgreso that = (DetalleEgreso) o;
        return cantidad == that.cantidad &&
                Double.compare(that.total, total) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(costo, that.costo) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(idCabeceraEgreso, that.idCabeceraEgreso) &&
                Objects.equals(idProducto, that.idProducto) &&
                Objects.equals(garantia, that.garantia) &&
                inicioGarantia == that.inicioGarantia &&
                Objects.equals(fechaPersonalizada, that.fechaPersonalizada);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cantidad, costo, total, estado, idCabeceraEgreso, idProducto, garantia, inicioGarantia, fechaPersonalizada);
    }

    @Override
    public String toString() {
        return "DetalleEgreso{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                ", total=" + total +
                ", estado=" + estado +
                ", idCabeceraEgreso=" + idCabeceraEgreso +
                ", idProducto=" + idProducto +
                ", garantia=" + garantia +
                ", inicioGarantia=" + inicioGarantia +
                ", fechaPersonalizada=" + fechaPersonalizada +
                '}';
    }
}
