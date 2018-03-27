/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ProductoModelo;
import com.innovaciones.reporte.util.EstadosEnum;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class ProductoModeloDAOImpl implements ProductoModeloDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public ProductoModelo add(ProductoModelo productoModelo) {
        sessionFactory.getCurrentSession().saveOrUpdate(productoModelo);
        return productoModelo;
    }

    @Override
    public List<ProductoModelo> add(List<ProductoModelo> productoModelos) {
        for (ProductoModelo productoModelo : productoModelos) {

            ProductoModelo busqueda = getByIdProductoByIdModelo(productoModelo.getIdProducto().getId(), productoModelo.getIdModelo().getId());

            if (busqueda == null) {
                add(productoModelo);
            } else {
                if (busqueda.getEstado().equals(EstadosEnum.INACTIVO.getValue())
                        && productoModelo.getEstado().equals(EstadosEnum.ACTIVO.getValue())) {
                    busqueda.setEstado(EstadosEnum.ACTIVO.getValue());
                }
                if (busqueda.getEstado().equals(EstadosEnum.ACTIVO.getValue())
                        && productoModelo.getEstado().equals(EstadosEnum.INACTIVO.getValue())) {
                    busqueda.setEstado(EstadosEnum.ACTIVO.getValue());
                }
                add(productoModelo);
            }
        }
        return productoModelos;
    }

    @Override
    public List<ProductoModelo> getModelosByIdProducto(Integer idProducto) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT p from ProductoModelo p WHERE p.idProducto.id=:idProducto ");
        query.setParameter("idProducto", idProducto);
        return query.list();
    }

    @Override
    public List<ProductoModelo> getModelosByIdProductoEstado(Integer idProducto, Integer estado) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT p from ProductoModelo p WHERE p.idProducto.id=:idProducto AND p.estado=:estado");
        query.setParameter("idProducto", idProducto).setParameter("estado", estado);
        return query.list();
    }

    @Override
    public List<ProductoModelo> getByEstado(Integer estado) {

        Query query = sessionFactory.getCurrentSession().createQuery("from ProductoModelo p WHERE p.estado=:estado ");
        query.setParameter("estado", estado);
        return query.list();

    }

//    @Override
//    public List<ProductoModelo> getAll() {
//        return sessionFactory.getCurrentSession().createQuery("from ProductoModelo")
//                .list();
//    }
//    @Override
//    public ProductoModelo getById(Integer id) {
//        ProductoModelo productoModelo = (ProductoModelo) sessionFactory.getCurrentSession().
//                createQuery("from ProductoModelo WHERE id=" + id).uniqueResult();
//        return productoModelo != null ? productoModelo : null;
//    }
    @Override
    public ProductoModelo getByIdProductoByIdModelo(Integer idProducto, Integer idModelo) {
        ProductoModelo productoModelo = (ProductoModelo) sessionFactory.getCurrentSession().
                createQuery("from ProductoModelo c WHERE c.idProducto.id=" + idProducto + " AND c.idModelo.id=" + idModelo).uniqueResult();
        return productoModelo != null ? productoModelo : null;
    }
}
