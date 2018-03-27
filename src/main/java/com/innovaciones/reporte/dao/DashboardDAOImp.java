/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.DashboardDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenAsignacionesPorTecnicoDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenAsigncaionesPorSucDTO;
import com.innovaciones.reporte.model.DTO.dashboard.ResumenTipoVisitaDTO;
import com.innovaciones.reporte.util.Enums;
import com.innovaciones.reporte.util.MesesEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fyaulema
 */
@Repository
public class DashboardDAOImp implements DashboardDAO, Serializable {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DashboardDTO> getAsignacionesByMesAnioEstado(Integer mes, Integer anio, String estado) {

        String estadoCond = "";
        if (estado != null && !"".equals(estado)) {
            estadoCond = "AND ar.estado =:estado ";
        }
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT DATE_FORMAT(ar.fecha_inicio_atencion,'%d') AS dia, DATE_FORMAT(ar.fecha_inicio_atencion,'%m') AS mes, " +
                        "DATE_FORMAT(ar.fecha_inicio_atencion,'%Y') AS anio ,ar.estado, count(ar.estado) " +
                        "FROM asignacion_reparacion ar " +
                        "WHERE DATE_FORMAT(ar.fecha_inicio_atencion,'%m')=:mes AND DATE_FORMAT(ar.fecha_inicio_atencion,'%Y') = :anio " +
                        estadoCond +
                        "GROUP BY  ar.estado, dia, mes, anio " +
                        "ORDER BY dia, mes, anio").
                setParameter("mes", mes).
                setParameter("anio", anio).
                setParameter("estado", estado);

        List<Object[]> resultObject = (List<Object[]>) query.list();

        List<DashboardDTO> result = new ArrayList<>();

        for (Object[] object : resultObject) {

            DashboardDTO dashboardDTO = new DashboardDTO();

            dashboardDTO.setDia(object[0] != null ? Integer.parseInt(object[0].toString()) : null);
            dashboardDTO.setMesNumero(object[1] != null ? Integer.parseInt(object[1].toString()) : null);
            dashboardDTO.setMesNombre(dashboardDTO.getMesNumero() != null ? MesesEnum.get(dashboardDTO.getMesNumero()).getPropertyName() : null);
            dashboardDTO.setAnio(object[2] != null ? Integer.parseInt(object[2].toString()) : null);
            dashboardDTO.setEstado(object[3] != null ? object[3].toString() : "");
            dashboardDTO.setCount(object[4] != null ? Integer.parseInt(object[4].toString()) : null);

            result.add(dashboardDTO);

            System.out.println("getAsignacionesByMesAnio(): " + dashboardDTO.toString());
        }

        return result;
    }

    @Override
    public List<DashboardDTO> getAsignacionesReportesGroupTecnicoByMesAnioEstado(Integer mes, Integer anio, String estado) {

        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT DISTINCT u.id, DATE_FORMAT(ar.fecha_inicio_atencion,'%d') dia, DATE_FORMAT(ar.fecha_inicio_atencion,'%m') mes, " +
                        "DATE_FORMAT(ar.fecha_inicio_atencion,'%Y') anio, concat(u.nombre,' ',u.apellido) tecnico,  " +
                        "r.estado, count(r.estado) " +
                        "FROM asignacion_reparacion ar  " +
                        "INNER JOIN reporte r ON ar.id = r.id_asignacion AND ar.id = r.id_asignacion " +
                        "INNER JOIN usuarios u ON u.id = r.id_usuario  " +
                        "WHERE DATE_FORMAT(ar.fecha_inicio_atencion,'%m')= :mes AND " +
                        "DATE_FORMAT(ar.fecha_inicio_atencion,'%Y')= :anio AND  " +
                        "r.estado = :estadoReporte AND ar.estado = :estadoAsignacion " +
//                "AND ar.preasignacion = 0 " +
                        "GROUP BY tecnico, r.estado " +
                        "ORDER BY dia, mes, anio").
                setParameter("mes", mes).
                setParameter("anio", anio).
                setParameter("estadoReporte", estado).
                setParameter("estadoAsignacion", estado);

        List<Object[]> resultObject = (List<Object[]>) query.list();

        List<DashboardDTO> result = new ArrayList<>();

        Integer count = 1;
        for (Object[] object : resultObject) {

            DashboardDTO dashboardDTO = new DashboardDTO();

            dashboardDTO.setIdUsuario(object[0] != null ? Integer.parseInt(object[0].toString()) : null);
            dashboardDTO.setDia(object[1] != null ? Integer.parseInt(object[1].toString()) : null);
            dashboardDTO.setMesNumero(object[2] != null ? Integer.parseInt(object[2].toString()) : null);
            dashboardDTO.setMesNombre(dashboardDTO.getMesNumero() != null ? MesesEnum.get(dashboardDTO.getMesNumero()).getPropertyName() : null);
            dashboardDTO.setAnio(object[3] != null ? Integer.parseInt(object[3].toString()) : null);
            dashboardDTO.setNombre(object[4] != null ? object[4].toString() : "");
            dashboardDTO.setEstado(object[5] != null ? object[5].toString() : "");
            dashboardDTO.setCount(object[6] != null ? Integer.parseInt(object[6].toString()) : null);

            result.add(dashboardDTO);

            System.out.println("getAsignacionesByMesAnio(): " + dashboardDTO.toString());
        }

        return result;
    }

    @Override
    public List<ResumenAsignacionesPorTecnicoDTO> getAsignacionesGroupTecnicoByMesAnioEstado(Date fechaInicio, Date fechaFin, String estado) {

        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT DISTINCT  concat(u.nombre,' ',u.apellido) tecnico, " +
                        "ar.estado, count(u.id) count " +
                        "FROM asignacion_reparacion ar " +
                        "INNER JOIN usuarios u ON u.id = ar.id_usuario_atencion " +
                        "WHERE ar.fecha_inicio_atencion BETWEEN :fechaInicio AND :fechaFin " +
//                        "AND ar.preasignacion = :preasignacion " +
                        "AND ar.estado = :estado " +
                        "GROUP BY id_usuario_atencion, tecnico, ar.estado " +
                        "ORDER BY tecnico").
                setParameter("fechaInicio", fechaInicio).
                setParameter("fechaFin", fechaFin).
