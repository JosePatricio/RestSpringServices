/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ProductoClienteReporteDAO;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "productoClienteReporteService")
@ViewScoped
public class ProductoClienteReporteServiceImpl implements ProductoClienteReporteService, Serializable {

    @Setter
    private ProductoClienteReporteDAO productoClienteReporteDAO;

    @Override
    @Transactional
    public ProductoClienteReporte saveOrUpdateProductoClienteReporte(ProductoClienteReporte productoClienteReporte) {
        return productoClienteReporteDAO.saveOrUpdateProductoClienteReporte(productoClienteReporte);
    }

    
    @Override
    @Transactional
    public ProductoClienteReporte update(ProductoClienteReporte productoClienteReporte) {
        return productoClienteReporteDAO.update(productoClienteReporte);
    }

    @Override
    @Transactional
    public ProductoClienteReporte save(ProductoClienteReporte productoClienteReporte) {
        return productoClienteReporteDAO.save(productoClienteReporte);
    }

    @Override
    @Transactional
    public ProductoClienteReporte getByReportId(Integer ids) {
        return productoClienteReporteDAO.getByReportId(ids);
    }

    @Override
    @Transactional
    public ProductoClienteReporte getByUsuarioRuc(String ruc) {
        return productoClienteReporteDAO.getByUsuarioRuc(ruc);
    }

    @Override
    @Transactional
    public List<ProductoClienteReporte> getBySerial(String serial) {

        return productoClienteReporteDAO.getBySerial(serial);
    }

    @Override
    @Transactional
    public ProductoClienteReporte getByIdProductoCliente(Integer idProductoCliente) {
        return productoClienteReporteDAO.getByIdProductoCliente(idProductoCliente);
    }

}
