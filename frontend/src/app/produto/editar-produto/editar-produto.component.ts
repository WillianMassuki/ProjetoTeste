import { Component } from '@angular/core';
import { Produto } from '../produto';
import { ProdutoService } from '../produtoService';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-produto',
  templateUrl: './editar-produto.component.html',
  styleUrls: ['./editar-produto.component.css']
})
export class EditarProdutoComponent {

  produto: Produto = new Produto();

  codigo= this.actRoute.snapshot.params['codigo'];
  produtos:Produto[] = [];

  constructor(private service: ProdutoService, public actRoute: ActivatedRoute,
    public router: Router) { }

  ngOnInit() {
    const isIdPresent = this.actRoute.snapshot.paramMap.has('codigo');
    if (isIdPresent) {
      const codigo = +!this.actRoute.snapshot.paramMap.get('codigo');
      this.service.listarPorCodigo(codigo).subscribe(
        data => this.produto = data 
      )
  }
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
