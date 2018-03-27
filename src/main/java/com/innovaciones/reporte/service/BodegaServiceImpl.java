/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.BodegaDAO;
import com.innovaciones.reporte.model.Bodega;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fyaulema
 */
@Service
@ManagedBean(name = "bodegaService")
@ViewScoped
public class BodegaServiceImpl implements BodegaService, Serializable {

    private BodegaDAO bodegaDAO;

    public void setBodegaDAO(BodegaDAO bodegaDAO) {
        this.bodegaDAO = bodegaDAO;
    }

    @Override
    @Transactional
    public Bodega addBodega(Bodega bodega) {
        return bodegaDAO.addBodega(bodega);
    }

    @Override
    @Transactional
    public List<Bodega> getBodegas() {
        return bodegaDAO.getBodegas();
    }

    @Override
    @Transactional
    public Bodega getBodegaById(Integer id) {
        return bodegaDAO.getBodegaById(id);
    }

    @Override
    @Transactional
    public Bodega getBodegaByCodigo(String codigo) {
        return bodegaDAO.getBodegaByCodigo(codigo);
    }

    @Override
    @Transactional
    public List<Bodega> getBodegasByEstado(Integer estado) {
        return bodegaDAO.getBodegasByEstado(estado);
    }

    @Override
    @Transactional
    public Bodega getBodegaByNombre(String nombre) {
        return bodegaDAO.getBodegaByNombre(nombre);
    }

}
