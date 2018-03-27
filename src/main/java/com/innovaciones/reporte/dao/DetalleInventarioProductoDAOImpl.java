/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleInventarioProducto;
import com.innovaciones.reporte.util.Enums;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fyaulema
 */
@Repository
public class DetalleInventarioProductoDAOImpl implements DetalleInventarioProductoDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public DetalleInventarioProducto addDetalleInventarioProducto(DetalleInventarioProducto marca) {
        sessionFactory.getCurrentSession().saveOrUpdate(marca);
        return marca;
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioProductos() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m ORDER BY m.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public DetalleInventarioProducto getDetalleInventarioProductoById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        DetalleInventarioProducto result = object != null ? (DetalleInventarioProducto) object : null;
        return result;
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdDetalleInventario(Integer idDetalleInventarioProducto) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m ");
        sbQuery.append("WHERE m.idDetalleInventario.id =:idDetalleInventarioProducto");
        sbQuery.append("ORDER BY m.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idDetalleInventarioProducto", idDetalleInventarioProducto);
        return query.list();
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdDetalleInventario(Integer idDetalleInventarioProducto, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m ");
        sbQuery.append("WHERE m.idDetalleInventario.id =:idDetalleInventarioProducto ");
        sbQuery.append("AND m.estado=:estado");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idDetalleInventarioProducto", idDetalleInventarioProducto);
        query.setParameter("estado", estado);

        return query.list();
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioProductosByEstado(Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m ");
        sbQuery.append("WHERE m.estado=:estado ");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);

        return query.list();
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByProducto(Integer idBodega, Integer idProducto, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m ");
        sbQuery.append("WHERE m.idDetalleInventario.idProducto.id=:idProducto ");
        sbQuery.append("AND  m.estado=:estado ");
        sbQuery.append("AND m.estadoProceso<>:estadoProcesoSolicitado ");
        sbQuery.append("AND  m.estadoProceso <>:estadoProcesoDespachado ");
        if (idBodega != null) {
            sbQuery.append("AND m.idBodega.id= :idBodega ");
        }

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idProducto", idProducto);
        query.setParameter("estado", estado);
        query.setParameter("estadoProcesoSolicitado", Enums.ESTADO_PROCESO_RESERVADO.getValue());
        query.setParameter("estadoProcesoDespachado", Enums.ESTADO_PROCESO_DESPACHADO.getValue());

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        return query.list();
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT dip from CabeceraInventario ci, DetalleInventario di, DetalleInventarioProducto dip ");
        sbQuery.append("WHERE dip.idDetalleInventario.id = di.id AND  ");
        sbQuery.append("di.idCabeceraInventario.id = ci.id AND ");
        sbQuery.append("ci.id=:idCabeceraInventario AND  dip.estado=:estado ");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCabeceraInventario", idCabeceraInventario);
        query.setParameter("estado", estado);
        return query.list();
    }

    @Override
    @Transactional
    public DetalleInventarioProducto getBySerial(String serial) {
        /*  Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();

        List<DetalleInventarioProducto> list = session.createQuery("FROM DetalleInventarioProducto c WHERE c.serial= '" + serial + "'")
                .list();
        session.close();
        DetalleInventarioProducto result = null;
        if (list != null && !list.isEmpty()) {
            result = list.get(0);
        }*/
      
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m WHERE m.serial=:serial");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("serial", serial);
        Object object = query.uniqueResult();
        DetalleInventarioProducto result = object != null ? (DetalleInventarioProducto) object : null;

        return result;
    }

    @Override
    public List<DetalleInventarioProducto> getByIdProductoRepuestoReporte(Integer IdProductoRepuestoReporte) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m FROM DetalleInventarioProducto m  ");
        sbQuery.append("WHERE m.idDetalleInventario.idProducto.id IN  ");
        sbQuery.append("(SELECT pr.idProducto from ProductoRepuestoReporte as pr WHERE pr.id=:id ) AND m.estado=1");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", IdProductoRepuestoReporte);

        return query.list();
    }

    @Override
    public List<DetalleInventarioProducto> getDetalleInventarioByIdBodega(Integer idBodega, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleInventarioProducto m ");
        sbQuery.append("WHERE m.estado=:estado ");
        sbQuery.append("AND m.estadoProceso<>:estadoProcesoSolicitado ");
        sbQuery.append("AND  m.estadoProceso <>:estadoProcesoDespachado ");
        if (idBodega != null) {
            sbQuery.append("AND m.idBodega.id= :idBodega ");
        }

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        query.setParameter("estadoProcesoSolicitado", Enums.ESTADO_PROCESO_RESERVADO.getValue());
        query.setParameter("estadoProcesoDespachado", Enums.ESTADO_PROCESO_DESPACHADO.getValue());

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        return query.list();
    }

}
