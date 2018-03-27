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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "reporte_mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteMantenimiento.findAll", query = "SELECT r FROM ReporteMantenimiento r")})
public class ReporteMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo_repuesto")
    private String codigoRepuesto;
    @Column(name = "tipo_repuesto")
    private String tipoRepuesto;
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

    @JoinColumn(name = "id_producto_repuesto_reporte", referencedColumnName = "id")
    @ManyToOne
    private ProductoRepuestoReporte idProductoRepuestoReporte;

    @JoinColumn(name = "id_detalle_catalogo_reporte", referencedColumnName = "id")
    @ManyToOne
    private DetalleCatalogoReporte idDetalleCatalogoReporte;

    public ReporteMantenimiento() {
    }

    public ReporteMantenimiento(Integer id) {
        this.id = id;
    }

    public ReporteMantenimiento(Integer id, boolean estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(String codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public String getTipoRepuesto() {
        return tipoRepuesto;
    }

    public void setTipoRepuesto(String tipoRepuesto) {
        this.tipoRepuesto = tipoRepuesto;
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

    public ProductoRepuestoReporte getIdProductoRepuestoReporte() {
        return idProductoRepuestoReporte;
    }

    public void setIdProductoRepuestoReporte(ProductoRepuestoReporte idProductoRepuestoReporte) {
        this.idProductoRepuestoReporte = idProductoRepuestoReporte;
    }

    public DetalleCatalogoReporte getIdDetalleCatalogoReporte() {
        return idDetalleCatalogoReporte;
    }

    public void setIdDetalleCatalogoReporte(DetalleCatalogoReporte idDetalleCatalogoReporte) {
        this.idDetalleCatalogoReporte = idDetalleCatalogoReporte;
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
        if (!(object instanceof ReporteMantenimiento)) {
            return false;
        }
        ReporteMantenimiento other = (ReporteMantenimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReporteMantenimiento{" + "id=" + id + ","
                + " codigoRepuesto=" + codigoRepuesto + " , porcentaje =" + porcentaje
                + ", tipoRepuesto=" + tipoRepuesto + ", " + ", ESTADO=" + estado + " ,"
               + " , idProductoRepuestoReporte= " + idProductoRepuestoReporte + " , detallecatalogo= " + idDetalleCatalogoReporte
                + " )" + '}';
    }

}
