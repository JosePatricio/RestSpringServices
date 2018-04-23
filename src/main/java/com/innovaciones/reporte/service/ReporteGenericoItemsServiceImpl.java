/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ReporteGenericoItemsDAO;
import com.innovaciones.reporte.model.ReporteGenericoItems;
import com.innovaciones.reporte.model.ReporteMantenimiento;
import com.innovaciones.reporte.util.Utilities;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "reporteGenericoItemsService")
@ViewScoped
public class ReporteGenericoItemsServiceImpl extends Utilities implements ReporteGenericoItemsService, Serializable {

    @Setter
    private ReporteGenericoItemsDAO reporteGenericoItemsDAO;

    @Override
    @Transactional
    public ReporteGenericoItems save(ReporteGenericoItems reporteGenericoItem) {
        reporteGenericoItemsDAO.save(reporteGenericoItem);
        return reporteGenericoItem;
    }

    @Override
    @Transactional
    public ReporteGenericoItems update(ReporteGenericoItems reporteGenericoItem) {
        reporteGenericoItemsDAO.update(reporteGenericoItem);
        return reporteGenericoItem;
    }

    @Override
    @Transactional
    public void eliminar(ReporteGenericoItems reporteGenericoItem) {
        reporteGenericoItemsDAO.eliminar(reporteGenericoItem);
    }

    @Override
    @Transactional
    public List<ReporteMantenimiento> getReporteMantenimientoByReporteId(Integer id) {

        return reporteGenericoItemsDAO.getReporteMantenimientoByReporteId(id);
    }

}
