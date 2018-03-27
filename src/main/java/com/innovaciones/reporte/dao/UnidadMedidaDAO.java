/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.UnidadMedida;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface UnidadMedidaDAO {

    public UnidadMedida addUnidadMedida(UnidadMedida unidadMedida);

    public UnidadMedida saveUnidadMedida(UnidadMedida unidadMedida);

    public List<UnidadMedida> getUnidadMedidas();

    public UnidadMedida getUnidadMedidaById(Integer id);

    public UnidadMedida getUnidadMedidaByCodigo(String codigo);
    
    public UnidadMedida getUnidadMedidaByNombre(String nombre);

    public List<UnidadMedida> getUnidadMedidasByEstado(Integer estado);
}
