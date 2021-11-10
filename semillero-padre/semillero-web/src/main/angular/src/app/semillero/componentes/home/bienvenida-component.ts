import { Component, OnInit } from '@angular/core'; //Esta importación nos permite usar la notación Component, OnInit es una interfaz que implementaremos ene esta clase
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({ //Esta etiqueta es la que hace que se comporte como un componente, estos dos atributos son de forma obligatoria para todos los componentes
  selector: 'bienvenida', //Este será el nombre para nuestro componente, se puede usar como un tag o etiqueta de html
  templateUrl: './bienvenida-component.html', //Define dónde está la ruta del html que va a renderizar mi componente
  //styleUrls: 'aquí iría la url de la hoja de estilos que quisiera implementar'
})
/**
 * Note que de acuerdo al nombre de los componentes, la carpeta que contiene los .ts y .html no deberia llamarse home sino bienvenida
 */
export class BienvenidaComponent implements OnInit { //el export es para que el componente sea visible para todo el mundo
  //El nombre de la clase es el que debemos poner en el AppModule para que me lo pueda reconocer como un componente
  public urlImagen : string;
  
  constructor(private router : Router, private activatedRoute: ActivatedRoute) { //El constructor nos permite inyectar servicios, utilidades o clases propias de angular para funcionalidad
    //Router nos permite realizar la navegacion (el color opaco significa que no lo estamos usando), activateRoute si lo estoy usando
    console.log("entro al constructor del componente bienvenida");
  }

  ngOnInit(): void { //Este método será el primero en ejecutarse cuando se vaya a renderizar el componente, inicializar variable o consultas de info que necesite
    this.urlImagen = "https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg";
    let data = this.activatedRoute.snapshot.params;
    
    console.log("Parametros recibidos " + data);
    
  }

  public ejecucionEventoClick( parametroEvento : any, numero : number ) : void { //Evento
    alert("Hola: " + parametroEvento + ' ' + numero);
    
  }

}