/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.controller;

import com.portfolio.ulisestf.Dto.dtoProyectos;
import com.portfolio.ulisestf.Security.Controller.Mensaje;
import com.portfolio.ulisestf.entity.Proyectos;
import com.portfolio.ulisestf.service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://miportfoliopersonal-bfa5b.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class CProyectos {

    @Autowired
    SProyectos sProyectos;

    //crear lista de experiencia
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Crear experiencia
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy) {
        if (StringUtils.isBlank(dtoproy.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El campo Proyecto es oblicatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyectos.existsByNombreProyecto(dtoproy.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El Proyecto ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoproy.getNombreProyecto(), dtoproy.getDescripcionProyecto(), dtoproy.getImgProyecto(), dtoproy.getUrlProyecto());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
       Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    //actualizar la experiencia

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproy) {
        //validamos si el id ya existe
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparar el nombre Proyecto
        if (sProyectos.existsByNombreProyecto(dtoproy.getNombreProyecto()) && sProyectos.getByNombreProyecto(dtoproy.getNombreProyecto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre Proyecto ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoproy.getNombreProyecto())) {
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreProyecto(dtoproy.getNombreProyecto());
        proyectos.setDescripcionProyecto(dtoproy.getDescripcionProyecto());
        proyectos.setImgProyecto(dtoproy.getImgProyecto());
        proyectos.setUrlProyecto(dtoproy.getUrlProyecto());

        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

}
