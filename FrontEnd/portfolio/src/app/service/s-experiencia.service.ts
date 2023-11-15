import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Experiencia } from '../classes/experiencia';

@Injectable({
  providedIn: 'root'
})
export class SExperienciaService {
 /* expURL = 'https://backendulises.herokuapp.com/expelab/'

  */
   expURL= 'portafolio-arg-prog-hme3n7tvq-ulises-projects-1b64f4d4.vercel.app/expelab/';
  

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Experiencia[]> {
    return this.httpClient.get<Experiencia[]>(this.expURL + 'lista');
  }
  public detail(id: number): Observable<Experiencia> {
    return this.httpClient.get<Experiencia>(this.expURL + `detail/${id}`);
  }
  public save(experiencia: Experiencia): Observable<any> {
    return this.httpClient.post<any>(this.expURL + 'create', experiencia);
  }
  public update(id: number, experiencia: Experiencia): Observable<any> {
    return this.httpClient.put<any>(this.expURL + `update/${id}`, experiencia);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }
}
