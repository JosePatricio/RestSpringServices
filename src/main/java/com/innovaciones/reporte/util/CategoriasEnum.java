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
public enum CategoriasEnum {

    CAT_IMPRESORAS("IMPRESORAS", "IMPR"),
    CAT_MULTIFUNCION_BLANCO_NEGRO("MULTIFUNCION B&N", "MUL-B&N"),
    CAT_MULTIFUNCION_COLOR("MULTIFUNCION COLOR", "MUL-COL"),
    CAT_MONITORES("MONITORES", "MONI"),
    CAT_SCANNERS("SCANNERS", "SCAN"),
    CAT_TRITURADORAS("TRITURADORAS", "TRIT"),
    CAT_ETIQUETADORAS("ETIQUETADORAS", "ETIQ"),
    CAT_REPUESTOS("REPUESTOS", "REP");

    private final String propertyName; //Nombre del estado (propiedad)

    private final String value; // Valor del estado

    CategoriasEnum(String propertyName, String value) {
        this.propertyName = propertyName;
        this.value = value;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getValue() {
        return value;
    }
}
