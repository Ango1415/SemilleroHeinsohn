import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarCompraComicComponent } from './semillero/componentes/gestionar-compra-comic/gestionar-compra-comic.component';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic/gestionar-comic.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [ //Esto es un array de configuración de navegación
  //{ path: 'bienvenida', component: BienvenidaComponent, data : null, outlet : '' }, //Path es una palabra clave, component lo mismo, data es para ennviar datos pero se ven en la url, por lo que no lo usaremos, outlet es donde escojo el router outlet que quiero para enrutar si es que tenemos más de un router outlet
  { path: 'bienvenida', component: BienvenidaComponent, data : null},
  { path: 'gestionar-comic', component: GestionarComicComponent}, //Primero ejecuta el .ts y luego el .html
  { path: 'gestionar-compra-comic', component: GestionarCompraComicComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
