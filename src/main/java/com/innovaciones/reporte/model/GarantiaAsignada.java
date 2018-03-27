package com.innovaciones.reporte.model;

import com.innovaciones.reporte.util.EstadoGarantiaEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "garantia_asignada")
public class GarantiaAsignada {
    private int id;
    private Date fechaInicio;
    private EstadoGarantiaEnum estado;
    private String motivo;
    private DetalleEgresoInventario detalleEgresoInventario;
    private Integer instalacion;
    private Date fechaExpiracion;
    private Date fechaMotivo;
    private TipoSoporteGarantia tipoSoporte;
    private String contactoMotivo;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fecha_inicio")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "estado")
    public EstadoGarantiaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoGarantiaEnum estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "motivo")
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    @ManyToOne
    @JoinColumn(name = "detalle_egreso_inventario", referencedColumnName = "id", nullable = false)
    public DetalleEgresoInventario getDetalleEgresoInventario() {
        return detalleEgresoInventario;
    }

    public void setDetalleEgresoInventario(DetalleEgresoInventario detalleEgresoInventario) {
        this.detalleEgresoInventario = detalleEgresoInventario;
    }

    @Column(name = "instalacion")
    public Integer getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Integer instalacion) {
        this.instalacion = instalacion;
    }

    @Column(name = "fecha_motivo")
    public Date getFechaMotivo() {
        return fechaMotivo;
    }

    public void setFechaMotivo(Date fechaMotivo) {
        this.fechaMotivo = fechaMotivo;
    }

    @ManyToOne
    @JoinColumn(name = "tipo_soporte", referencedColumnName = "id")
    public TipoSoporteGarantia getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(TipoSoporteGarantia tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    @Column(name = "contacto_motivo")
    public String getContactoMotivo() {
        return contactoMotivo;
    }

    public void setContactoMotivo(String contactoMotivo) {
        this.contactoMotivo = contactoMotivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GarantiaAsignada that = (GarantiaAsignada) o;

        if (id != that.id) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        return estado != null ? estado.equals(that.estado) : that.estado == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @Transient
    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
