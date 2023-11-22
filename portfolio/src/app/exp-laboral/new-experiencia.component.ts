import { Component, OnInit } from '@angular/core';
import { SExperienciaService } from '../service/s-experiencia.service';
import { Router } from '@angular/router';
import { Experiencia } from '../classes/experiencia';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {
  nombreExp: string = '';
  descripcionExp: string = '';
  fechaExp: string = '';
  imgExp: string= '';

  constructor(private sExperiencia: SExperienciaService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void {
    const expe = new Experiencia(this.nombreExp, this.descripcionExp, this.fechaExp, this.imgExp);
    this.sExperiencia.save(expe).subscribe(data => {
      alert("Experiencia Generada");
      this.router.navigate(['']);
    }, err => {
      alert("No se pudo guardar la experiencia");
      this.router.navigate(['']);
    }
    )
  }

}
