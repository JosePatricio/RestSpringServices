/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando-PC
 */
@Entity
@Table(name = "bodega")
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "telefono", length = 20)
    private String telefono;
    @Column(name = "direccion", length = 250)
    private String direccion;
    @Column(name = "descripcion", length = 250)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private Integer estado;
    @OneToMany(mappedBy = "idBodega")
    private List<CabeceraInventario> cabeceraInventarioList;
    @JoinColumn(name = "id_configuracion", referencedColumnName = "id")
    @ManyToOne
    private Configuracion idConfiguracion;
    @JoinColumn(name = "id_bodeguero", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idBodeguero;

    public Bodega() {
    }

    public Bodega(Integer id) {
        this.id = id;
    }

    public Bodega(Integer id, String codigo, String nombre, Integer estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Usuarios getIdBodeguero() {
        return idBodeguero;
    }

    public void setIdBodeguero(Usuarios idBodeguero) {
        this.idBodeguero = idBodeguero;
    }

    @XmlTransient
    public List<CabeceraInventario> getCabeceraInventarioList() {
        return cabeceraInventarioList;
    }

    public void setCabeceraInventarioList(List<CabeceraInventario> cabeceraInventarioList) {
        this.cabeceraInventarioList = cabeceraInventarioList;
    }

    public Configuracion getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Configuracion idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
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
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.innovaciones.reporte.model.Bodega[ id=" + id + " ]";
    }

}
