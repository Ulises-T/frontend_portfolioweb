/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.controller;

import com.portfolio.ulisestf.Dto.dtoEstudios;
import com.portfolio.ulisestf.Security.Controller.Mensaje;
import com.portfolio.ulisestf.entity.Estudios;
import com.portfolio.ulisestf.service.SEstudios;
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
@RequestMapping("/estudios")
@CrossOrigin(origins = "https://miportfoliopersonal-bfa5b.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class CEstudios {

    @Autowired
    SEstudios sEstudios;

    //crear lista de Estudios
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list() {
        List<Estudios> list = sEstudios.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Crear experiencia
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudios dtoestudios) {
        if (StringUtils.isBlank(dtoestudios.getNombreEst())) {
            return new ResponseEntity(new Mensaje("El campo nombre es oblicatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEstudios.existsByNombreEst(dtoestudios.getNombreEst())) {
            return new ResponseEntity(new Mensaje("El estudio ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }

        Estudios estudios = new Estudios(dtoestudios.getNombreEst(), dtoestudios.getFechaEst(), dtoestudios.getDescripcionEst());
        sEstudios.save(estudios);
        return new ResponseEntity(new Mensaje("Estudio Agregado"), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEstudios.delete(id);
        return new ResponseEntity(new Mensaje("estudio eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id) {
        if (!sEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Estudios experiencia = sEstudios.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    //actualizar la experiencia

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEstudios dtoestudios) {
        //validamos si el id ya existe
        if (!sEstudios.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparar nombre de experiencia
        if (sEstudios.existsByNombreEst(dtoestudios.getNombreEst()) && sEstudios.getByNombreEst(dtoestudios.getNombreEst()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de estudio ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoestudios.getNombreEst())) {
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Estudios estudios = sEstudios.getOne(id).get();
        estudios.setNombreEst(dtoestudios.getNombreEst());
        estudios.setDescripcionEst(dtoestudios.getDescripcionEst());
        estudios.setFechaEst(dtoestudios.getFechaEst());

        sEstudios.save(estudios);
        return new ResponseEntity(new Mensaje("Estudio Actualizada"), HttpStatus.OK);
    }

}
