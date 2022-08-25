/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEst;
    private String fechaEst;
    private String descripcionEst;
    
    //consttrucotes

    public Estudios() {
    }

    public Estudios(String nombreEst, String fechaEst, String descripcionEst) {
        this.nombreEst = nombreEst;
        this.fechaEst = fechaEst;
        this.descripcionEst = descripcionEst;
    }
    
    //getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

