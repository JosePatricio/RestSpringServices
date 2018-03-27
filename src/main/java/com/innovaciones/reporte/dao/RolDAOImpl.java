/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Rol;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pisama
 */
@Repository
public class RolDAOImpl implements RolDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public List<Rol> getRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Rol")
                .list();
    }

    @Override
    public List<Rol> getRolesByestado(Integer estado) {
        return sessionFactory.getCurrentSession().createQuery("from Rol WHERE estado = " + estado + " ORDER BY descripcion")
                .list();
    }

    @Override
    public Rol getById(Integer id) {
        Rol cliente = (Rol) sessionFactory.getCurrentSession().createQuery("from Rol WHERE id=" + id).uniqueResult();
        return cliente != null ? cliente : null;
    }

    @Override
    public Rol getByRol(String rol) {
        Rol cliente = (Rol) sessionFactory.getCurrentSession().createQuery("from Rol WHERE rol='" + rol + "'").uniqueResult();
        return cliente != null ? cliente : null;
    }

}
