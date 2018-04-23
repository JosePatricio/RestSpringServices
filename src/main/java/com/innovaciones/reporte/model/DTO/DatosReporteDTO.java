/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model.DTO;

import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.ProductoDetalleReporte;
import com.innovaciones.reporte.model.Reporte;
import com.innovaciones.reporte.model.ReporteGenericoItems;
import com.innovaciones.reporte.model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pisama
 */
@XmlRootElement
public class DatosReporteDTO implements Serializable {

    @XmlElement(name = "reporte")
    @Getter
    @Setter
    private Reporte reporte;
    @XmlElement(name = "cliente")
    @Getter
    @Setter
    private Cliente cliente;
    @XmlElement(name = "producto")
    @Getter
    @Setter
    private Producto producto;

    @XmlElement(name = "serie")
    @Getter
    @Setter
    private String serie;
    @XmlElement(name = "productoDetalleReporte")
    @Getter
    @Setter
    private ProductoDetalleReporte productoDetalleReporte;
    @XmlElement(name = "productoClienteReporte")
    @Getter
    @Setter
    private ProductoClienteReporte productoClienteReporte;
    @XmlElement(name = "idClienteSucursal")
    @Getter
    @Setter
    private Integer idClienteSucursal;
    @XmlElement(name = "idTipoVisita")
    @Getter
    @Setter
    private Integer idTipoVisita;
    @XmlElement(name = "usuarios")
    @Getter
    @Setter
    private Usuarios usuarios;
    @XmlElement(name = "asignacionReparacion")
    @Getter
    @Setter
    private AsignacionReparacion asignacionReparacion;
    @XmlElement(name = "idProyecto")
    @Getter
    @Setter
    private Integer idProyecto;

    @Transient
    @XmlElement(name = "lista1")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista1;
    @Transient
    @XmlElement(name = "lista2")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista2;
    @Transient
    @XmlElement(name = "lista3")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista3;
    @Transient
    @XmlElement(name = "lista4")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista4;
    @Transient
    @XmlElement(name = "lista5")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista5;
    @Transient
    @XmlElement(name = "lista6")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista6;
    @Transient
    @XmlElement(name = "lista7")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista7;
    @Transient
    @XmlElement(name = "lista8")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista8;
    @Transient
    @XmlElement(name = "lista9")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista9;
    @Transient
    @XmlElement(name = "lista10")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista10;
    @Transient
    @XmlElement(name = "lista11")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista11;
    @Transient
    @XmlElement(name = "lista12")
    @Getter
    @Setter
    private List<DetalleCatalogoReporte> lista12;

    @Transient
    @XmlElement(name = "itemsReporteGenerico")
    @Getter
    @Setter
    private List<ReporteGenericoItems> itemsReporteGenerico;

    @Override
    public String toString() {
        return "DatosReporteDTO{" + "reporte=" + reporte + ", cliente=" + cliente + ", producto=" + producto + ", serie=" + serie + ", productoDetalleReporte=" + productoDetalleReporte + ", productoClienteReporte=" + productoClienteReporte + ", idClienteSucursal=" + idClienteSucursal + ", idTipoVisita=" + idTipoVisita + ", usuarios=" + usuarios + ", asignacionReparacion=" + asignacionReparacion + ", idProyecto=" + idProyecto + '}';
    }

}
