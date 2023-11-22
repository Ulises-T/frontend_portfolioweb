import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../classes/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaServiceService {
  URL= 'https://backendulises.herokuapp.com/personas/';
  

  constructor(
    private http: HttpClient 
    ) {}

    public getPersona():Observable<Persona>{    
      return this.http.get<Persona>(this.URL+'traer/perfil');
  }
}
