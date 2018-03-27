package com.innovaciones.reporte.model;

import javax.persistence.*;

@Entity
@Table(name = "garantia_detalle")
public class GarantiaDetalle {
    private int id;
    private String detalle;
    private Garantia garantia;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "detalle")
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GarantiaDetalle that = (GarantiaDetalle) o;

        if (id != that.id) return false;
        if (detalle != null ? !detalle.equals(that.detalle) : that.detalle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (detalle != null ? detalle.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "garantia", referencedColumnName = "id", nullable = false)
    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantiaByGarantia) {
        this.garantia = garantiaByGarantia;
    }
}
