/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.util;

import com.innovaciones.reporte.model.DTO.MantenimientoDTO;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.ReporteGenericoItems;
import com.innovaciones.reporte.model.TipoVisita;
import com.innovaciones.reporte.service.CabeceraCatalogoReporteService;
import com.innovaciones.reporte.service.DetalleCatalogoReporteService;
import com.innovaciones.reporte.service.ParametrosService;
import com.innovaciones.reporte.service.TipoVisitaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedProperty;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Fernando
 */
public class ReporteTecnico extends Utilities implements Serializable {

    /**
     * Creates a new instance of ReporteTecnicoBean
     */
    @Getter
    @Setter
    @ManagedProperty("#{parametrosService}")
    private ParametrosService parametrosService;

    private Map<String, Object> parameters;
    private final static String IMAGEN_EMBEBIDA_FORMAT = "data:image/png;base64,";
    private final static String REPORTE_TECNICO_PATH = "/reports/reporte_tecnico.jasper";
    private final static String REPORTE_INSTALACION_NUEVA_PATH = "/reports/instalacion_nueva.jasper";
    private final static String REPORTE_INSTALACION_TEMPORAL_PATH = "/reports/instalacion_temporal.jasper";
    private final static String REPORTE_MONITOR_PATH = "/reports/reporte_monitor.jasper";
    private final static String REPORTE_ETIQUETADORAS_PATH = "/reports/reporte_etiquetadora.jasper";
    private final static String REPORTE_SCANNERS_PATH = "/reports/reporte_scanner.jasper";
    private final static String REPORTE_TRITURADORAS_PATH = "/reports/reporte_trituradora.jasper";
    private final static String REPORTE_CUBO_ANVERSO_PATH = "/reports/reporte_cubo_anverso.jasper";
    private final static String REPORTE_CUBO_REVERSO_PATH = "/reports/reporte_cubo_reverso.jasper";
    private final static String REPORTE_TECNICO_GENERICO_PATH = "/reports/reporte_generico.jasper";

    private final static String SELECCIONAR = "X";

    private final static String DG_VISITA_POR_GARANTIA = "Vista por Garantía";
    private final static String DG_EQUIPOS_BAJO_CONTARTO = "Equipo bajo Contrato";
    private final static String DG_VISITA_DE_CORTESIA = "Visita de Cortesía";
    private final static String DG_CAPACITACION_MANEJO = "Capacitación / Manejo";
    private final static String DG_ARRENDAMIENTO = "Arrendamiento";
    private final static String DG_INSPECCION = "Inspección";
    private final static String DG_LABORATORIO = "Laboratorio";

    private final static String MP_UNIDAD_TRANSFERENCIA = "Unidad de Transferencia";
    private final static String MP_REGISTRO = "Registro";
    private final static String MP_SENSORES_PROCESAMIENTO = "Unidad de Revelado";
    private final static String MP_CORONA_TRANSFERENCIA = "Corona de Transferencia";
    private final static String MP_SECCION_PROCESAMIENTO = "Sección de Procesamiento";

    private final static String MP_PRESS_ROLLER = "Press Roller / Unidad Fusora";
    private final static String MP_HEAT_ROLLER = "Heat Roller / Unidad Fusora";
    private final static String MP_GUIAS = "Guías";
    private final static String MP_RODILLOS_ARRASTRE = "Rodillos de Alimentación";
    private final static String MP_SENSORES_FIJACION = "Rodillos de Transporte";
    private final static String MP_PINON_ACOPLE = "Piñón de Acople";

    private final static String MP_VIDRIOS = "Vidrios";
    private final static String MP_CUBIERTAS = "Cubiertas";
    private final static String MP_ALIMENTADOR_ORIGINALES = "Alimentador de Originales";
    private final static String MP_BANDEJA_PAPEL = "Bandejas de Papel";
    private final static String MP_BY_PASS = "By Pass (Manual)";
    private final static String MP_LUBRICACION_GENERAL = "Lubricación General";

    private final static String MC_TONER_K = "Toner K";
    private final static String MC_TONER_CMY = "Toner C,M,Y";
    private final static String MC_TONER_C = "Toner C";
    private final static String MC_TONER_M = "Toner M";
    private final static String MC_TONER_Y = "Toner Y";
    private final static String TANQUE_DESECHO = "Tanque de Desechos";

