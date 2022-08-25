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
public class dtoDatosContactos {
    @NotBlank    
    private String tipoContacto;
    private String direccionContacto; 
    
    //constructor

    public dtoDatosContactos() {
    }

    public dtoDatosContactos(String tipoContacto, String direccionContacto) {
        this.tipoContacto = tipoContacto;
        this.direccionContacto = direccionContacto;
    }
    
    //Getters & Setters

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }
        
}
