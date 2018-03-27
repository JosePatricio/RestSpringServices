/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ClienteSucursal;
import com.innovaciones.reporte.util.EstadosEnum;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernando
 */
@Repository
public class ClienteSucursalDAOImpl implements ClienteSucursalDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public ClienteSucursal saveOrUpdate(ClienteSucursal clienteSucursal) {
        sessionFactory.getCurrentSession().saveOrUpdate(clienteSucursal);
        return clienteSucursal;
    }

    @Override
    @Transactional
    public List<ClienteSucursal> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from ClienteSucursal c ORDER BY c.nombre")
                .list();
    }

    @Override
    @Transactional
    public ClienteSucursal getById(Integer id) {
        ClienteSucursal cliente = (ClienteSucursal) sessionFactory.getCurrentSession().createQuery("from ClienteSucursal WHERE id=" + id).uniqueResult();
        return cliente != null ? cliente : null;
    }

    @Override
    @Transactional
    public List<ClienteSucursal> getByIdCliente(Integer idCliente) {
        return sessionFactory.getCurrentSession().createQuery("from ClienteSucursal c where c.idCliente.id =" + idCliente + " AND c.estado= " + EstadosEnum.ACTIVO.getValue() + " ORDER BY c.nombre")
                .list();
    }

    @Override
    @Transactional
    public List<ClienteSucursal> getByEstado(Integer estado) {
        return sessionFactory.getCurrentSession().createQuery("from ClienteSucursal c WHERE c.estado =" + estado + " ORDER by c.nombre").
                list();
    }

    @Override
    @Transactional
    public ClienteSucursal getByNombre(String nombre) {

        List<ClienteSucursal> list = sessionFactory.getCurrentSession().createQuery("from ClienteSucursal c WHERE c.nombre='" + nombre + "'").
                list();

        ClienteSucursal clienteSucursal = !list.isEmpty() ? list.get(0) : null;
        return clienteSucursal;
    }

}
