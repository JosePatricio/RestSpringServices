/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.serviceRest;

import com.innovaciones.reporte.model.DTO.DatosReporteDTO;
import com.innovaciones.reporte.model.DTO.ReportesDTO;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.service.ClienteService;
import com.innovaciones.reporte.service.ConsultasService;
import com.innovaciones.reporte.service.DetalleCatalogoReporteService;
import com.innovaciones.reporte.service.ProductoClienteReporteService;
import com.innovaciones.reporte.service.ProductoService;
import com.innovaciones.reporte.service.ReporteService;
import com.innovaciones.reporte.util.Utilities;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author pisama
 */
@RestController
@RequestMapping("/reporteService")
public class ReporteServiceRest extends Utilities {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DetalleCatalogoReporteService detalleCatalogoReporteService;

    @Autowired
    private ConsultasService consultasService;

    @Autowired
    private ProductoClienteReporteService productoClienteReporteService;

    @RequestMapping(value = "/updateAllReporteImpresoras/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Void> updateAllReporteImpresoras(@PathVariable("id") Integer id, @RequestBody DatosReporteDTO datosReporteDTO) {
        HttpHeaders hd = new HttpHeaders();

        reporteService.updateAllReporteImpresoras(datosReporteDTO);
        hd.add("Access-Control-Allow-Origin", "*");
        hd.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        hd.add("Access-Control-Allow-Headers", "Content-Type");

        return new ResponseEntity<Void>(hd, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveAllReporteImpresoras/", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Void> saveAllReporteImpresoras(@RequestBody DatosReporteDTO datosReporteDTO, UriComponentsBuilder ucBuilder) {
        HttpHeaders hd = new HttpHeaders();
       
        reporteService.saveAllReporteImpresoras(datosReporteDTO);
        hd.add("Access-Control-Allow-Origin", "*");
        hd.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        hd.add("Access-Control-Allow-Headers", "Content-Type");

        return new ResponseEntity<Void>(hd, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getDatosReporteDTO", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<DatosReporteDTO> getDatosReporteDTO() {

        System.out.println("getDdatosReporteDTO");

        DatosReporteDTO dTO = new DatosReporteDTO();

        dTO.setCliente(clienteService.getClientesById(5351));
        dTO.setIdTipoVisita(123);
        dTO.setProducto(productoService.getProductoById(940));
        dTO.setLista1(detalleCatalogoReporteService.getDetalleCatalogoReporteByCabeceraCodigo("PROCESAMIENTO"));

        return new ResponseEntity<DatosReporteDTO>(dTO, headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/numeroReporte/{idusuario}/{tipo}/{subtipo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> numeroReporte(@PathVariable("idusuario") Integer idusuario, @PathVariable("tipo") String tipo, @PathVariable("subtipo") String subtipo) {
        String valor = "";

        valor = "{\"valor\":" + reporteService.getByUserByTipo(idusuario, tipo, subtipo).size() + "}";

        return new ResponseEntity<String>(valor, headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/numeroReporteFormateado/{idusuario}/{tipo}/{subtipo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> numeroReporteFormateado(@PathVariable("idusuario") Integer idusuario, @PathVariable("tipo") String tipo, @PathVariable("subtipo") String subtipo) {

        String valor = "";

        valor = formatoNumeroFactura(reporteService.getByUserByTipo(idusuario, tipo, subtipo).size());

        valor = "{\"valor\":\"" + valor + "\"}";

        return new ResponseEntity<String>(valor, headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/reportesById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ReportesDTO> reportesById(@PathVariable("id") Integer id) {

        return new ResponseEntity<ReportesDTO>(consultasService.reportesById(id), headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/reporteById/{id}", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ProductoClienteReporte> reporteById(@PathVariable("id") Integer id) {
        HttpHeaders hd = new HttpHeaders();
        hd.add("Access-Control-Allow-Origin", "*");
        hd.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        hd.add("Access-Control-Allow-Headers", "Content-Type");

        return new ResponseEntity<ProductoClienteReporte>(productoClienteReporteService.getByReportId(id), hd, HttpStatus.OK);
    }

    @RequestMapping(value = "/reportesBySubTipo/{subTipo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ReportesDTO>> reportesBySubTipo(@PathVariable("subTipo") String subTipo) {

        return new ResponseEntity<List<ReportesDTO>>(consultasService.reportesBySubTipo(subTipo), headers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/jasper/{id}", method = RequestMethod.GET, produces = "application/pdf")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    byte[] getOpenedEventsInPdf(HttpServletResponse response, @PathVariable("id") Integer id) {
        response.setHeader("Content-Disposition", "inline; filename=file.pdf");
        response.setContentType("application/pdf");
        byte[] file = reporteService.jasperReporte(id);

        System.out.println("EL TAMANIO ES  " + file.length);

        return file;
    }

    @RequestMapping(value = "/descarga/{id}", method = RequestMethod.GET, produces = "application/pdf")
    @CrossOrigin(origins = "*")
    public ResponseEntity<byte[]> getPDF(@PathVariable("id") Integer id) {

        byte[] contents = reporteService.jasperReporte(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "reporte.pdf";
        headers.setContentDispositionFormData(filename, filename);
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;

    }

}
