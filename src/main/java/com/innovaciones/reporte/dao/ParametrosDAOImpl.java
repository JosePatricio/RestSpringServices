/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Parametros;
import java.io.Serializable;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class ParametrosDAOImpl implements ParametrosDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Parametros getByParametro(String parametro) {
        Object object = sessionFactory.getCurrentSession().createQuery("from Parametros as p WHERE p.parametro='" + parametro + "'").uniqueResult();
        Parametros result = object != null ? (Parametros) object : null;
        return result;
    }

}
