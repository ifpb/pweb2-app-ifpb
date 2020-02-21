import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { NomeCampiDTO } from '../models/NomeCampiDTO';
import { QuantCursosDTO } from '../models/QuantCursosDTO';
import { NomeSituacoesDTO } from '../models/NomeSituacoesDTO';
import { NomeCursosDTO } from '../models/NomeCursosDTO';
import { QuantCampusCursoDTO } from '../models/QuantCampusCursoDTO';

const httpOptions = new HttpHeaders(
  {
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${sessionStorage.getItem('token')}`
  }
);

@Injectable({
  providedIn: 'root'
})
export class CampiService {
  private url = environment.host+'api/campi/';


  constructor(private http: HttpClient) { }


  getCursos(nomeCampus:string): Observable<HttpResponse<NomeCursosDTO[]>> {
    return this.http.get<NomeCursosDTO[]>(this.url + nomeCampus + '/cursos',  { headers: httpOptions, observe: 'response' });
  }

  getNomeCampus(nomeCampus:string): Observable<HttpResponse<QuantCursosDTO>> {
    return this.http.get<QuantCursosDTO>(this.url + 'campus/' + nomeCampus,  { headers: httpOptions, observe: 'response' });
  }


  getNomeCampusNomeCurso(nomeCampus:string, nomeCurso:string): Observable<HttpResponse<QuantCursosDTO>> {
    return this.http.get<QuantCursosDTO>(this.url + 'campus/' + nomeCampus + '/curso/' + nomeCurso , { headers: httpOptions, observe: 'response' });
  }

  getNomeCampusSituacao(nomeCampus:string, situacao:string): Observable<HttpResponse<QuantCursosDTO>> {
    return this.http.get<QuantCursosDTO>(this.url + 'campus/' + nomeCampus + '/situacao/' + situacao , { headers: httpOptions, observe: 'response' });
  }

  getNomeCampusCursoSituacao(nomeCampus:string, curso:string, situacao:string): Observable<HttpResponse<QuantCursosDTO>> {
    return this.http.get<QuantCursosDTO>(this.url + 'campus/' + nomeCampus + '/curso/' + curso + '/situacao/' + situacao , { headers: httpOptions, observe: 'response' });
  }

  getSituacoes(): Observable<HttpResponse<NomeSituacoesDTO[]>> {
    return this.http.get<NomeSituacoesDTO[]>(this.url + 'situacoes', { headers: httpOptions, observe: 'response' });
  }

  getQuantCursoPorCampus(nomeCampus: string, situacao: string): Observable<HttpResponse<QuantCampusCursoDTO[]>> {
    return this.http.get<QuantCampusCursoDTO[]>(this.url + 'campus/' + nomeCampus + '/cursos/situacao/' + situacao , { headers: httpOptions, observe: 'response' });
  }

}
