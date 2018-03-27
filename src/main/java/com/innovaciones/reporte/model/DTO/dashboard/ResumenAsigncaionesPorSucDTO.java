package com.innovaciones.reporte.model.DTO.dashboard;

import lombok.Getter;
import lombok.Setter;

public class ResumenAsigncaionesPorSucDTO {

    @Getter
    @Setter
    private double latitude;
    @Getter
    @Setter
    private double longitude;
    @Getter
    @Setter
    private String sucursal;
    @Getter
    @Setter
    private int count;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String cliente;
    @Getter
    @Setter
    private String direccion;
}
