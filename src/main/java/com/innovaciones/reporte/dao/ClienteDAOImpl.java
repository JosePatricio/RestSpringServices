/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Cliente;
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
public class ClienteDAOImpl implements ClienteDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Cliente addCliente(Cliente cliente) {
        sessionFactory.getCurrentSession().saveOrUpdate(cliente);
        return cliente;
    }

    @Override
    @Transactional
    public Cliente getClienteByRuc(String ruc) {
        List<Cliente> list = sessionFactory.getCurrentSession().createQuery("from Cliente WHERE ruc='" + ruc + "'")
                .list();
        Cliente client = new Cliente();
        for (Cliente cliente : list) {
            client = cliente;
            break;
        }
        return client;
    }

    @Override
    public Cliente getClienteByNombre(String nombre) {
        Cliente cliente = (Cliente) sessionFactory.getCurrentSession().createQuery("from Cliente WHERE cliente='" + nombre + "'").uniqueResult();
        return cliente != null ? cliente : null;
    }

    @Override
    @Transactional
    public List<Cliente> getClientes() {
        System.out.println("ENTROO DATO  getClientes");
        List<Cliente> LISTAdAO = sessionFactory.getCurrentSession().createQuery("from Cliente c Order by c.cliente")
                .list();
        System.out.println("SALIOO   DATO  getClientes  " + LISTAdAO.size());
        return LISTAdAO;
    }

    @Override
    public List<Cliente> getClientesByEstado(Integer estado) {
        return sessionFactory.getCurrentSession().createQuery("from Cliente WHERE estado = " + estado)
                .list();
    }

    @Override
    @Transactional
    public Cliente getClientesById(Integer id) {
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        Cliente cliente = (Cliente) session.createQuery("from Cliente WHERE id=" + id).uniqueResult();
        session.close();
        return cliente != null ? cliente : null;
    }

    @Override
    public List<Cliente> getConProyectos() {
        return sessionFactory.getCurrentSession().createQuery("SELECT c FROM Cliente c WHERE c.id IN ( SELECT p.idCliente from Proyectos p )")
                .list();
    }

}
