/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.NotificacionDTO;
import com.innovaciones.reporte.model.DTO.ReportesDTO;
import com.innovaciones.reporte.util.AsignacionReparacionEnum;
import com.innovaciones.reporte.util.Enums;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fyaulema
 */
@Repository
public class NotificacionDAOImp implements NotificacionDAO, Serializable {

    private SessionFactory sessionFactory;

    private List<NotificacionDTO> createNotificaciones(List<Object[]> resultObject) {
        List<NotificacionDTO> result = new ArrayList<>();

        Integer count = 1;
        for (Object[] object : resultObject) {

            NotificacionDTO notificacionDTO = new NotificacionDTO();

            notificacionDTO.setCount(count++);
            notificacionDTO.setId(Integer.parseInt(object[0].toString()));
            notificacionDTO.setFechaInicio(object[1] != null ? object[1].toString() : "");
            notificacionDTO.setHoraInicio(object[2] != null ? object[2].toString() : "");
            notificacionDTO.setFechaFin(object[3] != null ? object[3].toString() : "");
            notificacionDTO.setHoraFin(object[4] != null ? object[4].toString() : "");
            notificacionDTO.setTecnico(object[5] != null ? object[5].toString() : "");
            notificacionDTO.setCliente(object[6] != null ? object[6].toString() : "");
            notificacionDTO.setTipoReporte(object[7] != null ? object[7].toString() : "");
            notificacionDTO.setEstadoNotificacion(object[8] != null ? object[8].toString() : "");
            notificacionDTO.setPrioridad(object[9] != null ? Integer.parseInt(object[9].toString()) : AsignacionReparacionEnum.PRIORIDAD_DEFAULT.getValue());
            notificacionDTO.setTipoNotificacion(object[10] != null ? object[10].toString() : "");
            notificacionDTO.setIdCliente(object[11] != null ? Integer.parseInt(object[11].toString()) : 0);
            notificacionDTO.setIdClienteProducto(object[12] != null ? Integer.parseInt(object[12].toString()) : 0);
            notificacionDTO.setIdTecnico(object[13] != null ? Integer.parseInt(object[13].toString()) : 0);
            notificacionDTO.setIdReporte(object[14] != null ? Integer.parseInt(object[14].toString()) : null);
            notificacionDTO.setTipoEquipo(object[15] != null ? object[15].toString() : null);
            notificacionDTO.setIdClienteSucursal(object[16] != null ? Integer.parseInt(object[16].toString()) : 0);
            notificacionDTO.setNombreSucursal(object[17] != null ? object[17].toString() : null);
            notificacionDTO.setDireccionSucursal(object[18] != null ? object[18].toString() : null);
            notificacionDTO.setNombreContacto(object[19] != null ? object[19].toString() : null);
            notificacionDTO.setCelularContacto(object[20] != null ? object[20].toString() : null);
            notificacionDTO.setIdTipoVisita(object[21] != null ? Integer.parseInt(object[21].toString()) : 0);
            notificacionDTO.setTipoVisita(object[22] != null ? object[22].toString() : null);

            result.add(notificacionDTO);
        }
        return result;
    }

