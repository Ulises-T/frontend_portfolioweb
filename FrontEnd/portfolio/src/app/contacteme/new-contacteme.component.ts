import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contacteme } from '../classes/contacteme';
import { ContactemeService } from '../service/contacteme.service';

@Component({
  selector: 'app-new-contacteme',
  templateUrl: './new-contacteme.component.html',
  styleUrls: ['./new-contacteme.component.css']
})
export class NewContactemeComponent implements OnInit {
  tipoContacto: string = '';
 direccionContacto: string = '';


  constructor(private contactemeService: ContactemeService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void {
    const cont = new Contacteme(this.tipoContacto, this.direccionContacto);
    this.contactemeService.save(cont).subscribe(data => {
      alert("Contacteme Generado");
      this.router.navigate(['']);
    }, err => {
      alert("No se pudo guardar");
      this.router.navigate(['']);
    }
    )
  }

}
