/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleReporteEcu911;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class DetalleReporteEcu911DAOImpl implements DetalleReporteEcu911DAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public DetalleReporteEcu911 save(DetalleReporteEcu911 detalleReporteEcu911) {
        sessionFactory.getCurrentSession().save(detalleReporteEcu911);
        return detalleReporteEcu911;
    }

    @Override
    public DetalleReporteEcu911 update(DetalleReporteEcu911 detalleReporteEcu911) {
        sessionFactory.getCurrentSession().update(detalleReporteEcu911);
        return detalleReporteEcu911;
    }

    @Override
    public void delete(DetalleReporteEcu911 detalleReporteEcu911) {
        sessionFactory.getCurrentSession().delete(detalleReporteEcu911);
    }

    @Override
    public DetalleReporteEcu911 getByIdReporte(Integer id) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("from DetalleReporteEcu911 d WHERE d.Reporte.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        DetalleReporteEcu911 result = object != null ? (DetalleReporteEcu911) object : null;
        return result;
    }

    @Override
    public List<DetalleReporteEcu911> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from DetalleReporteEcu911 d")
                .list();

    }

}
