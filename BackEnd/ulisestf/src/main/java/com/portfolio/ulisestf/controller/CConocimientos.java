/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.controller;

import com.portfolio.ulisestf.Dto.dtoConocimientos;
import com.portfolio.ulisestf.Security.Controller.Mensaje;
import com.portfolio.ulisestf.entity.Conocimientos;
import com.portfolio.ulisestf.service.SConocimentos;
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
@RequestMapping("/conocimientos")
@CrossOrigin(origins = "https://miportfoliopersonal-bfa5b.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class CConocimientos {
     @Autowired
     SConocimentos sConocimientos;
     
       //crear lista de Conocimientos
    @GetMapping("/lista")
    public ResponseEntity<List<Conocimientos>> list() {
        List<Conocimientos> list = sConocimientos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Crear conocimiento
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoConocimientos dtoconocimientos) {
        if (StringUtils.isBlank(dtoconocimientos.getNombreLenguaje())) {
            return new ResponseEntity(new Mensaje("El campo nombre es oblicatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sConocimientos.existsByNombreLenguaje(dtoconocimientos.getNombreLenguaje())) {
            return new ResponseEntity(new Mensaje("El Lenguaje ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }

        Conocimientos conocimientos = new Conocimientos(dtoconocimientos.getNombreLenguaje(), dtoconocimientos.getPorcentLenguaje());
        sConocimientos.save(conocimientos);
        return new ResponseEntity(new Mensaje("Lenguaje Agregado"), HttpStatus.OK);
    }
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sConocimientos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sConocimientos.delete(id);
        return new ResponseEntity(new Mensaje("Conocimiento eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Conocimientos> getById(@PathVariable("id") int id) {
        if (!sConocimientos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Conocimientos conocimientos = sConocimientos.getOne(id).get();
        return new ResponseEntity(conocimientos, HttpStatus.OK);
    }
    
    //actualizar conocimiento

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoConocimientos dtoconocimientos) {
        //validamos si el id ya existe
        if (!sConocimientos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparar nombre de experiencia
        if (sConocimientos.existsByNombreLenguaje(dtoconocimientos.getNombreLenguaje()) && sConocimientos.getByNombreLenguaje(dtoconocimientos.getNombreLenguaje()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de lenguaje ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoconocimientos.getNombreLenguaje())) {
            return new ResponseEntity(new Mensaje("El campo nombre Lenguaje es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Conocimientos conocimientos = sConocimientos.getOne(id).get();
        conocimientos.setNombreLenguaje(dtoconocimientos.getNombreLenguaje());
        conocimientos.setPorcentLenguaje(dtoconocimientos.getPorcentLenguaje());

        sConocimientos.save(conocimientos);
        return new ResponseEntity(new Mensaje("Conocimiento Actualizado"), HttpStatus.OK);
    }
    
}
