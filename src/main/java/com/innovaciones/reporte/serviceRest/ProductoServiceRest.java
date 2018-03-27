/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.service.ProductoService;
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
@RequestMapping("/productoService")
public class ProductoServiceRest {

    @Autowired
    private ProductoService productoService;

    @RequestMapping(value = "/getOnlyProductosByCodigoCategoria/{codigoCategoria}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Producto>> getOnlyProductosByCodigoCategoria(@PathVariable("codigoCategoria") String codigoCategoria) {

        return new ResponseEntity<List<Producto>>(productoService.getOnlyProductosByCodigoCategoria(codigoCategoria), headers(), HttpStatus.OK);

    }

}
