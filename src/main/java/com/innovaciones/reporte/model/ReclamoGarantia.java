package com.innovaciones.reporte.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reclamos_garantias")
public class ReclamoGarantia implements Serializable {
    private int id;
    private String contacto;
    private MotivoReclamoGarantia motivoReclamo;
    private SolucionReclamoGarantia solucionReclamo;
    private GarantiaAsignada garantiaAsignada;
    private Date fecha;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contacto")
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReclamoGarantia that = (ReclamoGarantia) o;
        return id == that.id &&
                Objects.equals(contacto, that.contacto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, contacto);
    }

    @ManyToOne
    @JoinColumn(name = "motivo", referencedColumnName = "id")
    public MotivoReclamoGarantia getMotivoReclamo() {
        return motivoReclamo;
    }

    public void setMotivoReclamo(MotivoReclamoGarantia motivoReclamo) {
        this.motivoReclamo = motivoReclamo;
    }

    @ManyToOne
    @JoinColumn(name = "solucion", referencedColumnName = "id")
    public SolucionReclamoGarantia getSolucionReclamo() {
        return solucionReclamo;
    }

    public void setSolucionReclamo(SolucionReclamoGarantia solucionReclamo) {
        this.solucionReclamo = solucionReclamo;
    }

    @ManyToOne
    @JoinColumn(name = "garantia_asignada", referencedColumnName = "id")
    public GarantiaAsignada getGarantiaAsignada() {
        return garantiaAsignada;
    }

    public void setGarantiaAsignada(GarantiaAsignada garantiaAsignada) {
        this.garantiaAsignada = garantiaAsignada;
    }

    @Basic
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
