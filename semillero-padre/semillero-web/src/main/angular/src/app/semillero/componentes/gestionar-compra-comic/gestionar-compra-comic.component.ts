import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic-dto';
import { GestionarComicComponent } from '../gestionarComic/gestionar-comic/gestionar-comic.component';

/**
 * @description Componente encargado de gestionar la lógica para comprar un comic
 * @author agomeze
 * @see SEMILLERO 2021
 */
@Component({
  selector: 'gestionar-compra-comic',
  templateUrl: './gestionar-compra-comic.component.html',
})
export class GestionarCompraComicComponent implements OnInit {

  public comicDTO : ComicDTO;

  constructor() {
  
  }

  ngOnInit() {
  }

}
