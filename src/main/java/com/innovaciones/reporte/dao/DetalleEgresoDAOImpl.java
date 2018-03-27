/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleEgreso;
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
public class DetalleEgresoDAOImpl implements DetalleEgresoDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public DetalleEgreso addDetalleEgreso(DetalleEgreso detalleEgreso) {
        sessionFactory.getCurrentSession().saveOrUpdate(detalleEgreso);
        return detalleEgreso;
    }

    @Override
    public List<DetalleEgreso> getDetalleEgresos() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleEgreso d ORDER BY d.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public DetalleEgreso getDetalleEgresoById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleEgreso d WHERE d.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        DetalleEgreso result = object != null ? (DetalleEgreso) object : null;
        return result;
    }

    @Override
    public DetalleEgreso getDetalleEgresoByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleEgreso d WHERE d.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        DetalleEgreso result = object != null ? (DetalleEgreso) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DetalleEgreso> getDetalleEgresosByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleEgreso d WHERE d.estado=:estado ");
        sbQuery.append("ORDER BY d.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public List<DetalleEgreso> getDetalleEgresoByIdCabeceraEgreso(Integer idCabeceraEgreso) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleEgreso d WHERE d.idCabeceraEgreso.id=:idCabeceraEgreso ");
        sbQuery.append("ORDER BY d.id");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCabeceraEgreso", idCabeceraEgreso);
        return query.list();
    }

    @Override
    public List<DetalleEgreso> getDetalleEgresoByIdCabeceraEgresoEstado(Integer idCabeceraEgreso, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleEgreso d ");
        sbQuery.append("WHERE d.idCabeceraEgreso.id=:idCabeceraEgreso AND d.estado =:estado ");
        sbQuery.append("ORDER BY d.id");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCabeceraEgreso", idCabeceraEgreso);
        query.setParameter("estado", estado);
        return query.list();
    }

}
