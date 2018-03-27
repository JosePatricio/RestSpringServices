/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_padre")
    private Integer idPadre;
    @Column(name = "id_ancestro")
    private Integer idAncestro;
    @Basic(optional = false)
    @Column(name = "codigo_fabricante")
    private String codigoFabricante;
    @Column(name = "codigo_anterior")
    private String codigoAnterior;
    @Column(name = "codigo_ancestro")
    private String codigoAncestro;
    @Column(name = "codigo_interno")
    private String codigoInterno;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "version_firmware")
    private String versionFirmware;
    @Column(name = "campo_1")
    private String campo1;
    @Column(name = "campo_2")
    private String campo2;
    @Basic(optional = false)
    @Column(name = "estado")
    private Integer estado;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "id_usuario_registro")
    private int idUsuarioRegistro;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "id_usuario_modicacion")
    private Integer idUsuarioModicacion;

    @Column(name = "tiene_compatible")
    private Boolean tieneCompatible;

    @Column(name = "precio_sin_iva")
    private BigDecimal precioSinIva;
    @Column(name = "precio_iva")
    private BigDecimal precioIva;
    @Column(name = "precio_distribuidor")
    private BigDecimal precioDistribuidor;
    @Column(name = "precio_mayorista")
    private BigDecimal precioMayorista;
    @Column(name = "precio_canal")
    private BigDecimal precioCanal;
    @Column(name = "precio_mega_canal")
    private BigDecimal precioMegaCanal;

    @Basic(optional = false)
    @Column(name = "requiere_serial")
    private boolean requiereSerial;
    @Column(name = "descripcion_compra")
    private String descripcionCompra;
    @Column(name = "descripcion_venta")
    private String descripcionVenta;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "stock_maximo")
    private Integer stockMaximo;
    @Column(name = "stock_actual")
    private Integer stockActual;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<ProductoRepuestoReporte> productoRepuestoReporteList;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria idCategoria;

    @JoinColumn(name = "id_proveedor_preferido", referencedColumnName = "id")
    @ManyToOne
    private Proveedor idProveedorPreferido;
    
    @JoinColumn(name = "id_modelo", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private Modelo idModelo;

    @JoinColumn(name = "id_marca", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = true)
    private Marca idMarca;

    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id")
    @ManyToOne
    private UnidadMedida idUnidadMedida;

    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id")
    @ManyToOne
    private TipoProducto idTipoProducto;

    @JsonIgnore
    @OneToMany(mappedBy = "idProducto")
    private List<DetalleInventario> detalleInventarioList;

    @JsonIgnore
    @OneToMany(mappedBy = "idProducto")
    private List<ProductoClienteReporte> productoClienteReporteList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<ProductoModelo> productoModeloList;

    @JsonIgnore
    @OneToMany(mappedBy = "idProducto")
    private List<DetalleEgreso> detalleEgresoList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<AsignacionReparacion> asignacionReparacionList;

    @Getter
    @Setter
    @Transient
    List<Modelo> modeloCompatibleList;

    @Getter
    @Setter
    @Transient
    ProductoRepuestoReporte productoRepuestoReporte;

    @Getter
    @Setter
    @Transient
    List<UbicacionProductoBodega> ubicacionesProducto;

    @Column(name = "is_ciclo_mantenimiento")
    private Boolean cicloMantenimiento;

    @Column(name = "vida_util")
    private Integer vidaUtil;

    @Column(name = "rendimiento_fabrica")
    private Integer rendimientoFabrica;

    @Column(name = "rendimiento_real")
    private Integer rendimientoReal;

    @Column(name = "rendimiento_extendido")
    private Integer rendimientoExtendido;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String codigoFabricante, Integer estado, Date fechaRegistro, int idUsuarioRegistro, boolean requiereSerial) {
        this.id = id;
        this.codigoFabricante = codigoFabricante;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.requiereSerial = requiereSerial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Integer getIdAncestro() {
        return idAncestro;
    }

    public void setIdAncestro(Integer idAncestro) {
        this.idAncestro = idAncestro;
    }

    public String getCodigoFabricante() {
        return codigoFabricante;
    }

    public void setCodigoFabricante(String codigoFabricante) {
        this.codigoFabricante = codigoFabricante;
    }

    public String getCodigoAnterior() {
        return codigoAnterior;
    }

    public void setCodigoAnterior(String codigoAnterior) {
        this.codigoAnterior = codigoAnterior;
    }

    public String getCodigoAncestro() {
        return codigoAncestro;
    }

    public void setCodigoAncestro(String codigoAncestro) {
        this.codigoAncestro = codigoAncestro;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getVersionFirmware() {
        return versionFirmware;
    }

    public void setVersionFirmware(String versionFirmware) {
        this.versionFirmware = versionFirmware;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(int idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdUsuarioModicacion() {
        return idUsuarioModicacion;
    }

    public void setIdUsuarioModicacion(Integer idUsuarioModicacion) {
        this.idUsuarioModicacion = idUsuarioModicacion;
    }

    public Boolean getTieneCompatible() {
        return tieneCompatible;
    }

    public void setTieneCompatible(Boolean tieneCompatible) {
        this.tieneCompatible = tieneCompatible;
    }

    public BigDecimal getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(BigDecimal precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public BigDecimal getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(BigDecimal precioIva) {
        this.precioIva = precioIva;
    }

    public BigDecimal getPrecioDistribuidor() {
        return precioDistribuidor;
    }

    public void setPrecioDistribuidor(BigDecimal precioDistribuidor) {
        this.precioDistribuidor = precioDistribuidor;
    }

    public BigDecimal getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(BigDecimal precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

    public BigDecimal getPrecioCanal() {
        return precioCanal;
    }

    public void setPrecioCanal(BigDecimal precioCanal) {
        this.precioCanal = precioCanal;
    }

    public BigDecimal getPrecioMegaCanal() {
        return precioMegaCanal;
    }

    public void setPrecioMegaCanal(BigDecimal precioMegaCanal) {
        this.precioMegaCanal = precioMegaCanal;
    }

    public boolean getRequiereSerial() {
        return requiereSerial;
    }

    public void setRequiereSerial(boolean requiereSerial) {
        this.requiereSerial = requiereSerial;
    }

    public String getDescripcionCompra() {
        return descripcionCompra;
    }

    public void setDescripcionCompra(String descripcionCompra) {
        this.descripcionCompra = descripcionCompra;
    }

    public String getDescripcionVenta() {
        return descripcionVenta;
    }

    public void setDescripcionVenta(String descripcionVenta) {
        this.descripcionVenta = descripcionVenta;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    @XmlTransient
    public List<ProductoRepuestoReporte> getProductoRepuestoReporteList() {
        return productoRepuestoReporteList;
    }

    public void setProductoRepuestoReporteList(List<ProductoRepuestoReporte> productoRepuestoReporteList) {
        this.productoRepuestoReporteList = productoRepuestoReporteList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Proveedor getIdProveedorPreferido() {
        return idProveedorPreferido;
    }

    public void setIdProveedorPreferido(Proveedor idProveedorPreferido) {
        this.idProveedorPreferido = idProveedorPreferido;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public UnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(UnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public TipoProducto getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProducto idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public Boolean getCicloMantenimiento() {
        return cicloMantenimiento;
    }

    public void setCicloMantenimiento(Boolean cicloMantenimiento) {
        this.cicloMantenimiento = cicloMantenimiento;
    }

    public Integer getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public Integer getRendimientoFabrica() {
        return rendimientoFabrica;
    }

    public void setRendimientoFabrica(Integer rendimientoFabrica) {
        this.rendimientoFabrica = rendimientoFabrica;
    }

    public Integer getRendimientoReal() {
        return rendimientoReal;
    }

    public void setRendimientoReal(Integer rendimientoReal) {
        this.rendimientoReal = rendimientoReal;
    }

    public Integer getRendimientoExtendido() {
        return rendimientoExtendido;
    }

    public void setRendimientoExtendido(Integer rendimientoExtendido) {
        this.rendimientoExtendido = rendimientoExtendido;
    }

    @XmlTransient
    public List<DetalleInventario> getDetalleInventarioList() {
        return detalleInventarioList;
    }

    public void setDetalleInventarioList(List<DetalleInventario> detalleInventarioList) {
        this.detalleInventarioList = detalleInventarioList;
    }

    @XmlTransient
    public List<ProductoClienteReporte> getProductoClienteReporteList() {
        return productoClienteReporteList;
    }

    public void setProductoClienteReporteList(List<ProductoClienteReporte> productoClienteReporteList) {
        this.productoClienteReporteList = productoClienteReporteList;
    }

    @XmlTransient
    public List<ProductoModelo> getProductoModeloList() {
        return productoModeloList;
    }

    public void setProductoModeloList(List<ProductoModelo> productoModeloList) {
        this.productoModeloList = productoModeloList;
    }

    @XmlTransient
    public List<DetalleEgreso> getDetalleEgresoList() {
        return detalleEgresoList;
    }

    public void setDetalleEgresoList(List<DetalleEgreso> detalleEgresoList) {
        this.detalleEgresoList = detalleEgresoList;
    }

    @XmlTransient
    public List<AsignacionReparacion> getAsignacionReparacionList() {
        return asignacionReparacionList;
    }

    public void setAsignacionReparacionList(List<AsignacionReparacion> asignacionReparacionList) {
        this.asignacionReparacionList = asignacionReparacionList;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public Producto clone() throws CloneNotSupportedException {
        return (Producto) super.clone();
    }

    @Override
    public String toString() {
        return "Producto{ id= " + id + "'}'";
    }

}
