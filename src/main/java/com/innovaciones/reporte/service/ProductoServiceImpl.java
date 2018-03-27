/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ProductoDAO;
import com.innovaciones.reporte.model.DTO.ProductoDTO;
import com.innovaciones.reporte.model.Producto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fyaulema
 */
@Service
@ManagedBean(name = "productoService")
@ViewScoped
public class ProductoServiceImpl implements ProductoService, Serializable {

    private ProductoDAO productoDAO;

    @Override
    @Transactional
    public Producto addProducto(Producto producto) {
        return productoDAO.addProducto(producto);
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    @Override
    @Transactional
    public List<ProductoDTO> getProductosDTOStockByEstado(Integer idBodega, Integer estado) {
        return productoDAO.getProductosDTOStockByEstado(idBodega, estado);
    }

    @Override
    @Transactional
    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado) {
        return productoDAO.getDetalleProductosDTOByIdCabeceraInventario(idCabeceraInventario, estado);
    }

    @Override
    @Transactional
    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado) {
        return productoDAO.getSolicitudProductosDTOByIdCabeceraInventario(idCabeceraInventario, estado);
    }

    @Override
    @Transactional
    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado) {
        return productoDAO.getDetalleProductosDTOByIdCabeceraEgreso(idCabeceraEgreso, estado);

    }

    @Override
    @Transactional
    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado) {
        return productoDAO.getSolicitudProductosDTOByIdCabeceraEgreso(idCabeceraEgreso, estado);

    }

    @Override
    @Transactional
    public List<Producto> getProductosHijosByIdPadre(Integer idPadre) {
        return productoDAO.getProductosHijosByIdPadre(idPadre);
    }

    @Override
    @Transactional
    public List<Producto> getProductosHijosByIdAncestro(Integer idAncestro) {
        return productoDAO.getProductosHijosByIdAncestro(idAncestro);
    }

    @Override
    @Transactional
    public List<Producto> getOnlyProductos() {
        return productoDAO.getOnlyProductos();
    }

    @Override
    @Transactional
    public List<Producto> getOnlyProductosByCodigoCategoria(String codigoCategoria) {
        return productoDAO.getOnlyProductosByCodigoCategoria(codigoCategoria);
    }

    @Override
    @Transactional
    public Producto getProductoById(Integer id) {
        return productoDAO.getProductoById(id);
    }

    @Override
    @Transactional
    public List<Producto> getProductosByEstado(Integer estado) {
        return productoDAO.getProductosByEstado(estado);
    }

    @Override
    @Transactional
    public List<Producto> getProductosCompatiblesByIdPadre(Integer idPadre, Integer estado) {
        return productoDAO.getProductosCompatiblesByIdPadre(idPadre, estado);
    }

    @Override
    @Transactional
    public List<Producto> getProductos() {
        return productoDAO.getProductos();
    }

    @Override
    @Transactional
    public Producto getProductoByCodigoFabricante(String codigo) {
        return productoDAO.getProductoByCodigoFabricante(codigo);
    }

    @Override
    @Transactional
    public Producto getProductoBySerial(String serial) {
        return productoDAO.getProductoBySerial(serial);
    }

}
