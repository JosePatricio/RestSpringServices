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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "producto_cliente_reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoClienteReporte.findAll", query = "SELECT p FROM ProductoClienteReporte p")})
public class ProductoClienteReporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @Column(name = "atencion")
    private String atencion;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "ip_equipo")
    private String ipEquipo;
    @Column(name = "puerto_usb")
    private String puertoUsb;
    @Column(name = "direccion_equipo")
    private String direccionEquipo;
    @Column(name = "telefono_equipo")
    private String telefonoEquipo;
    @Column(name = "correo_equipo")
    private String correoEquipo;
    @Column(name = "celular_equipo")
    private String celularEquipo;
    @Column(name = "contacto_equipo")
    private String contactoEquipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoClienteReporte", fetch = FetchType.EAGER)
    private List<ReporteMantenimiento> reporteMantenimientoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoClienteReporte", fetch = FetchType.EAGER)
    private List<ReporteGenericoItems> reporteGenericoItemsList;

    @JoinColumn(name = "id_reporte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reporte idReporte;
    @JoinColumn(name = "id_producto_detalle_reporte", referencedColumnName = "id")
    @ManyToOne
    private ProductoDetalleReporte idProductoDetalleReporte;
    @JoinColumn(name = "id_detalle_reporte_instalacion_nueva", referencedColumnName = "id")
    @ManyToOne
    private DetalleReporteInstalacionNueva idDetalleReporteInstalacionNueva;
    @JoinColumn(name = "id_detalle_reporte_temporal", referencedColumnName = "id")
    @ManyToOne
    private DetalleReporteTemporal idDetalleReporteTemporal;
    @JoinColumn(name = "id_cliente_sucursal", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClienteSucursal idClienteSucursal;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_detalle_inventario_producto", referencedColumnName = "id")
    @ManyToOne
    private DetalleInventarioProducto idDetalleInventarioProducto;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    @ManyToOne
    private Proyectos idProyecto;
    @Column(name = "correo_atencion")
    private String correoAtencion;

    public ProductoClienteReporte() {
    }

    public ProductoClienteReporte(Integer id) {
        this.id = id;
    }

    public ProductoClienteReporte(Integer id, String atencion, String ipEquipo) {
        this.id = id;
        this.atencion = atencion;
        this.ipEquipo = ipEquipo;
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

    public String getCorreoAtencion() {
        return correoAtencion;
    }

    public void setCorreoAtencion(String correoAtencion) {
        this.correoAtencion = correoAtencion;
    }

    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getDireccionEquipo() {
        return direccionEquipo;
    }

    public void setDireccionEquipo(String direccionEquipo) {
        this.direccionEquipo = direccionEquipo;
    }

    public String getTelefonoEquipo() {
        return telefonoEquipo;
    }

    public void setTelefonoEquipo(String telefonoEquipo) {
        this.telefonoEquipo = telefonoEquipo;
    }

    public String getCorreoEquipo() {
        return correoEquipo;
    }

    public void setCorreoEquipo(String correoEquipo) {
        this.correoEquipo = correoEquipo;
    }

    public String getCelularEquipo() {
        return celularEquipo;
    }

    public void setCelularEquipo(String celularEquipo) {
        this.celularEquipo = celularEquipo;
    }

    public String getContactoEquipo() {
        return contactoEquipo;
    }

    public void setContactoEquipo(String contactoEquipo) {
        this.contactoEquipo = contactoEquipo;
    }

    @XmlTransient
    public List<ReporteMantenimiento> getReporteMantenimientoList() {
        return reporteMantenimientoList;
    }

    public void setReporteMantenimientoList(List<ReporteMantenimiento> reporteMantenimientoList) {
        this.reporteMantenimientoList = reporteMantenimientoList;
    }

    public Reporte getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Reporte idReporte) {
        this.idReporte = idReporte;
    }

    public ProductoDetalleReporte getIdProductoDetalleReporte() {
        return idProductoDetalleReporte;
    }

    public void setIdProductoDetalleReporte(ProductoDetalleReporte idProductoDetalleReporte) {
        this.idProductoDetalleReporte = idProductoDetalleReporte;
    }

    public DetalleReporteInstalacionNueva getIdDetalleReporteInstalacionNueva() {
        return idDetalleReporteInstalacionNueva;
    }

    public void setIdDetalleReporteInstalacionNueva(DetalleReporteInstalacionNueva idDetalleReporteInstalacionNueva) {
        this.idDetalleReporteInstalacionNueva = idDetalleReporteInstalacionNueva;
    }

    public DetalleReporteTemporal getIdDetalleReporteTemporal() {
        return idDetalleReporteTemporal;
    }

    public void setIdDetalleReporteTemporal(DetalleReporteTemporal idDetalleReporteTemporal) {
        this.idDetalleReporteTemporal = idDetalleReporteTemporal;
    }

    public ClienteSucursal getIdClienteSucursal() {
        return idClienteSucursal;
    }

    public void setIdClienteSucursal(ClienteSucursal idClienteSucursal) {
        this.idClienteSucursal = idClienteSucursal;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Proyectos getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyectos idProyecto) {
        this.idProyecto = idProyecto;
    }

    public DetalleInventarioProducto getIdDetalleInventarioProducto() {
        return idDetalleInventarioProducto;
    }

    public void setIdDetalleInventarioProducto(DetalleInventarioProducto idDetalleInventarioProducto) {
        this.idDetalleInventarioProducto = idDetalleInventarioProducto;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @XmlTransient
    public List<ReporteGenericoItems> getReporteGenericoItemsList() {
        return reporteGenericoItemsList;
    }

    public void setReporteGenericoItemsList(List<ReporteGenericoItems> reporteGenericoItemsList) {
        this.reporteGenericoItemsList = reporteGenericoItemsList;
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
        if (!(object instanceof ProductoClienteReporte)) {
            return false;
        }
        ProductoClienteReporte other = (ProductoClienteReporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nProductoClienteReporte{" + "id=" + id + ", idProyecto=" + idProyecto + ", serie=" + serie + ", atencion=" + atencion + ", departamento=" + departamento + ", ciudad=" + ciudad
                + ", ipEquipo=" + ipEquipo + ", puertoUsb=" + puertoUsb + ", direccionEquipo=" + direccionEquipo + ", telefonoEquipo=" + telefonoEquipo
                + ", correoEquipo=" + correoEquipo + ", celularEquipo=" + celularEquipo + ", contactoEquipo=" + contactoEquipo
                + ", \n idDetalleReporteInstalacionNueva=" + idDetalleReporteInstalacionNueva + ",\n idDetalleReporteTemporal=" + idDetalleReporteTemporal
                + ",\n idClienteSucursal=" + idClienteSucursal + ",\n idCliente=" + idCliente + ", \nidDetalleInventarioProducto=" + idDetalleInventarioProducto + "\n" + '}';
    }

}
