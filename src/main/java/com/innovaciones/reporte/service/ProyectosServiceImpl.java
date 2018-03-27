/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ProyectosDAO;
import com.innovaciones.reporte.model.Proyectos;
import com.innovaciones.reporte.model.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
/*
@Service
@ManagedBean(name = "proyectosService")
@ViewScoped*/
public class ProyectosServiceImpl implements ProyectosService, Serializable {

    @Setter
    private ProyectosDAO proyectosDAO;

    @Setter
    @Getter
    @ManagedProperty("#{usuariosService}")
    private UsuariosService usuariosService;

    @Override
    @Transactional
    public Proyectos save(Proyectos proyectos) {
        return proyectosDAO.save(proyectos);
    }

    @Override
    @Transactional
    public Proyectos update(Proyectos proyectos) {
        return proyectosDAO.update(proyectos);
    }

    @Override
    @Transactional
    public Proyectos saveorupdate(Proyectos proyectos) {
        return proyectosDAO.saveorupdate(proyectos);
    }

    @Override
    @Transactional
    public void delete(Proyectos proyectos) {
        proyectosDAO.delete(proyectos);
    }

    @Override
    @Transactional
    public List<Proyectos> getByIDCliente(Integer id) {
        Usuarios usuarios = usuariosService.getUsuariosById(id);
        Integer idCliente = 0;
        if (usuarios != null) {
            idCliente = usuarios.getIdCliente().getId();
        }
        
        List<Proyectos> list = new ArrayList<>();
        list = proyectosDAO.getByIDCliente(idCliente);

        return list;
    }

}
