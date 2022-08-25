/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.service;

import com.portfolio.ulisestf.entity.Conocimientos;
import com.portfolio.ulisestf.repository.RConocimientos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SConocimentos {
    @Autowired
    RConocimientos rConocimientos;
    
       public List<Conocimientos> list(){
        return rConocimientos.findAll();
    }
    
        public Optional<Conocimientos> getOne(int id){
        return rConocimientos.findById(id);
    }
          public Optional<Conocimientos> getByNombreLenguaje(String nombreLenguaje){
        return rConocimientos.findByNombreLenguaje(nombreLenguaje);
    }
    
    //guardar experiencia
    public void save(Conocimientos conocimeintos){
       rConocimientos.save(conocimeintos);
    }
    
    //borrar estudios
    public void delete(int id){
        rConocimientos.deleteById(id);
    }
    
    //Ver si el objeto existe al momento de buscar
    public boolean existsById(int id){
        return rConocimientos.existsById(id);
    }
    
    //buscar por nombre
    public boolean existsByNombreLenguaje(String nombreLenguaje){
        return rConocimientos.existsByNombreLenguaje(nombreLenguaje);
    }
}
