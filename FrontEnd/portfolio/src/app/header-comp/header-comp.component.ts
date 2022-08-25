import { Component, OnInit } from '@angular/core';
import { Persona } from '../classes/Persona';
import { PersonaServiceService } from '../service/persona-service.service';
import { Router } from '@angular/router';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-header-comp',
  templateUrl: './header-comp.component.html',
  styleUrls: ['./header-comp.component.css']
})
export class HeaderCompComponent implements OnInit {
  Persona: Persona = new Persona("","","","");
  isLogged = true;

  constructor(private router: Router, private tokenService:TokenService, public PersonaServiceService:PersonaServiceService) { 

  }

  ngOnInit(): void {
  this.PersonaServiceService.getPersona().subscribe(data => {this.Persona = data});
  if(this.tokenService.getToken()){
    this.isLogged = true;
  }else{
    this.isLogged = false;
  }
  }

  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login'])
  }

}
