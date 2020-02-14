import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Token } from '@angular/compiler/src/ml_parser/lexer';
import { Login } from '../models/Login';

const httpOptions = new HttpHeaders(
  {
    'Content-Type': 'application/json',
    'Authorization': sessionStorage.getItem('token')
  }
);

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = environment.host + 'login';
  constructor(private http: HttpClient) { }
  
  login(login : Login) : Observable<HttpResponse<Token>>{
    return this.http.post<Token>(this.url, login, { observe : 'response'});
  }
}
