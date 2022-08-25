import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EstudiosService } from '../service/EstudiosService';
import { Estudios } from '../classes/estudios';

@Component({
  selector: 'app-new-estudios',
  templateUrl: './new-estudios.component.html',
  styleUrls: ['./new-estudios.component.css']
})
export class NewEstudiosComponent implements OnInit {
  nombreEst: string = '';
  descripcionEst: string = '';
  fechaEst: string = '';

  constructor(private sEstudios: EstudiosService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void {
    const estudios = new Estudios(this.nombreEst, this.descripcionEst, this.fechaEst);
    this.sEstudios.save(estudios).subscribe(data => {
      alert("Estudio Generada");
      this.router.navigate(['']);
    }, err => {
      alert("No se pudo guardar El Estudio");
      this.router.navigate(['']);
    }
    )
  }
}
