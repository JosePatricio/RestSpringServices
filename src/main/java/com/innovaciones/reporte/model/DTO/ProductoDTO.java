/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fyaulema
 */
public class ProductoDTO implements Serializable {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer idPadre;
    @Getter
    @Setter
    private Integer idAncestro;

    @Getter
    @Setter
    private Integer idModelo;

    @Getter
    @Setter
    private String codigoModelo;

    @Getter
    @Setter
    private String nombreModelo;

    @Getter
    @Setter
    private Integer idMarca;

    @Getter
    @Setter
    private String codigoMarca;

    @Getter
    @Setter
    private String nombreMarca;

    @Getter
    @Setter
    private Integer idCategoria;
    @Getter
    @Setter
    private String codigoCategoria;

    @Getter
    @Setter
    private String nombreCategoria;

    @Getter
    @Setter
    private String codigoFabricante;
    @Getter
    @Setter
    private String codigoAnterior;
    @Getter
    @Setter
    private String codigoAncestro;
    @Getter
    @Setter
    private String codigoInterno;

    @Getter
    @Setter
    private String codigoBarras;
    @Getter
    @Setter
    private String equipo;
    @Getter
    @Setter
    private String descripcionCompra;

    @Getter
    @Setter
    private String descripcionVenta;

    @Getter
    @Setter
    private String firmware;
    @Getter
    @Setter
    private Integer idUsuarioRegistro;
    @Getter
    @Setter
    private String nombreUsuarioRegistro;
    @Getter
    @Setter
    private Integer idUsuarioModificacion;
    @Getter
    @Setter
    private String nombreUsuarioModificacion;
    @Getter
    @Setter
    private String campo1;
    @Getter
    @Setter
    private String campo2;
    @Getter
    @Setter
    private Date fechaRegistro;
    @Getter
    @Setter
    private Date fechaModificacion;
    @Getter
    @Setter
    private String esPadre;
    @Getter
    @Setter
    private Integer estado;
    @Getter
    @Setter
    private Boolean tieneOtro;
    @Getter
    @Setter
    private Boolean repuesto;

    @Getter
    @Setter
    private Boolean selected;

    @Getter
    @Setter
    private Integer stock;

    @Getter
    @Setter
    private Integer stockMinimo;

    @Getter
    @Setter
    private Integer stockMaximo;

    @Getter
    @Setter
    private String tipo;

    @Getter
    @Setter
    private String serial;

    @Getter
    @Setter
    private Integer idBodega;

    @Getter
    @Setter
    private String codigoBodega;

    @Getter
    @Setter
    private String nombreBodega;

    @Getter
    @Setter
    private String estadoProceso;

    @Getter
    @Setter
    private String unidadMedida;

    @Getter
    @Setter
    private String serialObligatorio;

    @Getter
    @Setter
    private String compatibleObligatorio;

    @Getter
    @Setter
    private String mueble;

    @Getter
    @Setter
    private String cajon;

    @Getter
    @Setter
    private String espacio;

    @Getter
    @Setter
    private String modelosCompatibles;

    @Getter
    @Setter
    private String nombreProductoEnReporte;

    @Getter
    @Setter
    private BigDecimal precioSinIva;
    @Getter
    @Setter
    private BigDecimal precioIva;
    @Getter
    @Setter
    private BigDecimal precioDistribuidor;
    @Getter
    @Setter
    private BigDecimal precioMayorista;
    @Getter
    @Setter
    private BigDecimal precioCanal;
    @Getter
    @Setter
    private BigDecimal precioMegaCanal;

    @Getter
    @Setter
    private String cicloMantenimiento;

    @Getter
    @Setter
    private Integer vidaUtil;
    
    @Getter
    @Setter
    private Integer rendimientoFabrica;
    
    @Getter
    @Setter
    private Integer rendimientoReal;
    
    @Getter
    @Setter
    private Integer rendimientoExtendido;

    @Getter
    @Setter
    private String estadoImportacion;

    @Override
    public String toString() {
        return "ProductoDTO{" + "id=" + id + ", idPadre=" + idPadre + ", idAncestro=" + idAncestro + ", idModelo=" + idModelo + ", codigoModelo=" + codigoModelo + ", nombreModelo=" + nombreModelo + ", idMarca=" + idMarca + ", codigoMarca=" + codigoMarca + ", nombreMarca=" + nombreMarca + ", idCategoria=" + idCategoria + ", codigoCategoria=" + codigoCategoria + ", nombreCategoria=" + nombreCategoria + ", codigoFabricante=" + codigoFabricante + ", codigoAnterior=" + codigoAnterior + ", codigoAncestro=" + codigoAncestro + ", codigoInterno=" + codigoInterno + ", codigoBarras=" + codigoBarras + ", equipo=" + equipo + ", descripcionCompra=" + descripcionCompra + ", descripcionVenta=" + descripcionVenta + ", firmware=" + firmware + ", idUsuarioRegistro=" + idUsuarioRegistro + ", nombreUsuarioRegistro=" + nombreUsuarioRegistro + ", idUsuarioModificacion=" + idUsuarioModificacion + ", nombreUsuarioModificacion=" + nombreUsuarioModificacion + ", campo1=" + campo1 + ", campo2=" + campo2 + ", fechaRegistro=" + fechaRegistro + ", fechaModificacion=" + fechaModificacion + ", esPadre=" + esPadre + ", estado=" + estado + ", tieneOtro=" + tieneOtro + ", repuesto=" + repuesto + ", selected=" + selected + ", stock=" + stock + ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + ", tipo=" + tipo + ", serial=" + serial + ", idBodega=" + idBodega + ", codigoBodega=" + codigoBodega + ", nombreBodega=" + nombreBodega + ", estadoProceso=" + estadoProceso + ", unidadMedida=" + unidadMedida + ", serialObligatorio=" + serialObligatorio + ", compatibleObligatorio=" + compatibleObligatorio + ", mueble=" + mueble + ", cajon=" + cajon + ", espacio=" + espacio + ", modelosCompatibles=" + modelosCompatibles + ", nombreProductoEnReporte=" + nombreProductoEnReporte + ", precioSinIva=" + precioSinIva + ", precioIva=" + precioIva + ", precioDistribuidor=" + precioDistribuidor + ", precioMayorista=" + precioMayorista + ", precioCanal=" + precioCanal + ", precioMegaCanal=" + precioMegaCanal + '}';
    }

}
