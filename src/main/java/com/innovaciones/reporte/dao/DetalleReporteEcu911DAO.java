/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DetalleReporteEcu911;
import java.util.List;

/**
 *
 * @author fyaulema
 */
public interface DetalleReporteEcu911DAO {

    public DetalleReporteEcu911 save(DetalleReporteEcu911 detalleReporteEcu911);

    public DetalleReporteEcu911 update(DetalleReporteEcu911 detalleReporteEcu911);

    public void delete(DetalleReporteEcu911 detalleReporteEcu911);

    public DetalleReporteEcu911 getByIdReporte(Integer id);
    
    public List<DetalleReporteEcu911> getAll();
    
    
}
