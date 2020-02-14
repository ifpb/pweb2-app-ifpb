import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Aluno } from '../models/Aluno';
import { Observable } from 'rxjs';

const httpOptions = new HttpHeaders(
  {
    'Content-Type': 'application/json',
    'Authorization': sessionStorage.getItem('token')
  }
);

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  private url = environment.host+'aluno';

  constructor(private http: HttpClient) {
  }

  salvar(aluno : Aluno): Observable<HttpResponse<Aluno>> {
    return this.http.post<Aluno>(this.url, aluno , { headers: httpOptions, observe: 'response' });
  }

  listar(): Observable<HttpResponse<Aluno[]>> {
    return this.http.get<Aluno[]>(this.url, { headers: httpOptions, observe: 'response' });
  }

}
