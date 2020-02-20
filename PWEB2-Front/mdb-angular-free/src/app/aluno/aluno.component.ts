import { Component, OnInit, OnDestroy } from '@angular/core';
import { AlunoService } from '../services/aluno.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Aluno } from '../models/Aluno';
import { Matricula } from '../models/Matricula';
import { Projetos } from '../models/Projetos';

@Component({
  selector: 'app-aluno',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.scss']
})
export class AlunoComponent implements OnInit, OnDestroy {

  panelOpenState = false;
  matriculaAluno: string;
  subscriptions: any = {};
  aluno: Aluno;
  matriculaLogin: Matricula;
  show: string;
  matriculaRecive: string;

  constructor(
    private alunoservice: AlunoService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit() {
    this.alunoservice.teste().subscribe(res => {
      console.log("OpA");
      console.log(res);
    });
    if (this.route.params != null) {
      this.subscriptions.route = this.route.params.subscribe(
        params => {
          this.matriculaAluno = params['matricula'];
          this.getAluno();
        }
      );
      
    }
  }

  getAluno() {
    this.alunoservice.buscar(this.matriculaAluno).subscribe(
      res => {
        this.aluno = res.body
        console.log(this.aluno)
        this.verificarMatricula();
      }
    )
  }

  verificarShow(titulo){
    return this.aluno.projetos[0].titulo === titulo;
  }

  verificarMatricula() {
    this.aluno.matriculas.forEach(element => {
      if(element.valor == this.aluno.id){
        this.matriculaLogin = element;
        console.log(this.matriculaLogin)
      }
    });
  }

  mudarInformacoes(event){
    console.log(event);
    this.aluno.matriculas.forEach(element => {
      if(element.valor == event){
        this.matriculaLogin = element;
        console.log(this.matriculaLogin)
      }
    });
  }

  ngOnDestroy() {
    if (this.subscriptions.route) {
      this.subscriptions.route.unsubscribe();
    }
  }

  logout() {
    sessionStorage.clear();
    this.router.navigate[('/home')]

  }

}
