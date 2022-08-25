import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NewExperienciaComponent } from './exp-laboral/new-experiencia.component';
import { UpdateExperienciaComponent } from './exp-laboral/update-experiencia.component';
import { NewEstudiosComponent } from './estudios/new-estudios.component';
import { UpdateEstudiosComponent } from './estudios/update-estudios.component';
import { NewConocimentoComponent } from './conocimientos/new-conocimento.component';
import { UpdateConociementoComponent } from './conocimientos/update-conociemento.component';
import { NewProyectoComponent } from './proyectos/new-proyecto.component';
import { UpdateProyectoComponent } from './proyectos/update-proyecto.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'nuevaexperiencia', component: NewExperienciaComponent },
  { path: 'editexp/:id', component: UpdateExperienciaComponent },
  { path: 'nuevoestudio', component: NewEstudiosComponent},
  { path: 'estupdate/:id', component: UpdateEstudiosComponent},
  { path: 'nuevoconocimento', component: NewConocimentoComponent},
  { path: 'conocupdate/:id', component: UpdateConociementoComponent},
  { path: 'nuevoproyecto', component: NewProyectoComponent},
  {path: 'proyectupdate/:id', component: UpdateProyectoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
