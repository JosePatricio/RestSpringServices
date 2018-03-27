/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.CicloMantenimiento;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fyaulema
 */
@Repository
public class CicloMantenimientoDAOImpl implements CicloMantenimientoDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public CicloMantenimiento addCicloMantenimiento(CicloMantenimiento cicloMantenimiento) {
        sessionFactory.getCurrentSession().saveOrUpdate(cicloMantenimiento);
        return cicloMantenimiento;
    }

    @Override
    public List<CicloMantenimiento> getCicloMantenimientos() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from CicloMantenimiento m ORDER BY m.estado DESC, m.codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public CicloMantenimiento getCicloMantenimientoById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from CicloMantenimiento m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        CicloMantenimiento result = object != null ? (CicloMantenimiento) object : null;
        return result;
    }

    @Override
    public CicloMantenimiento getCicloMantenimientoByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from CicloMantenimiento m WHERE m.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        CicloMantenimiento result = object != null ? (CicloMantenimiento) object : null;
        return result;
    }
    
    
    @Override
    public CicloMantenimiento getCicloMantenimientoByCicloIdEquipo(Integer valorCiclo, Integer idEquipo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from CicloMantenimiento m WHERE m.ciclo =:valorCiclo AND m.idEquipo.id = :idEquipo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());        
        query.setParameter("valorCiclo", valorCiclo);
        query.setParameter("idEquipo", idEquipo);
        Object object = query.uniqueResult();
        CicloMantenimiento result = object != null ? (CicloMantenimiento) object : null;
        return result;
    }

    @Override
    public CicloMantenimiento getCicloMantenimientoByNombre(String nombre) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from CicloMantenimiento m WHERE UPPER(m.cicloMantenimiento)=:nombre");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("nombre", nombre.trim().toUpperCase());
        Object object = query.uniqueResult();
        CicloMantenimiento result = object != null ? (CicloMantenimiento) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CicloMantenimiento> getCicloMantenimientosByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from CicloMantenimiento m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC, m.codigo");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public CicloMantenimiento saveCicloMantenimiento(CicloMantenimiento cicloMantenimiento) {
        sessionFactory.getCurrentSession().save(cicloMantenimiento);
        return cicloMantenimiento;
    }

}
