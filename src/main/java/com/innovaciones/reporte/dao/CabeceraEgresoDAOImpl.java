/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.CabeceraEgreso;
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
public class CabeceraEgresoDAOImpl implements CabeceraEgresoDAO, Serializable {

    private SessionFactory sessionFactory;

    @Override
    public CabeceraEgreso addCabeceraEgreso(CabeceraEgreso cabeceraEgreso) {
        sessionFactory.getCurrentSession().saveOrUpdate(cabeceraEgreso);
        return cabeceraEgreso;
    }

    @Override
    public List<CabeceraEgreso> getCabeceraEgresos(Integer idBodega, String pagina) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c FROM CabeceraEgreso c ");

        System.out.println("DAO.getCabeceraEgresos(): " + pagina);

        if (pagina.trim().equalsIgnoreCase(Enums.TIPO_DEVOLUCION_BODEGA.getValue())) {
            sbQuery.append("WHERE (c.estadoProceso  =:despachado OR c.estadoProceso=:reservado OR c.estadoProceso=:devuelto ) ");
        } else {
            sbQuery.append("WHERE c.pagina like :pagina AND estadoProceso <>:estadoDevuelto  ");
        }

        if (idBodega != null) {
            sbQuery.append("AND c.idBodega.id =:idBodega ");
        }

        sbQuery.append("ORDER BY c.estado DESC, c.fechaRegistro DESC, c.horaRegistro DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        if (pagina.equals(Enums.TIPO_DEVOLUCION_BODEGA.getValue())) {
            query.setParameter("despachado", Enums.ESTADO_PROCESO_DESPACHADO.getValue());
            query.setParameter("reservado", Enums.ESTADO_PROCESO_RESERVADO.getValue());
            query.setParameter("devuelto", Enums.ESTADO_PROCESO_DEVUELTO.getValue());
        } else {
            query.setParameter("pagina", "%" + pagina + "%");
            query.setParameter("estadoDevuelto", Enums.ESTADO_PROCESO_DEVUELTO.getValue());
        }

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        System.out.println("getCabeceraEgresos(): " + sbQuery.toString());

        return query.list();
    }

    @Override
    public CabeceraEgreso getCabeceraEgresoById(Integer id) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c FROM CabeceraEgreso c WHERE c.id=:id");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("id", id);
        Object object = query.uniqueResult();
        CabeceraEgreso result = object != null ? (CabeceraEgreso) object : null;
        return result;
    }

    @Override
    public CabeceraEgreso getCabeceraEgresoByCodigo(String codigo) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c FROM CabeceraEgreso c WHERE c.codigo=:codigo");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("codigo", codigo);
        Object object = query.uniqueResult();
        CabeceraEgreso result = object != null ? (CabeceraEgreso) object : null;
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CabeceraEgreso> getCabeceraEgresosByEstado(String pagina, Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT c FROM CabeceraEgreso c ");
        sbQuery.append("WHERE c.estado=:estado AND c.pagina=:pagina ");
        sbQuery.append("ORDER BY c.estado DESC");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("pagina", pagina);
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public Integer getCountEgresos(String pagina) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT count(c.id) ");
        sbQuery.append("FROM CabeceraEgreso c ");
        sbQuery.append("WHERE c.pagina=:pagina ");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("pagina", pagina);
        Object object = query.uniqueResult();
        Integer result = object != null ? Integer.parseInt(object.toString()) : 0;
        return result;
    }

    @Override
    public CabeceraEgreso actualizarStockSolicitado(Integer idCabeceraEgreso) {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append(" UPDATE cabecera_egreso ");
        sbQuery.append(" SET total_solicitado = ( SELECT SUM(de.cantidad) ");
        sbQuery.append(" FROM detalle_egreso de ");
        sbQuery.append(" WHERE de.estado = ");
        sbQuery.append(EstadosEnum.ACTIVO.getValue().toString());
        sbQuery.append(" AND de.id_cabecera_egreso =");
        sbQuery.append(idCabeceraEgreso.toString());
        sbQuery.append(") WHERE id = ");
        sbQuery.append(idCabeceraEgreso.toString());
        sbQuery.append(";");
        System.out.println("actualizarStockSolicitado(): " + sbQuery.toString());

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
        query.executeUpdate();
        return getCabeceraEgresoById(idCabeceraEgreso);
    }

    @Override
    public CabeceraEgreso actualizarStockEgresado(Integer idCabeceraEgreso) {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append(" UPDATE cabecera_egreso ceu SET total_egreso= ");
        sbQuery.append(" (SELECT COUNT(dei.id) ");
        sbQuery.append(" FROM detalle_egreso de ");
        sbQuery.append(" INNER JOIN detalle_egreso_inventario dei ON de.id = dei.id_detalle_egreso ");        
        sbQuery.append(" WHERE dei.estado_proceso <> '");
        sbQuery.append(Enums.ESTADO_PROCESO_DEVUELTO.getValue());
        sbQuery.append("' AND dei.estado = ");
        sbQuery.append(EstadosEnum.ACTIVO.getValue().toString());
        sbQuery.append(" AND de.id_cabecera_egreso =	");
        sbQuery.append(idCabeceraEgreso.toString());
        sbQuery.append(" ) WHERE ceu.id =");
        sbQuery.append(idCabeceraEgreso.toString());
        sbQuery.append(";");

        System.out.println("actualizarStockSolicitadoEgresado(): " + sbQuery.toString());

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());

        query.executeUpdate();
        return getCabeceraEgresoById(idCabeceraEgreso);
    }

    @Override
    public CabeceraEgreso actualizarStockDevuelto(Integer idCabeceraEgreso) {

        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append(" UPDATE cabecera_egreso ceu SET total_devolucion= ");
        sbQuery.append(" (SELECT COUNT(dei.id) ");
        sbQuery.append(" FROM detalle_egreso de ");
        sbQuery.append(" INNER JOIN detalle_egreso_inventario dei ON de.id = dei.id_detalle_egreso ");        
        sbQuery.append(" WHERE dei.estado_proceso = '");
        sbQuery.append(Enums.ESTADO_PROCESO_DEVUELTO.getValue());
        sbQuery.append("' AND dei.estado = ");
        sbQuery.append(EstadosEnum.ACTIVO.getValue().toString());
        sbQuery.append(" AND de.id_cabecera_egreso =	");
        sbQuery.append(idCabeceraEgreso.toString());
        sbQuery.append(" ) WHERE ceu.id =");
        sbQuery.append(idCabeceraEgreso.toString());
        sbQuery.append(";");

        System.out.println("actualizarStockDevuelto(): " + sbQuery.toString());

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());

        query.executeUpdate();
        return getCabeceraEgresoById(idCabeceraEgreso);
    }

    @Override
    public CabeceraEgreso actualizarStockSolicitadoEgresado(Integer idCabeceraEgreso) {

        actualizarStockSolicitado(idCabeceraEgreso);
        CabeceraEgreso stockEgresado = actualizarStockEgresado(idCabeceraEgreso);

        return stockEgresado;
    }

}
