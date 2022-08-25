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
public class dtoProyectos {
    
    @NotBlank
    private String nombreProyecto;
    private String descripcionProyecto;
    private String imgProyecto;
    private String urlProyecto;
    
    //contructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreProyecto, String descripcionProyecto, String imgProyecto, String urlProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.imgProyecto = imgProyecto;
        this.urlProyecto = urlProyecto;
    }
    
    //Getter & Setter

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }
    
}
