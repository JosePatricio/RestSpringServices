/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ReporteDAO;
import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.model.ClienteSucursal;
import com.innovaciones.reporte.model.DTO.DatosReporteDTO;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.model.DetalleInventarioProducto;
import com.innovaciones.reporte.model.DetalleReporteEcu911;
import com.innovaciones.reporte.model.DetalleReporteInstalacionNueva;
import com.innovaciones.reporte.model.DetalleReporteTemporal;
import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.ProductoDetalleReporte;
import com.innovaciones.reporte.model.ProductoRepuestoReporte;
import com.innovaciones.reporte.model.Proyectos;
import com.innovaciones.reporte.model.Reporte;
import com.innovaciones.reporte.model.ReporteGenericoItems;
import com.innovaciones.reporte.model.ReporteMantenimiento;
import com.innovaciones.reporte.model.TipoVisita;
import com.innovaciones.reporte.model.Usuarios;
import com.innovaciones.reporte.util.Enums;
import com.innovaciones.reporte.util.ReporteTecnico;
import com.innovaciones.reporte.util.Utilities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "reporteService")
@ViewScoped
public class ReporteServiceImpl extends Utilities implements ReporteService, Serializable {

    @Setter
    private ReporteDAO reporteDAO;

    @Getter
    @Setter
    @ManagedProperty("#{reporteMantenimientoService}")
    private ReporteMantenimientoService reporteMantenimientoService;

    @Getter
    @Setter
    @ManagedProperty("#{productoDetalleReporteService}")
    private ProductoDetalleReporteService productoDetalleReporteService;

    @Getter
    @Setter
    @ManagedProperty("#{productoClienteReporteService}")
    private ProductoClienteReporteService productoClienteReporteService;

    @Getter
    @Setter
    @ManagedProperty("#{productoService}")
    private ProductoService productoService;

    @Getter
    @Setter
    @ManagedProperty("#{asignacionReparacionService}")
    private AsignacionReparacionService asignacionReparacionService;

    @Getter
    @Setter
    @ManagedProperty("#{productoRepuestoReporteService}")
    private ProductoRepuestoReporteService productoRepuestoReporteService;

    @Getter
    @Setter
    @ManagedProperty("#{detalleCatalogoReporteService}")
    private DetalleCatalogoReporteService detalleCatalogoReporteService;

    @Getter
    @Setter
    @ManagedProperty("#{detalleReporteInstalacionNuevaService}")
    private DetalleReporteInstalacionNuevaService detalleReporteInstalacionNuevaService;

    @Getter
    @Setter
    @ManagedProperty("#{detalleReporteTemporalService}")
    private DetalleReporteTemporalService detalleReporteTemporalService;

    @Getter
    @Setter
    @ManagedProperty("#{detalleInventarioProductoService}")
    private DetalleInventarioProductoService detalleInventarioProductoService;

    @Getter
    @Setter
    @ManagedProperty("#{detalleReporteEcu911Service}")
    private DetalleReporteEcu911Service detalleReporteEcu911Service;

    @Getter
    @Setter
    @ManagedProperty("#{consultasService}")
    private ConsultasService consultasService;

    @Getter
    @Setter
    @ManagedProperty("#{clienteService}")
    private ClienteService clienteService;

    @Getter
    @Setter
    @ManagedProperty("#{parametrosService}")
    private ParametrosService parametrosService;

    @Getter
    @Setter
    @ManagedProperty("#{clienteSucursalService}")
    private ClienteSucursalService clienteSucursalService;

    @Getter
    @Setter
    @ManagedProperty("#{tipoVisitaService}")
    private TipoVisitaService tipoVisitaService;

    @Getter
    @Setter
    @ManagedProperty("#{reporteGenericoItemsService}")
    private ReporteGenericoItemsService reporteGenericoItemsService;

    @Getter
    @Setter
    @ManagedProperty("#{cabeceraCatalogoReporteService}")
    private CabeceraCatalogoReporteService cabeceraCatalogoReporteService;

    private ProductoClienteReporte globalProductoClienteReporte;
    private ReporteMantenimiento mantenimiento;
    private ReporteMantenimiento mantenimientoAux;

    private ReporteGenericoItems reporteGenericoItem;
    private ReporteGenericoItems reporteGenericoItemAux;

    @Override
    @Transactional
    public Reporte save(Reporte reporte) {
        return reporteDAO.saveReporte(reporte);
    }

    @Override
    @Transactional
    public Reporte update(Reporte reporte) {
        return reporteDAO.updateReporte(reporte);
    }

    @Override
    @Transactional
    public Reporte geById(Integer idReporte) {
        return reporteDAO.getReporteById(idReporte);
    }

    @Override
    @Transactional
    public List<Reporte> getByUserByTipo(Integer idUsuario, String tipo, String subtipo) {
        return reporteDAO.getReporteByUserByTipo(idUsuario, tipo, subtipo);
    }

    @Override
    @Transactional
    public void saveAllReporteMobile(Reporte reporte, Cliente cliente, Producto producto, String serie, ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Usuarios usuario, AsignacionReparacion asignacionReparacion, Integer idProyecto, List<List<DetalleCatalogoReporte>> listCorrectivos, List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros) {
        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFecha(new Date());
        newReporte.setFechaCreacion(new Date());
        newReporte.setUsuarioCreacion(usuario.getUsuario());
        newReporte = this.save((Reporte) toUpperCaseStrings(newReporte));

        DetalleInventarioProducto searchDetalleInventarioProducto = new DetalleInventarioProducto();

        searchDetalleInventarioProducto = detalleInventarioProductoService.getBySerial(serie);

        boolean existeDetalleInventarioProducto = (searchDetalleInventarioProducto == null);
        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();

        newProductoClienteReporte = productoClienteReporte;

        if (existeDetalleInventarioProducto) {

            searchDetalleInventarioProducto = null;
        }

        newProductoClienteReporte.setIdDetalleInventarioProducto(searchDetalleInventarioProducto);
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdCliente(cliente);
        newProductoClienteReporte.setSerie(serie);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.add(productoDetalleReporte));

        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = (productoClienteReporteService.save(newProductoClienteReporte));

        if (asignacionReparacion != null && asignacionReparacion.getId() != null) {
            AsignacionReparacion newAsignacionReparacion = new AsignacionReparacion();

            newAsignacionReparacion = asignacionReparacion;
            newAsignacionReparacion.setIdReporte(newReporte.getId());
            newAsignacionReparacion.setEstado(newReporte.getEstado());
            asignacionReparacionService.addAsignacionReparacion(asignacionReparacion);
        }

