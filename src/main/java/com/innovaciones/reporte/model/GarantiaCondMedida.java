package com.innovaciones.reporte.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "garantia_cond_medida")
public class GarantiaCondMedida {
    private int id;
    private String codigo;
    private String descripcion;
    private Collection<GarantiaCondicion> garantiaCondicionsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GarantiaCondMedida that = (GarantiaCondMedida) o;

        if (id != that.id) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "garantiaCondMedidaByUnidadMedida")
    public Collection<GarantiaCondicion> getGarantiaCondicionsById() {
        return garantiaCondicionsById;
    }

    public void setGarantiaCondicionsById(Collection<GarantiaCondicion> garantiaCondicionsById) {
        this.garantiaCondicionsById = garantiaCondicionsById;
    }
}
