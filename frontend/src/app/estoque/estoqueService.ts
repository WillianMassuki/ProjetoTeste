import { environment } from 'src/environments/environment';
import { Estoque } from './estoque';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable
({
    providedIn : 'root'
})
export class EstoqueService {

    apiUrl: string = environment.apiURLBase + '/estoque';
searchTerm: any;
page: any;
pageSize: any;

    constructor(private http: HttpClient) {}

    salvar(estoque: Estoque): Observable<Estoque>
    {
        return this.http.post<Estoque>(`${this.apiUrl}`, estoque);

    }

    atualizar(estoque: Estoque) : Observable<any>
    {
        return this.http.put<Estoque>(`${this.apiUrl}/${estoque.codigoEstoque}`, estoque); 
    }

    listar(): Observable<Estoque[]>
    {
        return this.http.get<Estoque[]>(this.apiUrl);
    }

    listarPorCodigo(codigo: number) : Observable<Estoque>
    {
        return this.http.get<any>(`${this.apiUrl}/${codigo}`);

    }

    remover(estoque: Estoque) : Observable<any>
    {
        return this.http.delete<any>(`${this.apiUrl}/ ${estoque.codigoEstoque}`);
    }


}