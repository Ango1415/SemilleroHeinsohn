/**
 * Contiene el inicio de nuestra aplicación, es el mismo app route que hay en index.html
 */
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private miObjeto : any;
  constructor(private router : Router) {
    
  }  

  ngOnInit(): void {
    this.router.navigate(['bienvenida']); // En primera instancia, navegará al componente bienvenida, es ña imagen del niño
    
  }
}
