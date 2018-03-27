/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ProductoDetalleReporte;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class ProductoDetalleReporteDAOImpl implements ProductoDetalleReporteDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public ProductoDetalleReporte add(ProductoDetalleReporte productoDetalleReporte) {
      
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        session.save(productoDetalleReporte);
        session.close();
        return productoDetalleReporte;
    }

    @Override
    public ProductoDetalleReporte update(ProductoDetalleReporte productoDetalleReporte) {
        sessionFactory.getCurrentSession().update(productoDetalleReporte);
        return productoDetalleReporte;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
