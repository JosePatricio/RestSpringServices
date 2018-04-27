/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ProductoClienteReporte;
import java.io.Serializable;
import java.math.BigInteger;
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
public class ProductoClienteReporteDAOImpl implements ProductoClienteReporteDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    public ProductoClienteReporte saveOrUpdateProductoClienteReporte(ProductoClienteReporte productoClienteReporte) {
        sessionFactory.getCurrentSession().saveOrUpdate(productoClienteReporte);
        return productoClienteReporte;
    }

    @Override
    @Transactional
    public ProductoClienteReporte save(ProductoClienteReporte productoClienteReporte) {

        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "INSERT INTO producto_cliente_reporte (serie,atencion,departamento,ciudad,ip_equipo,puerto_usb,id_cliente_sucursal,id_producto,id_proyecto,id_reporte,correo_atencion,id_cliente,id_producto_detalle_reporte)"
                + " VALUES (:serie,:atencion,:departamento,:ciudad,:ipEquipo,:puertoUsb,:idClienteSucursal,:idProducto,:idProyecto,:idReporte,:correoAtencion,:idCliente ,:idProductoDetalleReporte  )";

        Query query = session.createSQLQuery(hql);
        query.setParameter("serie", productoClienteReporte.getSerie());
        query.setParameter("atencion", productoClienteReporte.getAtencion());
        query.setParameter("departamento", productoClienteReporte.getDepartamento());
        query.setParameter("ciudad", productoClienteReporte.getCiudad());
        query.setParameter("ipEquipo", productoClienteReporte.getIpEquipo());
        query.setParameter("puertoUsb", productoClienteReporte.getPuertoUsb());
        query.setParameter("idClienteSucursal", productoClienteReporte.getIdClienteSucursal().getId());
        query.setParameter("idProducto", productoClienteReporte.getIdProducto().getId());
        query.setParameter("idProyecto", productoClienteReporte.getIdProyecto().getId());
        query.setParameter("idReporte", productoClienteReporte.getIdReporte().getId());
        query.setParameter("correoAtencion", productoClienteReporte.getCorreoAtencion());
        query.setParameter("idCliente", productoClienteReporte.getIdCliente().getId());
        query.setParameter("idProductoDetalleReporte", productoClienteReporte.getIdProductoDetalleReporte());

        int rr = query.executeUpdate();
        BigInteger result = (BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()")
                .uniqueResult();
        System.out.println("UID ES " + result);
        ProductoClienteReporte clienteReporte = new ProductoClienteReporte();
        clienteReporte = productoClienteReporte;
        clienteReporte.setId(result.intValue());
        t.commit();
        return clienteReporte;
    }

    /*
    
    
     */
    @Override
    public ProductoClienteReporte update(ProductoClienteReporte productoClienteReporte) {

        Session session = sessionFactory.getCurrentSession().getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "update ProductoClienteReporte set serie=:serie ,atencion=:atencion , departamento=:departamento , ciudad=:ciudad , ipEquipo=:ipEquipo"
                + " , puertoUsb=:puertoUsb , idClienteSucursal.id=:idClienteSucursal , idProducto.id=:idProducto , idProyecto.id=:idProyecto, correoAtencion=:correoAtencion where id=:id";

        Query query = session.createQuery(hql);
        query.setParameter("serie", productoClienteReporte.getSerie());
        query.setParameter("atencion", productoClienteReporte.getAtencion());
        query.setParameter("departamento", productoClienteReporte.getDepartamento());
        query.setParameter("ciudad", productoClienteReporte.getCiudad());
        query.setParameter("ipEquipo", productoClienteReporte.getIpEquipo());
        query.setParameter("puertoUsb", productoClienteReporte.getPuertoUsb());
        query.setParameter("idClienteSucursal", productoClienteReporte.getIdClienteSucursal().getId());
        query.setParameter("idProducto", productoClienteReporte.getIdProducto().getId());
        query.setParameter("idProyecto", productoClienteReporte.getIdProyecto().getId());
        query.setParameter("correoAtencion", productoClienteReporte.getCorreoAtencion());
        query.setParameter("id", productoClienteReporte.getId());

        int rr = query.executeUpdate();

        t.commit();
        session.close();

        return productoClienteReporte;
    }

    @Override
    public ProductoClienteReporte getByReportId(Integer ID) {
        ProductoClienteReporte productoClienteReporte
                = (ProductoClienteReporte) sessionFactory.getCurrentSession().
                        createQuery("from ProductoClienteReporte pcr WHERE pcr.idReporte.id=" + ID + "")
                        .uniqueResult();

        return productoClienteReporte != null ? productoClienteReporte : null;
    }

    @Override
    public ProductoClienteReporte getByUsuarioRuc(String ruc) {

        ProductoClienteReporte productoClienteReporte
                = (ProductoClienteReporte) sessionFactory.getCurrentSession().
                        createQuery("from ProductoClienteReporte p WHERE p.idProductoCliente.idCliente.ruc='" + ruc + "'")
                        .uniqueResult();

        return productoClienteReporte != null ? productoClienteReporte : null;
    }

    @Override
    public List<ProductoClienteReporte> getBySerial(String serial) {

        return sessionFactory.getCurrentSession().
                createQuery("from ProductoClienteReporte p WHERE p.serie='" + serial + "' ORDER BY p.idReporte.fechaCreacion DESC")
                .list();
    }

    @Override
    public ProductoClienteReporte getByIdProductoCliente(Integer idProductoCliente) {
        ProductoClienteReporte productoClienteReporte
                = (ProductoClienteReporte) sessionFactory.getCurrentSession().
                        createQuery("from ProductoClienteReporte p WHERE p.idProductoCliente.id=" + idProductoCliente + "")
                        .uniqueResult();

        return productoClienteReporte != null ? productoClienteReporte : null;
    }

    @Override
    public List<ProductoClienteReporte> getByTipoReporte(String tipo) {

        return sessionFactory.getCurrentSession().
                createQuery("from ProductoClienteReporte p WHERE p.idReporte.tipo='" + tipo + "' ORDER BY p.idReporte.fechaCreacion DESC")
                .list();
    }

}