//                setParameter("preasignacion", preasignacion).
        setParameter("estado", estado);

        List<Object[]> resultObject = (List<Object[]>) query.list();

        List<ResumenAsignacionesPorTecnicoDTO> result = new ArrayList<>();

        for (Object[] object : resultObject) {

            ResumenAsignacionesPorTecnicoDTO dashboardDTO = new ResumenAsignacionesPorTecnicoDTO();

            dashboardDTO.setTecnico(object[0].toString());
            dashboardDTO.setEstado(object[1].toString());
            dashboardDTO.setCount(Integer.parseInt(object[2].toString()));

            result.add(dashboardDTO);

            System.out.println("getAsignacionesGroupTecnicoByMesAnioEstado(): " + dashboardDTO.toString());
        }

        return result;
    }

    @Override
    public List<ResumenTipoVisitaDTO> getCountTipoVisita(Date fechaInicio, Date fechaFin) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT t.descripcion, count(ar.id_tipo_visita) " +
                        "FROM asignacion_reparacion ar INNER JOIN tipo_visita t ON ar.id_tipo_visita = t.id " +
                        "WHERE ar.fecha_inicio_atencion BETWEEN :fechaInicio AND :fechaFin " +
//                        "AND ar.estado = :estado " +
                        "GROUP BY  ar.id_tipo_visita ").
//                setParameter("estado", Enums.ESTADO_REPORTE_FINALIADO).
        setParameter("fechaInicio", fechaInicio).
                        setParameter("fechaFin", fechaFin);
        List<Object[]> resultObject = (List<Object[]>) query.list();

        List<ResumenTipoVisitaDTO> result = new ArrayList<>();

        for (Object[] object : resultObject) {

            ResumenTipoVisitaDTO dashboardDTO = new ResumenTipoVisitaDTO();

            dashboardDTO.setTipoVisita(object[0].toString());
            dashboardDTO.setCount(Integer.parseInt(object[1].toString()));

            result.add(dashboardDTO);

        }

        return result;
    }

    @Override
    public List<ResumenAsigncaionesPorSucDTO> getCountAsignacionesPorSucursal(String estado, Date fechaInicio, Date fechaFin) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT suc.longitud, suc.latitud, suc.nombre, count(ar.id_cliente_sucursal), cl.cliente, cl.direccion " +
                        "FROM asignacion_reparacion ar INNER JOIN cliente_sucursal suc ON ar.id_cliente_sucursal = suc.id " +
                        "INNER JOIN cliente cl ON suc.id_cliente = cl.id " +
                        "WHERE ar.fecha_inicio_atencion BETWEEN :fechaInicio AND :fechaFin " +
                        "AND ar.estado = :estado " +
                        "GROUP BY  ar.id_cliente_sucursal ").
                setParameter("estado", estado).
                setParameter("fechaInicio", fechaInicio).
                setParameter("fechaFin", fechaFin);
        List<Object[]> resultObject = (List<Object[]>) query.list();
        List<ResumenAsigncaionesPorSucDTO> result = new ArrayList<>();
        for (Object[] object : resultObject) {
            if (object[0] == null || object[1] == null) {
                continue;
            }
            ResumenAsigncaionesPorSucDTO dto = new ResumenAsigncaionesPorSucDTO();
            dto.setLongitude((Double) object[0]);
            dto.setLatitude((Double) object[1]);
            dto.setSucursal(object[2].toString());
            dto.setCount(Integer.parseInt(object[3].toString()));
            dto.setEstado(estado);
            dto.setCliente(object[4].toString());
            dto.setDireccion(object[5].toString());
            result.add(dto);
        }
        return result;
    }
}
