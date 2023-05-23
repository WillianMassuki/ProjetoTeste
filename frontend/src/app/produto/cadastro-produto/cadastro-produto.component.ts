import { Component, OnInit } from '@angular/core';
import { Produto } from '../produto';
import { ProdutoService } from '../produtoService';
import { Params, Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})
export class CadastroProdutoComponent implements OnInit {

  produtos: Produto[] = [];
  produto!: Produto;
  codigo!: number;
  router!: Router;
  params!: Params;

  constructor(private service : ProdutoService) 
  {
    this.produto = new Produto();
  }

  ngOnInit(): void {

  }


  voltarParaListagem()
  {
    this.router.navigate(['/eventos/lista']);
  }

  onSubmit()
  {

  }

  salvar(produto: any)
  {
  this.service.salvar(this.produto).subscribe( salvado => 
    { this.produtos.push(salvado) 
      console.log(salvado);
    
    })

    console.log("Teste", produto);
  }



}
