/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.TipoCuentaBancariaDAO;
import com.innovaciones.reporte.model.TipoCuentaBancaria;
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
@ManagedBean(name = "tipoCuentaBancariaService")
@ViewScoped
public class TipoCuentaBancariaServiceImpl implements TipoCuentaBancariaService, Serializable {

    private TipoCuentaBancariaDAO tipoCuentaBancariaDAO;

    public void setTipoCuentaBancariaDAO(TipoCuentaBancariaDAO tipoCuentaBancariaDAO) {
        this.tipoCuentaBancariaDAO = tipoCuentaBancariaDAO;
    }

    @Override
    @Transactional
    public TipoCuentaBancaria addTipoCuentaBancaria(TipoCuentaBancaria tipoCuentaBancaria) {
        return tipoCuentaBancariaDAO.addTipoCuentaBancaria(tipoCuentaBancaria);

    }

    @Override
    @Transactional
    public List<TipoCuentaBancaria> getTipoCuentaBancarias() {
        return tipoCuentaBancariaDAO.getTipoCuentaBancarias();
    }

    @Override
    @Transactional
    public TipoCuentaBancaria getTipoCuentaBancariaById(Integer id) {
        return tipoCuentaBancariaDAO.getTipoCuentaBancariaById(id);
    }

    @Override
    @Transactional
    public List<TipoCuentaBancaria> getTipoCuentaBancariasByEstado(Integer estado) {
        return tipoCuentaBancariaDAO.getTipoCuentaBancariasByEstado(estado);
    }

    @Override
    @Transactional
    public TipoCuentaBancaria saveTipoCuentaBancaria(TipoCuentaBancaria tipoCuentaBancaria) {
        return tipoCuentaBancariaDAO.saveTipoCuentaBancaria(tipoCuentaBancaria);
    }

}
