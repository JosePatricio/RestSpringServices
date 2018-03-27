/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.RolDAO;
import com.innovaciones.reporte.model.Rol;
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
@ManagedBean(name = "rolService")
@ViewScoped
public class RolServiceImpl implements RolService, Serializable {

    @Setter
    private RolDAO rolDAO;

    @Override
    @Transactional
    public List<Rol> getRoles() {
        return rolDAO.getRoles();
    }

    @Override
    @Transactional
    public List<Rol> getRolesByestado(Integer estado) {
        return rolDAO.getRolesByestado(estado);
    }

    @Override
    @Transactional
    public Rol getById(Integer id) {
        return rolDAO.getById(id);
    }

    @Override
    @Transactional
    public Rol getByRol(String rol) {
        return rolDAO.getByRol(rol);
    }

}
