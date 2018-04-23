/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ReporteGenericoItems;
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
public class ReporteGenericoItemsDAOImpl extends Utilities implements ReporteGenericoItemsDAO {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public ReporteGenericoItems save(ReporteGenericoItems reporteGenericoItem) {
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String sql = "INSERT INTO reporte_generico_items (id_producto_cliente_reporte,tipo,descripcion,cambiado,solicitar,codigo_repuesto,porcentaje,estado)"
                + " VALUES ( :id_producto_cliente_reporte,:tipo,:descripcion,:cambiado,:solicitar,:codigo_repuesto,:porcentaje,:estado ) ";

        Query query = session.createSQLQuery(sql);
        query.setParameter("id_producto_cliente_reporte", reporteGenericoItem.getIdProductoClienteReporte().getId());
        query.setParameter("tipo", reporteGenericoItem.getTipo());
        query.setParameter("descripcion", reporteGenericoItem.getDescripcion());
        query.setParameter("cambiado", reporteGenericoItem.getCambiado());
        query.setParameter("solicitar", reporteGenericoItem.getSolicitar());
        query.setParameter("codigo_repuesto", reporteGenericoItem.getCodigoRepuesto());
        query.setParameter("porcentaje", reporteGenericoItem.getPorcentaje());
        query.setParameter("estado", reporteGenericoItem.getEstado());

        int rr = query.executeUpdate();
        t.commit();
        session.close();
        return reporteGenericoItem;
    }

    @Override
    public ReporteGenericoItems update(ReporteGenericoItems reporteMantenimiento) {
        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        session.update(reporteMantenimiento);
        session.close();
        return reporteMantenimiento;
    }

    @Override
    public void eliminar(ReporteGenericoItems reporteGenericoItem) {

        String delQuery = "DELETE FROM ReporteGenericoItems AS r WHERE r.id=" + reporteGenericoItem.getId();
        sessionFactory.getCurrentSession().createQuery(delQuery).executeUpdate();
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();

    }

    @Override
    public List<ReporteMantenimiento> getReporteMantenimientoByReporteId(Integer id) {
        return sessionFactory.getCurrentSession().
                createQuery("from ReporteGenericoItems r WHERE r.idProductoClienteReporte.idReporte.id=" + id + "")
                .list();
    }

}
