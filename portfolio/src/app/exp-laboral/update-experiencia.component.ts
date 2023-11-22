import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from '../classes/experiencia';
import { SExperienciaService } from '../service/s-experiencia.service';

@Component({
  selector: 'app-update-experiencia',
  templateUrl: './update-experiencia.component.html',
  styleUrls: ['./update-experiencia.component.css']
})
export class UpdateExperienciaComponent implements OnInit {
  expLab: Experiencia = null;

  constructor(private sExperiencia: SExperienciaService, private activatedRouter: ActivatedRoute, 
    private router:Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperiencia.detail(id).subscribe(
      data =>{
        this.expLab = data;
      }, err =>{
        alert("Error al intentar modificar esta experiencia");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sExperiencia.update(id, this.expLab).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al intentar modificar esta experiencia");
        this.router.navigate(['']);
      } 
    )
  }

}
