/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ConsultasDAO;
import com.innovaciones.reporte.model.DTO.ReportesDTO;
import com.innovaciones.reporte.model.DetalleReporteEcu911;
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
@ManagedBean(name = "consultasService")
@ViewScoped
public class ConsultasServiceImpl implements ConsultasService, Serializable {

    @Setter
    private ConsultasDAO consultasDAO;

    @Transactional
    @Override
    public ReportesDTO reportesById(Integer id) {
        return consultasDAO.reportesById(id);
    }

    @Override
    @Transactional
    public List<ReportesDTO> reportesInstalaciones() {
        return consultasDAO.reportesInstalaciones();
    }

    @Override
    @Transactional
    public ReportesDTO reportesInstalacionesById(Integer id) {
        return consultasDAO.reportesInstalacionesById(id);
    }

    @Override
    @Transactional
    public List<ReportesDTO> reportesBySubTipo(String subTipo) {
        System.out.println("ENTRO A SERVICIO  "+subTipo);
        return consultasDAO.reportesBySubTipo(subTipo);
    }

    @Override
    @Transactional
    public List<DetalleReporteEcu911> reportesEcu911(boolean esInvitado, Integer IdUsuario, Integer idProyecto, Integer idCliente) {
        System.out.println("  esInvitado=  " + esInvitado + " , IdUsuario=" + IdUsuario + " , idCliente=" + idCliente + " , IdProyecto =" + idProyecto);
        if (esInvitado) {
            System.out.println("OPCION 1");
            return consultasDAO.reportesEcu911ByUserId(IdUsuario, idProyecto);
        }

        if (!esInvitado && idCliente == null) {
            System.out.println("OPCION 2");
            return consultasDAO.reportesEcu911();

        }
        if (!esInvitado && idCliente != null) {
            System.out.println("OPCION 3");
            System.out.println(" ID cLIENTE BUSQUEDA " + idCliente + "  , IDpROYECTO " + idProyecto + " ,Tamanio= " + consultasDAO.reportesEcu911ByUserId(idCliente, idProyecto).size());
            return consultasDAO.reportesEcu911ByUserId(idCliente, idProyecto);
        }
        return null;
    }

    @Override
    @Transactional
    public DetalleReporteEcu911 reportesEcu911ById(Integer id) {
        return consultasDAO.reportesEcu911ById(id);
    }

    @Override
    @Transactional
    public List<DetalleReporteEcu911> reportesEcu911ByUserId(Integer id, Integer idProyecto, Integer idCliente) {
        return consultasDAO.reportesEcu911ByUserId(id, idProyecto);
    }

}
