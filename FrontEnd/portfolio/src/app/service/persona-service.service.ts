import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../classes/Persona';


@Injectable({
  providedIn: 'root'
})
export class PersonaServiceService {
  URL= 'http://localhost:5000/persona';
  

  constructor(
    private http: HttpClient 
    ) {}

    getPersona():Observable<Persona>{    
      return this.http.get<Persona>(this.URL+'/1');
  }
}
