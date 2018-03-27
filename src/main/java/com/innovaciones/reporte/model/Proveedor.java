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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "telefono3")
    private String telefono3;
    @Column(name = "email")
    private String email;
    @Column(name = "representante")
    private String representante;
    @Column(name = "banco_deposito")
    private String bancoDeposito;
    @Column(name = "num_cuenta_bancaria")
    private String numCuentaBancaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Double descuento;
    @Column(name = "cupo_maximo")
    private Double cupoMaximo;
    @Column(name = "num_dias_prestamo")
    private Integer numDiasPrestamo;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @JsonIgnore
    @OneToMany(mappedBy = "idProveedorPreferido")
    private List<Producto> productoList;
    @JsonIgnore
    @OneToMany(mappedBy = "idProveedor")
    private List<CabeceraInventario> cabeceraInventarioList;
    @JoinColumn(name = "id_tipo_cuenta_bancaria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCuentaBancaria idTipoCuentaBancaria;
    @JoinColumn(name = "id_tipo_proveedor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoProveedor idTipoProveedor;
    @JoinColumn(name = "id_tipo_documento_proveedor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoDocumentoProveedor idTipoDocumentoProveedor;

    public Proveedor() {
    }

    public Proveedor(Integer id) {
        this.id = id;
    }

    public Proveedor(Integer id, String ciudad, String nombre, int estado) {
        this.id = id;
        this.ciudad = ciudad;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getBancoDeposito() {
        return bancoDeposito;
    }

    public void setBancoDeposito(String bancoDeposito) {
        this.bancoDeposito = bancoDeposito;
    }

    public String getNumCuentaBancaria() {
        return numCuentaBancaria;
    }

    public void setNumCuentaBancaria(String numCuentaBancaria) {
        this.numCuentaBancaria = numCuentaBancaria;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(Double cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public Integer getNumDiasPrestamo() {
        return numDiasPrestamo;
    }

    public void setNumDiasPrestamo(Integer numDiasPrestamo) {
        this.numDiasPrestamo = numDiasPrestamo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @XmlTransient
    public List<CabeceraInventario> getCabeceraInventarioList() {
        return cabeceraInventarioList;
    }

    public void setCabeceraInventarioList(List<CabeceraInventario> cabeceraInventarioList) {
        this.cabeceraInventarioList = cabeceraInventarioList;
    }

    public TipoCuentaBancaria getIdTipoCuentaBancaria() {
        return idTipoCuentaBancaria;
    }

    public void setIdTipoCuentaBancaria(TipoCuentaBancaria idTipoCuentaBancaria) {
        this.idTipoCuentaBancaria = idTipoCuentaBancaria;
    }

    public TipoDocumentoProveedor getIdTipoDocumentoProveedor() {
        return idTipoDocumentoProveedor;
    }

    public void setIdTipoDocumentoProveedor(TipoDocumentoProveedor idTipoDocumentoProveedor) {
        this.idTipoDocumentoProveedor = idTipoDocumentoProveedor;
    }

    public TipoProveedor getIdTipoProveedor() {
        return idTipoProveedor;
    }

    public void setIdTipoProveedor(TipoProveedor idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", codigo=" + codigo + ", idTipoDocumentoProveedor=" + idTipoDocumentoProveedor + ", ciudad=" + ciudad + ", ruc=" + ruc + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", telefono3=" + telefono3 + ", email=" + email + ", representante=" + representante + ", bancoDeposito=" + bancoDeposito + ", numCuentaBancaria=" + numCuentaBancaria + ", descuento=" + descuento + ", cupoMaximo=" + cupoMaximo + ", numDiasPrestamo=" + numDiasPrestamo + ", estado=" + estado + ", idTipoCuentaBancaria=" + idTipoCuentaBancaria + ", idTipoProveedor=" + idTipoProveedor + '}';
    }

}
