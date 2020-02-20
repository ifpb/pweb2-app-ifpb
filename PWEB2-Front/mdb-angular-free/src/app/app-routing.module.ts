import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', loadChildren: './home/home.module#HomeModule', pathMatch:'full'},
  { path: 'login', loadChildren: './login/login.module#LoginModule', pathMatch:'full' },
  { path: 'cadastro', loadChildren: './cadastro/cadastro.module#CadastroModule', pathMatch:'full'},
  { path: 'aluno/:matricula', loadChildren: './aluno/aluno.module#AlunoModule', canActivate:[AuthGuard]},
  { path: 'home', loadChildren: './home/home.module#HomeModule', pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
