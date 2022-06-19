import { Component, OnInit } from '@angular/core';
import { Persona } from '../classes/Persona';
import { PersonaServiceService } from '../service/persona-service.service';

@Component({
  selector: 'app-header-comp',
  templateUrl: './header-comp.component.html',
  styleUrls: ['./header-comp.component.css']
})
export class HeaderCompComponent implements OnInit {
  Persona: Persona = new Persona("","","");

  constructor(public PersonaServiceService:PersonaServiceService) { 

  }

  ngOnInit(): void {
  this.PersonaServiceService.getPersona().subscribe(Persona => {this.Persona = Persona})  
  }

}
