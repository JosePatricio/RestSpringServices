package com.innovaciones.reporte.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class EstadoGarantiaConverter implements AttributeConverter<EstadoGarantiaEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EstadoGarantiaEnum estadoGarantiaEnum) {
        switch (estadoGarantiaEnum) {

            case NO_ACTIVA:
                return 0;
            case ACTIVA:
                return 1;
            case VENCIDA:
                return 2;
            case ANULADA:
                return 3;
            default:
                throw new IllegalArgumentException("Unknown " + estadoGarantiaEnum);
        }
    }

    @Override
    public EstadoGarantiaEnum convertToEntityAttribute(Integer integer) {
        switch (integer) {
            case 0:
                return EstadoGarantiaEnum.NO_ACTIVA;
            case 1:
                return EstadoGarantiaEnum.ACTIVA;
            case 2:
                return EstadoGarantiaEnum.VENCIDA;
            case 3:
                return EstadoGarantiaEnum.ANULADA;
            default:
                throw new IllegalArgumentException("Unknown " + integer);
        }
    }
}
