/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoProveedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class TipoProveedorDAOImpl implements TipoProveedorDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public TipoProveedor addTipoProveedor(TipoProveedor tipoProveedor) {
        sessionFactory.getCurrentSession().saveOrUpdate(tipoProveedor);
        return tipoProveedor;
    }

    @Override
    public List<TipoProveedor> getTipoProveedores() {
        return sessionFactory.getCurrentSession().createQuery("from TipoProveedor t ORDER BY t.estado desc, t.nombre")
                .list();
    }

    @Override
    public TipoProveedor getTipoProveedorById(Integer id) {
        TipoProveedor tipoProveedor = (TipoProveedor) sessionFactory.getCurrentSession().createQuery("from TipoProveedor t WHERE t.id=" + id + "").uniqueResult();
        return tipoProveedor != null ? tipoProveedor : null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TipoProveedor> getTipoProveedoresByEstado(Integer estado) {

        return sessionFactory.getCurrentSession().createQuery("from TipoProveedor t WHERE t.estado =" + estado+ " ORDER BY t.nombre").
                list();
    }

    @Override
    public TipoProveedor saveTipoProveedor(TipoProveedor tipoProveedor) {
        sessionFactory.getCurrentSession().save(tipoProveedor);
        return tipoProveedor;
    }

}
