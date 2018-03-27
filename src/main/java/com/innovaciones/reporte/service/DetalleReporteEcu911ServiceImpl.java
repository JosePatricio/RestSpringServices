/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DetalleReporteEcu911DAO;
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
@ManagedBean(name = "detalleReporteEcu911Service")
@ViewScoped
public class DetalleReporteEcu911ServiceImpl implements DetalleReporteEcu911Service, Serializable {

    @Setter
    private DetalleReporteEcu911DAO detalleReporteEcu911DAO;

    @Override
    @Transactional
    public DetalleReporteEcu911 save(DetalleReporteEcu911 detalleReporteEcu911) {
        return detalleReporteEcu911DAO.save(detalleReporteEcu911);
    }

    @Override
    @Transactional
    public DetalleReporteEcu911 update(DetalleReporteEcu911 detalleReporteEcu911) {
        return detalleReporteEcu911DAO.update(detalleReporteEcu911);
    }

    @Override
    @Transactional
    public void delete(DetalleReporteEcu911 detalleReporteEcu911) {
        detalleReporteEcu911DAO.save(detalleReporteEcu911);
    }

    @Override
    @Transactional
    public DetalleReporteEcu911 getByIdReporte(Integer id) {
        return detalleReporteEcu911DAO.getByIdReporte(id);
    }

    @Override
    @Transactional
    public List<DetalleReporteEcu911> getAll() {
        return detalleReporteEcu911DAO.getAll();
    }

}
