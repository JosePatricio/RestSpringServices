/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.Parametros;
import com.innovaciones.reporte.service.ParametrosService;
import com.innovaciones.reporte.util.Utilities;
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
@RequestMapping("/parametrosService")
public class ParametrosServiceRest extends Utilities{

    @Autowired
    private ParametrosService parametrosService;

    @RequestMapping(value = "/getByParametro/{parametro}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Parametros> getByParametro(@PathVariable("parametro") String parametro) {

        return new ResponseEntity<Parametros>(parametrosService.getByParametro(parametro), headers(), HttpStatus.OK);

    }

}
