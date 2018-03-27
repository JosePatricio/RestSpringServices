/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "producto_repuesto_reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoRepuestoReporte.findAll", query = "SELECT p FROM ProductoRepuestoReporte p")})
public class ProductoRepuestoReporte implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto idProducto;
   
    @JoinColumn(name = "id_detalle_catalogo_reporte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DetalleCatalogoReporte idDetalleCatalogoReporte;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoRepuestoReporte")
    private List<ReporteMantenimiento> reporteMantenimientoList;

    @Transient
    @Getter
    @Setter
    private BigDecimal porcentaje;

    @Transient
    @Getter
    @Setter
    private boolean seleccion;

    @Transient
    @Getter
    @Setter
    private String tipoRepuesto;

    @Transient
    @Getter
    @Setter
    private Integer stock;

    public ProductoRepuestoReporte() {
    }

    public ProductoRepuestoReporte(Integer id) {
        this.id = id;
    }

    public ProductoRepuestoReporte(Integer id, Boolean estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public DetalleCatalogoReporte getIdDetalleCatalogoReporte() {
        return idDetalleCatalogoReporte;
    }

    public void setIdDetalleCatalogoReporte(DetalleCatalogoReporte idDetalleCatalogoReporte) {
        this.idDetalleCatalogoReporte = idDetalleCatalogoReporte;
    }

    @XmlTransient
    public List<ReporteMantenimiento> getReporteMantenimientoList() {
        return reporteMantenimientoList;
    }

    public void setReporteMantenimientoList(List<ReporteMantenimiento> reporteMantenimientoList) {
        this.reporteMantenimientoList = reporteMantenimientoList;
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
        if (!(object instanceof ProductoRepuestoReporte)) {
            return false;
        }
        ProductoRepuestoReporte other = (ProductoRepuestoReporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductoRepuestoReporte{ id=" + id + '}';
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
