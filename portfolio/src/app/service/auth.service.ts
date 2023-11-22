import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NuevoUsuario } from '../classes/nuevo-usuario';
import { Observable } from 'rxjs';
import { LoginUsuario } from '../classes/login-usuario';
import { JwtDto } from '../classes/jwt-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authURL = 'https://backendulises.herokuapp.com/auth/'

  constructor(private httpClient: HttpClient) { }

public nuevo(nuevoUsuario: NuevoUsuario): Observable<any>{
  return this.httpClient.post<any>(this.authURL + 'nuevo', nuevoUsuario)
}

public login(loginUsuario: LoginUsuario): Observable<JwtDto>{
  return this.httpClient.post<JwtDto>(this.authURL + 'login', loginUsuario);
}

}
