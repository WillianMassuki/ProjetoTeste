import { Component } from '@angular/core';
import { Estoque } from '../estoque';
import { EstoqueService } from '../estoqueService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-estoque',
  templateUrl: './listar-estoque.component.html',
  styleUrls: ['./listar-estoque.component.css']
})
export class ListarEstoqueComponent {

  estoque!: Estoque;
  estoques:Estoque[] = [];
  EstoqueSelecionado: Estoque = new Estoque;
  mensagemSucesso!: string;
  mensagemErro!: string;
  
  constructor(private service: EstoqueService, private router: Router ) {}

  ngOnInit(): void {
this.listarTodos();
    
  }


   listarTodos()
   {
   this.service.listar().subscribe( todos => {
     console.log(todos);
     this.estoques = todos;
 
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
