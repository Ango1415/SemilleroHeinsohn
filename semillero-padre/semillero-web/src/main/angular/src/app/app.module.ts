import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

import { AppComponent } from './app.component';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { CrearPersonaComponent } from './semillero/componentes/crearPersona/crear-persona/crear-persona.component';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic/gestionar-comic.component';
import { GestionarCompraComicComponent } from './semillero/componentes/gestionar-compra-comic/gestionar-compra-comic.component';
//import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';

// DTOs
//export { ComicDTO } from './semillero/dto/comic.dto';
//export { ResultadoDTO } from './semillero/dto/resultado.dto';

/**
 * Aquí agregaremos todos los componentes nuevos que yo vaya creando para poder visualizarlos y  usarlos
 * Debo importarlo y luego agragarlo acá abajo en declarations
 */
@NgModule({
  declarations: [ //COMPONENTES QUE VAYAMOS CREANDO
    AppComponent, //Siempre viene creado, es el componente clave para que todo funcione
    MenuComponent,
    BienvenidaComponent,
    CrearPersonaComponent,
    GestionarComicComponent,
    GestionarCompraComicComponent, //Puede estar o no la ultima coma, se deja por buena practica en seña de que puede importarse otros componentes
  ],
  imports: [ //FUNCIONALIDADES DE ANGULAR
    BrowserModule, //Manejar diferentes modulos
    AppRoutingModule, //Gestiona los direccionamientos
    HttpModule,
    HttpClientModule, //Sirve para todo lo relacionado con servicios
    FormsModule, //Relacionado con formularios reactivos, realizar validaciones
    ReactiveFormsModule //Trabaja con FormsModule
  ],
  providers: [
  	{ provide: APP_BASE_HREF, useValue: '/SemilleroHBT' } //Raíz de nuestro proyecto y la agrega a la URL /SemilleroHBT
  ],
  bootstrap: [AppComponent] //Define el componente inicial y principal, llamado AppComponent, el cual es el mismo app route que estaba el el index.html y que tiene nuestro inicio de aplicación
})
export class AppModule { 

}
