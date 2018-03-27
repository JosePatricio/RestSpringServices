/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.util.Enums;
import java.io.Serializable;
import java.util.List;
import lombok.Setter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class DetalleCatalogoReporteDAOImpl implements DetalleCatalogoReporteDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<DetalleCatalogoReporte> getDetalleCatalogoReporteByCabeceraCodigo(String codigo) {
        return sessionFactory.getCurrentSession().
                createQuery("from DetalleCatalogoReporte d WHERE d.idCabecera.codigo='" + codigo + "' ORDER BY orden")
                .list();
    }

    @Override
    @Transactional
    public List<DetalleCatalogoReporte> getDetalleCatalogoReporte() {
        return sessionFactory.getCurrentSession().createQuery("from DetalleCatalogoReporte d ORDER BY d.idCabecera.tipo,d.orden")
                .list();
    }

    @Override
    @Transactional
    public List<DetalleCatalogoReporte> getDetalleCatalogoReporteByEstado(Integer estado) {
        return sessionFactory.getCurrentSession().createQuery("from DetalleCatalogoReporte d WHERE d.estado=" + estado + " ORDER BY orden")
                .list();
    }

    @Override
    @Transactional
    public DetalleCatalogoReporte addDetalleCatalogoReporte(DetalleCatalogoReporte detalleCatalogoReporte) {
        sessionFactory.getCurrentSession().saveOrUpdate(detalleCatalogoReporte);
        return detalleCatalogoReporte;
    }

    @Override
    @Transactional
    public DetalleCatalogoReporte update(DetalleCatalogoReporte detalleCatalogoReporte) {
        sessionFactory.getCurrentSession().update(detalleCatalogoReporte);
        return detalleCatalogoReporte;
    }

    @Override
    @Transactional
    public void removeDetalleCatalogoReporte(DetalleCatalogoReporte detalleCatalogoReporte) {
        sessionFactory.getCurrentSession().delete(detalleCatalogoReporte);
    }

    @Override
    @Transactional
    public List<DetalleCatalogoReporte> getDetalleCatalogoReporteByIdCabeceraByDescripcion(Integer idCabecera, String descripcion) {
        return sessionFactory.getCurrentSession().createQuery("from DetalleCatalogoReporte d WHERE d.idCabecera.id=" + idCabecera + " AND d.descripcion='" + descripcion + "'")
                .list();
    }

    @Override
    @Transactional
    public DetalleCatalogoReporte getDetalleCatalogoReporteById(Integer id) {
        DetalleCatalogoReporte detalleCatalogoReporte = (DetalleCatalogoReporte) sessionFactory.getCurrentSession().createQuery("from DetalleCatalogoReporte d WHERE d.id=" + id).uniqueResult();
        return detalleCatalogoReporte != null ? detalleCatalogoReporte : null;
    }

    @Override
    @Transactional
    public DetalleCatalogoReporte getDetalleCatalogoReporteByDescripcionByIdCabecera(String descripcion, Integer idCabecera) {
        DetalleCatalogoReporte detalleCatalogoReporte = (DetalleCatalogoReporte) sessionFactory.getCurrentSession().createQuery("from DetalleCatalogoReporte d WHERE d.descripcion='" + descripcion + "' AND d.idCabecera.id=" + idCabecera).uniqueResult();
        return detalleCatalogoReporte != null ? detalleCatalogoReporte : null;
    }

    @Override
    @Transactional
    public List<DetalleCatalogoReporte> getDetalleCatalogoReporteByIdCategoria(Integer idCategoria, Integer estado) {

        Boolean estadoBooleano = estado == 1;

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT d from DetalleCatalogoReporte d, CabeceraCatalogoReporte c ");
        sbQuery.append("WHERE d.idCabecera.id =c.id ");
        sbQuery.append(" AND c.idCategoria =:idCategoria ");
        sbQuery.append(" AND c.tipo like :tipo ");
        sbQuery.append(" AND c.estado=:estado ");
        sbQuery.append(" AND d.estado=:estado ");
        sbQuery.append("ORDER BY d.descripcion");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idCategoria", idCategoria);
        query.setParameter("tipo", "%" + Enums.CORRECTIVO.getValue() + "%");
        query.setParameter("estado", estadoBooleano);
        return query.list();
    }

    @Override
    @Transactional
    public DetalleCatalogoReporte getDetalleCatalogoReporteByDescripcionByIdCategoria(String descripcion, Integer idCategoria) {
        String sql = "from DetalleCatalogoReporte d WHERE d.descripcion='" + descripcion + "' AND d.idCabecera.idCategoria=" + idCategoria;
//        System.out.println("getDetalleCatalogoReporteByDescripcionByIdCategoria(): " + sql);
        DetalleCatalogoReporte detalleCatalogoReporte = (DetalleCatalogoReporte) sessionFactory.getCurrentSession().createQuery("from DetalleCatalogoReporte d WHERE d.descripcion='"
                + descripcion
                + "' AND d.idCabecera.idCategoria="
                + idCategoria
                + " AND d.idCabecera.tipo like '%CORRECTIVO%'").uniqueResult();
        return detalleCatalogoReporte != null ? detalleCatalogoReporte : null;
    }

}
