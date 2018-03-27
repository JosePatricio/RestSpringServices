/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.ProductoRepuestoReporte;
import com.innovaciones.reporte.service.ProductoRepuestoReporteService;
import com.innovaciones.reporte.util.Utilities;
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
@RequestMapping("/productoRepuestoReporteServiceRest")
public class ProductoRepuestoReporteServiceRest extends Utilities {

    @Autowired
    private ProductoRepuestoReporteService productoRepuestoReporteService;

    @RequestMapping(value = "/getByIdDetalleCatalogoReporteByIdModelo/{iddetalle}/{idmodelo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ProductoRepuestoReporte>> getByIdDetalleCatalogoReporteByIdModelo(@PathVariable("iddetalle") Integer idDetalleCatalogo, @PathVariable("idmodelo") Integer idModelo) {

        System.out.println("ProductoRepuestoReporteServiceRest   " + idDetalleCatalogo + "  ," + idModelo);
        return new ResponseEntity<List<ProductoRepuestoReporte>>(productoRepuestoReporteService.getByIdDetalleCatalogoReporteByIdModelo(idDetalleCatalogo, idModelo), headers(), HttpStatus.OK);
    }

}