        this.saveRepuestosReportePreventivosMobile(globalProductoClienteReporte, listPreventivos);
        this.saveRepuestosReporteCorrectivosMobile(globalProductoClienteReporte, listCorrectivos);
    }

    @Override
    @Transactional
    public void updateAllReporteMobile(Reporte reporte, Cliente cliente, Producto producto, DetalleInventarioProducto detalleInventarioProducto, ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Integer idProyecto, Usuarios usuario, List<List<DetalleCatalogoReporte>> listCorrectivos, List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros) {
        globalProductoClienteReporte = new ProductoClienteReporte();
        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFechaModificacion(new Date());
        newReporte.setUsuarioModificacion(usuario.getUsuario());
        newReporte = this.update((Reporte) toUpperCaseStrings(newReporte));

        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.update(productoDetalleReporte));
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = productoClienteReporteService.update(newProductoClienteReporte);

        this.updateListReporteMantenimientoPreventivoMobile(productoClienteReporte, listPreventivos);
        this.updateListReporteMantenimientoCorrectivoMobile(productoClienteReporte, listCorrectivos);

        System.out.println(" ACUALIZACION FINALIZADA ");
        //this.updateOtrosRepuestos(productoClienteReporte, listOtros);

        /*  byte[] bytes = ReporteTecnico.jasperBytesReportes(productoClienteReporte, tipoVisitaService, detalleCatalogoReporteService, cabeceraCatalogoReporteService);
        enviarMail(parametrosService, bytes, newProductoClienteReporte.getIdCliente().getEmail(), "Edición de Reporte", "Reporte ");*/
    }

    @Override
    @Transactional
    public void saveAllReporte(Reporte reporte, Cliente cliente, Producto producto, String serie, ProductoDetalleReporte productoDetalleReporte,
            ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita,
            Usuarios usuario, AsignacionReparacion asignacionReparacion, Integer idProyecto, List<List<DetalleCatalogoReporte>> listCorrectivos,
            List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros) {
        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFecha(new Date());
        newReporte.setFechaCreacion(new Date());
        newReporte.setUsuarioCreacion(usuario.getUsuario());

        newReporte = this.save((Reporte) toUpperCaseStrings(newReporte));

        DetalleInventarioProducto searchDetalleInventarioProducto = new DetalleInventarioProducto();

        searchDetalleInventarioProducto = detalleInventarioProductoService.getBySerial(serie);

        boolean existeDetalleInventarioProducto = (searchDetalleInventarioProducto == null);
        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();

        newProductoClienteReporte = productoClienteReporte;

        if (existeDetalleInventarioProducto) {

            searchDetalleInventarioProducto = null;
        }

        newProductoClienteReporte.setIdDetalleInventarioProducto(searchDetalleInventarioProducto);
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdCliente(cliente);
        newProductoClienteReporte.setSerie(serie);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.add(productoDetalleReporte));

        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = (productoClienteReporteService.save(newProductoClienteReporte));

        if (asignacionReparacion != null && asignacionReparacion.getId() != null) {
            AsignacionReparacion newAsignacionReparacion = new AsignacionReparacion();

            newAsignacionReparacion = asignacionReparacion;
            newAsignacionReparacion.setIdReporte(newReporte.getId());
            newAsignacionReparacion.setEstado(newReporte.getEstado());
            asignacionReparacionService.addAsignacionReparacion(asignacionReparacion);
        }

        this.saveRepuestosReportePreventivos(globalProductoClienteReporte, listPreventivos);
        this.saveRepuestosReporteCorrectivos(globalProductoClienteReporte, listCorrectivos);

    }

    @Override
    @Transactional
    public void updateAllReporte(Reporte reporte, Cliente cliente, Producto producto, DetalleInventarioProducto detalleInventarioProducto, ProductoDetalleReporte productoDetalleReporte,
            ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Integer idProyecto, Usuarios usuario,
            List<List<DetalleCatalogoReporte>> listCorrectivos, List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros) {

        globalProductoClienteReporte = new ProductoClienteReporte();
        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFechaModificacion(new Date());
        newReporte.setUsuarioModificacion(usuario.getUsuario());
        newReporte = this.update((Reporte) toUpperCaseStrings(newReporte));

        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.update(productoDetalleReporte));
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = productoClienteReporteService.saveOrUpdateProductoClienteReporte(newProductoClienteReporte);

        this.updateListReporteMantenimientoPreventivo(productoClienteReporte, listPreventivos);
        this.updateListReporteMantenimientoCorrectivo(productoClienteReporte, listCorrectivos);

        System.out.println(" ACUALIZACION FINALIZADA ");
        //this.updateOtrosRepuestos(productoClienteReporte, listOtros);

        /*  byte[] bytes = ReporteTecnico.jasperBytesReportes(productoClienteReporte, tipoVisitaService, detalleCatalogoReporteService, cabeceraCatalogoReporteService);
        enviarMail(parametrosService, bytes, newProductoClienteReporte.getIdCliente().getEmail(), "Edición de Reporte", "Reporte ");*/
    }

    @Override
    @Transactional
    public void saveAllReporteImpresoras(DatosReporteDTO datosReporteDTO) {

        List<List<DetalleCatalogoReporte>> listCorrectivos = new ArrayList<>();
        List<List<DetalleCatalogoReporte>> listPreventivos = new ArrayList<>();

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_DIAGNOSTICO.getValue()) || datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_REPARACION.getValue())) {

            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }
            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista4());
            }

            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
            if (datosReporteDTO.getLista7() != null && !datosReporteDTO.getLista7().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista7());
            }
            if (datosReporteDTO.getLista7() != null && !datosReporteDTO.getLista7().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista7());
            }
            if (datosReporteDTO.getLista7() != null && !datosReporteDTO.getLista7().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista7());
            }
            if (datosReporteDTO.getLista8() != null && !datosReporteDTO.getLista8().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista8());
            }
            if (datosReporteDTO.getLista9() != null && !datosReporteDTO.getLista9().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista9());
            }
        }

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_SCANNERS.getValue())) {
            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }

            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista4());
            }
            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
        }

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_MONITORES.getValue())) {
            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }

            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista4());
            }
            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
        }

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_TRITURADORAS.getValue())) {
            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }

            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista4());
            }
            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
        }

        this.saveAllReporteMobile(datosReporteDTO.getReporte(), datosReporteDTO.getCliente(), datosReporteDTO.getProducto(), datosReporteDTO.getSerie(), datosReporteDTO.getProductoDetalleReporte(),
                datosReporteDTO.getProductoClienteReporte(), datosReporteDTO.getIdClienteSucursal(), datosReporteDTO.getIdTipoVisita(), datosReporteDTO.getUsuarios(), datosReporteDTO.getAsignacionReparacion(),
                datosReporteDTO.getIdProyecto(), listCorrectivos, listPreventivos, datosReporteDTO.getLista10());

    }

    @Override
    @Transactional
    public void updateAllReporteImpresoras(DatosReporteDTO datosReporteDTO) {

        List<List<DetalleCatalogoReporte>> listCorrectivos = new ArrayList<>();
        List<List<DetalleCatalogoReporte>> listPreventivos = new ArrayList<>();

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_DIAGNOSTICO.getValue()) || datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_REPARACION.getValue())) {

            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }
            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista4());
            }

            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
            if (datosReporteDTO.getLista7() != null && !datosReporteDTO.getLista7().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista7());
            }
            if (datosReporteDTO.getLista7() != null && !datosReporteDTO.getLista7().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista7());
            }
            if (datosReporteDTO.getLista7() != null && !datosReporteDTO.getLista7().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista7());
            }
            if (datosReporteDTO.getLista8() != null && !datosReporteDTO.getLista8().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista8());
            }
            if (datosReporteDTO.getLista9() != null && !datosReporteDTO.getLista9().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista9());
            }
        }

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_SCANNERS.getValue())) {
            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }

            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista4());
            }
            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
        }

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_MONITORES.getValue())) {
            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }

            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista4());
            }
            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
        }

        if (datosReporteDTO.getReporte().getSubtipo().equals(Enums.TIPO_REPORTE_TRITURADORAS.getValue())) {
            if (datosReporteDTO.getLista1() != null && !datosReporteDTO.getLista1().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista1());
            }
            if (datosReporteDTO.getLista2() != null && !datosReporteDTO.getLista2().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista2());
            }
            if (datosReporteDTO.getLista3() != null && !datosReporteDTO.getLista3().isEmpty()) {
                listPreventivos.add(datosReporteDTO.getLista3());
            }

            if (datosReporteDTO.getLista4() != null && !datosReporteDTO.getLista4().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista4());
            }
            if (datosReporteDTO.getLista5() != null && !datosReporteDTO.getLista5().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista5());
            }
            if (datosReporteDTO.getLista6() != null && !datosReporteDTO.getLista6().isEmpty()) {
                listCorrectivos.add(datosReporteDTO.getLista6());
            }
        }

        this.updateAllReporteMobile(datosReporteDTO.getReporte(), datosReporteDTO.getCliente(), datosReporteDTO.getProducto(),
                new DetalleInventarioProducto(), datosReporteDTO.getProductoDetalleReporte(), datosReporteDTO.getProductoClienteReporte(),
                datosReporteDTO.getIdClienteSucursal(), datosReporteDTO.getIdTipoVisita(), datosReporteDTO.getIdProyecto(),
                datosReporteDTO.getUsuarios(), listCorrectivos, listPreventivos, datosReporteDTO.getLista10());

    }

    @Override
    @Transactional
    public void saveAllReporteReparacion(Reporte reporte, Cliente cliente, Producto producto, DetalleInventarioProducto detalleInventarioProducto, ProductoDetalleReporte productoDetalleReporte,
            ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Usuarios usuario, AsignacionReparacion asignacionReparacion, Integer idProyecto,
            List<List<DetalleCatalogoReporte>> listCorrectivos, List<List<DetalleCatalogoReporte>> listPreventivos, List<DetalleCatalogoReporte> listOtros) {

        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte newReporte = new Reporte(), oldReporte = new Reporte();

        oldReporte = productoClienteReporteService.getByReportId(reporte.getId()).getIdReporte();
        oldReporte.setEstado(Enums.ESTADO_REPORTE_FINALIADO.getValue());
        oldReporte = this.save((Reporte) toUpperCaseStrings(oldReporte));

        newReporte.setFactura(reporte.getFactura());
        newReporte.setFirmaCliente(reporte.getFirmaCliente());
        newReporte.setFirmaClienteBase64(reporte.getFirmaClienteBase64());
        newReporte.setHoraFin(reporte.getHoraFin());
        newReporte.setHoraInicio(reporte.getHoraInicio());
        newReporte.setNombreCliente(reporte.getNombreCliente());
        newReporte.setNotas(reporte.getNotas());
        newReporte.setNumerofactura(reporte.getNumerofactura());
        newReporte.setObservacionMantenimiento(reporte.getObservacionMantenimiento());
        newReporte.setObservacionesRecomendaciones(reporte.getObservacionesRecomendaciones());
        newReporte.setReferencia(reporte.getReferencia());
        newReporte.setSintomasEquipo(reporte.getSintomasEquipo());
        newReporte.setSubtipo(reporte.getSubtipo() + "->" + Enums.TIPO_REPORTE_REPARACION.getValue());
        newReporte.setTipo(reporte.getTipo());
        newReporte.setEstado(reporte.getEstado());
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFecha(new Date());
        newReporte.setFechaCreacion(new Date());
        newReporte.setUsuarioCreacion(usuario.getUsuario());
        newReporte = this.save((Reporte) toUpperCaseStrings(newReporte));

        DetalleInventarioProducto searchDetalleInventarioProducto = new DetalleInventarioProducto();
        searchDetalleInventarioProducto = detalleInventarioProductoService.getBySerial(detalleInventarioProducto.getSerial());
        boolean existeDetalleInventarioProducto = (searchDetalleInventarioProducto == null);
        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;
        if (existeDetalleInventarioProducto) {
            searchDetalleInventarioProducto = null;

        }
        newProductoClienteReporte.setSerie(detalleInventarioProducto.getSerial());
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdDetalleInventarioProducto(searchDetalleInventarioProducto);
        newProductoClienteReporte.setIdCliente(cliente);
        newProductoClienteReporte.setSerie(detalleInventarioProducto.getSerial());
        newProductoClienteReporte.setIdProducto(producto);
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        newProductoClienteReporte.setCelularEquipo(productoClienteReporte.getCelularEquipo());
        newProductoClienteReporte.setAtencion(productoClienteReporte.getAtencion());
        newProductoClienteReporte.setCiudad(productoClienteReporte.getCiudad());
        newProductoClienteReporte.setContactoEquipo(productoClienteReporte.getContactoEquipo());
        newProductoClienteReporte.setCorreoEquipo(productoClienteReporte.getCorreoEquipo());
        newProductoClienteReporte.setDepartamento(productoClienteReporte.getDepartamento());
        newProductoClienteReporte.setDireccionEquipo(productoClienteReporte.getDireccionEquipo());
        newProductoClienteReporte.setIpEquipo(productoClienteReporte.getIpEquipo());
        newProductoClienteReporte.setPuertoUsb(productoClienteReporte.getPuertoUsb());
        newProductoClienteReporte.setTelefonoEquipo(productoClienteReporte.getTelefonoEquipo());

        newProductoClienteReporte.setIdReporte(newReporte);

        ProductoDetalleReporte newDetalleReporte = new ProductoDetalleReporte();
        newDetalleReporte.setContadorBnActual(productoDetalleReporte.getContadorBnActual());
        newDetalleReporte.setContadorBnAnterior(productoDetalleReporte.getContadorBnAnterior());
        newDetalleReporte.setContadorBnImpReal(productoDetalleReporte.getContadorBnImpReal());
        newDetalleReporte.setContadorColorActual(productoDetalleReporte.getContadorColorActual());
        newDetalleReporte.setContadorColorAnterior(productoDetalleReporte.getContadorColorAnterior());
        newDetalleReporte.setContadorColorImpReal(productoDetalleReporte.getContadorColorImpReal());
        newDetalleReporte.setContadorTotalActual(productoDetalleReporte.getContadorTotalActual());
        newDetalleReporte.setContadorTotalAnterior(productoDetalleReporte.getContadorTotalAnterior());
        newDetalleReporte.setContadorTotalImpReal(productoDetalleReporte.getContadorTotalImpReal());
        newDetalleReporte.setServicioFacturar(productoDetalleReporte.getServicioFacturar());
        newDetalleReporte.setServicioFacturarEstado(productoDetalleReporte.getServicioFacturarEstado());
        newDetalleReporte = (ProductoDetalleReporte) toUpperCaseStrings(productoDetalleReporteService.add(newDetalleReporte));

        newProductoClienteReporte.setIdProductoDetalleReporte(newDetalleReporte);
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        newProductoClienteReporte.setReporteMantenimientoList(new ArrayList<>());
        globalProductoClienteReporte = productoClienteReporteService.save(newProductoClienteReporte);

        this.saveRepuestosReporteCorrectivos(globalProductoClienteReporte, listCorrectivos);
        this.saveRepuestosReportePreventivos(globalProductoClienteReporte, listPreventivos);
        // this.saveOtrosRepuestos(globalProductoClienteReporte, listOtros, usuario);
    }

    @Override
    @Transactional
    public void saveAllInstalacion(String tipoInstalacion, Reporte reporte, Cliente cliente, Producto producto, Producto producto2, String serie, String serie2,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idProyecto,
            Integer idClienteSucursal2, DetalleReporteInstalacionNueva detalleReporteInstalacionNueva, DetalleReporteTemporal detalleReporteTemporal,
            Usuarios usuario, AsignacionReparacion asignacionReparacion, List<DetalleCatalogoReporte> listPreguntas) {
        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdUsuario(usuario);
        newReporte.setFecha(new Date());
        newReporte.setFechaCreacion(new Date());
        newReporte.setUsuarioCreacion(usuario.getUsuario());
        newReporte.setEstado(serie);
        newReporte = this.save((Reporte) toUpperCaseStrings(newReporte));

        DetalleInventarioProducto searchDetalleInventarioProducto = new DetalleInventarioProducto();
        searchDetalleInventarioProducto = detalleInventarioProductoService.getBySerial(serie);

        boolean existeDetalleInventarioProducto = (searchDetalleInventarioProducto == null);
        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;

        if (existeDetalleInventarioProducto) {
            searchDetalleInventarioProducto = null;

        }
        newProductoClienteReporte.setIdDetalleInventarioProducto(searchDetalleInventarioProducto);

        newProductoClienteReporte = productoClienteReporte;
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setSerie(serie);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdCliente(cliente);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.add(productoDetalleReporte));
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        if (tipoInstalacion.equals(Enums.INSTALACION_NUEVA.getValue())) {
            DetalleReporteInstalacionNueva newDetalleReporteInstalacionNueva = new DetalleReporteInstalacionNueva();
            newDetalleReporteInstalacionNueva = detalleReporteInstalacionNuevaService.addDetalleReporteInstalacionNueva(detalleReporteInstalacionNueva);

            newProductoClienteReporte.setIdDetalleReporteInstalacionNueva(newDetalleReporteInstalacionNueva);

            newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
            newProductoClienteReporte
                    = productoClienteReporteService.saveOrUpdateProductoClienteReporte(newProductoClienteReporte);

            List<List<DetalleCatalogoReporte>> catalogoReportes = new ArrayList<>();
            catalogoReportes.add(listPreguntas);
            this.saveRepuestosReportePreventivos(productoClienteReporte, catalogoReportes);
        }

        if (tipoInstalacion.equals(Enums.INSTALACION_TEMPORAL.getValue())) {

            DetalleInventarioProducto searchDetalleInventarioProducto2 = new DetalleInventarioProducto();
            searchDetalleInventarioProducto2 = detalleInventarioProductoService.getBySerial(serie2);

            boolean existeDetalleInventarioProducto2 = (searchDetalleInventarioProducto2 == null);

            DetalleReporteTemporal newDetalleReporteTemporal = new DetalleReporteTemporal();
            newDetalleReporteTemporal = detalleReporteTemporal;

            if (existeDetalleInventarioProducto2) {
                searchDetalleInventarioProducto2 = null;

            }
            newDetalleReporteTemporal.setSerie(serie2);
            newDetalleReporteTemporal.setIdDetalleInventarioProducto(searchDetalleInventarioProducto2);
            newDetalleReporteTemporal.setNeutro(detalleReporteInstalacionNueva.getNeutro());
            newDetalleReporteTemporal.setFaseNeutro(detalleReporteInstalacionNueva.getFaseNeutro());
            newDetalleReporteTemporal.setFaseTierra(detalleReporteInstalacionNueva.getFaseTierra());
            newDetalleReporteTemporal.setObservacionMedicion(detalleReporteInstalacionNueva.getObservacion());

            newDetalleReporteTemporal.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal2));

            newDetalleReporteTemporal = detalleReporteTemporalService.addDetalleReporteTemporal((DetalleReporteTemporal) toUpperCaseStrings(newDetalleReporteTemporal));

            newProductoClienteReporte.setIdDetalleReporteTemporal(newDetalleReporteTemporal);

            newProductoClienteReporte = productoClienteReporteService.saveOrUpdateProductoClienteReporte(newProductoClienteReporte);

        }

        if (asignacionReparacion != null) {
            AsignacionReparacion newAsignacionReparacion = new AsignacionReparacion();

            newAsignacionReparacion = asignacionReparacion;
            newAsignacionReparacion.setIdReporte(newReporte.getId());
            newAsignacionReparacion.setEstado(newReporte.getEstado());
            asignacionReparacionService.addAsignacionReparacion(asignacionReparacion);
        }
        byte[] bytes = ReporteTecnico.jasperBytesReportes(productoClienteReporte, tipoVisitaService, detalleCatalogoReporteService, cabeceraCatalogoReporteService);
        enviarMail(parametrosService, bytes, newProductoClienteReporte.getIdCliente().getEmail(), "Nuevo Reporte", "Reporte ");
    }

    @Override
    @Transactional
    public void updateAllInstalacion(String tipoInstalacion, Reporte reporte, Cliente cliente, Producto producto1, Producto producto2,
            DetalleInventarioProducto detalleInventarioProducto1, DetalleInventarioProducto detalleInventarioProducto2,
            ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal,
            Integer idClienteSucursal2, Integer idProyecto, DetalleReporteInstalacionNueva detalleReporteInstalacionNueva, DetalleReporteTemporal detalleReporteTemporal,
            Usuarios usuario, AsignacionReparacion asignacionReparacion, List<DetalleCatalogoReporte> listPreguntas) {

        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdUsuario(usuario);
        newReporte.setFechaModificacion(new Date());
        newReporte.setUsuarioModificacion(usuario.getUsuario());
        newReporte = this.update((Reporte) toUpperCaseStrings(newReporte));

        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.add(productoDetalleReporte));
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));

        if (tipoInstalacion.equals(Enums.INSTALACION_NUEVA.getValue())) {

            DetalleReporteInstalacionNueva newDetalleReporteInstalacionNueva = new DetalleReporteInstalacionNueva();
            newDetalleReporteInstalacionNueva = detalleReporteInstalacionNuevaService.update(detalleReporteInstalacionNueva);

            newProductoClienteReporte.setIdDetalleReporteInstalacionNueva(newDetalleReporteInstalacionNueva);
            newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
            newProductoClienteReporte
                    = productoClienteReporteService.update(newProductoClienteReporte);

            List<List<DetalleCatalogoReporte>> catalogoReportes = new ArrayList<>();
            catalogoReportes.add(listPreguntas);

            this.updateListReporteMantenimientoPreventivo(productoClienteReporte, catalogoReportes);

        }

        if (tipoInstalacion.equals(Enums.INSTALACION_TEMPORAL.getValue())) {

            DetalleReporteTemporal newDetalleReporteTemporal = new DetalleReporteTemporal();

            newDetalleReporteTemporal = detalleReporteTemporal;
            newDetalleReporteTemporal.setNeutro(detalleReporteInstalacionNueva.getNeutro());
            newDetalleReporteTemporal.setFaseNeutro(detalleReporteInstalacionNueva.getFaseNeutro());
            newDetalleReporteTemporal.setFaseTierra(detalleReporteInstalacionNueva.getFaseTierra());
            newDetalleReporteTemporal.setObservacionMedicion(detalleReporteInstalacionNueva.getObservacion());

            newDetalleReporteTemporal.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal2));

            newDetalleReporteTemporal = detalleReporteTemporalService.addDetalleReporteTemporal((DetalleReporteTemporal) toUpperCaseStrings(newDetalleReporteTemporal));

            newProductoClienteReporte.setIdDetalleReporteTemporal(newDetalleReporteTemporal);

            productoDetalleReporte = productoDetalleReporteService.update((ProductoDetalleReporte) toUpperCaseStrings(productoDetalleReporte));
            newDetalleReporteTemporal.setNeutro(detalleReporteInstalacionNueva.getNeutro());
            newDetalleReporteTemporal.setFaseNeutro(detalleReporteInstalacionNueva.getFaseNeutro());
            newDetalleReporteTemporal.setFaseTierra(detalleReporteInstalacionNueva.getFaseTierra());
            newDetalleReporteTemporal.setObservacionMedicion(detalleReporteInstalacionNueva.getObservacion());

            DetalleReporteTemporal updateDetalleReporteTemporal = new DetalleReporteTemporal();

            updateDetalleReporteTemporal.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal2));

            updateDetalleReporteTemporal = detalleReporteTemporalService.updateDetalleReporteTemporal((DetalleReporteTemporal) toUpperCaseStrings(newDetalleReporteTemporal));
            newProductoClienteReporte = productoClienteReporteService.update(newProductoClienteReporte);

        }

    }

    @Override
    @Transactional
    public void saveReporteEcu911(Reporte reporte, Cliente cliente, DetalleReporteEcu911 detalleReporteEcu911, ProductoClienteReporte productoClienteReporte, Integer idSucursal, Integer idProyecto, Usuarios usuario) {
        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdUsuario(usuario);
        newReporte.setIdVisita(null);
        newReporte.setFecha(new Date());
        newReporte.setFechaCreacion(new Date());
        newReporte.setUsuarioCreacion(usuario.getUsuario());
        newReporte = this.save((Reporte) toUpperCaseStrings(newReporte));

        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdCliente(cliente);
        newProductoClienteReporte.setIpEquipo("");
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = productoClienteReporteService.save(newProductoClienteReporte);

        DetalleReporteEcu911 newDetalleReporteEcu9111 = new DetalleReporteEcu911();
        newDetalleReporteEcu9111 = detalleReporteEcu911;
        newDetalleReporteEcu9111.setIdReporte(newReporte);

        newDetalleReporteEcu9111 = detalleReporteEcu911Service.save((DetalleReporteEcu911) toUpperCaseStrings(newDetalleReporteEcu9111));
    }

    @Override
    @Transactional
    public void updateReporteEcu911(Reporte reporte, Cliente cliente, DetalleReporteEcu911 detalleReporteEcu911, ProductoClienteReporte productoClienteReporte, Integer idSucursal, Integer idProyecto, Usuarios usuario) {
        globalProductoClienteReporte = new ProductoClienteReporte();

        Reporte updatedReporte = new Reporte();
        updatedReporte = reporte;
        updatedReporte.setIdUsuario(usuario);
        updatedReporte.setIdVisita(null);
        updatedReporte.setFechaModificacion(new Date());
        updatedReporte.setUsuarioModificacion(usuario.getUsuario());
        updatedReporte = this.update((Reporte) toUpperCaseStrings(reporte));
        ProductoClienteReporte updatedProductoClienteReporte = new ProductoClienteReporte();
        updatedProductoClienteReporte = productoClienteReporte;
        updatedProductoClienteReporte.setIdReporte(updatedReporte);
        updatedProductoClienteReporte.setIdCliente(cliente);
        updatedProductoClienteReporte.setIpEquipo("");
        updatedProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idSucursal));

        if (idProyecto != null) {
            updatedProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = productoClienteReporteService.update(updatedProductoClienteReporte);

        DetalleReporteEcu911 updatedDetalleReporteEcu9111 = new DetalleReporteEcu911();
        updatedDetalleReporteEcu9111 = detalleReporteEcu911;
        updatedDetalleReporteEcu9111.setIdReporte(updatedReporte);

        updatedDetalleReporteEcu9111 = detalleReporteEcu911Service.update((DetalleReporteEcu911) toUpperCaseStrings(updatedDetalleReporteEcu9111));

    }

    @Override
    @Transactional
    public boolean ingresoMasivoReportesEcu(List<DetalleReporteEcu911> reportes, Usuarios usuarios) {
        try {

            Cliente cliente = clienteService.getClienteByRuc(parametrosService.getByParametro("CLIENTE_ECU911_RUC").getValor());
            reportes.forEach((DetalleReporteEcu911 det) -> {

                ClienteSucursal clienteSucursal = clienteSucursalService.getByNombre(det.getProductoClienteReporte().getCiudad());

                if (clienteSucursal == null) {

                    return;

                } else {

                    Integer numero_factura = this.getByUserByTipo(usuarios.getId(), Enums.TIPO_REPORTE_ECU911.getValue(), det.getIdReporte().getSubtipo()).size();

                    ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
                    Reporte reporte = new Reporte();
                    reporte = det.getIdReporte();
                    newProductoClienteReporte = det.getProductoClienteReporte();
                    reporte.setIdUsuario(usuarios);
                    reporte.setEstado(Enums.ESTADO_REPORTE_PROCESO.getValue());
                    reporte.setNumerofactura(numero_factura);
                    reporte.setTipo(Enums.TIPO_REPORTE_ECU911.getValue());
                    reporte.setNumeroReporteTecnico(usuarios.getCodigo() + "-" + formatoNumeroFactura(numero_factura));

                    newProductoClienteReporte.setIdClienteSucursal(clienteSucursal);
                    this.saveReporteEcu911(reporte, cliente, det, newProductoClienteReporte, clienteSucursal.getId(), null, usuarios);
                }
            }
            );

            return true;
        } catch (Exception e) {
            System.out.println("ERROR  " + e.getMessage() + "   , " + e.getCause());
            return false;
        }
    }

    @Override
    @Transactional
    public void saveReporteReporteGenerico(DatosReporteDTO datosReporteDTO) {

        this.saveReporteReporteGenerico(datosReporteDTO.getReporte(), datosReporteDTO.getCliente(), datosReporteDTO.getProducto(), datosReporteDTO.getSerie(), datosReporteDTO.getProductoDetalleReporte(),
                datosReporteDTO.getProductoClienteReporte(), datosReporteDTO.getIdClienteSucursal(), datosReporteDTO.getIdTipoVisita(), datosReporteDTO.getUsuarios(), datosReporteDTO.getAsignacionReparacion(),
                datosReporteDTO.getIdProyecto(), datosReporteDTO.getItemsReporteGenerico());

    }

    @Override
    @Transactional
    public void updateReporteReporteGenerico(DatosReporteDTO datosReporteDTO) {
        this.updateReporteReporteGenerico(datosReporteDTO.getReporte(), datosReporteDTO.getCliente(), datosReporteDTO.getProducto(), datosReporteDTO.getSerie(), datosReporteDTO.getProductoDetalleReporte(),
                datosReporteDTO.getProductoClienteReporte(), datosReporteDTO.getIdClienteSucursal(), datosReporteDTO.getIdTipoVisita(), datosReporteDTO.getUsuarios(), datosReporteDTO.getAsignacionReparacion(),
                datosReporteDTO.getIdProyecto(), datosReporteDTO.getItemsReporteGenerico());
    }

    private void saveRepuestosReporteCorrectivos(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.isSeleccion() && !catalogoReporte.getCodigoRepuesto().isEmpty()))
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                        ReporteMantenimiento newReporteMantenimiento = new ReporteMantenimiento();
                        newReporteMantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                        newReporteMantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte(catalogoReporte.getIdProductoRepuestoReporte()));
                        newReporteMantenimiento.setIdDetalleCatalogoReporte(new DetalleCatalogoReporte());
                        newReporteMantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                        newReporteMantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                        newReporteMantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                        newReporteMantenimiento.setEstado(Boolean.TRUE);
                        newReporteMantenimiento = reporteMantenimientoService.saveOrUpdate(newReporteMantenimiento);

                    });
        });

    }

    private void saveRepuestosReportePreventivos(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.getId() != null && catalogoReporte.isSeleccion()))
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                        ReporteMantenimiento newReporteMantenimiento = new ReporteMantenimiento();
                        newReporteMantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                        newReporteMantenimiento.setIdDetalleCatalogoReporte(catalogoReporte);
                        newReporteMantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte());
                        newReporteMantenimiento.setEstado(Boolean.TRUE);
                        newReporteMantenimiento = reporteMantenimientoService.save(newReporteMantenimiento);
                    });

        });
    }

    private void updateListReporteMantenimientoPreventivo(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                        mantenimientoAux = new ReporteMantenimiento();

                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());

                        mantenimiento = new ReporteMantenimiento();
                        mantenimiento.setEstado(Boolean.TRUE);

                        if (mantenimientoAux != null) {

                            mantenimiento = mantenimientoAux;
                            mantenimiento.setIdDetalleCatalogoReporte(catalogoReporte);
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte());
                            mantenimiento = reporteMantenimientoService.saveOrUpdate(mantenimiento);
                        } else {
                            mantenimiento.setIdDetalleCatalogoReporte(catalogoReporte);
                            mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte());
                            mantenimiento = reporteMantenimientoService.saveOrUpdate(mantenimiento);
                        }

                    });

            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.getIdReporteMantenimiento() != null) && !catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                        mantenimiento = new ReporteMantenimiento();
                        mantenimientoAux = new ReporteMantenimiento();
                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());

                        if (mantenimientoAux != null) {
                            mantenimiento = mantenimientoAux;
                            reporteMantenimientoService.eliminar(mantenimientoAux);

                        }
                    });
        });
    }

    private void updateListReporteMantenimientoCorrectivo(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.getIdProductoRepuestoReporte() != null) && catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                        mantenimientoAux = mantenimiento = new ReporteMantenimiento();
                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());
                        mantenimiento.setEstado(Boolean.TRUE);

                        if (mantenimientoAux != null) {
                            mantenimiento = mantenimientoAux;
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte(catalogoReporte.getIdProductoRepuestoReporte()));
                            mantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                            mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                            mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                            mantenimiento = reporteMantenimientoService.saveOrUpdate(mantenimiento);

                        } else {
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte(catalogoReporte.getIdProductoRepuestoReporte()));
                            mantenimiento.setIdDetalleCatalogoReporte(new DetalleCatalogoReporte());
                            mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                            mantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                            mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                            mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                            mantenimiento = reporteMantenimientoService.saveOrUpdate(mantenimiento);
                        }

                    });

            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (Objects.nonNull(catalogoReporte.getIdReporteMantenimiento())) && !catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                        mantenimientoAux = mantenimiento = new ReporteMantenimiento();
                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());

                        if (mantenimientoAux != null) {
                            mantenimiento = mantenimientoAux;
                            mantenimiento.setEstado(Boolean.FALSE);
                            reporteMantenimientoService.eliminar(mantenimiento);
                        }

                    });

        });
    }

    private void saveRepuestosReporteCorrectivosMobile(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.isSeleccion() && !catalogoReporte.getCodigoRepuesto().isEmpty()))
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                        ReporteMantenimiento newReporteMantenimiento = new ReporteMantenimiento();
                        newReporteMantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                        newReporteMantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte(catalogoReporte.getIdProductoRepuestoReporte()));
                        newReporteMantenimiento.setIdDetalleCatalogoReporte(new DetalleCatalogoReporte());
                        newReporteMantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                        newReporteMantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                        newReporteMantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                        newReporteMantenimiento.setEstado(Boolean.TRUE);
                        newReporteMantenimiento = reporteMantenimientoService.save(newReporteMantenimiento);

                    });
        });

    }

    private void saveRepuestosReportePreventivosMobile(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.getId() != null && catalogoReporte.isSeleccion()))
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                        ReporteMantenimiento newReporteMantenimiento = new ReporteMantenimiento();
                        newReporteMantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                        newReporteMantenimiento.setIdDetalleCatalogoReporte(catalogoReporte);
                        newReporteMantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte());
                        newReporteMantenimiento.setEstado(Boolean.TRUE);
                        newReporteMantenimiento = reporteMantenimientoService.save(newReporteMantenimiento);
                    });
        });
    }

    private void updateListReporteMantenimientoPreventivoMobile(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                        mantenimientoAux = new ReporteMantenimiento();

                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());

                        mantenimiento = new ReporteMantenimiento();
                        mantenimiento.setEstado(Boolean.TRUE);

                        if (mantenimientoAux != null) {

                            mantenimiento = mantenimientoAux;
                            mantenimiento.setIdDetalleCatalogoReporte(catalogoReporte);
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte());
                            mantenimiento = reporteMantenimientoService.update(mantenimiento);
                        } else {
                            mantenimiento.setIdDetalleCatalogoReporte(catalogoReporte);
                            mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte());
                            mantenimiento = reporteMantenimientoService.save(mantenimiento);
                        }

                    });

            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.getIdReporteMantenimiento() != null) && !catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                        mantenimiento = new ReporteMantenimiento();
                        mantenimientoAux = new ReporteMantenimiento();
                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());

                        if (mantenimientoAux != null) {
                            mantenimiento = mantenimientoAux;
                            reporteMantenimientoService.eliminar(mantenimientoAux);

                        }
                    });
        });
    }

    private void updateListReporteMantenimientoCorrectivoMobile(ProductoClienteReporte productoClienteReporte, List<List<DetalleCatalogoReporte>> list) {

        list.forEach((List<DetalleCatalogoReporte> lista) -> {
            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (catalogoReporte.getIdProductoRepuestoReporte() != null) && catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                        mantenimientoAux = mantenimiento = new ReporteMantenimiento();
                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());
                        mantenimiento.setEstado(Boolean.TRUE);

                        if (mantenimientoAux != null) {
                            mantenimiento = mantenimientoAux;
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte(catalogoReporte.getIdProductoRepuestoReporte()));
                            mantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                            mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                            mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                            mantenimiento = reporteMantenimientoService.update(mantenimiento);

                        } else {
                            mantenimiento.setIdProductoRepuestoReporte(new ProductoRepuestoReporte(catalogoReporte.getIdProductoRepuestoReporte()));
                            mantenimiento.setIdDetalleCatalogoReporte(new DetalleCatalogoReporte());
                            mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                            mantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                            mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                            mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                            mantenimiento = reporteMantenimientoService.save(mantenimiento);
                        }

                    });

            lista.stream().filter((DetalleCatalogoReporte catalogoReporte) -> (Objects.nonNull(catalogoReporte.getIdReporteMantenimiento())) && !catalogoReporte.isSeleccion())
                    .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                        mantenimientoAux = mantenimiento = new ReporteMantenimiento();
                        mantenimientoAux = this.containsIdReporteMantenimiento(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getIdReporteMantenimiento());

                        if (mantenimientoAux != null) {
                            mantenimiento = mantenimientoAux;
                            mantenimiento.setEstado(Boolean.FALSE);
                            reporteMantenimientoService.eliminar(mantenimiento);
                        }

                    });

        });
    }

    private void updateOtrosRepuestos(ProductoClienteReporte productoClienteReporte, List<DetalleCatalogoReporte> listOtros) {

        listOtros.stream().filter((DetalleCatalogoReporte catalogoReporte) -> Objects.nonNull(catalogoReporte.getProductoRepuestoReporte()) && catalogoReporte.isSeleccion())
                .forEach((DetalleCatalogoReporte catalogoReporte) -> {

                    mantenimientoAux = mantenimiento = new ReporteMantenimiento();
                    mantenimientoAux = this.containsIdReporteMantenimientoOtros(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getProductoRepuestoReporte().getId());

                    mantenimiento.setEstado(Boolean.TRUE);
                    if (mantenimientoAux.getId() != null) {
                        mantenimiento = mantenimientoAux;
                        mantenimiento.setIdProductoRepuestoReporte(catalogoReporte.getProductoRepuestoReporte());
                        mantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());
                        mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                        mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                        mantenimiento = reporteMantenimientoService.update(mantenimiento);

                    } else {
                        mantenimiento.setIdProductoRepuestoReporte(catalogoReporte.getProductoRepuestoReporte());
                        mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                        mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                        mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                        mantenimiento = reporteMantenimientoService.save(mantenimiento);
                    }

                });

        listOtros.stream().filter((DetalleCatalogoReporte catalogoReporte) -> Objects.nonNull(catalogoReporte.getProductoRepuestoReporte()) && !catalogoReporte.isSeleccion())
                .forEach((DetalleCatalogoReporte catalogoReporte) -> {
                    mantenimientoAux = mantenimiento = new ReporteMantenimiento();
                    mantenimientoAux = this.containsIdReporteMantenimientoOtros(productoClienteReporte.getReporteMantenimientoList(), catalogoReporte.getProductoRepuestoReporte().getId());

                    if (mantenimientoAux.getId() != null) {
                        mantenimiento = mantenimientoAux;
                        mantenimiento.setEstado(Boolean.FALSE);
                        reporteMantenimientoService.eliminar(mantenimiento);
                    }

                });

    }

    private ReporteMantenimiento containsIdReporteMantenimiento(List<ReporteMantenimiento> list, Integer id) {
        ReporteMantenimiento mantenimiento;
        for (ReporteMantenimiento object : list) {
            if (id != null && object.getId().intValue() == id.intValue() && object.getEstado() == Boolean.TRUE) {
                mantenimiento = new ReporteMantenimiento();
                mantenimiento = object;
                return mantenimiento;
            }
        }
        return null;
    }

    private ReporteMantenimiento containsIdReporteMantenimientoOtros(List<ReporteMantenimiento> list, Integer id) {
        ReporteMantenimiento mantenimiento;
        for (ReporteMantenimiento object : list) {
            if (Objects.nonNull(object.getIdProductoRepuestoReporte())) {
                if (object.getIdProductoRepuestoReporte().getId().intValue() == id && object.getEstado() == Boolean.TRUE) {
                    mantenimiento = new ReporteMantenimiento();
                    mantenimiento = object;
                    return mantenimiento;
                }
            }
        }
        return new ReporteMantenimiento();
    }

    @Override
    @Transactional
    public byte[] jasperReporte(int idReporte) {

        ProductoClienteReporte productoClienteReporte = productoClienteReporteService.getByReportId(idReporte);

        byte[] bytes = ReporteTecnico.jasperBytesReportes(productoClienteReporte, tipoVisitaService, detalleCatalogoReporteService, cabeceraCatalogoReporteService);

        return bytes;

    }

    @Transactional
    public void saveReporteReporteGenerico(Reporte reporte, Cliente cliente, Producto producto, String serie, ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Usuarios usuario, AsignacionReparacion asignacionReparacion, Integer idProyecto, List<ReporteGenericoItems> items) {
        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFecha(new Date());
        newReporte.setFechaCreacion(new Date());
        newReporte.setUsuarioCreacion(usuario.getUsuario());

        newReporte = this.save((Reporte) toUpperCaseStrings(newReporte));
        DetalleInventarioProducto searchDetalleInventarioProducto = new DetalleInventarioProducto();
        searchDetalleInventarioProducto = detalleInventarioProductoService.getBySerial(serie);
        boolean existeDetalleInventarioProducto = (searchDetalleInventarioProducto == null);
        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();

        newProductoClienteReporte = productoClienteReporte;

        if (existeDetalleInventarioProducto) {
            searchDetalleInventarioProducto = null;
        }

        newProductoClienteReporte.setIdDetalleInventarioProducto(searchDetalleInventarioProducto);
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdCliente(cliente);
        newProductoClienteReporte.setSerie(serie);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.add(productoDetalleReporte));

        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = (productoClienteReporteService.save(newProductoClienteReporte));

        if (asignacionReparacion != null && asignacionReparacion.getId() != null) {
            AsignacionReparacion newAsignacionReparacion = new AsignacionReparacion();

            newAsignacionReparacion = asignacionReparacion;
            newAsignacionReparacion.setIdReporte(newReporte.getId());
            newAsignacionReparacion.setEstado(newReporte.getEstado());
            asignacionReparacionService.addAsignacionReparacion(asignacionReparacion);
        }

        this.saveItemsReporteGenerico(globalProductoClienteReporte, items);

    }

    @Transactional
    public void updateReporteReporteGenerico(Reporte reporte, Cliente cliente, Producto producto, String serie, ProductoDetalleReporte productoDetalleReporte, ProductoClienteReporte productoClienteReporte, Integer idClienteSucursal, Integer idTipoVisita, Usuarios usuario, AsignacionReparacion asignacionReparacion, Integer idProyecto, List<ReporteGenericoItems> items) {
        globalProductoClienteReporte = new ProductoClienteReporte();
        Reporte newReporte = new Reporte();
        newReporte = reporte;
        newReporte.setIdVisita(new TipoVisita(idTipoVisita));
        newReporte.setIdUsuario(usuario);
        newReporte.setFechaModificacion(new Date());
        newReporte.setUsuarioModificacion(usuario.getUsuario());
        newReporte = this.update((Reporte) toUpperCaseStrings(newReporte));

        ProductoClienteReporte newProductoClienteReporte = new ProductoClienteReporte();
        newProductoClienteReporte = productoClienteReporte;
        newProductoClienteReporte.setIdReporte(newReporte);
        newProductoClienteReporte.setIdProducto(producto);
        newProductoClienteReporte.setIdProductoDetalleReporte(productoDetalleReporteService.update(productoDetalleReporte));
        newProductoClienteReporte.setIdClienteSucursal(new ClienteSucursal(idClienteSucursal));
        if (idProyecto != null) {
            newProductoClienteReporte.setIdProyecto(new Proyectos(idProyecto));
        }

        globalProductoClienteReporte = productoClienteReporteService.update(newProductoClienteReporte);

        this.updateItemsReporteGenericoPreventivo(globalProductoClienteReporte, items);
        this.updateItemsReporteGenericoCorrectivo(globalProductoClienteReporte, items);

    }

    private void saveItemsReporteGenerico(ProductoClienteReporte productoClienteReporte, List<ReporteGenericoItems> items) {
        items.forEach((ReporteGenericoItems reporteGenericoItem) -> {
            ReporteGenericoItems re = new ReporteGenericoItems();
            re = reporteGenericoItem;
            re.setIdProductoClienteReporte(productoClienteReporte);
            reporteGenericoItemsService.save(re);
        });
    }

    private void updateItemsReporteGenericoPreventivo(ProductoClienteReporte productoClienteReporte, List<ReporteGenericoItems> currentList) {

        currentList.stream().filter((ReporteGenericoItems reporteGenericoItem) -> reporteGenericoItem.isSeleccion() && reporteGenericoItem.getTipo().charValue() == 'P').forEach((ReporteGenericoItems catalogoReporte) -> {
            reporteGenericoItemAux = new ReporteGenericoItems();
            reporteGenericoItemAux = catalogoReporte;
            reporteGenericoItemAux = this.containsIdReporteGenericoItems(productoClienteReporte.getReporteGenericoItemsList(), reporteGenericoItemAux.getId());

            reporteGenericoItem = new ReporteGenericoItems();
            reporteGenericoItem.setEstado(Boolean.TRUE);

            if (reporteGenericoItemAux != null) {

                reporteGenericoItem = reporteGenericoItemAux;

                reporteGenericoItem = reporteGenericoItemsService.update(reporteGenericoItem);
            } else {

                reporteGenericoItem = new ReporteGenericoItems();
                reporteGenericoItem = catalogoReporte;
                reporteGenericoItem.setIdProductoClienteReporte(productoClienteReporte);
                reporteGenericoItem = reporteGenericoItemsService.save(catalogoReporte);
            }

        });

        currentList.stream().filter((ReporteGenericoItems reporteGenericoItem) -> !reporteGenericoItem.isSeleccion() && reporteGenericoItem.getTipo().charValue() == 'P').forEach((ReporteGenericoItems catalogoReporte) -> {
            reporteGenericoItem = new ReporteGenericoItems();
            reporteGenericoItemAux = new ReporteGenericoItems();
            reporteGenericoItemAux = this.containsIdReporteGenericoItems(productoClienteReporte.getReporteGenericoItemsList(), catalogoReporte.getId());

            if (reporteGenericoItemAux != null) {
                reporteGenericoItem = reporteGenericoItemAux;
                reporteGenericoItemsService.eliminar(reporteGenericoItem);

            }
        });

    }

    private void updateItemsReporteGenericoCorrectivo(ProductoClienteReporte productoClienteReporte, List<ReporteGenericoItems> currentList) {
        currentList.stream().filter((ReporteGenericoItems reporteGenericoItem) -> reporteGenericoItem.isSeleccion() && reporteGenericoItem.getTipo().charValue() == 'C').forEach((ReporteGenericoItems catalogoReporte) -> {
            reporteGenericoItemAux = new ReporteGenericoItems();
            reporteGenericoItemAux = catalogoReporte;
            reporteGenericoItemAux = this.containsIdReporteGenericoItems(productoClienteReporte.getReporteGenericoItemsList(), reporteGenericoItemAux.getId());

            reporteGenericoItem = new ReporteGenericoItems();
            reporteGenericoItem.setEstado(Boolean.TRUE);

            if (reporteGenericoItemAux != null) {

                reporteGenericoItem = reporteGenericoItemAux;

                reporteGenericoItem = reporteGenericoItemsService.update(reporteGenericoItem);
            } else {

                reporteGenericoItem = new ReporteGenericoItems();
                reporteGenericoItem = catalogoReporte;
                reporteGenericoItem.setIdProductoClienteReporte(productoClienteReporte);
                reporteGenericoItem = reporteGenericoItemsService.save(catalogoReporte);
            }

        });

        currentList.stream().filter((ReporteGenericoItems reporteGenericoItem) -> !reporteGenericoItem.isSeleccion() && reporteGenericoItem.getTipo().charValue() == 'C').forEach((ReporteGenericoItems catalogoReporte) -> {
            reporteGenericoItem = new ReporteGenericoItems();
            reporteGenericoItemAux = new ReporteGenericoItems();
            reporteGenericoItemAux = this.containsIdReporteGenericoItems(productoClienteReporte.getReporteGenericoItemsList(), catalogoReporte.getId());

            if (reporteGenericoItemAux != null) {
                reporteGenericoItem = reporteGenericoItemAux;
                reporteGenericoItemsService.eliminar(reporteGenericoItem);

            }
        });

    }

    private ReporteGenericoItems containsIdReporteGenericoItems(List<ReporteGenericoItems> list, Integer id) {
        ReporteGenericoItems mantenimiento;
        for (ReporteGenericoItems object : list) {
            if (id != null && object.getId().intValue() == id.intValue()) {
                mantenimiento = new ReporteGenericoItems();
                mantenimiento = object;
                return mantenimiento;
            }
        }
        return null;
    }

}
