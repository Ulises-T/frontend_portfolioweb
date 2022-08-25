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
public class dtoEstudios {
    @NotBlank
     private String nombreEst;
    private String fechaEst;
    private String descripcionEst;
    
    //constructor

    public dtoEstudios() {
    }

    public dtoEstudios(String nombreEst, String fechaEst, String descripcionEst) {
        this.nombreEst = nombreEst;
        this.fechaEst = fechaEst;
        this.descripcionEst = descripcionEst;
    }
    
    //getter & setter

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public String getFechaEst() {
        return fechaEst;
    }

    public void setFechaEst(String fechaEst) {
        this.fechaEst = fechaEst;
    }

    public String getDescripcionEst() {
        return descripcionEst;
    }

    public void setDescripcionEst(String descripcionEst) {
        this.descripcionEst = descripcionEst;
    }
    
    
}
