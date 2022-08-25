/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.ulisestf.repository;

import com.portfolio.ulisestf.entity.Conocimientos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ulises
 */
public interface RConocimientos extends JpaRepository<Conocimientos, Integer>{
    public Optional<Conocimientos> findByNombreLenguaje(String nombreLenguaje);
    public boolean existsByNombreLenguaje(String nombreLenguaje);    
}