/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.service;

import com.portfolio.ulisestf.entity.Experiencia;
import com.portfolio.ulisestf.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return rExperiencia.findByNombreExp(nombreExp);
    }
    
    //guardar experiencia
    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }
    
    //borrar experiencia
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    //Ver si el objeto existe al momento de buscar
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    //buscar por nombre
    public boolean existsByNombreExp(String nombreExp){
        return rExperiencia.existsByNombreExp(nombreExp);
    }
    
}
