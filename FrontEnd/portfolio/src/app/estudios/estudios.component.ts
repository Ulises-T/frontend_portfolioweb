import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudios } from '../classes/estudios';
import { Persona } from '../classes/Persona';
import { EstudiosService } from "../service/EstudiosService";
import { TokenService } from '../service/token.service';
import { PersonaServiceService } from '../service/persona-service.service';

@Component({
  selector: 'app-estudios',
  templateUrl: './estudios.component.html',
  styleUrls: ['./estudios.component.css']
})
export class EstudiosComponent implements OnInit {
  est: Estudios[] = [];
  Persona: Persona = new Persona("","","","");

  constructor(private sEstudios: EstudiosService, private tokenService: TokenService, private router: Router, public PersonaServiceService:PersonaServiceService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarEstudios();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    };
      this.PersonaServiceService.getPersona().subscribe(data => {this.Persona = data});
      if(this.tokenService.getToken()){
        this.isLogged = true;
      }else{
        this.isLogged = false;
      }
  }
  
  
  cargarEstudios(): void {
    this.sEstudios.lista().subscribe(data => { this.est = data; })
  }
  delete(id?: number) {
    if (id != undefined) {
      this.sEstudios.delete(id).subscribe(
        data => {
          this.cargarEstudios();
        }, err => {
          alert("No se pudo borrar la el Estudio");
        }
      )
    }
  }
}