    private final static String MC_UNIDAD_IMAGEN_K = "Unidad de Imagen K";
    private final static String MC_CILINDRO = "Cilindro";
    private final static String MC_BANDA_TRANSFERENCIA = "Banda Transferencia";

    private final static String MC_UNIDAD_IMAGEN_C = "Unidad Imagen C";
    private final static String MC_UNIDAD_IMAGEN_M = "Unidad Imagen M";
    private final static String MC_UNIDAD_IMAGEN_Y = "Unidad Imagen Y";

    private final static String MC_UNIDAD_FUSION = "Unidad de Fusión";
    private final static String MC_PRESS_ROLLER = "Press Roller";
    private final static String MC_HEAT_ROLLER = "Heat Roller";
    private final static String MC_UNIDAD_REVELADO = "Unidad Revelado";
    private final static String MC_REVELADOR = "Revelador";

    private final static String MC_PICKUP_ROLLER = "Pick up Roller";
    private final static String MC_FEED_ROLLER = "Feed Roller";
    private final static String MC_SEPARATION_ROLLER = "Separation Roller";
    private final static String MC_UNIDAD_LASER = "Unidad Láser";
    private final static String MC_REGULADOR_VOLTAJE = "Regulador de Voltaje";

    public ReporteTecnico() {
    }

