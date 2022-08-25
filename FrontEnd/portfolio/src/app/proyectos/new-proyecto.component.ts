import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from '../classes/proyecto';
import { ProyectoService } from '../service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
  nombreProyecto: string;
  descripcionProyecto: string;
  imgProyecto:string;
  urlProyecto:string;

  constructor(private proyectoService: ProyectoService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void {
    const proy = new Proyecto(this.nombreProyecto, this.nombreProyecto, this.nombreProyecto, this. urlProyecto);
    this.proyectoService.save(proy).subscribe(data => {
      alert("Proyecto Generado");
      this.router.navigate(['']);
    }, err => {
      alert("No se pudo guardar la experiencia");
      this.router.navigate(['']);
    }
    )
  }

}
