import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConocoimentosService } from '../service/conocoimentos.service';
import { Conocimiento } from '../classes/conocimiento';

@Component({
  selector: 'app-new-conocimento',
  templateUrl: './new-conocimento.component.html',
  styleUrls: ['./new-conocimento.component.css']
})
export class NewConocimentoComponent implements OnInit {
  nombreLenguaje: string = '';
  porcentLenguaje: string = '';

  constructor(private conocimentosService: ConocoimentosService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void {
  const conoc = new Conocimiento(this.nombreLenguaje, this.porcentLenguaje);
  this.conocimentosService.save(conoc).subscribe(data => {
    alert("Conocimeinto Generado");
    this.router.navigate(['']);
  }, err => {
    alert("No se pudo guarda");
    this.router.navigate(['']);
  }
  )
}

}
