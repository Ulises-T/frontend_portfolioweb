import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from '../classes/proyecto';
import { ProyectoService } from '../service/proyecto.service';

@Component({
  selector: 'app-update-proyecto',
  templateUrl: './update-proyecto.component.html',
  styleUrls: ['./update-proyecto.component.css']
})
export class UpdateProyectoComponent implements OnInit {
  proyect: Proyecto = null;

  constructor(private proyectoService: ProyectoService, private activatedRouter: ActivatedRoute, 
  private router:Router) { }

  ngOnInit(): void {
    const id=this.activatedRouter.snapshot.params['id'];
    this.proyectoService.detail(id).subscribe(
      data => {
        this.proyect = data;
      }, err =>{
      alert("Error al intentar modificar este Proyecto");
      this.router.navigate(['']);
    }
    )
  }
  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.proyectoService.update(id, this.proyect).subscribe(
      data => {
        alert("Proyecto Actualizado");
        this.router.navigate(['']);
      }, err => {
        alert("Error al intentar modificar este Proyecto");
        this.router.navigate(['']);
      } 
    )
  }

}
