import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';

@Component({
  selector: 'crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {

  private nombreInstructor : string;

  public listaComics : Array<any>;

  public urlImagen : string;

  constructor() { }

  ngOnInit() {

    this.nombreInstructor = "Angel Gomez";
    this.listaComics = new Array<any>();
    this.urlImagen = "https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg";

    let edadInstructor : number = 26;

    if(edadInstructor < 33){
      let resultadoCalculo : number = 2;
      let resultado : number = resultadoCalculo + edadInstructor;
    }

    let concatenacion : string = "";
    for (let index = 0; index < this.nombreInstructor.length; index++) {
      const element = this.nombreInstructor[index];
      concatenacion = concatenacion + element;
    }
    this.nombreInstructor = this.obtenerNombre();

    this.simularCrearComic();
  }

  private obtenerNombre() : string {
    this.nombreInstructor = "Shakira";
    let nombreInstructor = "Juanes";
    let apellidoInstructor = "Barrera";

    return nombreInstructor + apellidoInstructor;
  }

  private simularCrearComic() : void {
    let comic1 : any = {
      id : 1,
      nombre : "Superman II",
      tematicaEnum : "AVENTURAS",
      precio : 300
    }

    let comic2 : any = {
      id : 1,
      nombre : "Dr. Strange y Spiderman",
      tematicaEnum : "AVENTURAS",
      precio : 500
    }

    let comic3 : any = new ComicDTO();
    comic3.id = 3;
    comic3.nombre = "Chapulin Colorado"
    comic3.tematicaEnum = "HUMORISTICO"
    comic3.precio = 500

    this.listaComics.push(comic1);
    this.listaComics.push(comic2);
    this.listaComics.push(comic3);

    this.listaComics.forEach(comic =>{
      console.log("Comic con nombre: " + comic.nombre + " con precio de: " + comic.precio)
    });

  }

}