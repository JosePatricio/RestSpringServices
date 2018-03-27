/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoDocumentoProveedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class TipoDocumentoProveedorDAOImpl implements TipoDocumentoProveedorDAO, Serializable {

    private SessionFactory sessionFactory;
    
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public TipoDocumentoProveedor addTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor) {
        sessionFactory.getCurrentSession().saveOrUpdate(tipoDocumentoProveedor);
        return tipoDocumentoProveedor;
    }

    @Override
    public List<TipoDocumentoProveedor> getTipoDocumentoProveedores() {
        return sessionFactory.getCurrentSession().createQuery("from TipoDocumentoProveedor t ORDER BY t.estado desc, t.nombre")
                .list();
    }

    @Override
    public TipoDocumentoProveedor getTipoDocumentoProveedorById(Integer id) {
        TipoDocumentoProveedor tipoDocumentoProveedor = (TipoDocumentoProveedor) sessionFactory.getCurrentSession().createQuery("from TipoDocumentoProveedor t WHERE t.id=" + id + "").uniqueResult();
        return tipoDocumentoProveedor != null ? tipoDocumentoProveedor : null;
    }

    @Override
    public List<TipoDocumentoProveedor> getTipoDocumentoProveedorsByEstado(Integer estado) {

        return sessionFactory.getCurrentSession().createQuery("from TipoDocumentoProveedor t WHERE estado =" + estado+ " ORDER BY t.nombre").
                list();
    }

    @Override
    public TipoDocumentoProveedor saveTipoDocumentoProveedor(TipoDocumentoProveedor tipoDocumentoProveedor) {
        sessionFactory.getCurrentSession().save(tipoDocumentoProveedor);
        return tipoDocumentoProveedor;
    }

}
