/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.Marca;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface MarcaService {

    public Marca addMarca(Marca marca);

    public List<Marca> getMarcas();

    public Marca getMarcaById(Integer id);

    public Marca getMarcaByCodigo(String codigo);
    
    public Marca getMarcaByNombre(String nombre);

    public List<Marca> getMarcasByEstado(Integer estado);
    
    public Marca saveMarca(Marca marca) ;

//    List<Marca> getMarcasLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException;
}
