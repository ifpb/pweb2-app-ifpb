import { Component, OnInit, OnDestroy } from '@angular/core';
import { AlunoService } from '../services/aluno.service';
import { ActivatedRoute } from '@angular/router';
import { Aluno } from '../models/Aluno';

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

  constructor(
    private alunoservice: AlunoService,
    private route: ActivatedRoute,
    ) { }

  ngOnInit() {
    if(this.route.params != null){
      this.subscriptions.route = this.route.params.subscribe(
        params => {
          this.matriculaAluno = params['matricula'];
          this.getAluno();          
        }
      )
    }
  }

  getAluno(){
    this.alunoservice.buscar(this.matriculaAluno).subscribe(
      res => {
        this.aluno = res.body
        console.log(this.aluno)
      }
    )
  }

  ngOnDestroy(){
    if(this.subscriptions.route){
      this.subscriptions.route.unsubscribe();
    }
  }

}
