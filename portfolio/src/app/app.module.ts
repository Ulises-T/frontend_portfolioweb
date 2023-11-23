  import { NgModule } from '@angular/core';
  import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderCompComponent } from './header-comp/header-comp.component';
import { SobreMiComponent } from './sobre-mi/sobre-mi.component';
import { ExpLaboralComponent } from './exp-laboral/exp-laboral.component';
import { ConocimientosComponent } from './conocimientos/conocimientos.component';
import { ProyectosComponent } from './proyectos/proyectos.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { interceptorProvider } from './service/interceptor-service';
import { NewExperienciaComponent } from './exp-laboral/new-experiencia.component';
import { UpdateExperienciaComponent } from './exp-laboral/update-experiencia.component';
import { EstudiosComponent } from './estudios/estudios.component';
import { NewEstudiosComponent } from './estudios/new-estudios.component';
import { UpdateEstudiosComponent } from './estudios/update-estudios.component';
import { NewConocimentoComponent } from './conocimientos/new-conocimento.component';
import { UpdateConociementoComponent } from './conocimientos/update-conociemento.component';
import { NewProyectoComponent } from './proyectos/new-proyecto.component';
import { UpdateProyectoComponent } from './proyectos/update-proyecto.component';
import { ContactemeComponent } from './contacteme/contacteme.component';
import { NewContactemeComponent } from './contacteme/new-contacteme.component';
import { UpdateContactemeComponent } from './contacteme/update-contacteme.component';





@NgModule({
  declarations: [
    AppComponent,
    HeaderCompComponent,
    SobreMiComponent,
    ExpLaboralComponent,
    ConocimientosComponent,
    ProyectosComponent,
    LoginComponent,
    HomeComponent,
    NewExperienciaComponent,
    UpdateExperienciaComponent,
    EstudiosComponent,
    NewEstudiosComponent,
    UpdateEstudiosComponent,
    NewConocimentoComponent,
    UpdateConociementoComponent,
    NewProyectoComponent,
    UpdateProyectoComponent,
    ContactemeComponent,
    NewContactemeComponent,
    UpdateContactemeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule , 
    ReactiveFormsModule    
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
