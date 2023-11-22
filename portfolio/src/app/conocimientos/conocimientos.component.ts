import { Component, OnInit } from '@angular/core';
import { Conocimiento } from '../classes/conocimiento';
import { ConocoimentosService } from '../service/conocoimentos.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-conocimientos',
  templateUrl: './conocimientos.component.html',
  styleUrls: ['./conocimientos.component.css']
})
export class ConocimientosComponent implements OnInit {
conoc: Conocimiento[] = [];

  constructor(private conocimentoService: ConocoimentosService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarConocimiento();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarConocimiento(): void {
    this.conocimentoService.lista().subscribe(data => { this.conoc = data; })
  }
  delete(id?: number) {
    if (id != undefined) {
      this.conocimentoService.delete(id).subscribe(
        data => {
          this.cargarConocimiento();
        }, err => {
          alert("No se pudo borrar");
        }
      )
    }
  }
}
