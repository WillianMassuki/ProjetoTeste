import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produto } from './produto';


@Injectable
({
    providedIn : 'root'
})
export class ProdutoService {

    apiUrl: string = environment.apiURLBase + '/produto';

    constructor(private http: HttpClient) {}

    salvar(produto: Produto): Observable<Produto>
    {
        return this.http.post<Produto>(`${this.apiUrl}`, produto);

    }

    atualizar(produto: Produto) : Observable<any>
    {
        return this.http.put<Produto>(`${this.apiUrl}/${produto.id}`, produto); 
    }

    listar(): Observable<Produto[]>
    {
        return this.http.get<Produto[]>(this.apiUrl);
    }

    listarPorCodigo(id: number) : Observable<Produto>
    {
        return this.http.get<any>(`${this.apiUrl}/${id}`);

    }

    remover(produto: Produto) : Observable<any>
    {
        return this.http.delete<any>(`${this.apiUrl}/ ${produto.id}`);
    }


}