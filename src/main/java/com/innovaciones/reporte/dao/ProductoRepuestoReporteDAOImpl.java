/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ProductoRepuestoReporte;
import com.innovaciones.reporte.util.EstadosEnum;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fyaulema
 */
@Repository
public class ProductoRepuestoReporteDAOImpl implements ProductoRepuestoReporteDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public ProductoRepuestoReporte add(ProductoRepuestoReporte productoModelo) {
        sessionFactory.getCurrentSession().saveOrUpdate(productoModelo);
        return productoModelo;
    }

    @Override
    public List<ProductoRepuestoReporte> getAll() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from ProductoRepuestoReporte p ORDER BY p.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        return query.list();

    }

    @Override
    public ProductoRepuestoReporte getById(Integer id) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("p from ProductoRepuestoReporte p WHERE p.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        ProductoRepuestoReporte result = object != null ? (ProductoRepuestoReporte) object : null;
        return result;
    }

    @Override
    public List<ProductoRepuestoReporte> getProductosRepuestoByIdProducto(Integer idProducto) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from ProductoRepuestoReporte p WHERE p.idProducto.id =:idProducto ORDER BY p.idProducto.id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);
        return query.list();
    }

    @Override
    public List<ProductoRepuestoReporte> getProductosRepuestoByIdProductoEstado(Integer idProducto, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from ProductoRepuestoReporte p WHERE ");
        sbQuery.append("p.idProducto.id =:idProducto AND p.estado =:estado ORDER BY p.idProducto.id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);
        query.setParameter("estado", estado.equals(EstadosEnum.ACTIVO.getValue()) ? Boolean.TRUE : Boolean.FALSE);
        return query.list();
    }

    @Override
    public List<ProductoRepuestoReporte> getByEstado(boolean estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from ProductoRepuestoReporte p WHERE p.estado=:estado");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();
    }

    @Override
    public ProductoRepuestoReporte getByIdProductoByIdRepuesto(Integer idProducto, Integer idRepuesto) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from ProductoRepuestoReporte p ");
        sbQuery.append("WHERE p.idProducto.id=:idProducto AND p.idDetalleCatalogoReporte.id=:idRepuesto");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);
        query.setParameter("idRepuesto", idRepuesto);
        Object object = query.uniqueResult();
        ProductoRepuestoReporte result = object != null ? (ProductoRepuestoReporte) object : null;
        return result;
    }

    @Override
    @Transactional
    public List<ProductoRepuestoReporte> getByIdDetalleCatalogoReporteByIdModelo(Integer id, Integer idModelo) {
        return sessionFactory.getCurrentSession().createQuery("SELECT p FROM ProductoRepuestoReporte p WHERE p.idProducto.id IN ( SELECT pm.idProducto.id FROM ProductoModelo AS pm WHERE pm.idModelo.id=  " + idModelo + "   ) AND p.idDetalleCatalogoReporte.id=" + id)
                .list();
    }

    @Override
    public List<ProductoRepuestoReporte> getOtrosByModeloByIdDetalleCatalogoByEstado(Integer idModelo, Integer estado) {

        System.out.println("    id modelo " + idModelo);

        return sessionFactory.getCurrentSession().createQuery("from ProductoRepuestoReporte p WHERE "
                + "p.idProducto.idCategoria.nombre='REPUESTOS' AND p.idProducto.idModelo.id=" + idModelo + " AND p.estado=" + estado)
                .list();
    }

    @Override
    public ProductoRepuestoReporte getProductoRepuestoByIdProducto(Integer idProducto) {
        ProductoRepuestoReporte result = null;

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from ProductoRepuestoReporte p ");
        sbQuery.append("WHERE p.idProducto.id=:idProducto");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);
        List<ProductoRepuestoReporte> list = query.list();

        if (!list.isEmpty()) {
            result = list.get(0);
        }

        return result;
    }

}
