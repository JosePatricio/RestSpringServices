/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "detalle_reporte_temporal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReporteTemporal.findAll", query = "SELECT d FROM DetalleReporteTemporal d")})
public class DetalleReporteTemporal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "serie")
    private String serie;
    @Column(name = "contador_total_anterior")
    private Integer contadorTotalAnterior;
    @Column(name = "contador_color_anterior")
    private Integer contadorColorAnterior;
    @Column(name = "contador_bn_anterior")
    private Integer contadorBnAnterior;
    @Column(name = "contador_total_actual")
    private Integer contadorTotalActual;
    @Column(name = "contador_color_actual")
    private Integer contadorColorActual;
    @Column(name = "contador_bn_actual")
    private Integer contadorBnActual;
    @Column(name = "contador_total_imp_real")
    private Integer contadorTotalImpReal;
    @Column(name = "contador_color_imp_real")
    private Integer contadorColorImpReal;
    @Column(name = "contador_bn_imp_real")
    private Integer contadorBnImpReal;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fase_neutro")
    private String faseNeutro;
    @Column(name = "fase_tierra")
    private String faseTierra;
    @Column(name = "neutro")
    private String neutro;
    @Column(name = "observacion_medicion")
    private String observacionMedicion;
    @Column(name = "ip_equipo")
    private String ipEquipo;
    @Column(name = "puerto_usb")
    private String puertoUsb;

    @JoinColumn(name = "id_cliente_sucursal", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClienteSucursal idClienteSucursal;
    @JoinColumn(name = "id_detalle_inventario_producto", referencedColumnName = "id")
    @ManyToOne
    private DetalleInventarioProducto idDetalleInventarioProducto;
    @JsonIgnore
    @OneToMany(mappedBy = "idDetalleReporteTemporal")
    private List<ProductoClienteReporte> productoClienteReporteList;

    public DetalleReporteTemporal() {
    }

    public DetalleReporteTemporal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getContadorTotalAnterior() {
        return contadorTotalAnterior;
    }

    public void setContadorTotalAnterior(Integer contadorTotalAnterior) {
        this.contadorTotalAnterior = contadorTotalAnterior;
    }

    public Integer getContadorColorAnterior() {
        return contadorColorAnterior;
    }

    public void setContadorColorAnterior(Integer contadorColorAnterior) {
        this.contadorColorAnterior = contadorColorAnterior;
    }

    public Integer getContadorBnAnterior() {
        return contadorBnAnterior;
    }

    public void setContadorBnAnterior(Integer contadorBnAnterior) {
        this.contadorBnAnterior = contadorBnAnterior;
    }

    public Integer getContadorTotalActual() {
        return contadorTotalActual;
    }

    public void setContadorTotalActual(Integer contadorTotalActual) {
        this.contadorTotalActual = contadorTotalActual;
    }

    public Integer getContadorColorActual() {
        return contadorColorActual;
    }

    public void setContadorColorActual(Integer contadorColorActual) {
        this.contadorColorActual = contadorColorActual;
    }

    public Integer getContadorBnActual() {
        return contadorBnActual;
    }

    public void setContadorBnActual(Integer contadorBnActual) {
        this.contadorBnActual = contadorBnActual;
    }

    public Integer getContadorTotalImpReal() {
        return contadorTotalImpReal;
    }

    public void setContadorTotalImpReal(Integer contadorTotalImpReal) {
        this.contadorTotalImpReal = contadorTotalImpReal;
    }

    public Integer getContadorColorImpReal() {
        return contadorColorImpReal;
    }

    public void setContadorColorImpReal(Integer contadorColorImpReal) {
        this.contadorColorImpReal = contadorColorImpReal;
    }

    public Integer getContadorBnImpReal() {
        return contadorBnImpReal;
    }

    public void setContadorBnImpReal(Integer contadorBnImpReal) {
        this.contadorBnImpReal = contadorBnImpReal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFaseNeutro() {
        return faseNeutro;
    }

    public void setFaseNeutro(String faseNeutro) {
        this.faseNeutro = faseNeutro;
    }

    public String getFaseTierra() {
        return faseTierra;
    }

    public void setFaseTierra(String faseTierra) {
        this.faseTierra = faseTierra;
    }

    public String getNeutro() {
        return neutro;
    }

    public void setNeutro(String neutro) {
        this.neutro = neutro;
    }

    public String getObservacionMedicion() {
        return observacionMedicion;
    }

    public void setObservacionMedicion(String observacionMedicion) {
        this.observacionMedicion = observacionMedicion;
    }

    public String getIpEquipo() {
        return ipEquipo;
    }

    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }

    public String getPuertoUsb() {
        return puertoUsb;
    }

    public void setPuertoUsb(String puertoUsb) {
        this.puertoUsb = puertoUsb;
    }

    public ClienteSucursal getIdClienteSucursal() {
        return idClienteSucursal;
    }

    public void setIdClienteSucursal(ClienteSucursal idClienteSucursal) {
        this.idClienteSucursal = idClienteSucursal;
    }

    public DetalleInventarioProducto getIdDetalleInventarioProducto() {
        return idDetalleInventarioProducto;
    }

    public void setIdDetalleInventarioProducto(DetalleInventarioProducto idDetalleInventarioProducto) {
        this.idDetalleInventarioProducto = idDetalleInventarioProducto;
    }

    @XmlTransient
    public List<ProductoClienteReporte> getProductoClienteReporteList() {
        return productoClienteReporteList;
    }

    public void setProductoClienteReporteList(List<ProductoClienteReporte> productoClienteReporteList) {
        this.productoClienteReporteList = productoClienteReporteList;
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
        if (!(object instanceof DetalleReporteTemporal)) {
            return false;
        }
        DetalleReporteTemporal other = (DetalleReporteTemporal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleReporteTemporal{" + "id=" + id + ", contadorTotalAnterior=" + contadorTotalAnterior + ", contadorColorAnterior=" + contadorColorAnterior
                + "\n, contadorBnAnterior=" + contadorBnAnterior + ", contadorTotalActual=" + contadorTotalActual + ", contadorColorActual=" + contadorColorActual
                + ",\n contadorBnActual=" + contadorBnActual + ", contadorTotalImpReal=" + contadorTotalImpReal + ", contadorColorImpReal=" + contadorColorImpReal
                + ",\n contadorBnImpReal=" + contadorBnImpReal + ", observaciones=" + observaciones
                + ",\n ipEquipo=" + ipEquipo + ", faseNeutro=" + faseNeutro + ", faseTierra=" + faseTierra + ", neutro=" + neutro + ", observacionMedicion=" + observacionMedicion
                + ",\n idClienteSucursal=" + idClienteSucursal + "\n\n" + '}';
    }

}
