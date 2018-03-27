/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoCuentaBancaria;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class TipoCuentaBancariaDAOImpl implements TipoCuentaBancariaDAO, Serializable {

    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TipoCuentaBancaria addTipoCuentaBancaria(TipoCuentaBancaria tipoCuentaBancaria) {
        sessionFactory.getCurrentSession().saveOrUpdate(tipoCuentaBancaria);
        return tipoCuentaBancaria;
    }

    @Override
    public List<TipoCuentaBancaria> getTipoCuentaBancarias() {
        return sessionFactory.getCurrentSession().createQuery("from TipoCuentaBancaria t ORDER BY t.estado desc, t.nombre")
                .list();
    }

    @Override
    public TipoCuentaBancaria getTipoCuentaBancariaById(Integer id) {
        TipoCuentaBancaria tipoCuentaBancaria = (TipoCuentaBancaria) sessionFactory.getCurrentSession().createQuery("from TipoCuentaBancaria WHERE id=" + id + "").uniqueResult();
        return tipoCuentaBancaria != null ? tipoCuentaBancaria : null;
    }


    @Override
    public List<TipoCuentaBancaria> getTipoCuentaBancariasByEstado(Integer estado) {

        return sessionFactory.getCurrentSession().createQuery("from TipoCuentaBancaria t WHERE t.estado =" + estado + " ORDER BY t.estado desc, t.nombre").
                list();
    }

    @Override
    public TipoCuentaBancaria saveTipoCuentaBancaria(TipoCuentaBancaria tipoCuentaBancaria) {
        sessionFactory.getCurrentSession().save(tipoCuentaBancaria);
        return tipoCuentaBancaria;
    }

}
