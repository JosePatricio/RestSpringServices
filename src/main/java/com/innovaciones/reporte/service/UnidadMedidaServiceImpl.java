/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.UnidadMedidaDAO;
import com.innovaciones.reporte.model.UnidadMedida;
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
@ManagedBean(name = "unidadMedidaService")
@ViewScoped
public class UnidadMedidaServiceImpl implements UnidadMedidaService, Serializable {

    private UnidadMedidaDAO unidadMedidaDAO;

    public void setUnidadMedidaDAO(UnidadMedidaDAO unidadMedidaDAO) {
        this.unidadMedidaDAO = unidadMedidaDAO;
    }

    @Override
    @Transactional
    public UnidadMedida addUnidadMedida(UnidadMedida unidadMedida) {
        return unidadMedidaDAO.addUnidadMedida(unidadMedida);

    }

    @Override
    @Transactional
    public List<UnidadMedida> getUnidadMedidas() {
        return unidadMedidaDAO.getUnidadMedidas();
    }

    @Override
    @Transactional
    public UnidadMedida getUnidadMedidaById(Integer id) {
        return unidadMedidaDAO.getUnidadMedidaById(id);
    }

    @Override
    @Transactional
    public UnidadMedida getUnidadMedidaByCodigo(String codigo) {
        return unidadMedidaDAO.getUnidadMedidaByCodigo(codigo);
    }

    @Override
    @Transactional
    public UnidadMedida getUnidadMedidaByNombre(String nombre) {
        return unidadMedidaDAO.getUnidadMedidaByNombre(nombre);
    }

    @Override
    @Transactional
    public List<UnidadMedida> getUnidadMedidasByEstado(Integer estado) {
        return unidadMedidaDAO.getUnidadMedidasByEstado(estado);
    }

    @Override
    @Transactional
    public UnidadMedida saveUnidadMedida(UnidadMedida unidadMedida) {
        return unidadMedidaDAO.saveUnidadMedida(unidadMedida);
    }

}
