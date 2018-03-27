/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DetalleCicloDAO;
import com.innovaciones.reporte.model.DetalleCicloMantenimiento;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
@ManagedBean(name = "detalleCicloService")
@ViewScoped
public class DetalleCicloServiceImpl implements DetalleCicloService, Serializable {

    @Getter
    @Setter
    private DetalleCicloDAO detalleCicloDAO;
   

    @Transactional
    @Override
    public DetalleCicloMantenimiento addDetalleCiclo(DetalleCicloMantenimiento detalleCiclo) {
        return detalleCicloDAO.addDetalleCiclo(detalleCiclo);
    }

    @Transactional
    @Override
    public DetalleCicloMantenimiento getDetalleCicloByIdCicloIdProducto(Integer idCiclo, Integer idProducto) {
        return detalleCicloDAO.getDetalleCicloByIdCicloIdProducto(idCiclo, idProducto);
    }

    @Transactional
    @Override
    public List<DetalleCicloMantenimiento> getDetallesCicloByIdCiclo(Integer id, Integer estado) {
        return detalleCicloDAO.getDetallesCicloByIdCiclo(id, estado);
    }

    @Transactional
    @Override
    public List<DetalleCicloMantenimiento> getDetalleCiclosByEstado(Integer estado) {
        return detalleCicloDAO.getDetalleCiclosByEstado(estado);
    }
}
