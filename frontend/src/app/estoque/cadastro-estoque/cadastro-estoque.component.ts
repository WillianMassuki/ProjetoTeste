import { Component } from '@angular/core';
import { Estoque } from '../estoque';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { EstoqueService } from '../estoqueService';

@Component({
  selector: 'cadastro-estoque',
  templateUrl: './cadastro-estoque.component.html',
  styleUrls: ['./cadastro-estoque.component.css']
})
export class CadastroEstoqueComponent {

  estoques: Estoque[] = [];
  estoque: Estoque;
  codigo!: number;
  router!: Router;
  params!: Params;

  constructor(private service : EstoqueService) 
  {
    this.estoque = new Estoque();
  }

  ngOnInit(): void {
   /* let params 
    params.subscribe(urlParams => {
      this.codigo = urlParams['codigo'];
      if(this.codigo)
      {
        this.service.listarPorCodigo(this.codigo)
        .subscribe( response => this.evento = response,
          errorResponse => this.evento = new Evento())
      }

    })*/
  }


  voltarParaListagem()
  {
    this.router.navigate(['/eventos/lista']);
  }

  onSubmit()
  {
  /*  if(this.codigo)
    {
      this.service.atualizar(this.evento)
      .subscribe(response => {
        this.sucess = true;
        this.errors = null;
    }, errorResponse => {
      this.errors = ['Erro ao atualizar o cliente.']
    }) 
  } /*else
  {
    this.service
    .salvar(this.evento)
      .subscribe( response => {
        this.sucess = true;
        this.errors = null;
        this.evento = response;
      } , errorResponse => {
        this.sucess = false;
        this.errors = errorResponse.error.errors;
      })
  }*/
  }

  salvar(estoque: any)
  {
  this.service.salvar(this.estoque).subscribe( salvado => 
    { this.estoques.push(salvado) 
      console.log(salvado);
    
    })

    console.log("Teste", estoque);
  }

}
  
