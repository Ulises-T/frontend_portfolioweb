import { Component, OnInit } from '@angular/core';
import { Contacteme } from '../classes/contacteme';
import { ContactemeService } from '../service/contacteme.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-contacteme',
  templateUrl: './contacteme.component.html',
  styleUrls: ['./contacteme.component.css']
})
export class ContactemeComponent implements OnInit {
  contacte: Contacteme[] = [];

  constructor(private contactemeService: ContactemeService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarContacteme();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }
  cargarContacteme(): void {
    this.contactemeService.lista().subscribe(data => { this.contacte = data; })
  }
  delete(id?: number) {
    if (id != undefined) {
      this.contactemeService.delete(id).subscribe(
        data => {
          this.cargarContacteme();
        }, err => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }
  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }
}