    public static byte[] jasperBytesReportes(ProductoClienteReporte productoClienteReporte,
            TipoVisitaService tipoVisitaService, DetalleCatalogoReporteService detalleCatalogoReporteService,
            CabeceraCatalogoReporteService cabeceraCatalogoReporteService) {

        /*  Map<String, Object> */
        Map<String, Object> parametros = loadParametersReporteBytes(productoClienteReporte, tipoVisitaService,
                detalleCatalogoReporteService, cabeceraCatalogoReporteService);;

        String path = "";

        if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_DIAGNOSTICO.getValue())) {

            path = REPORTE_TECNICO_PATH;
        }

        if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_REPARACION.getValue())) {

            path = REPORTE_TECNICO_PATH;
        }

        if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_CONTADORES.getValue())) {

            path = REPORTE_TECNICO_PATH;
        }

        if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_GENERICO.getValue())) {

            path = REPORTE_TECNICO_GENERICO_PATH;
        }
        
        return jasperBytes(parametros, path);
    }

    public static Map<String, Object> loadParametersReporteBytes(ProductoClienteReporte productoClienteReporte,
            TipoVisitaService tipoVisitaService, DetalleCatalogoReporteService detalleCatalogoReporteService,
            CabeceraCatalogoReporteService cabeceraCatalogoReporteService) {
        Map<String, Object> parametros = new HashMap();

        try {

            parametros.put("codigo", productoClienteReporte.getIdReporte().getIdUsuario().getCodigo());

            parametros.put("fecha", fomatearFecha(productoClienteReporte.getIdReporte().getFecha()));
            //DATOS GENERALES
            parametros.put("cliente", productoClienteReporte.getIdCliente().getCliente());
            parametros.put("ruc", productoClienteReporte.getIdCliente().getRuc());

            parametros.put("atencion", productoClienteReporte.getAtencion());
            parametros.put("telefono", productoClienteReporte.getIdCliente().getTelefono());
            parametros.put("telefono2", productoClienteReporte.getIdCliente().getTelefono2());
            parametros.put("direccion", productoClienteReporte.getIdCliente().getDireccion());
            parametros.put("factura", productoClienteReporte.getIdReporte().getFactura());
            parametros.put("referencia", productoClienteReporte.getIdReporte().getReferencia());
            parametros.put("departamento", productoClienteReporte.getDepartamento());
            parametros.put("ciudad", productoClienteReporte.getIdCliente().getCiudad());
            parametros.put("email", productoClienteReporte.getIdCliente().getEmail());
            parametros.put("numero_reporte", "N° " + productoClienteReporte.getIdReporte().getIdUsuario().getCodigo() + " - " + formatoNumeroFactura(productoClienteReporte.getIdReporte().getId()));
            parametros.put("direccion_equipo", productoClienteReporte.getDireccionEquipo());
            parametros.put("telefono_equipo", productoClienteReporte.getTelefonoEquipo());
            parametros.put("mail_equipo", productoClienteReporte.getCelularEquipo());
            //FIRMA
            String image64Cliente = productoClienteReporte.getIdReporte().getFirmaClienteBase64();
            String image64Tecnico = productoClienteReporte.getIdReporte().getIdUsuario().getFirmaBase64();

            if (image64Cliente != null && !image64Cliente.isEmpty()) {
                image64Cliente = image64Cliente.replace(IMAGEN_EMBEBIDA_FORMAT, "").trim();

                parametros.put("firma_cliente", image64Cliente);
            }
            if (image64Tecnico != null && !image64Tecnico.isEmpty()) {
                image64Tecnico = image64Tecnico.replace(IMAGEN_EMBEBIDA_FORMAT, "").trim();

                parametros.put("firma_tecnico", image64Tecnico);
            }

            List<TipoVisita> tiposVisita = tipoVisitaService.getAllTipoVisitas();
            //Asignacion de visitas en Datos Generales
            for (TipoVisita tipoVisita : tiposVisita) {
                tipoVisita.setDescripcion(tipoVisita.getDescripcion().trim());

                if (tipoVisita.getId().intValue() == productoClienteReporte.getIdReporte().getIdVisita().getId().intValue()) {

                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_VISITA_POR_GARANTIA)) {
                        parametros.put("visita_garantia", SELECCIONAR);
                    }
                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_EQUIPOS_BAJO_CONTARTO)) {
                        parametros.put("equipos_bajo_contrato", SELECCIONAR);
                    }
                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_VISITA_DE_CORTESIA)) {
                        parametros.put("visita_cortesia", SELECCIONAR);
                    }
                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_CAPACITACION_MANEJO)) {
                        parametros.put("capacitacion_manejo", SELECCIONAR);
                    }
                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_ARRENDAMIENTO)) {
                        parametros.put("arrendamiento", SELECCIONAR);
                    }
                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_INSPECCION)) {
                        parametros.put("inspeccion", SELECCIONAR);
                    }
                    if (tipoVisita.getDescripcion().equalsIgnoreCase(DG_LABORATORIO)) {
                        parametros.put("laboratorio", SELECCIONAR);
                    }

                    break;
                }
            }

            //DATOS DEL EQUIPO
            parametros.put("equipo", productoClienteReporte.getIdProducto().getIdCategoria().getNombre());
            parametros.put("marca", productoClienteReporte.getIdProducto().getIdModelo().getIdMarca().getMarca());
            parametros.put("modelo", productoClienteReporte.getIdProducto().getIdModelo().getModelo());
            parametros.put("serie", productoClienteReporte.getSerie());
            parametros.put("ip", productoClienteReporte.getIpEquipo());
            parametros.put("firmware", productoClienteReporte.getIdProducto().getVersionFirmware());

            //DATOS SUCURSAL
            parametros.put("empty1", productoClienteReporte.getIdClienteSucursal().getNombreContacto());
            parametros.put("empty1", productoClienteReporte.getIdClienteSucursal().getEmailContacto());
            parametros.put("departamento", productoClienteReporte.getIdClienteSucursal().getCiudad());
            parametros.put("direccion_equipo", productoClienteReporte.getIdClienteSucursal().getDireccion());
            parametros.put("telefono_equipo", productoClienteReporte.getIdClienteSucursal().getTelefonoContacto());
            parametros.put("mail_equipo", productoClienteReporte.getIdClienteSucursal().getCelularContacto());

            System.out.println(" SETEAR CONTADORES  .....  ");
            //DATOS DE CONTADORES
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorTotalAnterior() != null) {
                parametros.put("contador_total_anterior", productoClienteReporte.getIdProductoDetalleReporte().getContadorTotalAnterior().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorColorAnterior() != null) {
                parametros.put("contador_color_anterior", productoClienteReporte.getIdProductoDetalleReporte().getContadorColorAnterior().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorBnAnterior() != null) {
                parametros.put("contador_bn_anterior", productoClienteReporte.getIdProductoDetalleReporte().getContadorBnAnterior().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorTotalActual() != null) {
                parametros.put("contador_total_actual", productoClienteReporte.getIdProductoDetalleReporte().getContadorTotalActual().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorColorActual() != null) {
                parametros.put("contador_color_actual", productoClienteReporte.getIdProductoDetalleReporte().getContadorColorActual().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorBnActual() != null) {
                parametros.put("contador_bn_actual", productoClienteReporte.getIdProductoDetalleReporte().getContadorBnActual().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorTotalImpReal() != null) {
                parametros.put("contador_total_real", productoClienteReporte.getIdProductoDetalleReporte().getContadorTotalImpReal().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorColorImpReal() != null) {
                parametros.put("contador_color_real", productoClienteReporte.getIdProductoDetalleReporte().getContadorColorImpReal().toString());

            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getContadorBnImpReal() != null) {
                parametros.put("contador_bn_real", productoClienteReporte.getIdProductoDetalleReporte().getContadorBnImpReal().toString());

            }

            if (productoClienteReporte.getIdProductoDetalleReporte().getMantenimiento() != null) {
                parametros.put("mantenimiento", productoClienteReporte.getIdProductoDetalleReporte().getMantenimiento().toString());

            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getOtros() != null) {
                parametros.put("otros", productoClienteReporte.getIdProductoDetalleReporte().getOtros().toString());

            }

            if (productoClienteReporte.getIdProductoDetalleReporte().getServicioFacturar() != null) {
                parametros.put("servicio_facturar", productoClienteReporte.getIdProductoDetalleReporte().getServicioFacturar().toString());
            }
            if (productoClienteReporte.getIdProductoDetalleReporte().getServicioFacturarEstado() != null && productoClienteReporte.getIdProductoDetalleReporte().getServicioFacturarEstado()) {
                parametros.put("servicio_facturar_estado", SELECCIONAR);
            }
            System.out.println("  CONTADORES SETEADO   ");

            parametros.put("sintomas", productoClienteReporte.getIdReporte().getSintomasEquipo());
            parametros.put("observacion", productoClienteReporte.getIdReporte().getObservacionMantenimiento());
            parametros.put("observaciones_recomendaciones", productoClienteReporte.getIdReporte().getObservacionesRecomendaciones());

            try {
                
            } catch (Exception e) {
            }
            
            
            // parametros.put("hora_inicio", fomatearHora(productoClienteReporte.getIdReporte().getHoraInicio()));
            //  parametros.put("hora_finalizacion", fomatearHora(productoClienteReporte.getIdReporte().getHoraFin()));
            parametros.put("nombre_tecnico", productoClienteReporte.getIdReporte().getIdUsuario().getNombreCompleto());
            parametros.put("nombre_cliente", productoClienteReporte.getIdReporte().getNombreCliente());

            System.out.println(" TIPO IF " + productoClienteReporte.getIdReporte().getTipo());

            if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_DIAGNOSTICO.getValue())) {
                parametros.putAll(loadParametersReportesRepuestosByte(productoClienteReporte, detalleCatalogoReporteService, cabeceraCatalogoReporteService));
            }

            if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_REPARACION.getValue())) {
                parametros.putAll(loadParametersReportesRepuestosByte(productoClienteReporte, detalleCatalogoReporteService, cabeceraCatalogoReporteService));
            }

            if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_CONTADORES.getValue())) {
                parametros.putAll(loadParametersReportesRepuestosByte(productoClienteReporte, detalleCatalogoReporteService, cabeceraCatalogoReporteService));
            }

            if (productoClienteReporte.getIdReporte().getTipo().equals(Enums.TIPO_REPORTE_GENERICO.getValue())) {
                parametros.putAll(loadParametersReporteGenerico(productoClienteReporte));
            }

        } catch (Exception e) {
            System.out.println("Error cargar Parametros " + e.getMessage());
            e.getStackTrace();
        }

        
        return parametros;

    }

    public static Map<String, Object> loadParametersReporteGenerico(ProductoClienteReporte productoClienteReporte) {
        Map<String, Object> parametros = new HashMap();
        parametros.put("lbl_cont_anterior", productoClienteReporte.getIdProductoDetalleReporte().getEtiquetaAnterior());
        parametros.put("lbl_cont_actual", productoClienteReporte.getIdProductoDetalleReporte().getEtiquetaActual());
        parametros.put("lbl_cont_real", productoClienteReporte.getIdProductoDetalleReporte().getEtiquetaImpresionReal());

        parametros.put("lbl_cont_total", productoClienteReporte.getIdProductoDetalleReporte().getEtiquetaContadorTotal());
        parametros.put("lbl_cont_color", productoClienteReporte.getIdProductoDetalleReporte().getEtiquetaContadorColor());
        parametros.put("lbl_cont_bn", productoClienteReporte.getIdProductoDetalleReporte().getEtiquetaContadorBn());

        parametros.put("lbl_sintomas", productoClienteReporte.getIdReporte().getEtiquetaSintomasEquipo());

        List<MantenimientoDTO> mantenimientosPreventivos = new ArrayList<>();
        List<MantenimientoDTO> mantenimientosCorrectivos = new ArrayList<>();

        MantenimientoDTO mantenimiento = null;
        for (ReporteGenericoItems item : productoClienteReporte.getReporteGenericoItemsList()) {

            mantenimiento = new MantenimientoDTO();

            mantenimiento.setDescripcion(item.getDescripcion());

            if (item.getTipo().charValue() == 'P') {
                mantenimiento.setCodigo("");
                mantenimiento.setValor1(true);
                mantenimientosPreventivos.add(mantenimiento);
            } else {
                mantenimiento.setValor1(item.getCambiado());
                mantenimiento.setValor2(item.getSolicitar());
                mantenimiento.setCodigo(item.getCodigoRepuesto());
                mantenimientosCorrectivos.add(mantenimiento);
            }

        }

        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(mantenimientosPreventivos);

        JRBeanCollectionDataSource itemsJRBean2 = new JRBeanCollectionDataSource(mantenimientosCorrectivos);

        parametros.put("ItemDataSource", itemsJRBean);
        parametros.put("ItemDataSource2", itemsJRBean2);
        return parametros;
    }

    
    
    public static Map<String, Object> loadParametersReportesRepuestosByte(ProductoClienteReporte productoClienteReporte,
            DetalleCatalogoReporteService detalleCatalogoReporteService,
            CabeceraCatalogoReporteService cabeceraCatalogoReporteService) {
        Map<String, Object> parametros = new HashMap();

        List<DetalleCatalogoReporte> listProcesamiento = llenarRepuestosPreventivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_PROCESAMIENTO.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listPreventivoImagen = llenarRepuestosPreventivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_PREVENTIVO_IMAGEN.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listPreventivoFijacion = llenarRepuestosPreventivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_PREVENTIVO_FIJACION.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listPreventivoLimpieza = llenarRepuestosPreventivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_EXTERIORES.getValue()), productoClienteReporte);

        List<DetalleCatalogoReporte> listCorrectivoSuministros = llenarRepuestosCorrectivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_SUMINISTROS.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listCorrectivoImagen = llenarRepuestosCorrectivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_CORRECTIVO_IMAGEN.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listCorrectivoFijacion = llenarRepuestosCorrectivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_CORRECTIVO_FIJACION.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listCorrectivoRevelado = llenarRepuestosCorrectivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_CORRECTIVO_REVELADO.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> listCorrectivoAlimentacion = llenarRepuestosCorrectivos(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(Enums.MANTENIMIENTO_ALIMENTACION.getValue()), productoClienteReporte);
        List<DetalleCatalogoReporte> otros = llenarRepuestosOtros(listCorrectivoOtros(cabeceraCatalogoReporteService.getCabeceraCatalogoReportesByCodigo(Enums.MANTENIMIENTO_OTROS.getValue())), productoClienteReporte,
                cabeceraCatalogoReporteService.getCabeceraCatalogoReportesByCodigo(Enums.MANTENIMIENTO_OTROS.getValue()));

        //MANTENIMIENTO PREVENTIVO
        for (DetalleCatalogoReporte detalleCatalogoReporte : listProcesamiento) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.isSeleccion()) {

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_UNIDAD_TRANSFERENCIA)) {
                    parametros.put("unidad_transferencia", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_REGISTRO)) {
                    parametros.put("registro", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_SENSORES_PROCESAMIENTO)) {
                    parametros.put("sensores_procesamiento", SELECCIONAR);
                }

            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listPreventivoImagen) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());

            if (detalleCatalogoReporte.isSeleccion()) {
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_CORONA_TRANSFERENCIA)) {
                    parametros.put("corona_transferencia", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_SECCION_PROCESAMIENTO)) {
                    parametros.put("seccion_procesamiento", SELECCIONAR);
                }
            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listPreventivoFijacion) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.isSeleccion()) {
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_PRESS_ROLLER)) {
                    parametros.put("press_roller", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_HEAT_ROLLER)) {
                    parametros.put("heat_roller", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_GUIAS)) {
                    parametros.put("guias", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_RODILLOS_ARRASTRE)) {
                    parametros.put("rodillo_arrastre", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_SENSORES_FIJACION)) {
                    parametros.put("sensores_fijacion", SELECCIONAR);
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_PINON_ACOPLE)) {
                    parametros.put("pinon_acople", SELECCIONAR);
                }

            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listPreventivoLimpieza) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.isSeleccion()) {
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_VIDRIOS)) {
                    parametros.put("vidrios", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_CUBIERTAS)) {
                    parametros.put("cubiertas", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_ALIMENTADOR_ORIGINALES)) {
                    parametros.put("alimentador_originales", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_BANDEJA_PAPEL)) {
                    parametros.put("bandeja_papel", SELECCIONAR);
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_BY_PASS)) {

                    parametros.put("by_pass", SELECCIONAR);
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MP_LUBRICACION_GENERAL)) {
                    parametros.put("lubricacion_general", SELECCIONAR);
                }
            }
        }

        //MANTENIMIENTO CORRECTIVO
        for (DetalleCatalogoReporte detalleCatalogoReporte : listCorrectivoSuministros) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.getTipoRepuesto() != null && !detalleCatalogoReporte.getTipoRepuesto().equals("") && detalleCatalogoReporte.getCodigoRepuesto() != null) {

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_TONER_K)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("toner_k_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("toner_k_s", SELECCIONAR);
                    }
                    parametros.put("tonerk_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("toner_k_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_TONER_CMY)) {

                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("toner_cmy_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("toner_cmy_s", SELECCIONAR);
                    }
                    parametros.put("tonercmy_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("toner_cmy_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_TONER_C)) {

                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("toner_c_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("toner_c_s", SELECCIONAR);
                    }
                    parametros.put("tonerc_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("toner_c_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_TONER_M)) {

                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("toner_m_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("toner_m_s", SELECCIONAR);
                    }
                    parametros.put("tonerm_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("toner_m_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_TONER_Y)) {

                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("toner_y_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("toner_y_s", SELECCIONAR);
                    }
                    parametros.put("tonery_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("toner_y_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(TANQUE_DESECHO)) {

                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("tanque_desechos_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("tanque_desechos_s", SELECCIONAR);
                    }
                    parametros.put("tanque_desechos_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("tanque_desechos_code", detalleCatalogoReporte.getCodigoRepuesto());
                }

            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listCorrectivoImagen) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.getTipoRepuesto() != null && !detalleCatalogoReporte.getTipoRepuesto().equals("") && detalleCatalogoReporte.getCodigoRepuesto() != null) {

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_IMAGEN_K)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("u_imagen_k_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("u_imagen_k_s", SELECCIONAR);
                    }
                    parametros.put("u_imagen_k_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("u_imagen_k_code_rep", detalleCatalogoReporte.getCodigoRepuesto());

                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_CILINDRO)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("cilindro_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("cilindro_s", SELECCIONAR);
                    }
                    parametros.put("cilindro_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("cilindro_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_BANDA_TRANSFERENCIA)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("banda_transferencia_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("banda_transferencia_s", SELECCIONAR);
                    }
                    parametros.put("banda_trans_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("banda_transferencia_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_IMAGEN_C)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("u_imagen_c_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("u_imagen_c_s", SELECCIONAR);
                    }
                    parametros.put("u_imagen_c_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("u_imagen_c_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_IMAGEN_M)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("u_imagen_m_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("u_imagen_m_s", SELECCIONAR);
                    }
                    parametros.put("u_imagen_m_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("u_imagen_m_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_IMAGEN_Y)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("u_imagen_y_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("u_imagen_y_s", SELECCIONAR);
                    }
                    parametros.put("u_imagen_y_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("u_imagen_y_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listCorrectivoFijacion) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.getTipoRepuesto() != null && !detalleCatalogoReporte.getTipoRepuesto().equals("") && detalleCatalogoReporte.getCodigoRepuesto() != null) {
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_FUSION)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("unidad_fusion_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("unidad_fusion_s", SELECCIONAR);
                    }
                    parametros.put("u_fusion_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("unidad_fusion_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_PRESS_ROLLER)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("press_roller_correctivo_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("press_roller_correctivo_s", SELECCIONAR);
                    }
                    parametros.put("press_roller_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("press_roller_correctivo_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_HEAT_ROLLER)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("heat_roller_correctivo_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("heat_roller_correctivo_s", SELECCIONAR);
                    }
                    parametros.put("heat_roller_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("heat_roller_correctivo_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }
            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listCorrectivoRevelado) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.getTipoRepuesto() != null && !detalleCatalogoReporte.getTipoRepuesto().equals("") && detalleCatalogoReporte.getCodigoRepuesto() != null) {
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_REVELADO)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("unidad_revelado_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("unidad_revelado_s", SELECCIONAR);
                    }
                    parametros.put("u_revelado_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("unidad_revelado_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_REVELADOR)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("revelador_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("revelador_s", SELECCIONAR);
                    }
                    parametros.put("revelador_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("revelador_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }
            }
        }

        for (DetalleCatalogoReporte detalleCatalogoReporte : listCorrectivoAlimentacion) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.getTipoRepuesto() != null && !detalleCatalogoReporte.getTipoRepuesto().equals("") && detalleCatalogoReporte.getCodigoRepuesto() != null) {
                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_PICKUP_ROLLER)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("pickup_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("pickup_s", SELECCIONAR);
                    }
                    parametros.put("pick_uproller_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("pickup_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_FEED_ROLLER)) {

                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("feed_roller_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("feed_roller_s", SELECCIONAR);
                    }
                    parametros.put("feed_roller_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("feed_roller_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_SEPARATION_ROLLER)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("separation_roller_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("separation_roller_s", SELECCIONAR);
                    }
                    parametros.put("sep_roller_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("separation_roller_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_UNIDAD_LASER)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("unidad_laser_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("unidad_laser_s", SELECCIONAR);
                    }
                    parametros.put("u_laser_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("unidad_laser_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }

                if (detalleCatalogoReporte.getDescripcion().equalsIgnoreCase(MC_REGULADOR_VOLTAJE)) {
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                        parametros.put("regulador_voltaje_c", SELECCIONAR);
                    }
                    if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                        parametros.put("regulador_voltaje_s", SELECCIONAR);
                    }
                    parametros.put("r_voltaje_porc", detalleCatalogoReporte.getPorcentaje() != null ? detalleCatalogoReporte.getPorcentaje().toString().concat(" %") : null);
                    parametros.put("regulador_voltaje_code_rep", detalleCatalogoReporte.getCodigoRepuesto());
                }
            }
        }

        int c = 1;

        for (DetalleCatalogoReporte detalleCatalogoReporte : otros) {
            detalleCatalogoReporte.setDescripcion(detalleCatalogoReporte.getDescripcion().trim());
            if (detalleCatalogoReporte.getTipoRepuesto() != null
                    && !detalleCatalogoReporte.getTipoRepuesto().equals("")
                    && !detalleCatalogoReporte.getDescripcion().equals("")) {

                parametros.put("otros_" + c, detalleCatalogoReporte.getDescripcion());
                if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("C")) {
                    parametros.put("otros_c_" + c, "( " + SELECCIONAR + " )");
                }
                if (detalleCatalogoReporte.getTipoRepuesto().equalsIgnoreCase("S")) {
                    parametros.put("otros_s_" + c, "( " + SELECCIONAR + " )");
                }
                parametros.put("otros_cod_rep_" + c, detalleCatalogoReporte.getCodigoRepuesto());
            }
            c++;
        }

        return parametros;
    }

}
