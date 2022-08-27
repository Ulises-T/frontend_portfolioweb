/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.ulisestf.repository;

import com.portfolio.ulisestf.entity.Contacteme;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RContacteme extends JpaRepository<Contacteme, Integer>{
    public Optional<Contacteme> findByTipoContacto(String tipoContacto);
    public boolean existsByTipoContacto(String tipoContacto);  
}
