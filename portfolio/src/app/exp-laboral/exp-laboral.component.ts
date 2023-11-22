import { Component, OnInit } from '@angular/core';
import { SExperienciaService } from '../service/s-experiencia.service';
import { TokenService } from '../service/token.service';
import { Experiencia } from '../classes/experiencia';

@Component({
  selector: 'app-exp-laboral',
  templateUrl: './exp-laboral.component.html',
  styleUrls: ['./exp-laboral.component.css']
})
export class ExpLaboralComponent implements OnInit {
  expe: Experiencia[] = [];

  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarExperiencia(): void {
    this.sExperiencia.lista().subscribe(data => { this.expe = data; })
  }
  delete(id?: number) {
    if (id != undefined) {
      this.sExperiencia.delete(id).subscribe(
        data => {
          this.cargarExperiencia();
        }, err => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }
  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }
}