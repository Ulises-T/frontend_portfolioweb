
package com.portfolio.ulisestf.Interface;

import com.portfolio.ulisestf.entity.Persona;
import java.util.List;



public interface IPersonaService {
    //Traer una lista de personas
  public List<Persona> getPersona();
  
  // Guardar un objeto de tipo Persona
  public void savePersona(Persona persona);
  
  //Eliminar un objeto de tipo Persona
  public void deletePersona(Long id);
  
  //Buscar un objeto de tipo Persona
  public Persona findPersona(Long id);
}
