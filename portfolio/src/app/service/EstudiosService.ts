import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Estudios } from '../classes/Estudios';
import { Persona } from '../classes/Persona';


@Injectable({
  providedIn: 'root'
})
export class EstudiosService {
  /*estURL = 'https://backendulises.herokuapp.com/estudios/';
  URL= 'https://backendulises.herokuapp.com/personas/';
*/
  

  estURL = 'https://portafolio-arg-prog-production.up.railway.app/estudios/';
  URL= 'https://portafolio-arg-prog-production.up.railway.app/personas/';



  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Estudios[]> {
    return this.httpClient.get<Estudios[]>(this.estURL + 'lista');
  }
  public detail(id: number): Observable<Estudios> {
    return this.httpClient.get<Estudios>(this.estURL + `detail/${id}`);
  }
  public save(estudios: Estudios): Observable<any> {
    return this.httpClient.post<any>(this.estURL + 'create', estudios);
  }
  public update(id: number, estudios: Estudios): Observable<any> {
    return this.httpClient.put<any>(this.estURL + `update/${id}`, estudios);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.estURL + `delete/${id}`);
  }
  public getPersona():Observable<Persona>{    
    return this.httpClient.get<Persona>(this.URL+'traer/perfil');
}
}
