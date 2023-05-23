import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CadastroEstoqueComponent } from './estoque/cadastro-estoque/cadastro-estoque.component';
import { ListarEstoqueComponent } from './estoque/listar-estoque/listar-estoque.component';
import { CadastroProdutoComponent } from './produto/cadastro-produto/cadastro-produto.component';
import { ListarProdutoComponent } from './produto/listar-produto/listar-produto.component';

import { UsuarioComponent } from './user/usuario/usuario.component';

import { MenuModule } from 'primeng/menu';


import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {MenubarModule} from 'primeng/menubar';
import { EditarEstoqueComponent } from './estoque/editar-estoque/editar-estoque.component';
import { EditarProdutoComponent } from './produto/editar-produto/editar-produto.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroEstoqueComponent,
    ListarEstoqueComponent,
    CadastroProdutoComponent,
    ListarProdutoComponent,
    UsuarioComponent,
    EditarEstoqueComponent,
    EditarProdutoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenuModule,
    MenubarModule,
    CardModule,
    ButtonModule,
    BrowserModule,
    CardModule,
    ButtonModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MenubarModule,
    TableModule,
    ReactiveFormsModule,
    
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
