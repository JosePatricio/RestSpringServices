/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pato
 */
@Entity
@Table(name = "reporte_generico_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteGenericoItems.findAll", query = "SELECT r FROM ReporteGenericoItems r")})
public class ReporteGenericoItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cambiado")
    private boolean cambiado;

    @Column(name = "solicitar")
    private boolean solicitar;
    @Column(name = "codigo_repuesto")
    private String codigoRepuesto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JsonIgnore
    @JoinColumn(name = "id_producto_cliente_reporte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductoClienteReporte idProductoClienteReporte;
    @Column(name = "seleccionado")
    private Boolean seleccionado;

    @Transient
    private boolean seleccion;

    public ReporteGenericoItems() {
    }

    public ReporteGenericoItems(Integer id) {
        this.id = id;
    }

    public ReporteGenericoItems(Integer id, Character tipo, boolean cambiado, boolean solicitar, boolean estado) {
        this.id = id;
        this.tipo = tipo;
        this.cambiado = cambiado;
        this.solicitar = solicitar;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Character getTipo() {
        return tipo;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCambiado() {
        return cambiado;
    }

    public void setCambiado(boolean cambiado) {
        this.cambiado = cambiado;
    }

    public boolean getSolicitar() {
        return solicitar;
    }

    public void setSolicitar(boolean solicitar) {
        this.solicitar = solicitar;
    }

    public String getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(String codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ProductoClienteReporte getIdProductoClienteReporte() {
        return idProductoClienteReporte;
    }

    public void setIdProductoClienteReporte(ProductoClienteReporte idProductoClienteReporte) {
        this.idProductoClienteReporte = idProductoClienteReporte;
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
        if (!(object instanceof ReporteGenericoItems)) {
            return false;
        }
        ReporteGenericoItems other = (ReporteGenericoItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteGenericoItems{" + "id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", cambiado=" + cambiado + ", solicitar=" + solicitar + ", codigoRepuesto=" + codigoRepuesto + ", porcentaje=" + porcentaje + ", estado=" + estado + ", seleccionado=" + seleccionado + ", seleccion=" + seleccion + ", idProductoClienteReporte=" + idProductoClienteReporte + '}';
    }

}
