import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Aluno } from '../models/Aluno';
import { Observable } from 'rxjs';
import { Login } from '../models/Login';

const httpOptions = new HttpHeaders(
  {
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${sessionStorage.getItem('token')}`
  }
);

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  private url = environment.host+'api/aluno/';

  private urlRegistro = environment.host+'api/register/';

  constructor(private http: HttpClient) {
  }

  salvar(login : Login): Observable<HttpResponse<Login>> {
    return this.http.post<Login>(this.urlRegistro, login , { headers: httpOptions, observe: 'response' });
  }

  listar(): Observable<HttpResponse<Aluno[]>> {
    return this.http.get<Aluno[]>(this.url, { headers: httpOptions, observe: 'response' });
  }

  buscar(matricula: string): Observable<HttpResponse<Aluno>>{
    return this.http.get<Aluno>(this.url + "aluno/" + matricula, {headers: httpOptions, observe: 'response'});
  }

  teste():Observable<HttpResponse<any>> {
    return this.http.get<any>("http://192.168.0.124:8082/campus/CAJAZEIRAS/curso/TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS - CAJAZEIRAS (CAMPUS CAJAZEIRAS)", {observe: 'response'});
  }

}
