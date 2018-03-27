/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.Bodega;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface BodegaService {

    public Bodega addBodega(Bodega bodega);

    public List<Bodega> getBodegas();

    public Bodega getBodegaById(Integer id);

    public Bodega getBodegaByCodigo(String codigo);
    
    public Bodega getBodegaByNombre(String nombre);

    public List<Bodega> getBodegasByEstado(Integer estado);
}
