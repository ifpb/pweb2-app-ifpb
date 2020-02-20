import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

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
  private url = environment.host+'api/aluno/';

  private urlRegistro = environment.host+'api/register/';

  constructor(private http: HttpClient) { }

  // listar(): Observable<HttpResponse<Aluno[]>> {
  //   return this.http.get<Aluno[]>(this.url, { headers: httpOptions, observe: 'response' });
  // }

}
