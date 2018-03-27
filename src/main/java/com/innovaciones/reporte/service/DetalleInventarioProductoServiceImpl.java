/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.DetalleInventarioProductoDAO;
import com.innovaciones.reporte.model.DetalleInventarioProducto;
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
@ManagedBean(name = "detalleInventarioProductoService")
@ViewScoped
public class DetalleInventarioProductoServiceImpl implements DetalleInventarioProductoService, Serializable {

    @Setter
    private DetalleInventarioProductoDAO detalleInventarioProductoDAO;

    @Override
    @Transactional
    public DetalleInventarioProducto addDetalleInventarioProducto(DetalleInventarioProducto marca) {
        return detalleInventarioProductoDAO.addDetalleInventarioProducto(marca);

    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioProductos() {
        return detalleInventarioProductoDAO.getDetalleInventarioProductos();
    }

    @Override
    @Transactional
    public DetalleInventarioProducto getDetalleInventarioProductoById(Integer id) {
        return detalleInventarioProductoDAO.getDetalleInventarioProductoById(id);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdDetalleInventario(Integer idDetalleInventarioProducto) {
        return detalleInventarioProductoDAO.getDetalleInventarioProductoByIdDetalleInventario(idDetalleInventarioProducto);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdDetalleInventario(Integer idDetalleInventarioProducto, Integer estado) {
        return detalleInventarioProductoDAO.getDetalleInventarioProductoByIdDetalleInventario(idDetalleInventarioProducto, estado);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioProductosByEstado(Integer estado) {
        return detalleInventarioProductoDAO.getDetalleInventarioProductosByEstado(estado);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByProducto(Integer idBodega, Integer idProducto, Integer estado) {
        return detalleInventarioProductoDAO.getDetalleInventarioProductoByProducto(idBodega, idProducto, estado);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioProductoByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado) {
        return detalleInventarioProductoDAO.getDetalleInventarioProductoByIdCabeceraInventario(idCabeceraInventario, estado);
    }

    @Override
    @Transactional
    public DetalleInventarioProducto getBySerial(String serial) {
        return detalleInventarioProductoDAO.getBySerial(serial);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getByIdProductoRepuestoReporte(Integer IdProductoRepuestoReporte) {
        return detalleInventarioProductoDAO.getByIdProductoRepuestoReporte(IdProductoRepuestoReporte);
    }

    @Override
    @Transactional
    public List<DetalleInventarioProducto> getDetalleInventarioByIdBodega(Integer idBodega, Integer estado) {
        return detalleInventarioProductoDAO.getDetalleInventarioByIdBodega(idBodega, estado);
    }

}
