import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { CadastroComponent } from './cadastro.component';
import { CadastroRoutingModule} from './cadastro-routing.module'


@NgModule({
  declarations: [CadastroComponent],
  imports: [
  CommonModule,
    FormsModule,
    MDBBootstrapModule,
    CadastroRoutingModule,
    ReactiveFormsModule,
  ]
})
export class CadastroModule { }
