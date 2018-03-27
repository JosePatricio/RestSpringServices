/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.NotificacionDTO;
import com.innovaciones.reporte.model.DTO.ReportesDTO;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface NotificacionDAO {

    public List<NotificacionDTO> getNotificacionesByEstadoReporte(boolean preasignacion);
    public List<NotificacionDTO> getNotificacionesByEstadoReporteByIdUsuario(Integer idUsuario, boolean preasignacion);
    public NotificacionDTO getNotificacionById(int id);
    List<ReportesDTO> getReportesPorProducto(int rows, int idProducto) throws ParseException;

}
