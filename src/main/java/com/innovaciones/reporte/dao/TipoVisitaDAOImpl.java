/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.TipoVisita;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class TipoVisitaDAOImpl implements TipoVisitaDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<TipoVisita> getAllTipoVisitas() {
        return sessionFactory.getCurrentSession().createQuery("from TipoVisita t order by t.orden")
                .list();
    }

    @Override
    @Transactional
    public List<TipoVisita> getByTipo(String tipo) {
        return sessionFactory.getCurrentSession().createQuery("from TipoVisita t WHERE t.tipo='" + tipo + "' order by t.orden")
                .list();
    }

}
