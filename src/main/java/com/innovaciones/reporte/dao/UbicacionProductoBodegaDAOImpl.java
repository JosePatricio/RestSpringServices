/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.UbicacionProductoBodega;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fyaulema
 */
@Repository
public class UbicacionProductoBodegaDAOImpl implements UbicacionProductoBodegaDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public UbicacionProductoBodega addUbicacionProducto(UbicacionProductoBodega ubicacionProductoBodega) {
        sessionFactory.getCurrentSession().saveOrUpdate(ubicacionProductoBodega);
        return ubicacionProductoBodega;
    }

    @Override
    public UbicacionProductoBodega saveUbicacionProducto(UbicacionProductoBodega ubicacionProductoBodega) {
        sessionFactory.getCurrentSession().save(ubicacionProductoBodega);
        return ubicacionProductoBodega;
    }

    @Override
    public List<UbicacionProductoBodega> getUbicacionesProducto() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UbicacionProductoBodega m ORDER BY m.estado DESC, m.ubicacionProductoBodega");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public UbicacionProductoBodega getUbicacionProductoById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UbicacionProductoBodega m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        UbicacionProductoBodega result = object != null ? (UbicacionProductoBodega) object : null;
        return result;
    }

    @Override
    public List<UbicacionProductoBodega> getUbicacionesProductoByIdProducto(Integer idProducto) {

        List result = null;

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UbicacionProductoBodega m WHERE m.idProducto.id=:idProducto ");
        sbQuery.append("ORDER BY m.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);

        try {
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<UbicacionProductoBodega> getUbicacionesProductoByIdBodega(Integer idBodega) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UbicacionProductoBodega m WHERE m.idBodega.id=:idBodega ");
        sbQuery.append("ORDER BY m.estado DESC, m.idBodega.codigo");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idBodega", idBodega);
        return query.list();
    }

    @Override
    public List<UbicacionProductoBodega> getUbicacionesProductoByIdBodegaIdProducto(Integer idBodega, Integer idProducto, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UbicacionProductoBodega m WHERE 1=1 ");

        if (idBodega != null) {
            sbQuery.append(" AND m.idBodega.id =:idBodega ");
        }

        if (idProducto != null) {
            sbQuery.append(" AND m.idProducto.id =:idProducto ");
        }

        if (estado != null) {
            sbQuery.append(" AND m.estado =:estado ");
        }

        System.out.println("getUbicacionesProductoByIdBodegaIdProducto(): " + sbQuery.toString());

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        if (idProducto != null) {
            query.setParameter("idProducto", idProducto);
        }

        if (estado != null) {
            query.setParameter("estado", estado);
        }

        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UbicacionProductoBodega> getUbicacionesProductoByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from UbicacionProductoBodega m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC, m.ubicacionProductoBodega");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

}
