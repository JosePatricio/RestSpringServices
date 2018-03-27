/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleCicloMantenimiento;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fyaulema
 */
@Repository
public class DetalleCicloDAOImpl implements DetalleCicloDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public DetalleCicloMantenimiento addDetalleCiclo(DetalleCicloMantenimiento comboMantenimiento) {
        sessionFactory.getCurrentSession().saveOrUpdate(comboMantenimiento);
        return comboMantenimiento;
    }

    @Override
    public DetalleCicloMantenimiento getDetalleCicloByIdCicloIdProducto(Integer idCiclo, Integer idProducto) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleCicloMantenimiento m ");
        sbQuery.append("WHERE m.idCicloMantenimiento.id=:idCiclo AND m.idProducto.id=:idProducto");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCiclo", idCiclo);
        query.setParameter("idProducto", idProducto);
        Object object = query.uniqueResult();
        DetalleCicloMantenimiento result = object != null ? (DetalleCicloMantenimiento) object : null;
        return result;
    }

    @Override
    public List<DetalleCicloMantenimiento> getDetallesCicloByIdCiclo(Integer id, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleCicloMantenimiento m ");
        sbQuery.append("WHERE m.idCicloMantenimiento.id=:id AND m.estado =:estado");
        //sbQuery.append("ORDER BY m.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        query.setParameter("estado", estado);
        return query.list();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DetalleCicloMantenimiento> getDetalleCiclosByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleCicloMantenimiento m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }
  
}
