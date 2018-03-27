/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoProducto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fyaulema
 */
@Repository
public class TipoProductoDAOImpl implements TipoProductoDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public TipoProducto addTipoProducto(TipoProducto tipoProducto) {
        sessionFactory.getCurrentSession().saveOrUpdate(tipoProducto);
        return tipoProducto;
    }

    @Override
    public List<TipoProducto> getTipoProductos() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from TipoProducto m ORDER BY m.estado DESC, m.nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public TipoProducto getTipoProductoById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from TipoProducto m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        TipoProducto result = object != null ? (TipoProducto) object : null;
        return result;
    }

    @Override
    public TipoProducto getTipoProductoByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from TipoProducto m WHERE m.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        TipoProducto result = object != null ? (TipoProducto) object : null;
        return result;
    }

    @Override
    public TipoProducto getTipoProductoByNombre(String nombre) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from TipoProducto m WHERE UPPER(m.nombre)=:nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("nombre", nombre.trim().toUpperCase());
        Object object = query.uniqueResult();
        TipoProducto result = object != null ? (TipoProducto) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TipoProducto> getTipoProductosByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from TipoProducto m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC, m.nombre");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public TipoProducto saveTipoProducto(TipoProducto tipoProducto) {
        sessionFactory.getCurrentSession().save(tipoProducto);
        return tipoProducto;
    }

}
