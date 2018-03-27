/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ReporteMantenimientoDAO;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.ReporteMantenimiento;
import com.innovaciones.reporte.model.Usuarios;
import com.innovaciones.reporte.util.Utilities;
import java.io.Serializable;
import java.util.List;
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
@ManagedBean(name = "reporteMantenimientoService")
@ViewScoped
public class ReporteMantenimientoServiceImpl extends Utilities implements ReporteMantenimientoService, Serializable {

    @Setter
    private ReporteMantenimientoDAO reporteMantenimientoDAO;

    @Getter
    @Setter
    @ManagedProperty("#{detalleCatalogoReporteService}")
    private DetalleCatalogoReporteService detalleCatalogoReporteService;

    @Override
    @Transactional
    public ReporteMantenimiento save(ReporteMantenimiento reporteMantenimiento) {
        reporteMantenimientoDAO.save(reporteMantenimiento);
        return reporteMantenimiento;
    }

    
    @Override
    @Transactional
    public void eliminar(ReporteMantenimiento reporteMantenimiento) {
      
        reporteMantenimientoDAO.eliminar(reporteMantenimiento);
        
    }

    @Override
    @Transactional
    public ReporteMantenimiento update(ReporteMantenimiento reporteMantenimiento) {
        reporteMantenimientoDAO.update(reporteMantenimiento);
        return reporteMantenimiento;
    }

    @Override
    @Transactional
    public void removeReporteMantenimiento(ReporteMantenimiento reporteMantenimiento) {
        reporteMantenimientoDAO.removeReporteMantenimiento(reporteMantenimiento);
    }

    public void agregarMantenimientoPreventivo(ProductoClienteReporte productoClienteReporte, List<DetalleCatalogoReporte> lista) {

        if (lista != null) {

            ReporteMantenimiento mantenimiento;
            for (DetalleCatalogoReporte catalogoReporte : lista) {
                if (catalogoReporte.isSeleccion()) {
                    mantenimiento = new ReporteMantenimiento();
                    // mantenimiento.setIdRepuestoModelo(new RepuestoModelo(catalogoReporte.getIdRepuestoModelo()));
                    mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                    mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                    mantenimiento.setEstado(Boolean.TRUE);
                    reporteMantenimientoDAO.save(mantenimiento);
                }
            }
        }
    }

    @Override
    @Transactional
    public void addReporteMantenimientoPreventivo(ProductoClienteReporte productoClienteReporte,
            List<DetalleCatalogoReporte> procesamiento,
            List<DetalleCatalogoReporte> imagen,
            List<DetalleCatalogoReporte> fijacion,
            List<DetalleCatalogoReporte> limpieza) {

        this.agregarMantenimientoPreventivo(productoClienteReporte, procesamiento);
        this.agregarMantenimientoPreventivo(productoClienteReporte, imagen);
        this.agregarMantenimientoPreventivo(productoClienteReporte, fijacion);
        this.agregarMantenimientoPreventivo(productoClienteReporte, limpieza);

    }

    public void agregarRepuesteMantenimientoCorrectivo(ProductoClienteReporte productoClienteReporte, List<DetalleCatalogoReporte> repuestos, String esReparacion, Usuarios usuario) {

        if (repuestos != null) {

            ReporteMantenimiento mantenimiento;
            for (DetalleCatalogoReporte catalogoReporte : repuestos) {

                if (catalogoReporte.getTipoRepuesto() != null && catalogoReporte.getCodigoRepuesto() != null) {
                    mantenimiento = new ReporteMantenimiento();

                    // mantenimiento.setIdRepuestoModelo(new RepuestoModelo());
                    //         mantenimiento.getIdRepuestoModelo().setId(catalogoReporte.getIdRepuestoModelo());
                    mantenimiento.setIdProductoClienteReporte(productoClienteReporte);
                    mantenimiento.setTipoRepuesto(catalogoReporte.getTipoRepuesto());
                    mantenimiento.setCodigoRepuesto(catalogoReporte.getCodigoRepuesto());
                    mantenimiento.setEstado(Boolean.TRUE);
                    mantenimiento.setPorcentaje(catalogoReporte.getPorcentaje());

                    mantenimiento = reporteMantenimientoDAO.save(mantenimiento);

                }
            }
        }

    }

    @Override
    @Transactional
    public void addReporteMantenimientoCorrectivo(ProductoClienteReporte productoClienteReporte,
            List<DetalleCatalogoReporte> suministros,
            List<DetalleCatalogoReporte> imagen,
            List<DetalleCatalogoReporte> fijacion,
            List<DetalleCatalogoReporte> revelado,
            List<DetalleCatalogoReporte> alimentacion,
            List<DetalleCatalogoReporte> otros, String tipoReparacion,
            Usuarios usuario) {

    }

