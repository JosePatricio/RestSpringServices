/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.Usuarios;
import com.innovaciones.reporte.service.UsuariosService;
import com.innovaciones.reporte.util.Utilities;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/usuariosService")

public class UsuariosServiceRest extends Utilities {

    @Autowired
    private UsuariosService usuariosService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login/{usuario}/{clave}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Usuarios> login(@PathVariable("usuario") String usuario, @PathVariable("clave") String clave) {
        Usuarios usuario_ = usuariosService.login(usuario, encrypt(clave), 1);

        System.out.println("EL USUARIO ENCONTRADO ES " + usuario_);
        return new ResponseEntity<Usuarios>(usuario_, headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getConProyectos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Usuarios>> getConProyectos() {
        return new ResponseEntity<List<Usuarios>>(usuariosService.getConProyectos(), headers(), HttpStatus.OK);
    }

}
