import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderCompComponent } from './header-comp/header-comp.component';
import { SobreMiComponent } from './sobre-mi/sobre-mi.component';
import { ExpLaboralComponent } from './exp-laboral/exp-laboral.component';
import { ConocimientosComponent } from './conocimientos/conocimientos.component';
import { ProyectosComponent } from './proyectos/proyectos.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import {HttpClientModule} from '@angular/common/http';




@NgModule({
  declarations: [
    AppComponent,
    HeaderCompComponent,
    SobreMiComponent,
    ExpLaboralComponent,
    ConocimientosComponent,
    ProyectosComponent,
    FooterComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
