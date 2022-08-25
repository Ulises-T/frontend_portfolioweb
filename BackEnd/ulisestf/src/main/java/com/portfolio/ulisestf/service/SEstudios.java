/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.service;

import com.portfolio.ulisestf.entity.Estudios;
import com.portfolio.ulisestf.repository.REstudios;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudios {
    @Autowired
    REstudios rEstudios;
    
    public List<Estudios> list(){
        return rEstudios.findAll();
    }
    
        public Optional<Estudios> getOne(int id){
        return rEstudios.findById(id);
    }
    
    public Optional<Estudios> getByNombreEst(String nombreEst){
        return rEstudios.findByNombreEst(nombreEst);
    }
    
    //guardar experiencia
    public void save(Estudios estudios){
        rEstudios.save(estudios);
    }
    
    //borrar estudios
    public void delete(int id){
        rEstudios.deleteById(id);
    }
    
    //Ver si el objeto existe al momento de buscar
    public boolean existsById(int id){
        return rEstudios.existsById(id);
    }
    
    //buscar por nombre
    public boolean existsByNombreEst(String nombreEst){
        return rEstudios.existsByNombreEst(nombreEst);
    }
    
}
