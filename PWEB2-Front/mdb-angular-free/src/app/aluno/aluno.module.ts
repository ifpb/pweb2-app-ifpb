import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AlunoComponent } from './aluno.component';
import { AlunoRoutingModule } from './aluno-routing.module';


@NgModule({
  declarations: [AlunoComponent],
  imports: [
  CommonModule,
    FormsModule,
    MDBBootstrapModule,
    AlunoRoutingModule,
    ReactiveFormsModule,
  ]
})
export class AlunoModule { }
