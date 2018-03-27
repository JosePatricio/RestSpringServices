/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pisama
 */
@Entity
@Table(name = "detalle_reporte_ecu911")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReporteEcu911.findAll", query = "SELECT d FROM DetalleReporteEcu911 d")})
public class DetalleReporteEcu911 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bastidor_marca")
    private String bastidorMarca;
    @Column(name = "bastidor_modelo")
    private String bastidorModelo;
    @Column(name = "bastidor_serie")
    private String bastidorSerie;
    @Column(name = "bastidor_observacion")
    private String bastidorObservacion;
    @Column(name = "pantalla_marca")
    private String pantallaMarca;
    @Column(name = "pantalla_modelo")
    private String pantallaModelo;
    @Column(name = "pantalla_serie")
    private String pantallaSerie;
    @Column(name = "pantalla_separacion_cubos_hd")
    private String pantallaSeparacionCubosHd;
    @Column(name = "pantalla_separacion_cubos_hi")
    private String pantallaSeparacionCubosHi;
    @Column(name = "pantalla_separacion_cubos_vs")
    private String pantallaSeparacionCubosVs;
    @Column(name = "pantalla_separacion_cubos_vi")
    private String pantallaSeparacionCubosVi;
    @Column(name = "pantalla_observacion")
    private String pantallaObservacion;
    @Column(name = "engine_marca")
    private String engineMarca;
    @Column(name = "engine_modelo")
    private String engineModelo;
    @Column(name = "engine_serie")
    private String engineSerie;
    @Column(name = "engine_direccion_ip")
    private String engineDireccionIp;
    @Column(name = "engine_modo_operacion")
    private String engineModoOperacion;
    @Column(name = "engine_id_unidad")
    private String engineIdUnidad;
    @Column(name = "engine_mascara_subred")
    private String engineMascaraSubred;
    @Column(name = "engine_version_fw")
    private String engineVersionFw;
    @Column(name = "engine_tiempo_uso")
    private String engineTiempoUso;
    @Column(name = "engine_puerta_enlace")
    private String enginePuertaEnlace;
    @Column(name = "engine_observacion")
    private String engineObservacion;
    @Column(name = "lampara_marca")
    private String lamparaMarca;
    @Column(name = "lampara_modelo")
    private String lamparaModelo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lampara_voltaje")
    private BigDecimal lamparaVoltaje;

    @Column(name = "lampara_a_serial")
    private String lamparaASerial;
    @Column(name = "lampara_a_estado")
    private String lamparaAEstado;
    @Column(name = "lampara_a_tiempo_uso")
    private String lamparaATiempoUso;
    @Column(name = "lampara_b_serial")
    private String lamparaBSerial;
    @Column(name = "lampara_b_estado")
    private String lamparaBEstado;
    @Column(name = "lampara_b_tiempo_uso")
    private String lamparaBTiempoUso;
    @Column(name = "lampara_observacion")
    private String lamparaObservacion;
    @Column(name = "tarjeta_slot1_modelo")
    private String tarjetaSlot1Modelo;
    @Column(name = "tarjeta_slot1_entrada_digital")
    private Boolean tarjetaSlot1EntradaDigital;
    @Column(name = "tarjeta_slot1_entrada_analogico")
    private Boolean tarjetaSlot1EntradaAnalogico;
    @Column(name = "tarjeta_slot1_entrada_video")
    private Boolean tarjetaSlot1EntradaVideo;
    @Column(name = "tarjeta_slot1_salida_digital")
    private Boolean tarjetaSlot1SalidaDigital;
    @Column(name = "tarjeta_slot2_modelo")
    private String tarjetaSlot2Modelo;
    @Column(name = "tarjeta_slot2_entrada_digital")
    private Boolean tarjetaSlot2EntradaDigital;
    @Column(name = "tarjeta_slot2_entrada_analogico")
    private Boolean tarjetaSlot2EntradaAnalogico;
    @Column(name = "tarjeta_slot2_entrada_video")
    private Boolean tarjetaSlot2EntradaVideo;
    @Column(name = "tarjeta_slot2_salida_digital")
    private Boolean tarjetaSlot2SalidaDigital;
    @Column(name = "tarjeta_slot3_modelo")
    private String tarjetaSlot3Modelo;
    @Column(name = "tarjeta_slot3_entrada_digital")
    private Boolean tarjetaSlot3EntradaDigital;
    @Column(name = "tarjeta_slot3_entrada_analogico")
    private Boolean tarjetaSlot3EntradaAnalogico;
    @Column(name = "tarjeta_slot3_entrada_video")
    private Boolean tarjetaSlot3EntradaVideo;
    @Column(name = "tarjeta_slot3_salida_digital")
    private Boolean tarjetaSlot3SalidaDigital;
    @Column(name = "tarjeta_fuente")
    private String tarjetaFuente;
    @Column(name = "tarjeta_filtro")
    private String tarjetaFiltro;
    @Column(name = "tarjeta_balastro_a")
    private String tarjetaBalastroA;
    @Column(name = "tarjeta_balastro_b")
    private String tarjetaBalastroB;
    @Column(name = "tarjeta_observacion")
    private String tarjetaObservacion;
    @Column(name = "temperatura_fuente_pcb1_temp")
    private BigDecimal temperaturaFuentePcb1Temp;
    @Column(name = "temperatura_fuente_pcb1_temp_max")
    private BigDecimal temperaturaFuentePcb1TempMax;
    @Column(name = "temperatura_fuente_pcb1_estado")
    private String temperaturaFuentePcb1Estado;
    @Column(name = "temperatura_fuente_pcb2_temp")
    private BigDecimal temperaturaFuentePcb2Temp;
    @Column(name = "temperatura_fuente_pcb2_temp_max")
    private BigDecimal temperaturaFuentePcb2TempMax;
    @Column(name = "temperatura_fuente_pcb2_estado")
    private String temperaturaFuentePcb2Estado;
    @Column(name = "temperatura_chip_dlp_temp")
    private BigDecimal temperaturaChipDlpTemp;
    @Column(name = "temperatura_chip_dlp_temp_max")
    private BigDecimal temperaturaChipDlpTempMax;
    @Column(name = "temperatura_chip_dlp_estado")
    private String temperaturaChipDlpEstado;
    @Column(name = "temperatura_lampara_a_temp")
    private BigDecimal temperaturaLamparaATemp;
    @Column(name = "temperatura_lampara_a_temp_max")
    private BigDecimal temperaturaLamparaATempMax;
    @Column(name = "temperatura_lampara_a_estado")
    private String temperaturaLamparaAEstado;
    @Column(name = "temperatura_lampara_b_temp")
    private BigDecimal temperaturaLamparaBTemp;
    @Column(name = "temperatura_lampara_b_temp_max")
    private BigDecimal temperaturaLamparaBTempMax;
    @Column(name = "temperatura_lampara_b_estado")
    private String temperaturaLamparaBEstado;
    @Column(name = "temperatura_observacion")
    private String temperaturaObservacion;
    @Column(name = "imagen_display_memory")
    private String imagenDisplayMemory;
    @Column(name = "imagen_input_memory")
    private String imagenInputMemory;
    @Column(name = "imagen_resolucion")
    private String imagenResolucion;
    @Column(name = "imagen_brillo")
    private String imagenBrillo;
    @Column(name = "imagen_foreground_windows")
    private String imagenForegroundWindows;
    @Column(name = "imagen_input_slot")
    private String imagenInputSlot;
    @Column(name = "imagen_input_slot_type")
    private String imagenInputSlotType;
    @Column(name = "imagen_contraste")
    private String imagenContraste;
    @Column(name = "imagen_status")
    private String imagenStatus;
    @Column(name = "imagen_rueda_color")
    private String imagenRuedaColor;
    @Column(name = "imagen_rojo_iniciales")
    private String imagenRojoIniciales;
    @Column(name = "imagen_rojo_actuales")
    private String imagenRojoActuales;
    @Column(name = "imagen_verde_iniciales")
    private String imagenVerdeIniciales;
    @Column(name = "imagen_verde_actuales")
    private String imagenVerdeActuales;
    @Column(name = "imagen_azul_iniciales")
    private String imagenAzulIniciales;
    @Column(name = "imagen_azul_actuales")
    private String imagenAzulActuales;
    @Column(name = "imagen_observacion")
    private String imagenObservacion;
    @Column(name = "numero_cubos")
    private Integer numeroCubos;
    @Column(name = "dimension_filas")
    private Integer dimensionFilas;
    @Column(name = "dimension_columnas")
    private Integer dimensionColumnas;
    @Lob
    @Column(name = "matriz_ubicacion_base64")
    private String matrizUbicacionBase64;
    @JoinColumn(name = "id_reporte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reporte idReporte;

    @Transient
    @Getter
    @Setter
    private String factura;

    @Transient
    @Getter
    @Setter
    private String numeroFactura;

    @Transient
    @Getter
    @Setter
    private String cliente;

    @Transient
    @Getter
    @Setter
    private String nombre_soporte;

    @Transient
    @Getter
    @Setter
    private Date fecha;

    @Transient
    @Getter
    @Setter
    private String codigoTecnico;

    @Transient
    @Getter
    @Setter
    private String ciudad;

    @Transient
    @Getter
    @Setter
    private String numeroFacturaTecnico;

    @Transient
    @Getter
    @Setter
    private String atencion;

    @Transient
    @Getter
    @Setter
    private String referencia;

    @Transient
    @Getter
    @Setter
    private String correo;

    @Transient
    @Getter
    @Setter
    private ProductoClienteReporte productoClienteReporte;

    @Transient
    @Getter
    @Setter
    private String subtipo;

    @Transient
    @Getter
    @Setter
    private String nombreCliente;

    @Transient
    @Getter
    @Setter
    private Date horaInicio;

    @Transient
    @Getter
    @Setter
    private Date horaFin;

    @Transient
    @Getter
    @Setter
    private String observacionRecomendacion;

    @Transient
    @Getter
    @Setter
    private Boolean ed1;

    @Transient
    @Getter
    @Setter
    private Boolean ea1;

    @Transient
    @Getter
    @Setter
    private Boolean ev1;

    @Transient
    @Getter
    @Setter
    private Boolean sd1;

    @Transient
    @Getter
    @Setter
    private Boolean ed2;

    @Transient
    @Getter
    @Setter
    private Boolean ea2;

    @Transient
    @Getter
    @Setter
    private Boolean ev2;

    @Transient
    @Getter
    @Setter
    private Boolean sd2;

    @Transient
    @Getter
    @Setter
    private Boolean ed3;

    @Transient
    @Getter
    @Setter
    private Boolean ea3;

    @Transient
    @Getter
    @Setter
    private Boolean ev3;

    @Transient
    @Getter
    @Setter
    private Boolean sd3;

    public DetalleReporteEcu911() {
    }

    public DetalleReporteEcu911(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBastidorMarca() {
        return bastidorMarca;
    }

    public void setBastidorMarca(String bastidorMarca) {
        this.bastidorMarca = bastidorMarca;
    }

    public String getBastidorModelo() {
        return bastidorModelo;
    }

    public void setBastidorModelo(String bastidorModelo) {
        this.bastidorModelo = bastidorModelo;
    }

    public String getBastidorSerie() {
        return bastidorSerie;
    }

    public void setBastidorSerie(String bastidorSerie) {
        this.bastidorSerie = bastidorSerie;
    }

    public String getBastidorObservacion() {
        return bastidorObservacion;
    }

    public void setBastidorObservacion(String bastidorObservacion) {
        this.bastidorObservacion = bastidorObservacion;
    }

    public String getPantallaMarca() {
        return pantallaMarca;
    }

    public void setPantallaMarca(String pantallaMarca) {
        this.pantallaMarca = pantallaMarca;
    }

    public String getPantallaModelo() {
        return pantallaModelo;
    }

    public void setPantallaModelo(String pantallaModelo) {
        this.pantallaModelo = pantallaModelo;
    }

    public String getPantallaSerie() {
        return pantallaSerie;
    }

    public void setPantallaSerie(String pantallaSerie) {
        this.pantallaSerie = pantallaSerie;
    }

    public String getPantallaSeparacionCubosHd() {
        return pantallaSeparacionCubosHd;
    }

    public void setPantallaSeparacionCubosHd(String pantallaSeparacionCubosHd) {
        this.pantallaSeparacionCubosHd = pantallaSeparacionCubosHd;
    }

    public String getPantallaSeparacionCubosHi() {
        return pantallaSeparacionCubosHi;
    }

    public void setPantallaSeparacionCubosHi(String pantallaSeparacionCubosHi) {
        this.pantallaSeparacionCubosHi = pantallaSeparacionCubosHi;
    }

    public String getPantallaSeparacionCubosVs() {
        return pantallaSeparacionCubosVs;
    }

    public void setPantallaSeparacionCubosVs(String pantallaSeparacionCubosVs) {
        this.pantallaSeparacionCubosVs = pantallaSeparacionCubosVs;
    }

    public String getPantallaSeparacionCubosVi() {
        return pantallaSeparacionCubosVi;
    }

    public void setPantallaSeparacionCubosVi(String pantallaSeparacionCubosVi) {
        this.pantallaSeparacionCubosVi = pantallaSeparacionCubosVi;
    }

    public String getPantallaObservacion() {
        return pantallaObservacion;
    }

    public void setPantallaObservacion(String pantallaObservacion) {
        this.pantallaObservacion = pantallaObservacion;
    }

    public String getEngineMarca() {
        return engineMarca;
    }

    public void setEngineMarca(String engineMarca) {
        this.engineMarca = engineMarca;
    }

    public String getEngineModelo() {
        return engineModelo;
    }

    public void setEngineModelo(String engineModelo) {
        this.engineModelo = engineModelo;
    }

    public String getEngineSerie() {
        return engineSerie;
    }

    public void setEngineSerie(String engineSerie) {
        this.engineSerie = engineSerie;
    }

    public String getEngineDireccionIp() {
        return engineDireccionIp;
    }

    public void setEngineDireccionIp(String engineDireccionIp) {
        this.engineDireccionIp = engineDireccionIp;
    }

    public String getEngineModoOperacion() {
        return engineModoOperacion;
    }

    public void setEngineModoOperacion(String engineModoOperacion) {
        this.engineModoOperacion = engineModoOperacion;
    }

    public String getEngineIdUnidad() {
        return engineIdUnidad;
    }

    public void setEngineIdUnidad(String engineIdUnidad) {
        this.engineIdUnidad = engineIdUnidad;
    }

    public String getEngineMascaraSubred() {
        return engineMascaraSubred;
    }

    public void setEngineMascaraSubred(String engineMascaraSubred) {
        this.engineMascaraSubred = engineMascaraSubred;
    }

    public String getEngineVersionFw() {
        return engineVersionFw;
    }

    public void setEngineVersionFw(String engineVersionFw) {
        this.engineVersionFw = engineVersionFw;
    }

    public String getEngineTiempoUso() {
        return engineTiempoUso;
    }

    public void setEngineTiempoUso(String engineTiempoUso) {
        this.engineTiempoUso = engineTiempoUso;
    }

    public String getEnginePuertaEnlace() {
        return enginePuertaEnlace;
    }

    public void setEnginePuertaEnlace(String enginePuertaEnlace) {
        this.enginePuertaEnlace = enginePuertaEnlace;
    }

    public String getEngineObservacion() {
        return engineObservacion;
    }

    public void setEngineObservacion(String engineObservacion) {
        this.engineObservacion = engineObservacion;
    }

    public String getLamparaMarca() {
        return lamparaMarca;
    }

    public void setLamparaMarca(String lamparaMarca) {
        this.lamparaMarca = lamparaMarca;
    }

    public String getLamparaModelo() {
        return lamparaModelo;
    }

    public void setLamparaModelo(String lamparaModelo) {
        this.lamparaModelo = lamparaModelo;
    }

    public BigDecimal getLamparaVoltaje() {
        return lamparaVoltaje;
    }

    public void setLamparaVoltaje(BigDecimal lamparaVoltaje) {
        this.lamparaVoltaje = lamparaVoltaje;
    }

    public String getLamparaASerial() {
        return lamparaASerial;
    }

    public void setLamparaASerial(String lamparaASerial) {
        this.lamparaASerial = lamparaASerial;
    }

    public String getLamparaAEstado() {
        return lamparaAEstado;
    }

    public void setLamparaAEstado(String lamparaAEstado) {
        this.lamparaAEstado = lamparaAEstado;
    }

    public String getLamparaATiempoUso() {
        return lamparaATiempoUso;
    }

    public void setLamparaATiempoUso(String lamparaATiempoUso) {
        this.lamparaATiempoUso = lamparaATiempoUso;
    }

    public String getLamparaBSerial() {
        return lamparaBSerial;
    }

    public void setLamparaBSerial(String lamparaBSerial) {
        this.lamparaBSerial = lamparaBSerial;
    }

    public String getLamparaBEstado() {
        return lamparaBEstado;
    }

    public void setLamparaBEstado(String lamparaBEstado) {
        this.lamparaBEstado = lamparaBEstado;
    }

    public String getLamparaBTiempoUso() {
        return lamparaBTiempoUso;
    }

    public void setLamparaBTiempoUso(String lamparaBTiempoUso) {
        this.lamparaBTiempoUso = lamparaBTiempoUso;
    }

    public String getLamparaObservacion() {
        return lamparaObservacion;
    }

    public void setLamparaObservacion(String lamparaObservacion) {
        this.lamparaObservacion = lamparaObservacion;
    }

    public String getTarjetaSlot1Modelo() {
        return tarjetaSlot1Modelo;
    }

    public void setTarjetaSlot1Modelo(String tarjetaSlot1Modelo) {
        this.tarjetaSlot1Modelo = tarjetaSlot1Modelo;
    }

    public Boolean getTarjetaSlot1EntradaDigital() {
        return tarjetaSlot1EntradaDigital;
    }

    public void setTarjetaSlot1EntradaDigital(Boolean tarjetaSlot1EntradaDigital) {
        this.tarjetaSlot1EntradaDigital = tarjetaSlot1EntradaDigital;
    }

    public Boolean getTarjetaSlot1EntradaAnalogico() {
        return tarjetaSlot1EntradaAnalogico;
    }

    public void setTarjetaSlot1EntradaAnalogico(Boolean tarjetaSlot1EntradaAnalogico) {
        this.tarjetaSlot1EntradaAnalogico = tarjetaSlot1EntradaAnalogico;
    }

    public Boolean getTarjetaSlot1EntradaVideo() {
        return tarjetaSlot1EntradaVideo;
    }

    public void setTarjetaSlot1EntradaVideo(Boolean tarjetaSlot1EntradaVideo) {
        this.tarjetaSlot1EntradaVideo = tarjetaSlot1EntradaVideo;
    }

    public Boolean getTarjetaSlot1SalidaDigital() {
        return tarjetaSlot1SalidaDigital;
    }

    public void setTarjetaSlot1SalidaDigital(Boolean tarjetaSlot1SalidaDigital) {
        this.tarjetaSlot1SalidaDigital = tarjetaSlot1SalidaDigital;
    }

    public String getTarjetaSlot2Modelo() {
        return tarjetaSlot2Modelo;
    }

    public void setTarjetaSlot2Modelo(String tarjetaSlot2Modelo) {
        this.tarjetaSlot2Modelo = tarjetaSlot2Modelo;
    }

    public Boolean getTarjetaSlot2EntradaDigital() {
        return tarjetaSlot2EntradaDigital;
    }

    public void setTarjetaSlot2EntradaDigital(Boolean tarjetaSlot2EntradaDigital) {
        this.tarjetaSlot2EntradaDigital = tarjetaSlot2EntradaDigital;
    }

    public Boolean getTarjetaSlot2EntradaAnalogico() {
        return tarjetaSlot2EntradaAnalogico;
    }

    public void setTarjetaSlot2EntradaAnalogico(Boolean tarjetaSlot2EntradaAnalogico) {
        this.tarjetaSlot2EntradaAnalogico = tarjetaSlot2EntradaAnalogico;
    }

    public Boolean getTarjetaSlot2EntradaVideo() {
        return tarjetaSlot2EntradaVideo;
    }

    public void setTarjetaSlot2EntradaVideo(Boolean tarjetaSlot2EntradaVideo) {
        this.tarjetaSlot2EntradaVideo = tarjetaSlot2EntradaVideo;
    }

    public Boolean getTarjetaSlot2SalidaDigital() {
        return tarjetaSlot2SalidaDigital;
    }

    public void setTarjetaSlot2SalidaDigital(Boolean tarjetaSlot2SalidaDigital) {
        this.tarjetaSlot2SalidaDigital = tarjetaSlot2SalidaDigital;
    }

    public String getTarjetaSlot3Modelo() {
        return tarjetaSlot3Modelo;
    }

    public void setTarjetaSlot3Modelo(String tarjetaSlot3Modelo) {
        this.tarjetaSlot3Modelo = tarjetaSlot3Modelo;
    }

    public Boolean getTarjetaSlot3EntradaDigital() {
        return tarjetaSlot3EntradaDigital;
    }

    public void setTarjetaSlot3EntradaDigital(Boolean tarjetaSlot3EntradaDigital) {
        this.tarjetaSlot3EntradaDigital = tarjetaSlot3EntradaDigital;
    }

    public Boolean getTarjetaSlot3EntradaAnalogico() {
        return tarjetaSlot3EntradaAnalogico;
    }

    public void setTarjetaSlot3EntradaAnalogico(Boolean tarjetaSlot3EntradaAnalogico) {
        this.tarjetaSlot3EntradaAnalogico = tarjetaSlot3EntradaAnalogico;
    }

    public Boolean getTarjetaSlot3EntradaVideo() {
        return tarjetaSlot3EntradaVideo;
    }

    public void setTarjetaSlot3EntradaVideo(Boolean tarjetaSlot3EntradaVideo) {
        this.tarjetaSlot3EntradaVideo = tarjetaSlot3EntradaVideo;
    }

    public Boolean getTarjetaSlot3SalidaDigital() {
        return tarjetaSlot3SalidaDigital;
    }

    public void setTarjetaSlot3SalidaDigital(Boolean tarjetaSlot3SalidaDigital) {
        this.tarjetaSlot3SalidaDigital = tarjetaSlot3SalidaDigital;
    }

    public String getTarjetaFuente() {
        return tarjetaFuente;
    }

    public void setTarjetaFuente(String tarjetaFuente) {
        this.tarjetaFuente = tarjetaFuente;
    }

    public String getTarjetaFiltro() {
        return tarjetaFiltro;
    }

    public void setTarjetaFiltro(String tarjetaFiltro) {
        this.tarjetaFiltro = tarjetaFiltro;
    }

    public String getTarjetaBalastroA() {
        return tarjetaBalastroA;
    }

    public void setTarjetaBalastroA(String tarjetaBalastroA) {
        this.tarjetaBalastroA = tarjetaBalastroA;
    }

    public String getTarjetaBalastroB() {
        return tarjetaBalastroB;
    }

    public void setTarjetaBalastroB(String tarjetaBalastroB) {
        this.tarjetaBalastroB = tarjetaBalastroB;
    }

    public String getTarjetaObservacion() {
        return tarjetaObservacion;
    }

    public void setTarjetaObservacion(String tarjetaObservacion) {
        this.tarjetaObservacion = tarjetaObservacion;
    }

    public BigDecimal getTemperaturaFuentePcb1Temp() {
        return temperaturaFuentePcb1Temp;
    }

    public void setTemperaturaFuentePcb1Temp(BigDecimal temperaturaFuentePcb1Temp) {
        this.temperaturaFuentePcb1Temp = temperaturaFuentePcb1Temp;
    }

    public BigDecimal getTemperaturaFuentePcb1TempMax() {
        return temperaturaFuentePcb1TempMax;
    }

    public void setTemperaturaFuentePcb1TempMax(BigDecimal temperaturaFuentePcb1TempMax) {
        this.temperaturaFuentePcb1TempMax = temperaturaFuentePcb1TempMax;
    }

    public String getTemperaturaFuentePcb1Estado() {
        return temperaturaFuentePcb1Estado;
    }

    public void setTemperaturaFuentePcb1Estado(String temperaturaFuentePcb1Estado) {
        this.temperaturaFuentePcb1Estado = temperaturaFuentePcb1Estado;
    }

    public BigDecimal getTemperaturaFuentePcb2Temp() {
        return temperaturaFuentePcb2Temp;
    }

    public void setTemperaturaFuentePcb2Temp(BigDecimal temperaturaFuentePcb2Temp) {
        this.temperaturaFuentePcb2Temp = temperaturaFuentePcb2Temp;
    }

    public BigDecimal getTemperaturaFuentePcb2TempMax() {
        return temperaturaFuentePcb2TempMax;
    }

    public void setTemperaturaFuentePcb2TempMax(BigDecimal temperaturaFuentePcb2TempMax) {
        this.temperaturaFuentePcb2TempMax = temperaturaFuentePcb2TempMax;
    }

    public String getTemperaturaFuentePcb2Estado() {
        return temperaturaFuentePcb2Estado;
    }

    public void setTemperaturaFuentePcb2Estado(String temperaturaFuentePcb2Estado) {
        this.temperaturaFuentePcb2Estado = temperaturaFuentePcb2Estado;
    }

    public BigDecimal getTemperaturaChipDlpTemp() {
        return temperaturaChipDlpTemp;
    }

    public void setTemperaturaChipDlpTemp(BigDecimal temperaturaChipDlpTemp) {
        this.temperaturaChipDlpTemp = temperaturaChipDlpTemp;
    }

    public BigDecimal getTemperaturaChipDlpTempMax() {
        return temperaturaChipDlpTempMax;
    }

    public void setTemperaturaChipDlpTempMax(BigDecimal temperaturaChipDlpTempMax) {
        this.temperaturaChipDlpTempMax = temperaturaChipDlpTempMax;
    }

    public String getTemperaturaChipDlpEstado() {
        return temperaturaChipDlpEstado;
    }

    public void setTemperaturaChipDlpEstado(String temperaturaChipDlpEstado) {
        this.temperaturaChipDlpEstado = temperaturaChipDlpEstado;
    }

    public BigDecimal getTemperaturaLamparaATemp() {
        return temperaturaLamparaATemp;
    }

    public void setTemperaturaLamparaATemp(BigDecimal temperaturaLamparaATemp) {
        this.temperaturaLamparaATemp = temperaturaLamparaATemp;
    }

    public BigDecimal getTemperaturaLamparaATempMax() {
        return temperaturaLamparaATempMax;
    }

    public void setTemperaturaLamparaATempMax(BigDecimal temperaturaLamparaATempMax) {
        this.temperaturaLamparaATempMax = temperaturaLamparaATempMax;
    }

    public String getTemperaturaLamparaAEstado() {
        return temperaturaLamparaAEstado;
    }

    public void setTemperaturaLamparaAEstado(String temperaturaLamparaAEstado) {
        this.temperaturaLamparaAEstado = temperaturaLamparaAEstado;
    }

    public BigDecimal getTemperaturaLamparaBTemp() {
        return temperaturaLamparaBTemp;
    }

    public void setTemperaturaLamparaBTemp(BigDecimal temperaturaLamparaBTemp) {
        this.temperaturaLamparaBTemp = temperaturaLamparaBTemp;
    }

    public BigDecimal getTemperaturaLamparaBTempMax() {
        return temperaturaLamparaBTempMax;
    }

    public void setTemperaturaLamparaBTempMax(BigDecimal temperaturaLamparaBTempMax) {
        this.temperaturaLamparaBTempMax = temperaturaLamparaBTempMax;
    }

    public String getTemperaturaLamparaBEstado() {
        return temperaturaLamparaBEstado;
    }

    public void setTemperaturaLamparaBEstado(String temperaturaLamparaBEstado) {
        this.temperaturaLamparaBEstado = temperaturaLamparaBEstado;
    }

    public String getTemperaturaObservacion() {
        return temperaturaObservacion;
    }

    public void setTemperaturaObservacion(String temperaturaObservacion) {
        this.temperaturaObservacion = temperaturaObservacion;
    }

    public String getImagenDisplayMemory() {
        return imagenDisplayMemory;
    }

    public void setImagenDisplayMemory(String imagenDisplayMemory) {
        this.imagenDisplayMemory = imagenDisplayMemory;
    }

    public String getImagenInputMemory() {
        return imagenInputMemory;
    }

    public void setImagenInputMemory(String imagenInputMemory) {
        this.imagenInputMemory = imagenInputMemory;
    }

    public String getImagenResolucion() {
        return imagenResolucion;
    }

    public void setImagenResolucion(String imagenResolucion) {
        this.imagenResolucion = imagenResolucion;
    }

    public String getImagenBrillo() {
        return imagenBrillo;
    }

    public void setImagenBrillo(String imagenBrillo) {
        this.imagenBrillo = imagenBrillo;
    }

    public String getImagenForegroundWindows() {
        return imagenForegroundWindows;
    }

    public void setImagenForegroundWindows(String imagenForegroundWindows) {
        this.imagenForegroundWindows = imagenForegroundWindows;
    }

    public String getImagenInputSlot() {
        return imagenInputSlot;
    }

    public void setImagenInputSlot(String imagenInputSlot) {
        this.imagenInputSlot = imagenInputSlot;
    }

    public String getImagenInputSlotType() {
        return imagenInputSlotType;
    }

    public void setImagenInputSlotType(String imagenInputSlotType) {
        this.imagenInputSlotType = imagenInputSlotType;
    }

    public String getImagenContraste() {
        return imagenContraste;
    }

    public void setImagenContraste(String imagenContraste) {
        this.imagenContraste = imagenContraste;
    }

    public String getImagenStatus() {
        return imagenStatus;
    }

    public void setImagenStatus(String imagenStatus) {
        this.imagenStatus = imagenStatus;
    }

    public String getImagenRuedaColor() {
        return imagenRuedaColor;
    }

    public void setImagenRuedaColor(String imagenRuedaColor) {
        this.imagenRuedaColor = imagenRuedaColor;
    }

    public String getImagenRojoIniciales() {
        return imagenRojoIniciales;
    }

    public void setImagenRojoIniciales(String imagenRojoIniciales) {
        this.imagenRojoIniciales = imagenRojoIniciales;
    }

    public String getImagenRojoActuales() {
        return imagenRojoActuales;
    }

    public void setImagenRojoActuales(String imagenRojoActuales) {
        this.imagenRojoActuales = imagenRojoActuales;
    }

    public String getImagenVerdeIniciales() {
        return imagenVerdeIniciales;
    }

    public void setImagenVerdeIniciales(String imagenVerdeIniciales) {
        this.imagenVerdeIniciales = imagenVerdeIniciales;
    }

    public String getImagenVerdeActuales() {
        return imagenVerdeActuales;
    }

    public void setImagenVerdeActuales(String imagenVerdeActuales) {
        this.imagenVerdeActuales = imagenVerdeActuales;
    }

    public String getImagenAzulIniciales() {
        return imagenAzulIniciales;
    }

    public void setImagenAzulIniciales(String imagenAzulIniciales) {
        this.imagenAzulIniciales = imagenAzulIniciales;
    }

    public String getImagenAzulActuales() {
        return imagenAzulActuales;
    }

    public void setImagenAzulActuales(String imagenAzulActuales) {
        this.imagenAzulActuales = imagenAzulActuales;
    }

    public String getImagenObservacion() {
        return imagenObservacion;
    }

    public void setImagenObservacion(String imagenObservacion) {
        this.imagenObservacion = imagenObservacion;
    }

    public Integer getNumeroCubos() {
        return numeroCubos;
    }

    public void setNumeroCubos(Integer numeroCubos) {
        this.numeroCubos = numeroCubos;
    }

    public Integer getDimensionFilas() {
        return dimensionFilas;
    }

    public void setDimensionFilas(Integer dimensionFilas) {
        this.dimensionFilas = dimensionFilas;
    }

    public Integer getDimensionColumnas() {
        return dimensionColumnas;
    }

    public void setDimensionColumnas(Integer dimensionColumnas) {
        this.dimensionColumnas = dimensionColumnas;
    }

    
    public String getMatrizUbicacionBase64() {
        return matrizUbicacionBase64;
    }

    public void setMatrizUbicacionBase64(String matrizUbicacionBase64) {
        this.matrizUbicacionBase64 = matrizUbicacionBase64;
    }

    public Reporte getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Reporte idReporte) {
        this.idReporte = idReporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleReporteEcu911)) {
            return false;
        }
        DetalleReporteEcu911 other = (DetalleReporteEcu911) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleReporteEcu911{" + "id=" + id + ", bastidorMarca=" + bastidorMarca + ", bastidorModelo=" + bastidorModelo + ", bastidorSerie=" + bastidorSerie + ", bastidorObservacion=" + bastidorObservacion + ", pantallaMarca=" + pantallaMarca + ", pantallaModelo=" + pantallaModelo + ", pantallaSerie=" + pantallaSerie + ", pantallaSeparacionCubosHd=" + pantallaSeparacionCubosHd + ", pantallaSeparacionCubosHi=" + pantallaSeparacionCubosHi + ", pantallaSeparacionCubosVs=" + pantallaSeparacionCubosVs + ", pantallaSeparacionCubosVi=" + pantallaSeparacionCubosVi + ", pantallaObservacion=" + pantallaObservacion + ", engineMarca=" + engineMarca + ", engineModelo=" + engineModelo + ", engineSerie=" + engineSerie + ", engineDireccionIp=" + engineDireccionIp + ", engineModoOperacion=" + engineModoOperacion + ", engineIdUnidad=" + engineIdUnidad + ", engineMascaraSubred=" + engineMascaraSubred + ", engineVersionFw=" + engineVersionFw + ", engineTiempoUso=" + engineTiempoUso + ", enginePuertaEnlace=" + enginePuertaEnlace + ", engineObservacion=" + engineObservacion + ", lamparaMarca=" + lamparaMarca + ", lamparaModelo=" + lamparaModelo + ", lamparaVoltaje=" + lamparaVoltaje + ", lamparaASerial=" + lamparaASerial + ", lamparaAEstado=" + lamparaAEstado + ", lamparaATiempoUso=" + lamparaATiempoUso + ", lamparaBSerial=" + lamparaBSerial + ", lamparaBEstado=" + lamparaBEstado + ", lamparaBTiempoUso=" + lamparaBTiempoUso + ", lamparaObservacion=" + lamparaObservacion + ", tarjetaSlot1Modelo=" + tarjetaSlot1Modelo + ", tarjetaSlot1EntradaDigital=" + tarjetaSlot1EntradaDigital + ", tarjetaSlot1EntradaAnalogico=" + tarjetaSlot1EntradaAnalogico + ", tarjetaSlot1EntradaVideo=" + tarjetaSlot1EntradaVideo + ", tarjetaSlot1SalidaDigital=" + tarjetaSlot1SalidaDigital + ", tarjetaSlot2Modelo=" + tarjetaSlot2Modelo + ", tarjetaSlot2EntradaDigital=" + tarjetaSlot2EntradaDigital + ", tarjetaSlot2EntradaAnalogico=" + tarjetaSlot2EntradaAnalogico + ", tarjetaSlot2EntradaVideo=" + tarjetaSlot2EntradaVideo + ", tarjetaSlot2SalidaDigital=" + tarjetaSlot2SalidaDigital + ", tarjetaSlot3Modelo=" + tarjetaSlot3Modelo + ", tarjetaSlot3EntradaDigital=" + tarjetaSlot3EntradaDigital + ", tarjetaSlot3EntradaAnalogico=" + tarjetaSlot3EntradaAnalogico + ", tarjetaSlot3EntradaVideo=" + tarjetaSlot3EntradaVideo + ", tarjetaSlot3SalidaDigital=" + tarjetaSlot3SalidaDigital + ", tarjetaFuente=" + tarjetaFuente + ", tarjetaFiltro=" + tarjetaFiltro + ", tarjetaBalastroA=" + tarjetaBalastroA + ", tarjetaBalastroB=" + tarjetaBalastroB + ", tarjetaObservacion=" + tarjetaObservacion + ", temperaturaFuentePcb1Temp=" + temperaturaFuentePcb1Temp + ", temperaturaFuentePcb1TempMax=" + temperaturaFuentePcb1TempMax + ", temperaturaFuentePcb1Estado=" + temperaturaFuentePcb1Estado + ", temperaturaFuentePcb2Temp=" + temperaturaFuentePcb2Temp + ", temperaturaFuentePcb2TempMax=" + temperaturaFuentePcb2TempMax + ", temperaturaFuentePcb2Estado=" + temperaturaFuentePcb2Estado + ", temperaturaChipDlpTemp=" + temperaturaChipDlpTemp + ", temperaturaChipDlpTempMax=" + temperaturaChipDlpTempMax + ", temperaturaChipDlpEstado=" + temperaturaChipDlpEstado + ", temperaturaLamparaATemp=" + temperaturaLamparaATemp + ", temperaturaLamparaATempMax=" + temperaturaLamparaATempMax + ", temperaturaLamparaAEstado=" + temperaturaLamparaAEstado + ", temperaturaLamparaBTemp=" + temperaturaLamparaBTemp + ", temperaturaLamparaBTempMax=" + temperaturaLamparaBTempMax + ", temperaturaLamparaBEstado=" + temperaturaLamparaBEstado + ", temperaturaObservacion=" + temperaturaObservacion + ", imagenDisplayMemory=" + imagenDisplayMemory + ", imagenInputMemory=" + imagenInputMemory + ", imagenResolucion=" + imagenResolucion + ", imagenBrillo=" + imagenBrillo + ", imagenForegroundWindows=" + imagenForegroundWindows + ", imagenInputSlot=" + imagenInputSlot + ", imagenInputSlotType=" + imagenInputSlotType + ", imagenContraste=" + imagenContraste + ", imagenStatus=" + imagenStatus + ", imagenRuedaColor=" + imagenRuedaColor + ", imagenRojoIniciales=" + imagenRojoIniciales + ", imagenRojoActuales=" + imagenRojoActuales + ", imagenVerdeIniciales=" + imagenVerdeIniciales + ", imagenVerdeActuales=" + imagenVerdeActuales + ", imagenAzulIniciales=" + imagenAzulIniciales + ", imagenAzulActuales=" + imagenAzulActuales + ", imagenObservacion=" + imagenObservacion + ", numeroCubos=" + numeroCubos + ", dimensionFilas=" + dimensionFilas + ", dimensionColumnas=" + dimensionColumnas + ", matrizUbicacionBase64=" + matrizUbicacionBase64 + ", idReporte=" + idReporte + ", factura=" + factura + ", numeroFactura=" + numeroFactura + ", cliente=" + cliente + ", nombre_soporte=" + nombre_soporte + ", fecha=" + fecha + ", codigoTecnico=" + codigoTecnico + ", ciudad=" + ciudad + ", numeroFacturaTecnico=" + numeroFacturaTecnico + ", atencion=" + atencion + ", referencia=" + referencia + ", correo=" + correo + ", productoClienteReporte=" + productoClienteReporte + ", subtipo=" + subtipo + ", nombreCliente=" + nombreCliente + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", observacionRecomendacion=" + observacionRecomendacion + ", ed1=" + ed1 + ", ea1=" + ea1 + ", ev1=" + ev1 + ", sd1=" + sd1 + ", ed2=" + ed2 + ", ea2=" + ea2 + ", ev2=" + ev2 + ", sd2=" + sd2 + ", ed3=" + ed3 + ", ea3=" + ea3 + ", ev3=" + ev3 + ", sd3=" + sd3 + '}';
    }

}
