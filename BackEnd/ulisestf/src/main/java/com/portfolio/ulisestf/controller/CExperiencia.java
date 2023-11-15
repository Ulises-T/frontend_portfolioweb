/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.controller;

import com.portfolio.ulisestf.Dto.dtoExperiencia;
import org.apache.commons.lang3.StringUtils;
import com.portfolio.ulisestf.Security.Controller.Mensaje;
import com.portfolio.ulisestf.entity.Experiencia;
import com.portfolio.ulisestf.service.SExperiencia;
import java.util.List;
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
@RequestMapping("/expelab")
@CrossOrigin(origins = "https://miportfoliopersonal-bfa5b.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    //crear lista de experiencia
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Crear experiencia
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if (StringUtils.isBlank(dtoexp.getNombreExp())) 
            return new ResponseEntity(new Mensaje("El campo nombre es oblicatorio"), HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByNombreExp(dtoexp.getNombreExp())) 
            return new ResponseEntity(new Mensaje("La experiencia ingresada ya existe"), HttpStatus.BAD_REQUEST);
        

        Experiencia experiencia = new Experiencia(dtoexp.getNombreExp(), dtoexp.getFechaExp(), dtoexp.getDescripcionExp(), dtoexp.getImgExp());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);

    }
    
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    //actualizar la experiencia

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        //validamos si el id ya existe
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparar nombre de experiencia
        if (sExperiencia.existsByNombreExp(dtoexp.getNombreExp()) && sExperiencia.getByNombreExp(dtoexp.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de experiencia ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El campo nombre no puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoexp.getNombreExp());
        experiencia.setDescripcionExp(dtoexp.getDescripcionExp());
        experiencia.setFechaExp(dtoexp.getFechaExp());
        experiencia.setImgExp(dtoexp.getImgExp());

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
}
