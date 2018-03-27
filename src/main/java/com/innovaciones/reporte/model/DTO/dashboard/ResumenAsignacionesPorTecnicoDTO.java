package com.innovaciones.reporte.model.DTO.dashboard;

import lombok.Getter;
import lombok.Setter;

public class ResumenAsignacionesPorTecnicoDTO {

    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String tecnico;
    @Getter
    @Setter
    private int count;
}
