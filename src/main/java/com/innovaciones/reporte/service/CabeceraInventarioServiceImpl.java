/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.CabeceraInventarioDAO;
import com.innovaciones.reporte.model.CabeceraInventario;
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
@ManagedBean(name = "cabeceraInventarioService")
@ViewScoped
public class CabeceraInventarioServiceImpl implements CabeceraInventarioService, Serializable {

    private CabeceraInventarioDAO cabeceraInventarioDAO;

    public void setCabeceraInventarioDAO(CabeceraInventarioDAO cabeceraInventarioDAO) {
        this.cabeceraInventarioDAO = cabeceraInventarioDAO;
    }

    @Override
    @Transactional
    public CabeceraInventario addCabeceraInventario(CabeceraInventario cabeceraInventario) {
        return cabeceraInventarioDAO.addCabeceraInventario(cabeceraInventario);
    }

    @Override
    @Transactional
    public List<CabeceraInventario> getCabeceraInventarios(Integer idBodega) {
        return cabeceraInventarioDAO.getCabeceraInventarios(idBodega);
    }

    @Override
    @Transactional
    public CabeceraInventario getCabeceraInventarioById(Integer id) {
        return cabeceraInventarioDAO.getCabeceraInventarioById(id);
    }

    @Override
    @Transactional
    public CabeceraInventario getCabeceraInventarioByCodigo(String codigo) {
        return cabeceraInventarioDAO.getCabeceraInventarioByCodigo(codigo);
    }

    @Override
    @Transactional
    public List<CabeceraInventario> getCabeceraInventariosByEstado(Integer idBodega, Integer estado) {
        return cabeceraInventarioDAO.getCabeceraInventariosByEstado(idBodega, estado);
    }

    @Override
    @Transactional
    public String getCountInventarios() {

        Integer count = cabeceraInventarioDAO.getCountInventarios();
        count++;
        String result = "INV-";

        if (count < 10) {
            result += "000";
        } else {
            if (count < 100) {
                result += "00";
            } else {
                if (count < 1000) {
                    result += "0";
                }
            }
        }
        result += count;

        return result;
    }

}
