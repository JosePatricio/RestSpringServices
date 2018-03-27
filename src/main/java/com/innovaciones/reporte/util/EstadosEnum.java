/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.util;

/**
 *
 * @author pisama
 */
public enum EstadosEnum {

    TODOS("TODOS", null),
    ACTIVO("ACTIVO", 1),
    INACTIVO("INACTIVO", 0),
    TIENE_MAS_DE_1("TIENE_MAS_DE_1", 1),
    TIENE_1("TIENE_1", 2),
    NO_TIENE("NO_TIENE", 3),
    NO_TIENE_PRODUCTO("NO_TIENE_PRODUCTO", 4);

    private final String propertyName; //Nombre del estado (propiedad)
    private final Integer value; // Valor del estado

    EstadosEnum(String propertyName, Integer value) {
        this.propertyName = propertyName;
        this.value = value;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Integer getValue() {
        return value;
    }
}
