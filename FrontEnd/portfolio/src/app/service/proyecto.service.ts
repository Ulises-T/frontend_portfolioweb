import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Proyecto } from '../classes/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {
  proyURL = 'http://localhost:8080/proyectos/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Proyecto[]> {
    return this.httpClient.get<Proyecto[]>(this.proyURL + 'lista');
  }

  public detail(id: number): Observable<Proyecto> {
    return this.httpClient.get<Proyecto>(this.proyURL + `detail/${id}`);
  }

  public save(proyecto: Proyecto): Observable<any> {
    return this.httpClient.post<any>(this.proyURL + 'create', proyecto);
  }

  public update(id: number, proyecto: Proyecto): Observable<any> {
    return this.httpClient.put<any>(this.proyURL + `update/${id}`, proyecto);
  }

  delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.proyURL + `delete/${id}`);
  }
}
