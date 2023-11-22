import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Estudios } from '../classes/Estudios';
import { EstudiosService } from '../service/EstudiosService';

@Component({
  selector: 'app-update-estudios',
  templateUrl: './update-estudios.component.html',
  styleUrls: ['./update-estudios.component.css']
})
export class UpdateEstudiosComponent implements OnInit {
  estuptate: Estudios = null;

  constructor(private sEstudio: EstudiosService, private activatedRouter: ActivatedRoute, 
    private router:Router) { }

    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sEstudio.detail(id).subscribe(
        data =>{
          this.estuptate = data;
        }, err =>{
          alert("Error al intentar modificar este estudio");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate():void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.sEstudio.update(id, this.estuptate).subscribe(
        data => {
          this.router.navigate(['']);
        }, err => {
          alert("Error al intentar modificar este Estudio");
          this.router.navigate(['']);
        } 
      )
    }
  
  }
  