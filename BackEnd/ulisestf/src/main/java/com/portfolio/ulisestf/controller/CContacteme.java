/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.controller;

import com.portfolio.ulisestf.Dto.dtoContacteme;
import com.portfolio.ulisestf.Security.Controller.Mensaje;
import com.portfolio.ulisestf.entity.Contacteme;
import com.portfolio.ulisestf.service.SContacteme;
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
@RequestMapping("/contacteme")
@CrossOrigin(origins = "https://miportfoliopersonal-bfa5b.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class CContacteme {
       @Autowired
       SContacteme sContacteme;

    //crear lista de experiencia
    
    @GetMapping("/lista")
    public ResponseEntity<List<Contacteme>> list() {
        List<Contacteme> list = sContacteme.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     //Crear experiencia
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContacteme dtocontact){
        if (StringUtils.isBlank(dtocontact.getTipoContacto())) 
            return new ResponseEntity(new Mensaje("El campo Tipo Contacto es oblicatorio"), HttpStatus.BAD_REQUEST);
        if (sContacteme.existsByTipoContacto(dtocontact.getTipoContacto())) 
            return new ResponseEntity(new Mensaje("El Tipo Contacto ya existe"), HttpStatus.BAD_REQUEST);
        

       Contacteme contacteme = new Contacteme(dtocontact.getTipoContacto(), dtocontact.getDireccionContacto());
        sContacteme.save(contacteme);
        return new ResponseEntity(new Mensaje("Contacteme Agregada"), HttpStatus.OK);
    }
    
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sContacteme.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sContacteme.delete(id);
        return new ResponseEntity(new Mensaje("Contacteme eliminado"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Contacteme> getById(@PathVariable("id") int id) {
        if (!sContacteme.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Contacteme contacteme = sContacteme.getOne(id).get();
        return new ResponseEntity(contacteme, HttpStatus.OK);
    }
    
      //actualizar la experiencia

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContacteme dtocontact) {
        //validamos si el id ya existe
        if (!sContacteme.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparar nombre de experiencia
        if (sContacteme.existsByTipoContacto(dtocontact.getTipoContacto()) && sContacteme.getByTipoContacto(dtocontact.getTipoContacto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de Contacto ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtocontact.getTipoContacto())) {
            return new ResponseEntity(new Mensaje("El campo Tipo Contacto es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Contacteme contacteme = sContacteme.getOne(id).get();
        contacteme.setTipoContacto(dtocontact.getTipoContacto());
        contacteme.setDireccionContacto(dtocontact.getDireccionContacto());
        

        sContacteme.save(contacteme);
        return new ResponseEntity(new Mensaje("Contacteme Actualizado"), HttpStatus.OK);
    }
    
}
