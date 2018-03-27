/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.DTO.ReportesDTO;
import com.innovaciones.reporte.service.ConsultasService;
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
@RequestMapping("/consultasService")

public class ConsultasServiceRest {

    @Autowired
    private ConsultasService consultasService;

    
    
    @RequestMapping(value = "/reportesById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ReportesDTO> reportesById(@PathVariable("id") Integer id) {

        return new ResponseEntity<ReportesDTO>(consultasService.reportesById(id), headers(), HttpStatus.OK);
    }

    
    
    @RequestMapping(value = "/reportesBySubTipo/{subTipo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ReportesDTO>> reportesBySubTipo(@PathVariable("subTipo") String subTipo) {

        System.out.println("TIPO " + subTipo);
        return new ResponseEntity<List<ReportesDTO>>(consultasService.reportesBySubTipo(subTipo), headers(), HttpStatus.OK);
    }
    
    

}
