/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Bodega;
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
public class BodegaDAOImpl implements BodegaDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public Bodega addBodega(Bodega cabeceraInventario) {
        sessionFactory.getCurrentSession().saveOrUpdate(cabeceraInventario);
        return cabeceraInventario;
    }

    @Override
    public List<Bodega> getBodegas() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT b from Bodega b ORDER BY b.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public Bodega getBodegaById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT b from Bodega b WHERE b.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        Bodega result = object != null ? (Bodega) object : null;
        return result;
    }

    @Override
    public Bodega getBodegaByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT b from Bodega b WHERE b.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        Bodega result = object != null ? (Bodega) object : null;
        return result;
    }

    @Override
    public Bodega getBodegaByNombre(String nombre) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT b from Bodega b WHERE b.nombre=:nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("nombre", nombre);
        Object object = query.uniqueResult();
        Bodega result = object != null ? (Bodega) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Bodega> getBodegasByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT b from Bodega b WHERE b.estado=:estado ");
        sbQuery.append("ORDER BY b.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public Bodega saveBodega(Bodega cabeceraInventario) {
        sessionFactory.getCurrentSession().save(cabeceraInventario);
        return cabeceraInventario;
    }

}
