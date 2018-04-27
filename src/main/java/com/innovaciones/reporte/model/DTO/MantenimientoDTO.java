/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.model.DTO;

/**
 *
 * @author Fernando-PC
 */
public class MantenimientoDTO {

    private String codigo;
    private String descripcion;
    private boolean valor1;
    private boolean valor2;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isValor1() {
        return valor1;
    }

    public void setValor1(boolean valor1) {
        this.valor1 = valor1;
    }

    public boolean isValor2() {
        return valor2;
    }

    public void setValor2(boolean valor2) {
        this.valor2 = valor2;
    }

    @Override
    public String toString() {
        return "MantenimientoDTO{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", valor1=" + valor1 + ", valor2=" + valor2 + '}';
    }

}
