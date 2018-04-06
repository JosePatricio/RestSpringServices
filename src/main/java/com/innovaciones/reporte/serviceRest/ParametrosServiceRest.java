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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ParametrosServiceRest extends Utilities {

    @Autowired
    private ParametrosService parametrosService;

    @RequestMapping(value = "/getByParametro/{parametro}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Parametros> getByParametro(@PathVariable("parametro") String parametro) {

        return new ResponseEntity<Parametros>(parametrosService.getByParametro(parametro), headers(), HttpStatus.OK);

    }

    @RequestMapping(value = "/updateIdDeviceCode/{valor}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Void> updateIdDeviceCode(@PathVariable("valor") String valor) {
        HttpHeaders hd = new HttpHeaders();

        Parametros currentvalue = parametrosService.getByParametro("DEVICE_ID_FIREBASE");

        if (!currentvalue.getValor().equals(valor)) {
            Parametros parametro = new Parametros();
            parametro = currentvalue;
            parametro.setValor(valor);

            parametrosService.saveOrUpdate(parametro);

            System.out.println("ACUTLUIZADO   " + currentvalue);

        }

        hd.add("Access-Control-Allow-Origin", "*");
        hd.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        hd.add("Access-Control-Allow-Headers", "Content-Type");

        return new ResponseEntity<Void>(hd, HttpStatus.OK);
    }

}
