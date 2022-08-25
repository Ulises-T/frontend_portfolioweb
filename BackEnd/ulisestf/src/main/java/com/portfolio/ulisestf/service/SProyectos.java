/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.service;

import com.portfolio.ulisestf.entity.Proyectos;
import com.portfolio.ulisestf.repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
     @Autowired
     RProyectos rProyectos;
     
     public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto){
        return rProyectos.findByNombreProyecto (nombreProyecto);
    }
    
    //guardar Proyectos
    public void save(Proyectos proy){
        rProyectos.save(proy);
    }
    
    
    //borrar Proyectos
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    //Ver si el objeto existe al momento de buscar
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    //buscar por nombre
    public boolean existsByNombreProyecto(String nombreProyecto){
        return rProyectos.existsByNombreProyecto(nombreProyecto);
    }
}