    public NotificacionDTO getNotificacionById(int id) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT  ar.id, DATE_FORMAT(fecha_inicio_atencion ,'%d-%m-%Y') AS fecha_inicio, DATE_FORMAT(ar.hora_inicio_atencion ,'%H:%i') AS hora_inicio,  "
                        + "DATE_FORMAT(ar.fecha_fin_atencion ,'%d-%m-%Y') fecha_fin, DATE_FORMAT(ar.hora_fin_atencion,'%H:%i') hora_fin,  "
                        + "concat(u.nombre,' ', u.apellido) AS tecnico, c.cliente, ar.tipo_reporte AS tipo_reporte,  "
                        + "ar.estado AS estado_notificacion, ar.prioridad, ar.tipo_notificacion tipo, c.id AS id_cliente, "
                        + "ar.producto AS id_producto, ar.id_usuario_atencion AS id_tecnico,ar.id_reporte, ar.tipo_equipo, "
                        + "cs.id id_sucursal, cs.nombre sucursal, cs.direccion ,cs.nombre_contacto, cs.celular_contacto, "
                        + "v.id id_visita, v.descripcion tipo_visita "
                        + "FROM asignacion_reparacion ar  "
                        + "INNER JOIN usuarios u ON ar.id_usuario_atencion = u.id "
//                        + "INNER JOIN producto_cliente pc on ar.id_producto_cliente = pc.id "
                        + "INNER JOIN cliente_sucursal cs ON cs.id = ar.id_cliente_sucursal "
                        + "INNER JOIN cliente c ON c.id = cs.id_cliente "
                        + "INNER JOIN tipo_visita v ON v.id = ar.id_tipo_visita "
                        + "WHERE ar.id = :id "
                        + "ORDER BY substring(cast(fecha_inicio AS NCHAR(10)),7,10) DESC,"
                        + "substring(cast(fecha_inicio AS NCHAR(10)),4,2) DESC,"
                        + "substring(cast(fecha_inicio AS NCHAR(10)),1,2) DESC,"
                        + "ar.prioridad DESC"
        );
        query.setParameter("id", id);
        List<Object[]> resultObject = (List<Object[]>) query.list();
        return createNotificaciones(resultObject).get(0);
    }

    @Override
    public List<NotificacionDTO> getNotificacionesByEstadoReporte(boolean preasignacion) {

        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT  ar.id, DATE_FORMAT(fecha_inicio_atencion ,'%d-%m-%Y') AS fecha_inicio, DATE_FORMAT(ar.hora_inicio_atencion ,'%H:%i') AS hora_inicio,  "
                        + "DATE_FORMAT(ar.fecha_fin_atencion ,'%d-%m-%Y') fecha_fin, DATE_FORMAT(ar.hora_fin_atencion,'%H:%i') hora_fin,  "
                        + "concat(u.nombre,' ', u.apellido) AS tecnico, c.cliente, ar.tipo_reporte AS tipo_reporte,  "
                        + "ar.estado AS estado_notificacion, ar.prioridad, ar.tipo_notificacion tipo, c.id AS id_cliente, "
                        + "ar.producto AS id_producto, ar.id_usuario_atencion AS id_tecnico,ar.id_reporte, ar.tipo_equipo, "
                        + "cs.id id_sucursal, cs.nombre sucursal, cs.direccion ,cs.nombre_contacto, cs.celular_contacto, "
                        + "v.id id_visita, v.descripcion tipo_visita "
                        + "FROM asignacion_reparacion ar  "
                        + "LEFT JOIN usuarios u ON ar.id_usuario_atencion = u.id "
//                        + "INNER JOIN producto_cliente pc on ar.id_producto_cliente = pc.id "
                        + "INNER JOIN cliente_sucursal cs ON cs.id = ar.id_cliente_sucursal "
                        + "INNER JOIN cliente c ON c.id = cs.id_cliente "
                        + "INNER JOIN tipo_visita v ON v.id = ar.id_tipo_visita "
                        + "WHERE ar.estado = :estadoAsignacion "
//                        + "AND ar.preasignacion = :preasignacion "
                        + "ORDER BY substring(cast(fecha_inicio AS NCHAR(10)),7,10) DESC,"
                        + "substring(cast(fecha_inicio AS NCHAR(10)),4,2) DESC,"
                        + "substring(cast(fecha_inicio AS NCHAR(10)),1,2) DESC,"
                        + "ar.prioridad DESC"
        );

        query.setParameter("estadoAsignacion", preasignacion ?
                Enums.ESTADO_ASIGNACION_PREASIGNADO.getValue() : Enums.ESTADO_ASIGNACION_ASIGNADO.getValue());
