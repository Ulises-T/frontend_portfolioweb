/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ulisestf.service;

import com.portfolio.ulisestf.entity.Contacteme;
import com.portfolio.ulisestf.repository.RContacteme;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContacteme {
    @Autowired
    RContacteme rContacteme;
    
    public List<Contacteme> list(){
        return rContacteme.findAll();
    }
    
    public Optional<Contacteme> getOne(int id){
        return rContacteme.findById(id);
    }
    
    public Optional<Contacteme> getByTipoContacto(String tipoContacto){
        return rContacteme.findByTipoContacto(tipoContacto);
    }
    
    //guardar experiencia
    public void save(Contacteme contact){
        rContacteme.save(contact);
    }
    
    //borrar experiencia
    public void delete(int id){
        rContacteme.deleteById(id);
    }
    
    //Ver si el objeto existe al momento de buscar
    public boolean existsById(int id){
        return rContacteme.existsById(id);
    }
    
    //buscar por nombre
    public boolean existsByTipoContacto(String tipoContacto){
        return rContacteme.existsByTipoContacto(tipoContacto);
    }
    
}