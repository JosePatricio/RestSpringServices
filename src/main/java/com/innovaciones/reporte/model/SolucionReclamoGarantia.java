package com.innovaciones.reporte.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reclamos_garantias_solucion")
public class SolucionReclamoGarantia implements Serializable {
    private int id;
    private String solucion;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "solucion")
    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolucionReclamoGarantia that = (SolucionReclamoGarantia) o;
        return id == that.id &&
                Objects.equals(solucion, that.solucion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, solucion);
    }
}
