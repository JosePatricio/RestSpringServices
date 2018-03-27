/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "preasignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preasignacion.findAll", query = "SELECT p FROM Preasignacion p")})
public class Preasignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "id_tipo_visita")
    private int idTipoVisita;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Column(name = "horario_tentativo")
    private String horarioTentativo;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "id_tipo_reporte")
    private String idTipoReporte;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "hora_creacion")
    @Temporal(TemporalType.TIME)
    private Date horaCreacion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_tipo_preasignacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPreasignacion idTipoPreasignacion;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idTecnico;
    @JoinColumn(name = "id_usuario_modificacion", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioModificacion;
    @JoinColumn(name = "id_usuario_registro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioRegistro;
 
    
    public Preasignacion() {
    }

    public Preasignacion(Integer id) {
        this.id = id;
    }

    public Preasignacion(Integer id, String codigo, int idTipoVisita, String idTipoReporte, Date fechaCreacion, Date horaCreacion, boolean estado) {
        this.id = id;
        this.codigo = codigo;
        this.idTipoVisita = idTipoVisita;
        this.idTipoReporte = idTipoReporte;
        this.fechaCreacion = fechaCreacion;
        this.horaCreacion = horaCreacion;
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

    public int getIdTipoVisita() {
        return idTipoVisita;
    }

    public void setIdTipoVisita(int idTipoVisita) {
        this.idTipoVisita = idTipoVisita;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public String getHorarioTentativo() {
        return horarioTentativo;
    }

    public void setHorarioTentativo(String horarioTentativo) {
        this.horarioTentativo = horarioTentativo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(String idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(Date horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoPreasignacion getIdTipoPreasignacion() {
        return idTipoPreasignacion;
    }

    public void setIdTipoPreasignacion(TipoPreasignacion idTipoPreasignacion) {
        this.idTipoPreasignacion = idTipoPreasignacion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Usuarios getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Usuarios idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Usuarios getIdUsuarioModificacion() {
        return idUsuarioModificacion;
    }

    public void setIdUsuarioModificacion(Usuarios idUsuarioModificacion) {
        this.idUsuarioModificacion = idUsuarioModificacion;
    }

    public Usuarios getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Usuarios idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
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
        if (!(object instanceof Preasignacion)) {
            return false;
        }
        Preasignacion other = (Preasignacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "mapeos.Preasignacion[ id=" + id + " ]";
    }
    
}
