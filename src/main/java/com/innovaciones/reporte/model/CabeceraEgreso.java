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
@Table(name = "cabecera_egreso")
public class CabeceraEgreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_usuario_registro", nullable = false)
    private int idUsuarioRegistro;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "hora_registro")
    @Temporal(TemporalType.TIME)
    private Date horaRegistro;

    @JoinColumn(name = "id_bodega", referencedColumnName = "id")
    @ManyToOne
    private Bodega idBodega;

    @Column(name = "id_usuario_modificacion")
    private Integer idUsuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "codigo", length = 10)
    private String codigo;
    @Column(name = "pagina", length = 10)
    private String pagina;
    @Basic(optional = false)
    @Column(name = "total_solicitado")
    private Integer totalSolicitado;

    @Column(name = "total_egreso")
    private Integer totalEgreso;

    @Column(name = "total_devolucion")
    private Integer totalDevolucion;

    @Column(name = "descripcion", length = 250)
    private String descripcion;
    @Column(name = "estado")
    private Integer estado;

    @Column(name = "estado_proceso")
    private String estadoProceso;

    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "egreso_contrato")
    private Boolean egresoContrato;

    @Column(name = "egreso_equipo")
    private Boolean egresoEquipo;

    @Column(name = "prestamo")
    private Boolean prestamo;

    @Column(name = "proceso_devolucion")
    private Boolean procesoDevolucion;

    @Column(name = "fecha_registro_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroPrestamo;

    @Column(name = "fecha_devolucion_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucionPrestamo;

    @JoinColumn(name = "id_cliente_sucursal", referencedColumnName = "id")
    @ManyToOne
    private ClienteSucursal idClienteSucursal;

    @JoinColumn(name = "id_detalle_egreso_inventario", referencedColumnName = "id")
    @ManyToOne
    private DetalleEgresoInventario idDetalleEgresoInventario;

    @JoinColumn(name = "id_responsable", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idResponsable;

    @Column(name = "firma_cliente")
    private String firmaCliente;

    @Column(name = "firma_cliente_64")
    private String firmaCliente64;

    public CabeceraEgreso() {
    }

    public CabeceraEgreso(Integer id) {
        this.id = id;
    }

    public CabeceraEgreso(Integer id, int idUsuarioRegistro) {
        this.id = id;
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(int idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Date horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdUsuarioModificacion() {
        return idUsuarioModificacion;
    }

    public void setIdUsuarioModificacion(Integer idUsuarioModificacion) {
        this.idUsuarioModificacion = idUsuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Integer getTotalSolicitado() {
        return totalSolicitado;
    }

    public void setTotalSolicitado(Integer totalSolicitado) {
        this.totalSolicitado = totalSolicitado;
    }

    public Integer getTotalEgreso() {
        return totalEgreso;
    }

    public void setTotalEgreso(Integer totalEgreso) {
        this.totalEgreso = totalEgreso;
    }

    public void setTotalDevolucion(Integer totalDevolucion) {
        this.totalDevolucion = totalDevolucion;
    }

    public Integer getTotalDevolucion() {
        return totalDevolucion;
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

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public Boolean getEgresoEquipo() {
        return egresoEquipo;
    }

    public void setEgresoEquipo(Boolean egresoEquipo) {
        this.egresoEquipo = egresoEquipo;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Boolean getEgresoContrato() {
        return egresoContrato;
    }

    public void setEgresoContrato(Boolean egresoContrato) {
        this.egresoContrato = egresoContrato;
    }

    public Boolean getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Boolean prestamo) {
        this.prestamo = prestamo;
    }

    public Boolean getProcesoDevolucion() {
        return procesoDevolucion;
    }

    public void setProcesoDevolucion(Boolean procesoDevolucion) {
        this.procesoDevolucion = procesoDevolucion;
    }

    public Date getFechaRegistroPrestamo() {
        return fechaRegistroPrestamo;
    }

    public void setFechaRegistroPrestamo(Date fechaRegistroPrestamo) {
        this.fechaRegistroPrestamo = fechaRegistroPrestamo;
    }

    public Date getFechaDevolucionPrestamo() {
        return fechaDevolucionPrestamo;
    }

    public void setFechaDevolucionPrestamo(Date fechaDevolucionPrestamo) {
        this.fechaDevolucionPrestamo = fechaDevolucionPrestamo;
    }

    public ClienteSucursal getIdClienteSucursal() {
        return idClienteSucursal;
    }

    public void setIdClienteSucursal(ClienteSucursal idClienteSucursal) {
        this.idClienteSucursal = idClienteSucursal;
    }

    public DetalleEgresoInventario getIdDetalleEgresoInventario() {
        return idDetalleEgresoInventario;
    }

    public void setIdDetalleEgresoInventario(DetalleEgresoInventario idDetalleEgresoInventario) {
        this.idDetalleEgresoInventario = idDetalleEgresoInventario;
    }

    public Usuarios getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Usuarios idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getFirmaCliente() {
        return firmaCliente;
    }

    public void setFirmaCliente(String firmaCliente) {
        this.firmaCliente = firmaCliente;
    }

    public String getFirmaCliente64() {
        return firmaCliente64;
    }

    public void setFirmaCliente64(String firmaCliente64) {
        this.firmaCliente64 = firmaCliente64;
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
        if (!(object instanceof CabeceraEgreso)) {
            return false;
        }
        CabeceraEgreso other = (CabeceraEgreso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CabeceraEgreso{" + "id=" + id + ", idUsuarioRegistro=" + idUsuarioRegistro + ", fechaRegistro=" + fechaRegistro + ", horaRegistro=" + horaRegistro + ", idBodega=" + idBodega + ", idUsuarioModificacion=" + idUsuarioModificacion + ", fechaModificacion=" + fechaModificacion + ", codigo=" + codigo + ", pagina=" + pagina + ", totalSolicitado=" + totalSolicitado + ", totalEgreso=" + totalEgreso + ", totalDevolucion=" + totalDevolucion + ", descripcion=" + descripcion + ", estado=" + estado + ", estadoProceso=" + estadoProceso + ", numDocumento=" + numDocumento + ", egresoContrato=" + egresoContrato + ", egresoEquipo=" + egresoEquipo + ", prestamo=" + prestamo + ", fechaRegistroPrestamo=" + fechaRegistroPrestamo + ", fechaDevolucionPrestamo=" + fechaDevolucionPrestamo + ", idClienteSucursal=" + idClienteSucursal + ", idDetalleEgresoInventario=" + idDetalleEgresoInventario + ", idResponsable=" + idResponsable + ", firmaCliente=" + firmaCliente + ", firmaCliente64=" + firmaCliente64 + '}';
    }

}
