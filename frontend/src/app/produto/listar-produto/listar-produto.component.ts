import { Component, OnInit } from '@angular/core';
import { Produto } from '../produto';
import { ProdutoService } from '../produtoService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-produto',
  templateUrl: './listar-produto.component.html',
  styleUrls: ['./listar-produto.component.css']
})
export class ListarProdutoComponent implements OnInit {

  
  produto!: Produto;
  produtos:Produto[] = [];
  ProdutoSelecionado: Produto = new Produto;
  mensagemSucesso!: string;
  mensagemErro!: string;
  
  constructor(private service: ProdutoService, private router: Router ) {}

  ngOnInit(): void {
this.listarTodos();
    
  }


   listarTodos()
   {
   this.service.listar().subscribe( todos => {
     console.log(todos);
     this.produtos = todos;
 
   });
   }
/*
     remover(estoque : Estoque)
     {
       this.service.remover(estoque.codigoEstoque).subscribe
          (     data => {
            this.estoques = this.estoques.filter( e => e !== estoque);
          })
      
     }
     */

}
