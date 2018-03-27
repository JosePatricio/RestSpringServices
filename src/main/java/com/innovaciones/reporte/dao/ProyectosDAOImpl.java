/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Proyectos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class ProyectosDAOImpl implements ProyectosDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public Proyectos save(Proyectos proyectos) {
        sessionFactory.getCurrentSession().save(proyectos);
        return proyectos;
    }

    @Override
    public Proyectos update(Proyectos proyectos) {
        sessionFactory.getCurrentSession().update(proyectos);
        return proyectos;
    }

      @Override
    public Proyectos saveorupdate(Proyectos proyectos) {
        sessionFactory.getCurrentSession().saveOrUpdate(proyectos);
        return proyectos;
    }
    @Override
    public void delete(Proyectos proyectos) {
        sessionFactory.getCurrentSession().delete(proyectos);
    }

    @Override
    public List<Proyectos> getByIDCliente(Integer id) {
        List<Proyectos> list = sessionFactory.getCurrentSession().createQuery("from Proyectos p WHERE p.idCliente.id=" + id).list();
        return !list.isEmpty() || list != null ? list : new ArrayList<>();
    }

}
