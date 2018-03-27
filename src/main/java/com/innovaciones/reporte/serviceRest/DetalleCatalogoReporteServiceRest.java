/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.CabeceraCatalogoReporte;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.service.CabeceraCatalogoReporteService;
import com.innovaciones.reporte.service.DetalleCatalogoReporteService;
import com.innovaciones.reporte.util.Utilities;
import java.util.List;
import javax.ws.rs.PathParam;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/detalleCatalogoReporteService")
public class DetalleCatalogoReporteServiceRest extends Utilities {

    @Autowired
    private DetalleCatalogoReporteService detalleCatalogoReporteService;

    @Autowired
    private CabeceraCatalogoReporteService cabeceraCatalogoReporteService;

    @RequestMapping(value = "/getDetalleCatalogoReporteByCabeceraCodigo/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<DetalleCatalogoReporte>> getDetalleCatalogoReporteByCabeceraCodigo_(@PathVariable("codigo") String codigo) {
        return new ResponseEntity<List<DetalleCatalogoReporte>>(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo(codigo), headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getDetalleCatalogoReporteByDescripcionByIdCabecera/{descripcion}/{idCabecera}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<DetalleCatalogoReporte> getDetalleCatalogoReporteByDescripcionByIdCabecera(@PathVariable("descripcion") String descripcion, @PathVariable("idCabecera") Integer idCabecera) {

        return new ResponseEntity<DetalleCatalogoReporte>(detalleCatalogoReporteService.getDetalleCatalogoReporteByDescripcionByIdCabecera(descripcion, idCabecera), headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getDetalleCatalogoReporteByDescripcionByIdCategoria/{descripcion}/{idCategoria}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<DetalleCatalogoReporte> getDetalleCatalogoReporteByDescripcionByIdCategoria(@PathParam("descripcion") String descripcion, @PathParam("idCategoria") Integer idCategoria) {

        return new ResponseEntity<DetalleCatalogoReporte>(detalleCatalogoReporteService.getDetalleCatalogoReporteByDescripcionByIdCategoria(descripcion, idCategoria), headers(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getCabeceraCatalogoReportesByTipo/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<CabeceraCatalogoReporte>> getCabeceraCatalogoReportesByTipo_(@PathVariable("codigo") String codigo) {

        return new ResponseEntity<List<CabeceraCatalogoReporte>>(cabeceraCatalogoReporteService.getCabeceraCatalogoReportesByTipo(codigo), headers(), HttpStatus.OK);
    }

}
