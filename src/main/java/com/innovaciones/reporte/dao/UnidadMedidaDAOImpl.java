/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.UnidadMedida;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class UnidadMedidaDAOImpl implements UnidadMedidaDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public UnidadMedida addUnidadMedida(UnidadMedida unidadMedida) {
        sessionFactory.getCurrentSession().saveOrUpdate(unidadMedida);
        return unidadMedida;
    }

    @Override
    public List<UnidadMedida> getUnidadMedidas() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UnidadMedida m ORDER BY m.estado DESC, m.nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public UnidadMedida getUnidadMedidaById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UnidadMedida m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        UnidadMedida result = object != null ? (UnidadMedida) object : null;
        return result;
    }

    @Override
    public UnidadMedida getUnidadMedidaByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UnidadMedida m WHERE m.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        UnidadMedida result = object != null ? (UnidadMedida) object : null;
        return result;
    }

    @Override
    public UnidadMedida getUnidadMedidaByNombre(String nombre) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UnidadMedida m WHERE UPPER(m.nombre)=:nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("nombre", nombre.trim().toUpperCase());
        Object object = query.uniqueResult();
        UnidadMedida result = object != null ? (UnidadMedida) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UnidadMedida> getUnidadMedidasByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UnidadMedida m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado, m.nombre ");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public UnidadMedida saveUnidadMedida(UnidadMedida unidadMedida) {
        sessionFactory.getCurrentSession().save(unidadMedida);
        return unidadMedida;
    }

}
