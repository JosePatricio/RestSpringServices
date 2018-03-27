/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ReporteMantenimiento;
import com.innovaciones.reporte.util.Utilities;
import java.util.List;
import lombok.Setter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class ReporteMantenimientoDAOImpl extends Utilities implements ReporteMantenimientoDAO {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public ReporteMantenimiento save(ReporteMantenimiento reporteMantenimiento) {
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "INSERT INTO reporte_mantenimiento (codigo_repuesto,tipo_repuesto,porcentaje,estado,id_producto_cliente_reporte,id_producto_repuesto_reporte,id_detalle_catalogo_reporte)"
                + " VALUES (:codigoRepuesto,:tipoRepuesto,:porcentaje,:estado,:id_producto_cliente_reporte,:id_producto_repuesto_reporte,:id_detalle_catalogo_reporte) ";

        Query query = session.createSQLQuery(hql);
        query.setParameter("codigoRepuesto", reporteMantenimiento.getCodigoRepuesto());
        query.setParameter("tipoRepuesto", reporteMantenimiento.getTipoRepuesto());
        query.setParameter("porcentaje", reporteMantenimiento.getPorcentaje());
        query.setParameter("estado", reporteMantenimiento.getEstado());
        query.setParameter("id_producto_cliente_reporte", reporteMantenimiento.getIdProductoClienteReporte().getId());
        query.setParameter("id_producto_repuesto_reporte", reporteMantenimiento.getIdProductoRepuestoReporte().getId());
        query.setParameter("id_detalle_catalogo_reporte", reporteMantenimiento.getIdDetalleCatalogoReporte().getId());

        int rr = query.executeUpdate();
        t.commit();
        session.close();
        return reporteMantenimiento;
    }

    @Override
    public ReporteMantenimiento update(ReporteMantenimiento reporteMantenimiento) {
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        session.update(reporteMantenimiento);
        session.close();
        return reporteMantenimiento;
    }

    @Override
    public void eliminar(ReporteMantenimiento reporteMantenimiento) {

        String delQuery = "DELETE FROM ReporteMantenimiento AS r WHERE r.id=" + reporteMantenimiento.getId();
        sessionFactory.getCurrentSession().createQuery(delQuery).executeUpdate();
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();

    }

    @Override
    public List<ReporteMantenimiento> getReporteMantenimientoByReporteId(Integer id) {
        return sessionFactory.getCurrentSession().
                createQuery("from ReporteMantenimiento r WHERE r.idProductoClienteReporte.idReporte.id=" + id + "")
                .list();
    }

    @Override
    public void removeReporteMantenimiento(ReporteMantenimiento reporteMantenimiento) {
        sessionFactory.getCurrentSession().delete(reporteMantenimiento);
    }

    @Override
    public List<ReporteMantenimiento> getReporteMantenimientoByDetalleCatalogoId(Integer id) {
        return sessionFactory.getCurrentSession().
                createQuery("from ReporteMantenimiento r WHERE r.idDetalleCatalogoReporte.id=" + id + "")
                .list();
    }

}
