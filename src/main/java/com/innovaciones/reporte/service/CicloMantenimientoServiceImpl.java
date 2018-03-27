/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.CicloMantenimientoDAO;
import com.innovaciones.reporte.model.CicloMantenimiento;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "cicloMantenimientoService")
@ViewScoped
public class CicloMantenimientoServiceImpl implements CicloMantenimientoService, Serializable {

    private CicloMantenimientoDAO cicloMantenimientoDAO;

    public void setCicloMantenimientoDAO(CicloMantenimientoDAO cicloMantenimientoDAO) {
        this.cicloMantenimientoDAO = cicloMantenimientoDAO;
    }

    @Override
    @Transactional
    public CicloMantenimiento addCicloMantenimiento(CicloMantenimiento cicloMantenimiento) {
        return cicloMantenimientoDAO.addCicloMantenimiento(cicloMantenimiento);

    }

    @Override
    @Transactional
    public List<CicloMantenimiento> getCicloMantenimientos() {
        return cicloMantenimientoDAO.getCicloMantenimientos();
    }

    @Override
    @Transactional
    public CicloMantenimiento getCicloMantenimientoById(Integer id) {
        return cicloMantenimientoDAO.getCicloMantenimientoById(id);
    }

    @Override
    @Transactional
    public CicloMantenimiento getCicloMantenimientoByCodigo(String codigo) {
        return cicloMantenimientoDAO.getCicloMantenimientoByCodigo(codigo);
    }

    @Override
    @Transactional
    public CicloMantenimiento getCicloMantenimientoByCicloIdEquipo(Integer valorCiclo, Integer idEquipo){
        return cicloMantenimientoDAO.getCicloMantenimientoByCicloIdEquipo(valorCiclo, idEquipo);
    }

    @Override
    @Transactional
    public CicloMantenimiento getCicloMantenimientoByNombre(String nombre) {
        return cicloMantenimientoDAO.getCicloMantenimientoByNombre(nombre);
    }

    @Override
    @Transactional
    public List<CicloMantenimiento> getCicloMantenimientosByEstado(Integer estado) {
        return cicloMantenimientoDAO.getCicloMantenimientosByEstado(estado);
    }

    @Override
    @Transactional
    public CicloMantenimiento saveCicloMantenimiento(CicloMantenimiento cicloMantenimiento) {
        return cicloMantenimientoDAO.saveCicloMantenimiento(cicloMantenimiento);
    }

//    @Override
//    @Transactional
//    public List<CicloMantenimiento> getCicloMantenimientosLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException {
//        return cicloMantenimientoDAO.getCicloMantenimientosLazy(start, size, sortField, sortOrder, filters);
//    }
}
