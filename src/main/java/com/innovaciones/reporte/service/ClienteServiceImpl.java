/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ClienteDAO;
import com.innovaciones.reporte.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "clienteService")
@ViewScoped

public class ClienteServiceImpl implements ClienteService, Serializable {

    @Getter
    @Setter
    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    @Transactional
    public Cliente addCliente(Cliente cliente) {
        return clienteDAO.addCliente(cliente);
    }

    @Override
    @Transactional
    public Cliente getClienteByRuc(String ruc) {

        return clienteDAO.getClienteByRuc(ruc);
    }

    @Override
    @Transactional
    public List<Cliente> getClientes() {
        
          System.out.println("ENTRO LISTA  getClientes  service   ");
        List<Cliente> LISTA=clienteDAO.getClientes();
        System.out.println("salio   LISTA  getClientes service");
        return LISTA;
    }

    @Override
    @Transactional
    public List<Cliente> getClientesByEstado(Integer estado) {
        return clienteDAO.getClientesByEstado(estado);
    }

    @Override
    @Transactional
    public Cliente getClienteByNombre(String nombre) {
        return clienteDAO.getClienteByNombre(nombre);
    }

    @Override
    @Transactional
    public Cliente getClientesById(Integer id) {
        return clienteDAO.getClientesById(id);
    }

    @Override
    @Transactional
    public List<Cliente> getConProyectos() {
        return clienteDAO.getConProyectos();
    }
}
