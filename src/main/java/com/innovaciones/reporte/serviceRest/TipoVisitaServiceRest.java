/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.TipoVisita;
import com.innovaciones.reporte.service.TipoVisitaService;
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
@RequestMapping("/tipoVisitaService")

public class TipoVisitaServiceRest {

    @Autowired
    private TipoVisitaService tipoVisitaService;

    @RequestMapping(value = "/getAllTipoVisitas", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TipoVisita>> getAllTipoVisitas() {

        return new ResponseEntity<List<TipoVisita>>(tipoVisitaService.getAllTipoVisitas(), headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getByTipo/{parametro}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TipoVisita>> getAllTipoVisitas(@PathVariable("parametro") String tipo) {

        return new ResponseEntity<List<TipoVisita>>(tipoVisitaService.getByTipo(tipo), headers(), HttpStatus.OK);
    }

}
