/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.model.DTO.DatosReporteDTO;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.model.DetalleInventarioProducto;
import com.innovaciones.reporte.model.DetalleReporteEcu911;
import com.innovaciones.reporte.model.DetalleReporteInstalacionNueva;
import com.innovaciones.reporte.model.DetalleReporteTemporal;
import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.ProductoDetalleReporte;
import com.innovaciones.reporte.model.Reporte;
import com.innovaciones.reporte.model.ReporteGenericoItems;
import com.innovaciones.reporte.model.Usuarios;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ReporteService {

    public Reporte save(Reporte reporte);

    public Reporte update(Reporte reporte);

    public Reporte geById(Integer idReporte);

    public List<Reporte> getByUserByTipo(Integer idUsuario, String tipo, String subtipo);

    public void saveAllReporte(Reporte reporte, Cliente cliente, Producto producto, String serie,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita,
            Usuarios usuarios, AsignacionReparacion asignacionReparacion, Integer idProyecto, List<List<DetalleCatalogoReporte>> listCorrectivos,
            List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros);

    public void saveAllReporteImpresoras(DatosReporteDTO datosReporteDTO);

    public void updateAllReporteImpresoras(DatosReporteDTO datosReporteDTO);

    public void saveAllReporteReparacion(Reporte reporte, Cliente cliente, Producto producto, DetalleInventarioProducto detalleInventarioProducto,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita,
            Usuarios usuarios, AsignacionReparacion asignacionReparacion, Integer idProyecto, List<List<DetalleCatalogoReporte>> listCorrectivos,
            List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros);

    public void updateAllReporte(Reporte reporte, Cliente cliente, Producto producto, DetalleInventarioProducto detalleInventarioProducto,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Integer idProyecto,
            Usuarios usuarios, List<List<DetalleCatalogoReporte>> listCorrectivos, List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros);

    public void saveAllInstalacion(String tipoInstalacion, Reporte reporte, Cliente cliente, Producto producto, Producto producto2, String serie, String serie2,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idProyecto,
            Integer idClienteSucursal2, DetalleReporteInstalacionNueva detalleReporteInstalacionNueva, DetalleReporteTemporal detalleReporteTemporal,
            Usuarios usuarios, AsignacionReparacion asignacionReparacion,
            List<DetalleCatalogoReporte> listPreguntas);

    public void updateAllInstalacion(String tipoInstalacion, Reporte reporte, Cliente cliente, Producto producto, Producto producto2, DetalleInventarioProducto detalleInventarioProducto1, DetalleInventarioProducto detalleInventarioProducto2,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idClienteSucursal2, Integer idProyecto,
            DetalleReporteInstalacionNueva detalleReporteInstalacionNueva, DetalleReporteTemporal detalleReporteTemporal,
            Usuarios usuarios, AsignacionReparacion asignacionReparacion,
            List<DetalleCatalogoReporte> listPreguntas);

    public void saveReporteEcu911(Reporte reporte, Cliente cliente, DetalleReporteEcu911 detalleReporteEcu911, ProductoClienteReporte productoClienteReporte,
            Integer idSucursal, Integer idProyecto, Usuarios usuarios);

    public void updateReporteEcu911(Reporte reporte, Cliente cliente, DetalleReporteEcu911 detalleReporteEcu911, ProductoClienteReporte productoClienteReporte,
            Integer idSucursal, Integer idProyecto, Usuarios usuarios);

    public boolean ingresoMasivoReportesEcu(List<DetalleReporteEcu911> reportes, Usuarios usuarios);

    public byte[] jasperReporte(int idReporte);

    public void saveReporteReporteGenerico(DatosReporteDTO datosReporteDTO);

    public void updateReporteReporteGenerico(DatosReporteDTO datosReporteDTO);

}
