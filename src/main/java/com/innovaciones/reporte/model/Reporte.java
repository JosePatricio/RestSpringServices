/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "factura")
    private String factura;

    @Column(name = "sintomas_equipo")
    private String sintomasEquipo;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "observacion_mantenimiento")
    private String observacionMantenimiento;
    @Basic(optional = false)

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "observaciones_recomendaciones")
    private String observacionesRecomendaciones;

    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)

    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Lob
    @Column(name = "firma_cliente")
    private String firmaCliente;

    @Lob
    @Column(name = "firma_cliente_base64")
    private String firmaClienteBase64;

    @Basic(optional = false)

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "subtipo")
    private String subtipo;

    @Basic(optional = false)

    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Basic(optional = false)

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Basic(optional = false)

    @Column(name = "numero_factura")
    private Integer numerofactura;

    @Column(name = "notas")
    private String notas;

    @JoinColumn(name = "id_visita", referencedColumnName = "id")
    @ManyToOne
    private TipoVisita idVisita;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    @JoinColumn(name = "id_asignacion", referencedColumnName = "id")
    @ManyToOne
    private AsignacionReparacion idAsignacion;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReporte")
    private List<ProductoClienteReporte> productoClienteReporteList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReporte", fetch = FetchType.EAGER)
    private List<DetalleReporteEcu911> detalleReporteEcu911List;

    @Column(name = "numero_reporte_tecnico")
    private String numeroReporteTecnico;

    public Reporte() {
    }

    public Reporte(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getSintomasEquipo() {
        return sintomasEquipo;
    }

    public void setSintomasEquipo(String sintomasEquipo) {
        this.sintomasEquipo = sintomasEquipo;
    }

    public String getObservacionMantenimiento() {
        return observacionMantenimiento;
    }

    public void setObservacionMantenimiento(String observacionMantenimiento) {
        this.observacionMantenimiento = observacionMantenimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacionesRecomendaciones() {
        return observacionesRecomendaciones;
    }

    public void setObservacionesRecomendaciones(String observacionesRecomendaciones) {
        this.observacionesRecomendaciones = observacionesRecomendaciones;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFirmaCliente() {
        return firmaCliente;
    }

    public void setFirmaCliente(String firmaCliente) {
        this.firmaCliente = firmaCliente;
    }

    public String getFirmaClienteBase64() {
        return firmaClienteBase64;
    }

    public void setFirmaClienteBase64(String firmaClienteBase64) {
        this.firmaClienteBase64 = firmaClienteBase64;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public TipoVisita getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(TipoVisita idVisita) {
        this.idVisita = idVisita;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(Integer numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public AsignacionReparacion getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(AsignacionReparacion idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    @XmlTransient
    public List<ProductoClienteReporte> getProductoClienteReporteList() {
        return productoClienteReporteList;
    }

    public void setProductoClienteReporteList(List<ProductoClienteReporte> productoClienteReporteList) {
        this.productoClienteReporteList = productoClienteReporteList;
    }

    @XmlTransient
    public List<DetalleReporteEcu911> getDetalleReporteEcu911List() {
        return detalleReporteEcu911List;
    }

    public void setDetalleReporteEcu911List(List<DetalleReporteEcu911> detalleReporteEcu911List) {
        this.detalleReporteEcu911List = detalleReporteEcu911List;
    }

    public String getNumeroReporteTecnico() {
        return numeroReporteTecnico;
    }

    public void setNumeroReporteTecnico(String numeroReporteTecnico) {
        this.numeroReporteTecnico = numeroReporteTecnico;
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
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reporte{" + "id=" + id + ", factura=" + factura + ", sintomasEquipo=" + sintomasEquipo + ", referencia=" + referencia
                + ", observacionMantenimiento=" + observacionMantenimiento + ", fecha=" + fecha + ", observacionesRecomendaciones=" + observacionesRecomendaciones
                + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", nombreCliente=" + nombreCliente + ", tipo=" + tipo + ", subtipo=" + subtipo + ", estado="
                + estado + ", numerofactura=" + numerofactura + " , notas= " + notas + ", idVisita=" + idVisita
                + ",fechaCreacion= " + fechaCreacion + " , usuarioCreacion= " + usuarioCreacion + ", idUsuario=" + idUsuario + '}';
    }

}
