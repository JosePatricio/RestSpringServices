/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.ProductoDTO;
import com.innovaciones.reporte.model.Proveedor;
import static com.innovaciones.reporte.util.Utilities.convertirToDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class ProveedorDAOImpl implements ProveedorDAO, Serializable {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Proveedor addProveedor(Proveedor proveedor) {
        sessionFactory.getCurrentSession().saveOrUpdate(proveedor);
        return proveedor;
    }

    @Override
    public List<Proveedor> getProveedores() {
        return sessionFactory.getCurrentSession().createQuery("from Proveedor p ORDER BY p.estado desc, p.nombre")
                .list();
    }

    @Override
    public Proveedor getProveedorById(Integer id) {
        Proveedor proveedor = (Proveedor) sessionFactory.getCurrentSession().createQuery("from p Proveedor WHERE p.id=" + id + "").uniqueResult();
        return proveedor != null ? proveedor : null;
    }

    @Override
    public List<Proveedor> getProveedoresByEstado(Integer estado) {

        return sessionFactory.getCurrentSession().createQuery("from Proveedor p WHERE p.estado =" + estado + " ORDER BY p.nombre").
                list();
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) {
        sessionFactory.getCurrentSession().save(proveedor);
        return proveedor;
    }

    @Override
    public List<String> getCiudadesProveedores() {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT UPPER(p.ciudad) ");
        sbQuery.append("FROM proveedor p ");
        sbQuery.append("GROUP BY p.ciudad ");
        sbQuery.append("ORDER BY p.ciudad ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());

        List<Object[]> resultObject = (List<Object[]>) query.list();

        List<String> result = new ArrayList<>();

        for (Object object : resultObject) {

            String ciudad = object != null ? object.toString() : "";            
            result.add(ciudad);
        }

        return result;
    }

    @Override
    public List<String> getBancosProveedores() {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT UPPER(p.banco_deposito) ");
        sbQuery.append("FROM proveedor p ");
        sbQuery.append("GROUP BY p.banco_deposito ");
        sbQuery.append("ORDER BY p.banco_deposito ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());

        List<Object[]> resultObject = (List<Object[]>) query.list();

        List<String> result = new ArrayList<>();

        for (Object object : resultObject) {

            String banco = object != null ? object.toString() : "";            
            result.add(banco);
        }

        return result;
    }

}
