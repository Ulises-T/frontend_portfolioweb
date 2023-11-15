import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contacteme } from '../classes/contacteme';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactemeService {
 /* contURL = 'https://backendulises.herokuapp.com/contacteme/' 
   */
  contURL = 'portafolio-arg-prog-hme3n7tvq-ulises-projects-1b64f4d4.vercel.app/contacteme/';
 

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Contacteme[]> {
    return this.httpClient.get<Contacteme[]>(this.contURL + 'lista');
  }
  public detail(id: number): Observable<Contacteme> {
    return this.httpClient.get<Contacteme>(this.contURL + `detail/${id}`);
  }
  public save(contacteme: Contacteme): Observable<any> {
    return this.httpClient.post<any>(this.contURL + 'create', contacteme);
  }
  public update(id: number, contacteme: Contacteme): Observable<any> {
    return this.httpClient.put<any>(this.contURL + `update/${id}`, contacteme);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.contURL + `delete/${id}`);
  }
}

