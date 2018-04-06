/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.service.AsignacionReparacionService;
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
@RequestMapping("/asignacionReparacionService")
public class AsignacionReparacionServiceRest extends Utilities {

    @Autowired
    private AsignacionReparacionService asignacionReparacionService;

    @RequestMapping(value = "/getAsignacionReparacionByIdReporte/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AsignacionReparacion> getClienteByRuc(@PathVariable("id") Integer id) {

        return new ResponseEntity<AsignacionReparacion>(asignacionReparacionService.getAsignacionReparacionByIdReporte(id), headers(), HttpStatus.OK);

    }

}
