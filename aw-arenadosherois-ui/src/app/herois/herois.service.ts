import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeroisService {

  private api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  listar(): Observable<any> {
    return this.http.get<any>(`${this.api}/herois`);
  }

  listaruniverso(): Observable<any> {
    return this.http.get<any>(`${this.api}/universos`);
  }

  cadastro(heroi: any): Observable<any> {
    return this.http.post<any>(`${this.api}/herois`, heroi);
  }

  listaridalterego(): Observable<any> {
    return this.http.get<any>(`${this.api}/idalteregos`);
  }

  retornardadosdeheroi(heroi: any): Observable<any> {
     return this.http.post<any>(`${this.api}/alteregos`, heroi);
  }

  capturardadosdeheroi(): Observable<any> {
    return this.http.get<any>(`${this.api}/alteregos`);
  }

  retornaoponentes(): Observable<any> {
    return this.http.get<any>(`${this.api}/oponentes`);
  }

  alterardadosdeheroi(heroi: any): Observable<any> {
    return this.http.put<any>(`${this.api}/herois`, heroi);
  }

  resultadodacontenda(oponentes: any): Observable<any> {
    return this.http.post<any>(`${this.api}/oponentes`, oponentes);
  }

  retornavencedor(): Observable<any> {
    return this.http.get<any>(`${this.api}/vencedor`);
  }

}
