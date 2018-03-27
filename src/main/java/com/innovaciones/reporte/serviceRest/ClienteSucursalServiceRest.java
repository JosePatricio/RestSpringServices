/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.ClienteSucursal;
import com.innovaciones.reporte.service.ClienteSucursalService;
import static com.innovaciones.reporte.util.Utilities.headers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pisama
 */
@RestController
@RequestMapping("/clienteSucursalService")
public class ClienteSucursalServiceRest {

    @Autowired
    private ClienteSucursalService clienteSucursalService;

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ClienteSucursal> getById(@PathVariable("id") Integer id) {

        return new ResponseEntity<ClienteSucursal>(clienteSucursalService.getById(id), headers(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getByIdCliente/{idCliente}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ClienteSucursal>> getByIdCliente(@PathVariable("idCliente") Integer idCliente) {

        return new ResponseEntity<List<ClienteSucursal>>(clienteSucursalService.getByIdCliente(idCliente), headers(), HttpStatus.OK);

    }

}
