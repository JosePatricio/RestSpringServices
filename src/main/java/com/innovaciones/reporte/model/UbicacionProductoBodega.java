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
import javax.persistence.Table;

/**
 *
 * @author Fernando-PC
 */
@Entity
@Table(name = "ubicacion_producto_bodega")
public class UbicacionProductoBodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "mueble", nullable = false, length = 10)
    private String mueble;
    @Basic(optional = false)
    @Column(name = "cajon", nullable = false, length = 10)
    private String cajon;
    @Basic(optional = false)
    @Column(name = "espacio", nullable = false, length = 10)
    private String espacio;
    @Column(name = "observacion", length = 250)
    private String observacion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private Integer estado;
    @JoinColumn(name = "id_bodega", referencedColumnName = "id")
    @ManyToOne
    private Bodega idBodega;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Producto idProducto;

    public UbicacionProductoBodega() {
    }

    public UbicacionProductoBodega(Integer id) {
        this.id = id;
    }

    public UbicacionProductoBodega(Integer id, String mueble, String cajon, String espacio, Integer estado) {
        this.id = id;
        this.mueble = mueble;
        this.cajon = cajon;
        this.espacio = espacio;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMueble() {
        return mueble;
    }

    public void setMueble(String mueble) {
        this.mueble = mueble;
    }

    public String getCajon() {
        return cajon;
    }

    public void setCajon(String cajon) {
        this.cajon = cajon;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
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
        if (!(object instanceof UbicacionProductoBodega)) {
            return false;
        }
        UbicacionProductoBodega other = (UbicacionProductoBodega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UbicacionProductoBodega{" + "id=" + id + ", mueble=" + mueble + ", cajon=" + cajon + ", espacio=" + espacio + ", observacion=" + observacion + ", estado=" + estado + ", idBodega=" + idBodega + ", idProducto=" + idProducto + '}';
    }

}
