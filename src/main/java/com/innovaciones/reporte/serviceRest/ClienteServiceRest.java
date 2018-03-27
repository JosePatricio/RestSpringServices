/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.service.ClienteService;
import com.innovaciones.reporte.util.Utilities;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clienteService")
public class ClienteServiceRest extends Utilities {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/getClientes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Cliente>> getAll() {

        List<Cliente> lista = clienteService.getClientes();
        return new ResponseEntity<List<Cliente>>(lista, headers(), HttpStatus.OK);
    }

    
    @RequestMapping(value = "/getClienteByRuc/{ruc}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Cliente> getClienteByRuc(@PathVariable("ruc") String ruc) {

        return new ResponseEntity<Cliente>(clienteService.getClienteByRuc(ruc), headers(), HttpStatus.OK);

    }

}
