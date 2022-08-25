/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Ulises
 */
public class dtoConocimientos {
    @NotBlank
    private String nombreLenguaje;
    private int porcentLenguaje;
    
    //constructores

    public dtoConocimientos() {
    }

    public dtoConocimientos(String nombreLenguaje, int porcentLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
        this.porcentLenguaje = porcentLenguaje;
    }
    
    //Getter & Setter

    public String getNombreLenguaje() {
        return nombreLenguaje;
    }

    public void setNombreLenguaje(String nombreLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
    }

    public int getPorcentLenguaje() {
        return porcentLenguaje;
    }

    public void setPorcentLenguaje(int porcentLenguaje) {
        this.porcentLenguaje = porcentLenguaje;
    }
    
}
