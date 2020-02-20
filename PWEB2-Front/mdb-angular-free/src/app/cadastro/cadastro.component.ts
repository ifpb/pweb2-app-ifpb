import { Component, OnInit } from '@angular/core';
import { Login } from '../models/Login';
import { AlunoService } from '../services/aluno.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  login: Login = new Login();

  constructor(
    private alunoService: AlunoService,
    private router: Router,
  ) { }

  ngOnInit() {
  }

  cadastrarAluno() {
    this.alunoService.salvar(this.login).subscribe(
      res => {
        console.log("foi");
        Swal.fire({
          icon: 'success',
          title: 'Cadastrado com sucesso!',
          text: 'retornando ao login',
          confirmButtonColor:'#00FF00'
        }).then(result =>{
          this.router.navigate[('/login')];
        }).catch(erro =>{
          console.log(erro);
        })
      },
      erro => {
        Swal.fire({
          icon: 'error',
          title: 'Não foi possivel efetuar cadastro!',
          text: 'Tente novamente',
          confirmButtonColor:'#FF8BAB'
        })
      });
    }
}
