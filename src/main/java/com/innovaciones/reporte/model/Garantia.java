package com.innovaciones.reporte.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "garantia")
public class Garantia {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer duracion;
    private Integer estado;
    private Categoria categoria;
    private Collection<GarantiaCondicion> garantiaCondicionsById;
    private Collection<GarantiaDetalle> garantiaDetallesById;
    private Integer timeBeforeAlert;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "duracion")
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Column(name = "estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Column(name = "time_before_alert")
    public Integer getTimeBeforeAlert() {
        return timeBeforeAlert;
    }

    public void setTimeBeforeAlert(Integer timeBeforeAlert) {
        this.timeBeforeAlert = timeBeforeAlert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garantia garantia = (Garantia) o;

        if (id != garantia.id) return false;
        if (nombre != null ? !nombre.equals(garantia.nombre) : garantia.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(garantia.descripcion) : garantia.descripcion != null)
            return false;
        if (duracion != null ? !duracion.equals(garantia.duracion) : garantia.duracion != null) return false;
        if (!estado.equals(garantia.estado)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (duracion != null ? duracion.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "garantia")
    public Collection<GarantiaCondicion> getGarantiaCondicionsById() {
        return garantiaCondicionsById;
    }

    public void setGarantiaCondicionsById(Collection<GarantiaCondicion> garantiaCondicionsById) {
        this.garantiaCondicionsById = garantiaCondicionsById;
    }

    @OneToMany(mappedBy = "garantia")
    public Collection<GarantiaDetalle> getGarantiaDetallesById() {
        return garantiaDetallesById;
    }

    public void setGarantiaDetallesById(Collection<GarantiaDetalle> garantiaDetallesById) {
        this.garantiaDetallesById = garantiaDetallesById;
    }
}
