import { Component } from '@angular/core';
import { Estoque } from '../estoque';
import { EstoqueService } from '../estoqueService';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-estoque',
  templateUrl: './editar-estoque.component.html',
  styleUrls: ['./editar-estoque.component.css']
})
export class EditarEstoqueComponent {

  estoque: Estoque = new Estoque();

   codigo= this.actRoute.snapshot.params['codigo'];
   estoques:Estoque[] = [];
 
   constructor(private service: EstoqueService, public actRoute: ActivatedRoute,
     public router: Router) { }
 
   ngOnInit() {
     const isIdPresent = this.actRoute.snapshot.paramMap.has('codigo');
     if (isIdPresent) {
       const codigo = +!this.actRoute.snapshot.paramMap.get('codigo');
       this.service.listarPorCodigo(codigo).subscribe(
         data => this.estoque = data 
       )
   }
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
