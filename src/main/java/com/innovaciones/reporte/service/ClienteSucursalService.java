/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.ClienteSucursal;
import java.util.List;

/**
 *
 * @author Fernando
 */
public interface ClienteSucursalService {

    public ClienteSucursal saveOrUpdate(ClienteSucursal clienteSucursal);

    public List<ClienteSucursal> saveOrUpdate(List<ClienteSucursal> listClienteSucursal);

    public List<ClienteSucursal> getAll();

    public ClienteSucursal getById(Integer id);

    public List<ClienteSucursal> getByIdCliente(Integer idCliente);

    public List<ClienteSucursal> getByEstado(Integer estado);

    public ClienteSucursal getByNombre(String nombre);
}
