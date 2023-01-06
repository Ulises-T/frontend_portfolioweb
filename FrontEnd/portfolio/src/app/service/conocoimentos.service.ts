import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Conocimiento } from '../classes/conocimiento';

@Injectable({
  providedIn: 'root'
})
export class ConocoimentosService {
  URL= 'https://portafolio-arg-prog-production.up.railway.app/conocimientos/';


  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Conocimiento[]> {
    return this.httpClient.get<Conocimiento[]>(this.URL + 'lista');
  }
  public detail(id: number): Observable<Conocimiento> {
    return this.httpClient.get<Conocimiento>(this.URL + `detail/${id}`);
  }
  public save(conocimento: Conocimiento): Observable<any> {
    return this.httpClient.post<any>(this.URL + 'create', conocimento);
  }
  public update(id: number, conocimento: Conocimiento): Observable<any> {
    return this.httpClient.put<any>(this.URL + `update/${id}`, conocimento);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
