import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../classes/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaServiceService {
 /* URL= 'https://backendulises.herokuapp.com/personas/';

  */
   URL= 'portafolio-arg-prog-hme3n7tvq-ulises-projects-1b64f4d4.vercel.app/personas/';
  
  

  constructor(
    private http: HttpClient 
    ) {}

    public getPersona():Observable<Persona>{    
      return this.http.get<Persona>(this.URL+'traer/perfil');
  }
}
