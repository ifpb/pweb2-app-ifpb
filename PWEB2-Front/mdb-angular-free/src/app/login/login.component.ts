import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material';
import Swal from 'sweetalert2';
import { Login } from '../models/Login';
import { Token } from '../models/Token';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public matcher = new MyErrorStateMatcher();
  public login: Login = new Login();
  public token: Token = new Token();
  public usuarioAutenticado:boolean = false;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
    sessionStorage.clear();
  }

  cadastro(){
    this.router.navigate[('/cadastro')]
  }

  loginUsuario() {
    try {
      this.loginService.login(this.login).subscribe(res => {
        console.log(res);
        console.log('foi');
        this.token.token = res.body.token;
        sessionStorage.setItem("token", this.token.token);
        if(sessionStorage.getItem("token") != null){
          this.usuarioAutenticado = true;
          this.router.navigate(['/aluno', this.login.matricula]);
          console.log(sessionStorage.getItem('token'))
        }
      },
      error => {
        console.log(error)
        Swal.fire({
          icon: 'error',
          title: 'Não foi possivel efetuar login!',
          text: 'Tente novamente',
          confirmButtonColor:'#FF8BAB'
        })
      });
    } catch (e) {
      console.log(e);
    }

  }


}
