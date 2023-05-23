import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from './auth.guard';
import { CadastroEstoqueComponent } from './estoque/cadastro-estoque/cadastro-estoque.component';
import { ListarEstoqueComponent } from './estoque/listar-estoque/listar-estoque.component';
import { CadastroProdutoComponent } from './produto/cadastro-produto/cadastro-produto.component';
import { ListarProdutoComponent } from './produto/listar-produto/listar-produto.component';
import { UsuarioComponent } from './user/usuario/usuario.component';
import { EditarEstoqueComponent } from './estoque/editar-estoque/editar-estoque.component';
import { EditarProdutoComponent } from './produto/editar-produto/editar-produto.component';

const routes: Routes = [
  {path: 'cadastroEstoque', component: CadastroEstoqueComponent, canActivate : [AuthGuard]},
  {path: 'listarEstoque', component: ListarEstoqueComponent, canActivate : [AuthGuard]},
  {path: 'CadastroProduto', component: CadastroProdutoComponent, canActivate : [AuthGuard]},
  {path: 'listarProduto', component: ListarProdutoComponent, canActivate : [AuthGuard]},
  {path: 'editarEstoque', component: EditarEstoqueComponent, canActivate: [AuthGuard] },
  {path: 'editarProduto', component: EditarProdutoComponent, canActivate: [AuthGuard] },
  {path: 'usuario', component: UsuarioComponent}

]

@NgModule({
  exports: [ RouterModule ],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {}
