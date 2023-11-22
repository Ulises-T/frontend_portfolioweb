import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConocoimentosService } from '../service/conocoimentos.service';
import { Conocimiento } from '../classes/conocimiento';

@Component({
  selector: 'app-update-conociemento',
  templateUrl: './update-conociemento.component.html',
  styleUrls: ['./update-conociemento.component.css']
})
export class UpdateConociementoComponent implements OnInit {
  conocim: Conocimiento = null;

  constructor(private conocimientoService: ConocoimentosService,private activatedRouter: ActivatedRoute, 
    private router:Router ) { }

    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.conocimientoService.detail(id).subscribe(
        data =>{
          this.conocim = data;
        }, err =>{
          alert("Error al intentar modificar este conocimiento");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate():void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.conocimientoService.update(id, this.conocim).subscribe(
        data => {
          this.router.navigate(['']);
        }, err => {
          alert("Error al intentar modificar este conocimiento");
          this.router.navigate(['']);
        } 
      )
    }
} 
