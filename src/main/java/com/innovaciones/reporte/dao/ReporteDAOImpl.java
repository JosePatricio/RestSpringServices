/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Reporte;
import com.innovaciones.reporte.util.Utilities;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class ReporteDAOImpl extends Utilities implements ReporteDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Reporte saveReporte(Reporte reporte) {
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();

        session.save(reporte);

        session.close();
        return reporte;
    }

    @Override
    @Transactional
    public Reporte updateReporte(Reporte reporte) {

        sessionFactory.getCurrentSession().saveOrUpdate(reporte);

        return reporte;
    }

    @Override
    @Transactional
    public Reporte getReporteById(Integer idReporte) {
        Reporte reporte = (Reporte) sessionFactory.getCurrentSession().
                createQuery("from Reporte WHERE id=" + idReporte).uniqueResult();
        return reporte != null ? reporte : null;
    }

    @Override
    @Transactional
    public List<Reporte> getReporteByUserByTipo(Integer idUsuario, String tipo, String subtipo) {
        return sessionFactory.getCurrentSession().createQuery("from Reporte r WHERE r.idUsuario.id=" + idUsuario + " AND r.tipo='" + tipo + "' AND r.subtipo = '" + subtipo + "'")
                .list();
    }

}