//        query.setParameter("preasignacion", preasignacion);

        List<Object[]> resultObject = (List<Object[]>) query.list();

        return createNotificaciones(resultObject);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<NotificacionDTO> getNotificacionesByEstadoReporteByIdUsuario(Integer idUsuario, boolean preasignacion) {


        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT  ar.id, DATE_FORMAT(fecha_inicio_atencion ,'%d-%m-%Y') AS fecha_inicio, DATE_FORMAT(ar.hora_inicio_atencion ,'%H:%i') AS hora_inicio,  "
                        + "DATE_FORMAT(ar.fecha_fin_atencion ,'%d-%m-%Y') fecha_fin, DATE_FORMAT(ar.hora_fin_atencion,'%H:%i') hora_fin,  "
                        + "concat(u.nombre,' ', u.apellido) AS tecnico, c.cliente, ar.tipo_reporte AS tipo_reporte,  "
                        + "ar.estado AS estado_notificacion, ar.prioridad, ar.tipo_notificacion tipo, c.id AS id_cliente, "
                        + "ar.producto AS id_producto, ar.id_usuario_atencion AS id_tecnico,ar.id_reporte, ar.tipo_equipo, "
                        + "cs.id id_sucursal, cs.nombre sucursal, cs.direccion ,cs.nombre_contacto, cs.celular_contacto, "
                        + "v.id id_visita, v.descripcion tipo_visita "
                        + "FROM asignacion_reparacion ar  "
                        + "INNER JOIN usuarios u ON ar.id_usuario_atencion = u.id "
//                + "INNER JOIN producto_cliente pc ON ar.id_producto_cliente = pc.id "
                        + "INNER JOIN cliente_sucursal cs ON cs.id = ar.id_cliente_sucursal "
                        + "INNER JOIN cliente c ON c.id = cs.id_cliente "
                        + "INNER JOIN tipo_visita v ON v.id = ar.id_tipo_visita "
                        + "WHERE ar.id_usuario_atencion=:idUsuario AND ar.estado = :estadoAsignacion "
//                        + "AND ar.preasignacion = :preasignacion "
                        + "ORDER BY substring(cast(fecha_inicio AS NCHAR(10)),7,10) DESC,"
                        + "substring(cast(fecha_inicio AS NCHAR(10)),4,2) DESC,"
                        + "substring(cast(fecha_inicio AS NCHAR(10)),1,2) DESC,"
                        + "ar.prioridad DESC"
        );

        query.setParameter("idUsuario", idUsuario)
                .setParameter("estadoAsignacion", preasignacion ?
                        Enums.ESTADO_ASIGNACION_PREASIGNADO.getValue() : Enums.ESTADO_ASIGNACION_ASIGNADO.getValue());
//                .setParameter("preasignacion", preasignacion);
        List<Object[]> resultObject = (List<Object[]>) query.list();

        return createNotificaciones(resultObject);
    }

    @Override
    public List<ReportesDTO> getReportesPorProducto(int rows, int idProducto) throws ParseException {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("" +
                "SELECT DATE_FORMAT(r.fecha, '%d-%m-%Y %H:%i:%s'), r.notas, r.numero_reporte_tecnico, r.id, r.factura, r.subtipo " +
                "FROM reporte r " +
                "INNER JOIN producto_cliente_reporte p ON p.id_reporte = r.id " +
                "INNER JOIN producto prod ON p.id_producto = prod.id " +
                "WHERE prod.id = :idProducto ORDER BY r.fecha DESC");
        query.setParameter("idProducto", idProducto);
        query.setMaxResults(rows);

        List<Object[]> resultObject = (List<Object[]>) query.list();
        List<ReportesDTO> list = new ArrayList<>();
        for (Object[] data : resultObject) {
            ReportesDTO dto = new ReportesDTO();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            dto.setFecha(format.parse((String) data[0]));
            dto.setNota((String) data[1]);
            dto.setNumeroFactura((String) data[2]);
            dto.setId(Integer.parseInt(data[3].toString()));
            dto.setFactura((String) data[4]);
            dto.setSubtipo((String) data[5]);

            list.add(dto);
        }

        return list;
    }

}
