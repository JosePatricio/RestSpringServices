/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.CabeceraInventario;
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
public class CabeceraInventarioDAOImpl implements CabeceraInventarioDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public CabeceraInventario addCabeceraInventario(CabeceraInventario cabeceraInventario) {
        sessionFactory.getCurrentSession().saveOrUpdate(cabeceraInventario);
        return cabeceraInventario;
    }

    @Override
    public List<CabeceraInventario> getCabeceraInventarios(Integer idBodega) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c from CabeceraInventario c ");

        if (idBodega != null) {
            sbQuery.append("WHERE c.idBodega.id =:idBodega ");
        }

        sbQuery.append("ORDER BY c.estado DESC, c.fechaRegistro DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        return query.list();
    }

    @Override
    public CabeceraInventario getCabeceraInventarioById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c from CabeceraInventario c WHERE c.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        CabeceraInventario result = object != null ? (CabeceraInventario) object : null;
        return result;
    }

    @Override
    public CabeceraInventario getCabeceraInventarioByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c from CabeceraInventario c WHERE c.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        CabeceraInventario result = object != null ? (CabeceraInventario) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CabeceraInventario> getCabeceraInventariosByEstado(Integer idBodega, Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c from CabeceraInventario c ");
        sbQuery.append("WHERE c.estado=:estado ");

        if (idBodega != null) {
            sbQuery.append("AND c.idBodega.id =:idBodega ");
        }

        sbQuery.append("ORDER BY c.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        return query.list();

    }

    @Override
    public Integer getCountInventarios() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT count(c.id) from CabeceraInventario c");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        Object object = query.uniqueResult();
        Integer result = object != null ? Integer.parseInt(object.toString()) : 0;
        return result;
    }

}
