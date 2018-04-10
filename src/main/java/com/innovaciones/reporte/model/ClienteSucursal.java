/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "cliente_sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteSucursal.findAll", query = "SELECT c FROM ClienteSucursal c")})
public class ClienteSucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "telefono_sucursal")
    private String telefonoSucursal;
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    @Column(name = "celular_contacto")
    private String celularContacto;

    @Column(name = "email_contacto")
    private String emailContacto;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "ciudad")
    private String ciudad;

    // @JsonIgnore
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClienteSucursal")
    private List<DetalleReporteTemporal> detalleReporteTemporalList;

    public ClienteSucursal() {
    }

    public ClienteSucursal(Integer id) {
        this.id = id;
    }

    public ClienteSucursal(Integer id, String nombre, String direccion, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(String telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCelularContacto() {
        return celularContacto;
    }

    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<DetalleReporteTemporal> getDetalleReporteTemporalList() {
        return detalleReporteTemporalList;
    }

    public void setDetalleReporteTemporalList(List<DetalleReporteTemporal> detalleReporteTemporalList) {
        this.detalleReporteTemporalList = detalleReporteTemporalList;
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
        if (!(object instanceof ClienteSucursal)) {
            return false;
        }
        ClienteSucursal other = (ClienteSucursal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteSucursal{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", referencia=" + referencia + ", estado=" + estado + ", telefonoSucursal=" + telefonoSucursal + ", telefonoContacto=" + telefonoContacto + ", nombreContacto=" + nombreContacto + ", celularContacto=" + celularContacto + ", emailContacto=" + emailContacto + ", idCliente=" + idCliente + '}';
    }

}
