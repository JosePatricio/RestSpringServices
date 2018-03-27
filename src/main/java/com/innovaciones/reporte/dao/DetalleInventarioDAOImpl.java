/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleInventario;
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
public class DetalleInventarioDAOImpl implements DetalleInventarioDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public DetalleInventario addDetalleInventario(DetalleInventario cabeceraInventario) {
        sessionFactory.getCurrentSession().saveOrUpdate(cabeceraInventario);
        return cabeceraInventario;
    }

    @Override
    public List<DetalleInventario> getDetalleInventarios() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleInventario d ORDER BY d.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public DetalleInventario getDetalleInventarioById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleInventario d WHERE d.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        DetalleInventario result = object != null ? (DetalleInventario) object : null;
        return result;
    }

    @Override
    public DetalleInventario getDetalleInventarioByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleInventario d WHERE d.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        DetalleInventario result = object != null ? (DetalleInventario) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DetalleInventario> getDetalleInventariosByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleInventario d WHERE d.estado=:estado ");
        sbQuery.append("ORDER BY d.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public List<DetalleInventario> getDetalleInventarioByIdCabeceraInventario(Integer idCabeceraInventario) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleInventario d WHERE d.idCabeceraInventario.id=:idCabeceraInventario ");
        sbQuery.append("ORDER BY d.id");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCabeceraInventario", idCabeceraInventario);
        return query.list();
    }

    @Override
    public DetalleInventario saveDetalleInventario(DetalleInventario cabeceraInventario) {
        sessionFactory.getCurrentSession().save(cabeceraInventario);
        return cabeceraInventario;
    }

    @Override
    public List<DetalleInventario> getDetalleInventarioByIdCabeceraInventarioEstado(Integer idCabeceraInventario, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleInventario d ");
        sbQuery.append("WHERE d.idCabeceraInventario.id=:idCabeceraInventario AND d.estado =:estado ");
        sbQuery.append("ORDER BY d.id");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCabeceraInventario", idCabeceraInventario);
        query.setParameter("estado", estado);
        return query.list();
    }

    @Override
    public Integer getCountDetalleByCabecera(Integer idCabeceraInventario, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT SUM(d.cantidad) ");
        sbQuery.append("FROM DetalleInventario d ");
        sbQuery.append("WHERE d.idCabeceraInventario.id =:idCabeceraInventario AND d.estado =:estado ");
        sbQuery.append("GROUP BY d.idCabeceraInventario.id");
        
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
                
        query.setParameter("idCabeceraInventario", idCabeceraInventario);
        query.setParameter("estado", estado);
        Object object = query.uniqueResult();        
        Integer result = object != null ? Integer.parseInt(object.toString()) : 0;
        return result;
    }

}
