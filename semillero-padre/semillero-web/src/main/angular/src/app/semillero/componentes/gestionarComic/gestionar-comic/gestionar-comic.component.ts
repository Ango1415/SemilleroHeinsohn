import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';

/**
 * @description Componente encargado de gestionar la lógica para crear consultar actualizar y eliminar
 * @author agomeze
 * @see SEMILLERO 2021
 */
@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html'
})
export class GestionarComicComponent implements OnInit {

  public comicDTO : ComicDTO;
  public comicDTOInfo : ComicDTO;
  public listaComics : Array<ComicDTO>;
  public mostrarItem : boolean;

  constructor() { }

  ngOnInit() {
    this.comicDTO = new ComicDTO(); //Una vez definido esto ya podemos usar el ngModel en nuestro .html
    this.listaComics = new Array<ComicDTO>();
    this.mostrarItem = false;
  }

  public crearComic() : void {
    this.listaComics.push(this.comicDTO);
    this.comicDTO = new ComicDTO(); //Instanciamos un nuevo objeto y quedamos a la espera de nueva informacion para el mismo
  }

  private limpiarDatosComic( comicDTO : ComicDTO) : void{

    //Esta clase no la estamos usando pero igual la dejamos ahí por si la llegamos a necesitar
    comicDTO.nombre = null;
    comicDTO.coleccion = null;
    comicDTO.color = null;
    comicDTO.editorial = null;
    comicDTO.id = null;
    comicDTO.tematicaEnum = null;
    comicDTO.precio = null;
    comicDTO.numeroPaginas = null;
    comicDTO.autores = null;
  }

  public imprimirInfoComic(posicion : number) : void {
    this.mostrarItem = true;
    this.comicDTOInfo = this.listaComics[posicion];
  }

  public cerrar() : void {
    this.mostrarItem = false;
  }
}
