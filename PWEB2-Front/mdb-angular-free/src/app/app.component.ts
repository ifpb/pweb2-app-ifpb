import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import * as jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'MDB Raul';
  showMenu: boolean = true;


  constructor(
    private router: Router
  ){}

  ngOnInit(){
    // this.verifica();
  }

verifica(){
  console.log("Comeco")
  console.log(sessionStorage.getItem('token'))
  if (sessionStorage.getItem('token')!= null) {
    try {
      console.log("TRY")
      jwt_decode(sessionStorage.getItem("token"));
      this.showMenu = true;

      this.router.events.subscribe(event => {

        if (event instanceof NavigationEnd) {
          let url: string
          url = event.url
          if (url == "/") {
            console.log(url)
            this.router.navigate(['/home']);
          }
          else if (url == "/login") {
            console.log(url)
            this.router.navigate([url]);
          }
          else {
            console.log("Ultimo else")
            this.router.navigate([url]);
          }
        }
      });

    }
    catch (Error) {
      console.log("entrou 1 catch")
      this.showMenu = false
      this.router.navigate(['/login']);
    }
  }
  else {
    console.log("entrou no else")
    this.router.navigate(['/login']);
  }
}

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('/login')
  }
}
