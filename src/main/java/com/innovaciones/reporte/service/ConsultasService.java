/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.DTO.ReportesDTO;
import com.innovaciones.reporte.model.DetalleReporteEcu911;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ConsultasService {

    public ReportesDTO reportesById(Integer id);

    public List<ReportesDTO> reportesInstalaciones();

    public ReportesDTO reportesInstalacionesById(Integer id);

    public List<ReportesDTO> reportesBySubTipo(String subTipo);

    public List<DetalleReporteEcu911> reportesEcu911(boolean esInvitado, Integer IdUsuario,Integer idProyecto,Integer idCliente);

    public DetalleReporteEcu911 reportesEcu911ById(Integer id);

    public List<DetalleReporteEcu911> reportesEcu911ByUserId(Integer id,Integer idProyecto,Integer idCliente);

}
