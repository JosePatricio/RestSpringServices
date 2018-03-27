package com.innovaciones.reporte.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reclamos_garantias_motivos")
public class MotivoReclamoGarantia implements Serializable {
    private int id;
    private String motivo;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "motivo")
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotivoReclamoGarantia that = (MotivoReclamoGarantia) o;
        return id == that.id &&
                Objects.equals(motivo, that.motivo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, motivo);
    }
}
