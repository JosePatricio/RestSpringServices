/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fernando-PC
 */
@Entity
@Table(name = "detalle_egreso_inventario")
public class DetalleEgresoInventario implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column(name = "id_usuario_registro")
    private Integer idUsuarioRegistro;

    @Column(name = "id_usuario_modificacion")
    private Integer idUsuarioModificacion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "estado_proceso")
    private String estadoProceso;

    @JoinColumn(name = "id_detalle_egreso", referencedColumnName = "id")
    @ManyToOne
    private DetalleEgreso idDetalleEgreso;
    @JoinColumn(name = "id_detalle_inventario_producto", referencedColumnName = "id")
    @ManyToOne
    private DetalleInventarioProducto idDetalleInventarioProducto;

    public DetalleEgresoInventario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Integer idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Integer getIdUsuarioModificacion() {
        return idUsuarioModificacion;
    }

    public void setIdUsuarioModificacion(Integer idUsuarioModificacion) {
        this.idUsuarioModificacion = idUsuarioModificacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public DetalleEgreso getIdDetalleEgreso() {
        return idDetalleEgreso;
    }

    public void setIdDetalleEgreso(DetalleEgreso idDetalleEgreso) {
        this.idDetalleEgreso = idDetalleEgreso;
    }

    public DetalleInventarioProducto getIdDetalleInventarioProducto() {
        return idDetalleInventarioProducto;
    }

    public void setIdDetalleInventarioProducto(DetalleInventarioProducto idDetalleInventarioProducto) {
        this.idDetalleInventarioProducto = idDetalleInventarioProducto;
    }

    @Override
    public DetalleEgresoInventario clone() throws CloneNotSupportedException {
        DetalleEgresoInventario detalleEgresoInventarioClonado = (DetalleEgresoInventario) super.clone();
        return detalleEgresoInventarioClonado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEgresoInventario)) {
            return false;
        }
        DetalleEgresoInventario other = (DetalleEgresoInventario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleEgresoInventario{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + ", idUsuarioRegistro=" + idUsuarioRegistro + ", estado=" + estado + ", idDetalleEgreso=" + idDetalleEgreso + ", idDetalleInventarioProducto=" + idDetalleInventarioProducto + '}';
    }

}
