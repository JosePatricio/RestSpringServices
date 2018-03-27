/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import java.io.Serializable;
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
@Table(name = "producto_modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoModelo.findAll", query = "SELECT p FROM ProductoModelo p")})
public class ProductoModelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Modelo idModelo;
    @JoinColumn(name = "id_detalle_catalogo_reporte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DetalleCatalogoReporte idDetalleCatalogoReporte;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "por_defecto")
    private Boolean porDefecto;

    public ProductoModelo() {
    }

    public ProductoModelo(Integer id) {
        this.id = id;
    }

    public ProductoModelo(Integer id, Integer estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public DetalleCatalogoReporte getIdDetalleCatalogoReporte() {
        return idDetalleCatalogoReporte;
    }

    public void setIdDetalleCatalogoReporte(DetalleCatalogoReporte idDetalleCatalogoReporte) {
        this.idDetalleCatalogoReporte = idDetalleCatalogoReporte;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getPorDefecto() {
        return porDefecto;
    }

    public void setPorDefecto(Boolean porDefecto) {
        this.porDefecto = porDefecto;
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
        if (!(object instanceof ProductoModelo)) {
            return false;
        }
        ProductoModelo other = (ProductoModelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nProductoModelo{" + "id=" + id + ", estado=" + estado + ", idProducto=" + idProducto.getId() + ", idModelo=" + idModelo.getId() + '}';
    }

}
