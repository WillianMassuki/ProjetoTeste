import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api/menuitem';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProjetoTeste';

  items!: MenuItem[];

  ngOnInit() {
      this.items = [
          {
              label: 'Estoque',
              items: [
                  {
                      label: 'Cadastro Estoque',
                      url: '/cadastroEstoque',
                  },
                  {
                      label: 'Listagem Estoque',
                      url: '/listarEstoque',
                  }
              ]
          },
          {
              label: 'Produtos',
              items: [
                  {
                      label: 'Cadastro Produtos',
                      url: '/CadastroProduto',
                  },
                  {
                      label: 'Listagem Produtos',
                      url: '/listarProduto',
                  }
              ]
          },
          {
              label: 'Usuarios',
              items: [
                  {
                      label: 'LOGIN',
                      url: '/usuario'
                  }
              ]
          }
          
      ];
  }
}
