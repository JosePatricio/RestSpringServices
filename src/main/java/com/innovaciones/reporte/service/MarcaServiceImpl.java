/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.MarcaDAO;
import com.innovaciones.reporte.model.Marca;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Service
@ManagedBean(name = "marcaService")
@ViewScoped
public class MarcaServiceImpl implements MarcaService, Serializable {

    private MarcaDAO marcaDAO;

    public void setMarcaDAO(MarcaDAO marcaDAO) {
        this.marcaDAO = marcaDAO;
    }

    @Override
    @Transactional
    public Marca addMarca(Marca marca) {
        return marcaDAO.addMarca(marca);

    }

    @Override
    @Transactional
    public List<Marca> getMarcas() {
        return marcaDAO.getMarcas();
    }

    @Override
    @Transactional
    public Marca getMarcaById(Integer id) {
        return marcaDAO.getMarcaById(id);
    }

    @Override
    @Transactional
    public Marca getMarcaByCodigo(String codigo) {
        return marcaDAO.getMarcaByCodigo(codigo);
    }

    @Override
    @Transactional
    public Marca getMarcaByNombre(String nombre) {
        return marcaDAO.getMarcaByNombre(nombre);
    }

    @Override
    @Transactional
    public List<Marca> getMarcasByEstado(Integer estado) {
        return marcaDAO.getMarcasByEstado(estado);
    }

    @Override
    @Transactional
    public Marca saveMarca(Marca marca) {
        return marcaDAO.saveMarca(marca);
    }

//    @Override
//    @Transactional
//    public List<Marca> getMarcasLazy(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters) throws IntrospectionException {
//        return marcaDAO.getMarcasLazy(start, size, sortField, sortOrder, filters);
//    }
}
