import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Contacteme } from '../classes/contacteme';
import { ContactemeService } from '../service/contacteme.service';

@Component({
  selector: 'app-update-contacteme',
  templateUrl: './update-contacteme.component.html',
  styleUrls: ['./update-contacteme.component.css']
})
export class UpdateContactemeComponent implements OnInit {
  updconta: Contacteme = null;

  constructor(private contactemeService: ContactemeService, private activatedRouter: ActivatedRoute, 
    private router:Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.contactemeService.detail(id).subscribe(
      data =>{
        this.updconta = data;
      }, err =>{
        alert("Error al intentar modificar esta experiencia");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.contactemeService.update(id, this.updconta).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al intentar modificar");
        this.router.navigate(['']);
      } 
    )
  }

}
