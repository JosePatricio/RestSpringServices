/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Marca;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fyaulema
 */
@Repository
public class MarcaDAOImpl implements MarcaDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public Marca addMarca(Marca marca) {
        sessionFactory.getCurrentSession().saveOrUpdate(marca);
        return marca;
    }

    @Override
    public List<Marca> getMarcas() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from Marca m ORDER BY m.estado DESC, m.marca");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public Marca getMarcaById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from Marca m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        Marca result = object != null ? (Marca) object : null;
        return result;
    }

    @Override
    public Marca getMarcaByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from Marca m WHERE m.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        Marca result = object != null ? (Marca) object : null;
        return result;
    }

    @Override
    public Marca getMarcaByNombre(String nombre) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from Marca m WHERE UPPER(m.marca)=:nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("nombre", nombre.trim().toUpperCase());
        Object object = query.uniqueResult();
        Marca result = object != null ? (Marca) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Marca> getMarcasByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from Marca m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC, m.marca");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public Marca saveMarca(Marca marca) {
        sessionFactory.getCurrentSession().save(marca);
        return marca;
    }

}
