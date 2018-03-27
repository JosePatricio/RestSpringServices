/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "asignacion_reparacion")
@NamedQueries({
    @NamedQuery(name = "AsignacionReparacion.findAll", query = "SELECT a FROM AsignacionReparacion a")})
public class AsignacionReparacion implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_inicio_atencion")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioAtencion;

    @Column(name = "hora_inicio_atencion")
    @Temporal(TemporalType.TIME)
    private Date horaInicioAtencion;

    @Column(name = "fecha_fin_atencion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinAtencion;

    @Column(name = "hora_fin_atencion")
    @Temporal(TemporalType.TIME)
    private Date horaFinAtencion;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "id_usuario_registro")
    private Integer idUsuarioRegistro;

    @Column(name = "nombre_usuario_registro")
    private String nombreUsuarioRegistro;

    @Column(name = "prioridad")
    private int prioridad;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "tipo_reporte")
    private String tipoReporte;

    @Column(name = "tipo_notificacion")
    private String tipoNotificacion;

    @Column(name = "tipo_equipo")
    private String tipoEquipo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_reporte")
    private Integer idReporte;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "contacto_requerimiento")
    private String contactoRequerimiento;

    @Column(name = "telefono_requerimiento")
    private String telefonoRequerimiento;

    @Column(name = "preasignacion", columnDefinition = "TINYINT(1)")
    private Boolean preasignacion;

    @JoinColumn(name = "id_usuario_atencion", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioAtencion;

    @JoinColumn(name = "id_cliente_sucursal", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteSucursal idClienteSucursal;

    @JoinColumn(name = "id_tipo_visita", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private TipoVisita idTipoVisita;

    @JoinColumn(name = "producto", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Producto producto;

    @Column
    private String serial;

    public AsignacionReparacion() {
    }

    public AsignacionReparacion(Integer id) {
        this.id = id;
    }

    public AsignacionReparacion(Integer id, Date fechaInicioAtencion, Date horaInicioAtencion, Date fechaFinAtencion, Date horaFinAtencion, Date fechaRegistro, Integer idUsuarioRegistro, String nombreUsuarioRegistro, int prioridad, String observacion, String tipoReporte, String estado, Producto producto, Usuarios idUsuarioAtencion, String serial) {
        this.id = id;
        this.fechaInicioAtencion = fechaInicioAtencion;
        this.horaInicioAtencion = horaInicioAtencion;
        this.fechaFinAtencion = fechaFinAtencion;
        this.horaFinAtencion = horaFinAtencion;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.nombreUsuarioRegistro = nombreUsuarioRegistro;
        this.prioridad = prioridad;
        this.observacion = observacion;
        this.tipoReporte = tipoReporte;
        this.estado = estado;
        this.idUsuarioAtencion = idUsuarioAtencion;
        this.producto = producto;
        this.serial = serial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicioAtencion() {
        return fechaInicioAtencion;
    }

    public void setFechaInicioAtencion(Date fechaInicioAtencion) {
        this.fechaInicioAtencion = fechaInicioAtencion;
    }

    public Date getHoraInicioAtencion() {
        return horaInicioAtencion;
    }

    public void setHoraInicioAtencion(Date horaInicioAtencion) {
        this.horaInicioAtencion = horaInicioAtencion;
    }

    public Date getFechaFinAtencion() {
        return fechaFinAtencion;
    }

    public void setFechaFinAtencion(Date fechaFinAtencion) {
        this.fechaFinAtencion = fechaFinAtencion;
    }

    public Date getHoraFinAtencion() {
        return horaFinAtencion;
    }

    public void setHoraFinAtencion(Date horaFinAtencion) {
        this.horaFinAtencion = horaFinAtencion;
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

    public String getNombreUsuarioRegistro() {
        return nombreUsuarioRegistro;
    }

    public void setNombreUsuarioRegistro(String nombreUsuarioRegistro) {
        this.nombreUsuarioRegistro = nombreUsuarioRegistro;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getIdUsuarioAtencion() {
        return idUsuarioAtencion;
    }

    public void setIdUsuarioAtencion(Usuarios idUsuarioAtencion) {
        this.idUsuarioAtencion = idUsuarioAtencion;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public String getContactoRequerimiento() {
        return contactoRequerimiento;
    }

    public void setContactoRequerimiento(String contactoRequerimiento) {
        this.contactoRequerimiento = contactoRequerimiento;
    }

    public String getTelefonoRequerimiento() {
        return telefonoRequerimiento;
    }

    public void setTelefonoRequerimiento(String telefonoRequerimiento) {
        this.telefonoRequerimiento = telefonoRequerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public ClienteSucursal getIdClienteSucursal() {
        return idClienteSucursal;
    }

    public void setIdClienteSucursal(ClienteSucursal idClienteSucursal) {
        this.idClienteSucursal = idClienteSucursal;
    }

    public TipoVisita getIdTipoVisita() {
        return idTipoVisita;
    }

    public void setIdTipoVisita(TipoVisita idTipoVisita) {
        this.idTipoVisita = idTipoVisita;
    }

    public Boolean getPreasignacion() {
        return preasignacion;
    }

    public void setPreasignacion(Boolean preasignacion) {
        this.preasignacion = preasignacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionReparacion)) {
            return false;
        }
        AsignacionReparacion other = (AsignacionReparacion) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "AsignacionReparacion{"
                + "id=" + id
                + ", fechaInicioAtencion=" + fechaInicioAtencion
                + ", horaInicioAtencion=" + horaInicioAtencion
                + ", fechaFinAtencion=" + fechaFinAtencion
                + ", horaFinAtencion=" + horaFinAtencion
                + ", fechaRegistro=" + fechaRegistro
                + ", idUsuarioRegistro=" + idUsuarioRegistro
                + ", nombreUsuarioRegistro='" + nombreUsuarioRegistro + '\''
                + ", prioridad=" + prioridad
                + ", observacion='" + observacion + '\''
                + ", tipoReporte='" + tipoReporte + '\''
                + ", tipoNotificacion='" + tipoNotificacion + '\''
                + ", tipoEquipo='" + tipoEquipo + '\''
                + ", estado='" + estado + '\''
                + ", idReporte=" + idReporte
                + ", codigo='" + codigo + '\''
                + ", preasignacion=" + preasignacion
                + ", idUsuarioAtencion=" + idUsuarioAtencion
                + ", idClienteSucursal=" + idClienteSucursal
                + ", idTipoVisita=" + idTipoVisita
                + ", producto=" + producto
                + ", serial='" + serial + '\''
                + '}';
    }
}
