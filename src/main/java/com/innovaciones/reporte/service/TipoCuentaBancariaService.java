/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.model.TipoCuentaBancaria;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface TipoCuentaBancariaService {

    public TipoCuentaBancaria addTipoCuentaBancaria(TipoCuentaBancaria tipoCuentaBancaria);

    public List<TipoCuentaBancaria> getTipoCuentaBancarias();

    public TipoCuentaBancaria getTipoCuentaBancariaById(Integer id);

    public List<TipoCuentaBancaria> getTipoCuentaBancariasByEstado(Integer estado);
    
    public TipoCuentaBancaria saveTipoCuentaBancaria(TipoCuentaBancaria tipoCuentaBancaria) ;
}
