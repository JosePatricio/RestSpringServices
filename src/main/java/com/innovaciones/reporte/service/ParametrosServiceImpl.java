/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.ModeloDAO;
import com.innovaciones.reporte.dao.ParametrosDAO;
import com.innovaciones.reporte.model.Modelo;
import com.innovaciones.reporte.model.Parametros;
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
@ManagedBean(name = "parametrosService")
@ViewScoped
public class ParametrosServiceImpl implements ParametrosService, Serializable {

    @Setter
    private ParametrosDAO parametrosDAO;

    @Override
    @Transactional
    public Parametros getByParametro(String parametro) {
        return parametrosDAO.getByParametro(parametro);
    }

}
