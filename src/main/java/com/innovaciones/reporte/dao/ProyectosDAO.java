/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.Proyectos;
import java.util.List;

/**
 *
 * @author Pato
 */
public interface ProyectosDAO {

    public Proyectos save(Proyectos proyectos);

    public Proyectos update(Proyectos proyectos);

    public Proyectos saveorupdate(Proyectos proyectos);

    public void delete(Proyectos proyectos);

    public List<Proyectos> getByIDCliente(Integer id);
}
