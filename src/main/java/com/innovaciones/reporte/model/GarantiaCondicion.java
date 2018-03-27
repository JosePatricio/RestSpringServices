package com.innovaciones.reporte.model;

import javax.persistence.*;

@Entity
@Table(name = "garantia_condicion")
public class GarantiaCondicion {
    private int id;
    private Integer valor;
    private GarantiaCondMedida garantiaCondMedidaByUnidadMedida;
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
    @Column(name = "valor")
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GarantiaCondicion that = (GarantiaCondicion) o;

        if (id != that.id) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "unidad_medida", referencedColumnName = "id", nullable = false)
    public GarantiaCondMedida getGarantiaCondMedidaByUnidadMedida() {
        return garantiaCondMedidaByUnidadMedida;
    }

    public void setGarantiaCondMedidaByUnidadMedida(GarantiaCondMedida garantiaCondMedidaByUnidadMedida) {
        this.garantiaCondMedidaByUnidadMedida = garantiaCondMedidaByUnidadMedida;
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
