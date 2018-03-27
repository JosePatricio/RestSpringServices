/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.NotificacionDAO;
import com.innovaciones.reporte.model.DTO.NotificacionDTO;
import com.innovaciones.reporte.model.DTO.ReportesDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Fernando
 */
@Service
@ManagedBean(name = "notificacionService")
@ViewScoped
public class NotificacionServiceImpl implements NotificacionService, Serializable {

    private NotificacionDAO notificacionDAO;

    @Override
    @Transactional
    public List<NotificacionDTO> getNotificacionesByEstadoReporte(boolean preasignacion) {
        return notificacionDAO.getNotificacionesByEstadoReporte(preasignacion);
    }

    @Override
    @Transactional
    public List<NotificacionDTO> getNotificacionesByEstadoReporteByIdUsuario(Integer idUsuario, boolean preasignacion) {
        return notificacionDAO.getNotificacionesByEstadoReporteByIdUsuario(idUsuario, preasignacion);
    }

    public NotificacionDAO getNotificacionDAO() {
        return notificacionDAO;
    }

    public void setNotificacionDAO(NotificacionDAO notificacionDAO) {
        this.notificacionDAO = notificacionDAO;
    }

    @Transactional
    public NotificacionDTO getNotificacionById(int id) {
        return notificacionDAO.getNotificacionById(id);
    }

    @Override
    @Transactional
    public List<ReportesDTO> getReportesPorProducto(int rows, int idProducto) throws ParseException {
        return notificacionDAO.getReportesPorProducto(rows,idProducto);
    }

}
