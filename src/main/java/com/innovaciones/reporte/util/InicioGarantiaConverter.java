package com.innovaciones.reporte.util;

import javax.persistence.AttributeConverter;

public class InicioGarantiaConverter implements AttributeConverter<InicioGarantia, Integer> {
    @Override
    public Integer convertToDatabaseColumn(InicioGarantia inicioGarantia) {
        switch (inicioGarantia) {

            case EGRESO:
                return 0;
            case INSTALACION:
                return 1;
            case FECHA_PERSONALIZADA:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown " + inicioGarantia);
        }
    }

    @Override
    public InicioGarantia convertToEntityAttribute(Integer integer) {
        switch (integer) {
            case 0:
                return InicioGarantia.EGRESO;
            case 1:
                return InicioGarantia.INSTALACION;
            case 2:
                return InicioGarantia.FECHA_PERSONALIZADA;
            default:
                throw new IllegalArgumentException("Unknown " + integer);
        }
    }
}