    @Override
    @Transactional
    public void addReporteMantenimientoInstalacionNueva(ProductoClienteReporte productoClienteReporte, List<DetalleCatalogoReporte> preguntas, Usuarios usuario) {
        if (!preguntas.isEmpty()) {
            this.agregarMantenimientoPreventivo(productoClienteReporte, preguntas);
        }

    }

    @Override
    @Transactional
    public void updateReporteMantenimientoInstalacionNueva(ProductoClienteReporte productoClienteReporte, List<DetalleCatalogoReporte> preguntas, Usuarios usuario) {

    }

    @Override
    @Transactional
    public void updateReporteMantenimientoCorrectivo(ProductoClienteReporte productoClienteReporte,
            List<DetalleCatalogoReporte> suministros, List<DetalleCatalogoReporte> imagen,
            List<DetalleCatalogoReporte> fijacion, List<DetalleCatalogoReporte> revelado,
            List<DetalleCatalogoReporte> listaAlimentacion, List<DetalleCatalogoReporte> otros, Usuarios usuario) {

    }

    public void updateListaReporteMantenimientoPreventivo(ProductoClienteReporte productoClienteReporte, List<DetalleCatalogoReporte> lista) {

        /* if (lista != null) {

            ReporteMantenimiento mantenimiento;
            int idDetalle = 0, idDetalleMantenimiento = 0;
            for (DetalleCatalogoReporte catalogoDetalle : lista) {
                mantenimiento = new ReporteMantenimiento();

                if (catalogoDetalle.isSeleccion()) {
                    if (containsId(productoClienteReporte.getReporteMantenimientoList(), catalogoDetalle.getIdReporteMantenimiento())) {

                        for (ReporteMantenimiento reporteMantenimiento : productoClienteReporte.getReporteMantenimientoList()) {
                            idDetalle = catalogoDetalle.getId();
                            //   idDetalleMantenimiento = reporteMantenimiento.getIdRepuestoModelo().getIdDetalleCatalogoReporte().getId();
                            if (idDetalle == idDetalleMantenimiento) {
                                mantenimiento = reporteMantenimiento;
                                break;
                            }

                        }

                    } else {
                        //  mantenimiento.setIdRepuestoModelo(new RepuestoModelo(catalogoDetalle.getIdRepuestoModelo()));
                        mantenimiento.setIdProductoClienteReporte(productoClienteReporte);

                    }

                    mantenimiento.setEstado(EstadosEnum.ACTIVO.getValue());
                    mantenimiento = this.save(mantenimiento);
                } else {

                    if (containsId(productoClienteReporte.getReporteMantenimientoList(), catalogoDetalle.getIdReporteMantenimiento())) {
                        for (ReporteMantenimiento reporteMantenimiento : productoClienteReporte.getReporteMantenimientoList()) {
                            mantenimiento = new ReporteMantenimiento();

                            idDetalle = catalogoDetalle.getId();
                            //idDetalleMantenimiento = reporteMantenimiento.getIdRepuestoModelo().getIdDetalleCatalogoReporte().getId();
                            if (idDetalle == idDetalleMantenimiento && reporteMantenimiento.getEstado() == 1) {
                                mantenimiento = reporteMantenimiento;
                                mantenimiento.setEstado(EstadosEnum.INACTIVO.getValue());

                                break;
                            }

                        }
                        this.removeReporteMantenimiento(mantenimiento);
                        //  mantenimiento = this.saveOrUpdateReporteMantenimiento(mantenimiento);

                    }

                }
            }
        }*/
    }

    @Override
    @Transactional
    public void updateReporteMantenimientoPreventivo(ProductoClienteReporte productoClienteReporte,
            List<DetalleCatalogoReporte> procesamiento, List<DetalleCatalogoReporte> imagen,
            List<DetalleCatalogoReporte> fijacion, List<DetalleCatalogoReporte> limpieza) {

        this.updateListaReporteMantenimientoPreventivo(productoClienteReporte, procesamiento);
        this.updateListaReporteMantenimientoPreventivo(productoClienteReporte, imagen);
        this.updateListaReporteMantenimientoPreventivo(productoClienteReporte, fijacion);
        this.updateListaReporteMantenimientoPreventivo(productoClienteReporte, limpieza);

    }

    @Override
    @Transactional
    public List<ReporteMantenimiento> getReporteMantenimientoByReporteId(Integer id) {
        return reporteMantenimientoDAO.getReporteMantenimientoByReporteId(id);

    }

    @Override
    @Transactional
    public List<ReporteMantenimiento> getReporteMantenimientoByDetalleCatalogoId(Integer id) {
        return reporteMantenimientoDAO.getReporteMantenimientoByDetalleCatalogoId(id);
    }

}
