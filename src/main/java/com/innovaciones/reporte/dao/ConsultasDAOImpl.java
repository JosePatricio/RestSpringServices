/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.ReportesDTO;
import com.innovaciones.reporte.model.DetalleReporteEcu911;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.Reporte;
import com.innovaciones.reporte.util.Utilities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Setter;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pisama
 */
@Repository
public class ConsultasDAOImpl extends Utilities implements ConsultasDAO, Serializable {

    @Setter
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public ReportesDTO reportesById(Integer id) {

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_reportes_by_subtipo ( null ," + id + "  )");

        return this.toList(query).stream().findFirst().get();
    }

    @Override
    @Transactional
    public List<ReportesDTO> reportesBySubTipo(String subTipo) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_reportes_by_subtipo ( '" + subTipo + "' ,null  )");
        return this.toList(query);
    }

    @Override
    @Transactional
    public List<ReportesDTO> reportesInstalaciones() {

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_instalaciones(null)");
        return this.toList(query);
    }

    @Override
    @Transactional
    public ReportesDTO reportesInstalacionesById(Integer id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_instalaciones( " + id + " )     ");
        return this.toList(query).stream().findFirst().get();

    }

    @Override
    @Transactional
    public DetalleReporteEcu911 reportesEcu911ById(Integer id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_reportes_ecu911( " + id + " )     ");
        return this.toListEcu911(query).stream().findFirst().get();
    }

    @Override
    @Transactional
    public List<DetalleReporteEcu911> reportesEcu911() {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_reportes_ecu911(null)");
        return this.toListEcu911(query);
    }

    @Override
    @Transactional
    public List<DetalleReporteEcu911> reportesEcu911ByUserId(Integer id, Integer idProyecto) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("call sp_reportes_ecu911_by_user(null," + id + "," + idProyecto + ")");
        return this.toListEcu911(query);
    }

    private List<ReportesDTO> toList(SQLQuery sql) {
        List<Object[]> result = sql.list();
        List<ReportesDTO> reporteLista = new ArrayList<ReportesDTO>();
        ReportesDTO reporte;
        for (int i = 0; i < result.size(); i++) {
            Object[] data = result.get(i);
            reporte = new ReportesDTO();
            reporte.setId(Integer.parseInt(data[0].toString()));
            reporte.setNumeroFactura(data[1] == null ? "" : data[1].toString());
            reporte.setFactura(data[2] == null ? "" : data[2].toString());
            reporte.setEquipo(data[3] == null ? "" : data[3].toString());
            reporte.setRuc(data[4].toString());
            reporte.setCliente(data[5].toString());
            reporte.setCiudad(data[6].toString());
            reporte.setEmail(data[7].toString());
            reporte.setSoporte(data[8].toString());
            reporte.setFecha((Date) data[9]);
            reporte.setTipoReporte(data[10] == null ? "" : data[10].toString());
            reporte.setSerial(data[11] == null ? "" : data[11].toString());
            reporte.setTipo(data[12].toString());
            reporte.setEstado(data[13].toString());
            reporte.setSubtipo(data[14].toString());
            reporte.setCodigoTecnico(data[15].toString());
            reporteLista.add(reporte);
        }
        return reporteLista;
    }

    private List<DetalleReporteEcu911> toListEcu911(SQLQuery sql) {
        List<Object[]> result = sql.list();

        List<DetalleReporteEcu911> reporteLista = new ArrayList<DetalleReporteEcu911>();
        DetalleReporteEcu911 reporte;
        ProductoClienteReporte productoClienteReporte;
        for (int i = 0; i < result.size(); i++) {
            Object[] data = result.get(i);
            reporte = new DetalleReporteEcu911();
            reporte.setIdReporte(new Reporte());
            productoClienteReporte = new ProductoClienteReporte();
            reporte.setProductoClienteReporte(new ProductoClienteReporte());
            reporte.setNumeroFactura(data[0].toString());
            reporte.setCodigoTecnico(data[1].toString());
            reporte.setNombre_soporte(data[2].toString());

            reporte.setFecha((Date) data[3]);
            reporte.setFactura(data[4].toString());
            reporte.setCliente(data[5].toString());
            reporte.getIdReporte().setTipo(data[6].toString());
            reporte.getIdReporte().setSubtipo(data[7].toString());
            reporte.getIdReporte().setEstado(data[8].toString());
            reporte.getIdReporte().setNotas(data[9].toString());

            reporte.setId(Integer.parseInt(data[10].toString()));
            reporte.getIdReporte().setId(Integer.parseInt(data[11].toString()));

            reporte.setBastidorMarca(data[12].toString());
            reporte.setBastidorModelo(data[13].toString());
            reporte.setBastidorSerie(data[14].toString());
            reporte.setPantallaSeparacionCubosVs(data[15].toString());
            reporte.setPantallaSeparacionCubosVi(data[16].toString());

            reporte.setBastidorObservacion(data[17].toString());

            reporte.setPantallaMarca(data[18].toString());
            reporte.setPantallaModelo(data[19].toString());
            reporte.setPantallaSerie(data[20].toString());
            reporte.setPantallaSeparacionCubosHd(data[21].toString());
            reporte.setPantallaSeparacionCubosHi(data[22].toString());
            reporte.setPantallaObservacion(data[23].toString());

            reporte.setEngineMarca(data[24].toString());
            reporte.setEngineModelo(data[25].toString());

            reporte.setEngineSerie(data[26].toString());
            reporte.setEngineDireccionIp(data[27].toString());
            reporte.setEngineModoOperacion(data[28].toString());
            reporte.setEngineIdUnidad(data[29].toString());

            //reporte.setUbicacionFila(Integer.parseInt(data[30].toString()));
            reporte.setEngineMascaraSubred(data[31].toString());
            reporte.setEngineVersionFw(data[32].toString());
            reporte.setEngineTiempoUso(data[33].toString());
            //reporte.setUbicacionColumna(Integer.parseInt(data[34].toString()));
            reporte.setEnginePuertaEnlace(data[35].toString());
            reporte.setEngineObservacion(data[36].toString());

            reporte.setLamparaMarca(data[37].toString());
            reporte.setLamparaModelo(data[38].toString());
            reporte.setLamparaVoltaje(BigDecimal.valueOf(Double.parseDouble(data[39].toString())));
            // reporte.setLamparaTiempoUso(Integer.parseInt(data[40].toString()));
            reporte.setLamparaASerial(data[41].toString());
            reporte.setLamparaAEstado(data[42].toString());
            reporte.setLamparaATiempoUso(data[43].toString());
            reporte.setLamparaBSerial(data[44].toString());
            reporte.setLamparaBEstado(data[45].toString());
            reporte.setLamparaBTiempoUso(data[46].toString());
            reporte.setLamparaObservacion(data[47].toString());

            reporte.setTarjetaSlot1Modelo(data[48].toString());
            reporte.setTarjetaSlot1EntradaDigital((Integer.parseInt(data[49].toString()) == 1));
            reporte.setTarjetaSlot1EntradaAnalogico((Integer.parseInt(data[50].toString()) == 1));
            reporte.setTarjetaSlot1EntradaVideo((Integer.parseInt(data[51].toString()) == 1));
            reporte.setTarjetaSlot1SalidaDigital((Integer.parseInt(data[52].toString()) == 1));
            reporte.setTarjetaSlot2Modelo(data[53].toString());
            reporte.setTarjetaSlot2EntradaDigital((Integer.parseInt(data[54].toString()) == 1));
            reporte.setTarjetaSlot2EntradaAnalogico((Integer.parseInt(data[55].toString()) == 1));
            reporte.setTarjetaSlot2EntradaVideo((Integer.parseInt(data[56].toString()) == 1));
            reporte.setTarjetaSlot2SalidaDigital((Integer.parseInt(data[57].toString()) == 1));
            reporte.setTarjetaSlot3Modelo(data[58].toString());
            reporte.setTarjetaSlot3EntradaDigital((Integer.parseInt(data[59].toString()) == 1));
            reporte.setTarjetaSlot3EntradaAnalogico((Integer.parseInt(data[60].toString()) == 1));
            reporte.setTarjetaSlot3EntradaVideo((Integer.parseInt(data[61].toString()) == 1));
            reporte.setTarjetaSlot3SalidaDigital((Integer.parseInt(data[62].toString()) == 1));

            reporte.setTarjetaFuente(data[63].toString());
            reporte.setTarjetaFiltro(data[64].toString());
            reporte.setTarjetaBalastroA(data[65].toString());
            reporte.setTarjetaBalastroB(data[66].toString());
            reporte.setTarjetaObservacion(data[67].toString());

            reporte.setTemperaturaFuentePcb1Temp(BigDecimal.valueOf(Double.parseDouble(data[68].toString())));
            reporte.setTemperaturaFuentePcb1TempMax(BigDecimal.valueOf(Double.parseDouble(data[69].toString())));
            reporte.setTemperaturaFuentePcb1Estado(data[70].toString());
            reporte.setTemperaturaFuentePcb2Temp(BigDecimal.valueOf(Double.parseDouble(data[71].toString())));
            reporte.setTemperaturaFuentePcb2TempMax(BigDecimal.valueOf(Double.parseDouble(data[72].toString())));
            reporte.setTemperaturaFuentePcb2Estado(data[73].toString());

            reporte.setTemperaturaChipDlpTemp(BigDecimal.valueOf(Double.parseDouble(data[74].toString())));
            reporte.setTemperaturaChipDlpTempMax(BigDecimal.valueOf(Double.parseDouble(data[75].toString())));
            reporte.setTemperaturaChipDlpEstado(data[76].toString());

            reporte.setTemperaturaLamparaATemp(BigDecimal.valueOf(Double.parseDouble(data[77].toString())));
            reporte.setTemperaturaLamparaATempMax(BigDecimal.valueOf(Double.parseDouble(data[78].toString())));
            reporte.setTemperaturaLamparaAEstado(data[79].toString());

            reporte.setTemperaturaLamparaBTemp(BigDecimal.valueOf(Double.parseDouble(data[80].toString())));
            reporte.setTemperaturaLamparaBTempMax(BigDecimal.valueOf(Double.parseDouble(data[81].toString())));
            reporte.setTemperaturaLamparaBEstado(data[82].toString());
            reporte.setTemperaturaObservacion(data[83].toString());

            reporte.setImagenDisplayMemory(data[84].toString());
            reporte.setImagenInputMemory(data[85].toString());
            reporte.setImagenResolucion(data[86].toString());
            reporte.setImagenBrillo(data[87].toString());
            reporte.setImagenForegroundWindows(data[88].toString());
            reporte.setImagenInputSlot(data[89].toString());
            reporte.setImagenInputSlotType(data[90].toString());
            reporte.setImagenContraste(data[91].toString());
            reporte.setImagenStatus(data[92].toString());
            reporte.setImagenRuedaColor(data[93].toString());
            reporte.setImagenRojoIniciales(data[94].toString());
            reporte.setImagenRojoActuales(data[95].toString());
            reporte.setImagenVerdeIniciales(data[96].toString());
            reporte.setImagenVerdeActuales(data[97].toString());
            reporte.setImagenAzulIniciales(data[98].toString());
            reporte.setImagenAzulActuales(data[99].toString());
            reporte.setImagenObservacion(data[100].toString());
            reporte.setNumeroCubos(Integer.parseInt(data[101].toString()));
            reporte.setDimensionFilas(Integer.parseInt(data[102].toString()));
            reporte.setDimensionColumnas(Integer.parseInt(data[103].toString()));
            reporte.setMatrizUbicacionBase64(data[104].toString());
            reporte.setCiudad(data[105].toString());
            productoClienteReporte.setCiudad(data[105].toString());
            reporte.getIdReporte().setReferencia(data[106].toString());
            productoClienteReporte.setAtencion(data[107].toString());
            reporte.setCorreo(data[108].toString());
            reporte.getIdReporte().setObservacionesRecomendaciones(data[109].toString());
            reporte.getIdReporte().setHoraInicio((Date) data[110]);
            reporte.getIdReporte().setHoraFin((Date) data[111]);
            reporte.getIdReporte().setNombreCliente(data[112].toString());
            reporte.getIdReporte().setNumeroReporteTecnico(data[113].toString());
            reporte.setNumeroFacturaTecnico(data[1].toString() + "-" + formatoNumeroFactura(Integer.parseInt(data[0].toString())));
            reporte.setProductoClienteReporte(productoClienteReporte);
            reporteLista.add(reporte);
        }
        return reporteLista;
    }

}
