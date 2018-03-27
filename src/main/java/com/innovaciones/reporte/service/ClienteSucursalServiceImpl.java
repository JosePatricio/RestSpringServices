/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ClienteSucursalDAO;
import com.innovaciones.reporte.model.ClienteSucursal;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernando
 */
@Service
@ManagedBean(name = "clienteSucursalService")
@ViewScoped
public class ClienteSucursalServiceImpl implements ClienteSucursalService, Serializable {

    @Setter
    private ClienteSucursalDAO clienteSucursalDAO;

    @Override
    @Transactional
    public ClienteSucursal saveOrUpdate(ClienteSucursal clienteSucursal) {
        return clienteSucursalDAO.saveOrUpdate(clienteSucursal);
    }

    @Override
    @Transactional
    public List<ClienteSucursal> saveOrUpdate(List<ClienteSucursal> listClienteSucursal) {
        for (ClienteSucursal clienteSucursal : listClienteSucursal) {
            clienteSucursalDAO.saveOrUpdate(clienteSucursal);
        }
        return listClienteSucursal;
    }

    @Override
    @Transactional
    public List<ClienteSucursal> getAll() {
        return clienteSucursalDAO.getAll();

    }

    @Override
    @Transactional
    public ClienteSucursal getById(Integer id) {
        return clienteSucursalDAO.getById(id);

    }

    @Override
    @Transactional
    public List<ClienteSucursal> getByIdCliente(Integer idCliente) {
        return clienteSucursalDAO.getByIdCliente(idCliente);
    }

    @Override
    @Transactional
    public List<ClienteSucursal> getByEstado(Integer estado) {
        return clienteSucursalDAO.getByEstado(estado);
    }

    @Override
    @Transactional
    public ClienteSucursal getByNombre(String nombre) {
        return clienteSucursalDAO.getByNombre(nombre);
    }

}
