/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.service;

import com.innovaciones.reporte.dao.CabeceraEgresoDAO;
import com.innovaciones.reporte.model.CabeceraEgreso;
import com.innovaciones.reporte.util.Enums;
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
@ManagedBean(name = "cabeceraEgresoService")
@ViewScoped
public class CabeceraEgresoServiceImpl implements CabeceraEgresoService, Serializable {

    private CabeceraEgresoDAO cabeceraEgresoDAO;

    public void setCabeceraEgresoDAO(CabeceraEgresoDAO cabeceraEgresoDAO) {
        this.cabeceraEgresoDAO = cabeceraEgresoDAO;
    }

    @Override
    @Transactional
    public CabeceraEgreso addCabeceraEgreso(CabeceraEgreso cabeceraEgreso) {
        return cabeceraEgresoDAO.addCabeceraEgreso(cabeceraEgreso);
    }

    @Override
    @Transactional
    public List<CabeceraEgreso> getCabeceraEgresos(Integer idbodega, String tipo) {
        return cabeceraEgresoDAO.getCabeceraEgresos(idbodega, tipo);
    }

    @Override
    @Transactional
    public CabeceraEgreso getCabeceraEgresoById(Integer id) {
        return cabeceraEgresoDAO.getCabeceraEgresoById(id);
    }

    @Override
    @Transactional
    public CabeceraEgreso getCabeceraEgresoByCodigo(String codigo) {
        return cabeceraEgresoDAO.getCabeceraEgresoByCodigo(codigo);
    }

    @Override
    @Transactional
    public List<CabeceraEgreso> getCabeceraEgresosByEstado(String tipo, Integer estado) {
        return cabeceraEgresoDAO.getCabeceraEgresosByEstado(tipo, estado);
    }

    @Override
    @Transactional
    public String getCountEgresos(String tipo) {

        Integer count = cabeceraEgresoDAO.getCountEgresos(tipo);
        count++;

        String result = "";

        if (tipo.equalsIgnoreCase(Enums.TIPO_EGRESO_BODEGA.getValue())) {
            result = Enums.TIPO_EGRESO_BODEGA.getValue() + "-000";
        } else {
            if (tipo.equalsIgnoreCase(Enums.TIPO_EGRESO_CONTRATO.getValue())) {
                result = Enums.TIPO_EGRESO_CONTRATO.getValue() + "-000";
            }
        }

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

    @Override
    @Transactional
    public CabeceraEgreso actualizarStockSolicitado(Integer idCabecereaEgreso) {
        return cabeceraEgresoDAO.actualizarStockSolicitado(idCabecereaEgreso);
    }

    @Override
    @Transactional
    public CabeceraEgreso actualizarStockEgresado(Integer idCabecereaEgreso) {
        return cabeceraEgresoDAO.actualizarStockEgresado(idCabecereaEgreso);
    }

    @Override
    @Transactional
    public CabeceraEgreso actualizarStockDevuelto(Integer idCabeceraEgreso) {
        return cabeceraEgresoDAO.actualizarStockDevuelto(idCabeceraEgreso);
    }

    @Override
    @Transactional
    public CabeceraEgreso actualizarStockSolicitadoEgresado(Integer idCabecereaEgreso) {
        return cabeceraEgresoDAO.actualizarStockSolicitadoEgresado(idCabecereaEgreso);
    }
//    @Override
//    @Transactional
//    public Integer calcularNumIngresosEgresos(Integer idCabecera) {
//        return cabeceraEgresoDAO.calcularNumIngresosEgresos(idCabecera);
//    }

}
