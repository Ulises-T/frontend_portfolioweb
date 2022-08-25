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
public class Conocimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreLenguaje;
    private int porcentLenguaje;
 
//Constructores

    public Conocimientos() {
    }

    public Conocimientos(String nombreLenguaje, int porcentLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
        this.porcentLenguaje = porcentLenguaje;
    }

    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
