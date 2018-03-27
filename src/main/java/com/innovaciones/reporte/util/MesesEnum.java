/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fyaulema
 */
public enum MesesEnum {

    ENERO("ENERO", 1),
    FEBRERO("FEBRERO", 2),
    MARZO("MARZO", 3),
    ABRIL("ABRIL", 4),
    MAYO("MAYO", 5),
    JUNIO("JUNIO", 6),
    JULIO("JULIO", 7),
    AGOSTO("AGOSTO", 8),
    SEPTIEMBRE("SEPTIEMBRE", 9),
    OCTUBRE("OCTUBRE", 10),
    NOVIEMBRE("NOVIEMBRE", 11),
    DICIEMBRE("DICIEMBRE", 12);
    

    private final String propertyName; //Nombre del estado (propiedad)
    private final Integer value; // Valor del estado 
     private static final Map<Integer, MesesEnum> lookup = new HashMap<>();

    MesesEnum(String propertyName, Integer value) {
        this.propertyName = propertyName;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String getPropertyName() {
        return propertyName;
    }
    
     static {
        for (MesesEnum d : MesesEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public static MesesEnum get(Integer key) {
        return lookup.get(key);
    }

}
