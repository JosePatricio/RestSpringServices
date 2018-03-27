/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando-PC
 */
@Entity
@Table(name = "ciclo_mantenimiento", catalog = "reportes_v2", schema = "")
public class CicloMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "codigo", length = 30)
    private String codigo;
    @Column(name = "ciclo")
    private Integer ciclo;
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    @Column(name = "observacion", length = 500)
    private String observacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "id_usuario_registro")
    private Integer idUsuarioRegistro;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "id_usuario_modificacion")
    private Integer idUsuarioModificacion;
    @Column(name = "estado")
    private Integer estado;
//    @OneToMany(mappedBy = "idCicloMantenimiento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<DetalleCicloMantenimiento> detalleCicloMantenimientoList;

    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    @ManyToOne
    private Producto idEquipo;

    public CicloMantenimiento() {
    }

    public CicloMantenimiento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setciclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Integer idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public Producto getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Producto idEquipo) {
        this.idEquipo = idEquipo;
    }

//    @XmlTransient
//    public List<DetalleCicloMantenimiento> getDetalleCicloMantenimientoList() {
//        return detalleCicloMantenimientoList;
//    }
//
//    public void setDetalleCicloMantenimientoList(List<DetalleCicloMantenimiento> detalleCicloMantenimientoList) {
//        this.detalleCicloMantenimientoList = detalleCicloMantenimientoList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloMantenimiento)) {
            return false;
        }
        CicloMantenimiento other = (CicloMantenimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.innovaciones.reporte.model.ComboMantenimiento[ id=" + id + " ]";
    }

}
