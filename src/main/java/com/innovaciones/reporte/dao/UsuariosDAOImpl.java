/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class UsuariosDAOImpl implements UsuariosDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Usuarios addUsuarios(Usuarios usuario) {
        sessionFactory.getCurrentSession().saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public Usuarios getUsuariosById(Integer ruc) {
        Usuarios user = (Usuarios) sessionFactory.getCurrentSession().
                createQuery("from Usuarios WHERE id='" + ruc + "'").
                uniqueResult();
        return user != null ? user : null;
    }

    @Override
    @Transactional
    public List<Usuarios> getUsuarios() {
        return sessionFactory.getCurrentSession().createQuery("from Usuarios u Order By u.nombre, u.apellido")
                .list();
    }

    @Override
    @Transactional
    public Usuarios getUsuarioByUsuarioByClaveByEstado(String usuario, String clave, Integer estado) {
        Usuarios user = (Usuarios) sessionFactory.getCurrentSession().
                createQuery("from Usuarios WHERE usuario='" + usuario + "' AND clave='" + clave + "' AND estado=" + estado).
                uniqueResult();
        return user != null ? user : null;
    }

    @Override
    @Transactional
    public List<Usuarios> getUsuariosByEstado(Integer estado) {
        return sessionFactory.getCurrentSession().createQuery("from Usuarios u Where u.estado = " + estado + " Order By u.nombre, u.apellido")
                .list();
    }

    @Override
    @Transactional
    public List<Usuarios> getUsuariosByRolByEstado(String nombreRol, Integer estado) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("SELECT u.id, u.dni, u.codigo, u.nombre, u.apellido, u.telefono, ");
        stringBuilder.append("u.celular, u.mail, u.direccion, u.usuario, u.clave, u.estado, ");
        stringBuilder.append("u.firma_base64, u.firma, u.imagen ");
        stringBuilder.append("FROM usuarios u ");
        stringBuilder.append("inner join usuario_roles ur on u.id = ur.id_usuario ");
        stringBuilder.append("inner join rol r on ur.id_rol = r.id ");
        stringBuilder.append("Where r.rol = '");
        stringBuilder.append(nombreRol);
        stringBuilder.append("' AND u.estado = ");
        stringBuilder.append(estado);
        stringBuilder.append(" AND r.estado = ");
        stringBuilder.append(estado);
        stringBuilder.append(" Order By u.nombre, u.apellido");

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString());
        List<Object[]> result = query.list();

        List<Usuarios> usuariosLista = new ArrayList<Usuarios>();

        Usuarios usuario;
        for (int i = 0; i < result.size(); i++) {
            Object[] data = result.get(i);

            usuario = new Usuarios();

            usuario.setId(Integer.parseInt(data[0].toString()));
            usuario.setDni(data[1].toString());
            usuario.setCodigo(data[2].toString());
            usuario.setNombre(data[3].toString());
            usuario.setApellido(data[4].toString());
            usuario.setTelefono(data[5] != null ? data[5].toString() : "");
            usuario.setCelular(data[6] != null ? data[6].toString() : "");
            usuario.setMail(data[7].toString());
            usuario.setDireccion(data[8] != null ? data[8].toString() : "");
            usuario.setUsuario(data[9].toString());
            usuario.setClave(data[10].toString());
            //usuario.setEstado(Integer.parseInt(data[11].toString()));
            usuario.setFirmaBase64(data[12] != null ? data[12].toString() : "");
            usuario.setFirma(data[13] != null ? data[13].toString() : "");
            usuariosLista.add(usuario);
        }

        return usuariosLista;
    }

    @Override
    @Transactional
    public List<Usuarios> getConProyectos() {
        return sessionFactory.getCurrentSession().createQuery("SELECT u FROM Usuarios u WHERE u.idCliente.id IN  (SELECT p.idCliente.id FROM Proyectos p )")
                .list();
    }

    @Override
    @Transactional
    public Usuarios update(Usuarios cliente) {
        sessionFactory.getCurrentSession().update(cliente);
        return cliente;
    }

    @Override
    @Transactional
    public Usuarios getByIdCliente(Integer id) {
        Usuarios user = (Usuarios) sessionFactory.getCurrentSession().
                createQuery("from Usuarios u WHERE  u.idCliente.id='" + id + "'").
                uniqueResult();
        return user != null ? user : null;
    }

}
