/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.ProductoModelo;
import java.util.List;

/**
 *
 * @author pisama
 */
public interface ProductoModeloDAO {

    public ProductoModelo add(ProductoModelo productoModelo);
    
    public List<ProductoModelo> add(List<ProductoModelo> productoModelos);
    
    public List<ProductoModelo> getModelosByIdProducto(Integer idProducto);
    
    public List<ProductoModelo> getModelosByIdProductoEstado(Integer idProducto, Integer estado);
    
    public List<ProductoModelo> getByEstado(Integer estado);

//    public List<ProductoModelo> getAll();
//
//    public ProductoModelo getById(Integer id);
//
    public ProductoModelo getByIdProductoByIdModelo(Integer idProducto,Integer idModelo);

    

}
