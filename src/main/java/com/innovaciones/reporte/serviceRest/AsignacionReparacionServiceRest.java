/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.service.AsignacionReparacionService;
import com.innovaciones.reporte.service.NotificacionService;
import com.innovaciones.reporte.util.Utilities;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignacionReparacionService")
public class AsignacionReparacionServiceRest extends Utilities {

    @Autowired
    private AsignacionReparacionService asignacionReparacionService;

    @Autowired
    private NotificacionService notificacionService;

    @RequestMapping(value = "/getNotificacionesByEstadoReporteByIdUsuario/{id}", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<List<AsignacionReparacion>> getNotificacionesByEstadoReporteByIdUsuario(@PathVariable("id") Integer id) {
        List<AsignacionReparacion> lista = asignacionReparacionService.getAsignacionReparacionesNoEliminados();
        lista = lista.stream().filter((AsignacionReparacion a) -> a.getIdUsuarioAtencion().getId().intValue() == id).collect(Collectors.toList());

        return new ResponseEntity<List<AsignacionReparacion>>(lista, headers(), HttpStatus.OK);

    }

    @RequestMapping(value = "/ejecutar/{id}", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<AsignacionReparacion> AsignacionReparacion(@PathVariable("id") Integer id) {

        AsignacionReparacion as = asignacionReparacionService.getAsignacionReparacionById(id);
       
        //  System.out.println("ENTIDAD  == " + reparacion);
        // enviarNotificacion(reparacion);
        if (asignacionReparacionService.enviarNotificacion(as)) {
            System.out.println("ENVIADOP ");
        } else {
            System.out.println("ERROR EN LA NOTIFICACIOSN ");

        }

        return new ResponseEntity<AsignacionReparacion>(as, headers(), HttpStatus.OK);

    }

}
