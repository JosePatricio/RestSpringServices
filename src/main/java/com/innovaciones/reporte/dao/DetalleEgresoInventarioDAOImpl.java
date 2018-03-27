/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleEgresoInventario;
import com.innovaciones.reporte.util.Enums;
import com.innovaciones.reporte.util.EstadosEnum;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fyaulema
 */
@Repository
public class DetalleEgresoInventarioDAOImpl implements DetalleEgresoInventarioDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public DetalleEgresoInventario addDetalleEgresoInventario(DetalleEgresoInventario detalleEgresoInventario) {
        sessionFactory.getCurrentSession().saveOrUpdate(detalleEgresoInventario);
        return detalleEgresoInventario;
    }

    @Override
    public List<DetalleEgresoInventario> getDetalleEgresoInventarios() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleEgresoInventario m ORDER BY m.estado DESC");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        return query.list();
    }

    @Override
    public DetalleEgresoInventario getDetalleEgresoInventarioById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleEgresoInventario m WHERE m.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        DetalleEgresoInventario result = object != null ? (DetalleEgresoInventario) object : null;
        return result;
    }

    @Override
    public DetalleEgresoInventario getDetalleEgresoInventarioByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleEgresoInventario m WHERE m.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        DetalleEgresoInventario result = object != null ? (DetalleEgresoInventario) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DetalleEgresoInventario> getDetalleEgresoInventariosByEstado(Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleEgresoInventario m WHERE m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public List<DetalleEgresoInventario> getDetalleEgresoInventarioByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT m from DetalleEgresoInventario m, DetalleEgreso d ");
        sbQuery.append("WHERE m.idDetalleEgreso.id = d.id ");
        sbQuery.append("AND m.idDetalleEgreso.idCabeceraEgreso.id=:idCabeceraEgreso AND m.estado=:estado ");
        sbQuery.append("ORDER BY m.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCabeceraEgreso", idCabeceraEgreso);
        query.setParameter("estado", estado);
        return query.list();
    }

    @Override
    public List<DetalleEgresoInventario> getDetalleEgresosInventarioByIdClienteSucursal(Integer idClienteSucursal) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT dei from ClienteSucursal cs, CabeceraEgreso ce, ");
        sbQuery.append("DetalleEgreso de, DetalleEgresoInventario dei, Producto p ");
        sbQuery.append("WHERE cs.id = ce.idClienteSucursal.id AND ");
        sbQuery.append("ce.id = de.idCabeceraEgreso.id  AND ");
        sbQuery.append("de.id = dei.idDetalleEgreso.id  AND ");
        sbQuery.append("de.idProducto.id = p.id  AND ");
        sbQuery.append("p.idTipoProducto.nombre =:tipoProducto AND ");
        sbQuery.append("cs.id =:idClienteSucursal AND dei.estado =:estado AND ");
        sbQuery.append("dei.estadoProceso <>:estadoProceso ");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idClienteSucursal", idClienteSucursal);
        query.setParameter("tipoProducto", Enums.TIPO_PRODUCTO_EQUIPO.getValue());
        query.setParameter("estado", EstadosEnum.ACTIVO.getValue());
        query.setParameter("estadoProceso", Enums.ESTADO_PROCESO_DEVUELTO.getValue());
        return query.list();
    }
}
