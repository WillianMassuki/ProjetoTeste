import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../UserService';
import { Usuario } from '../Usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent {

  username!: string;
  password!: string;
  cadastrando!: boolean;
  mensagemSucesso!: string;
  errors!: String[];

  constructor(
    private router: Router,
    private service: UsuarioService
  ) { }

  onSubmit(){

    this.service.tentarLogar(this.username, this.password)
    .subscribe(
        response => { 
          const access_token = JSON.stringify(response);
          localStorage.setItem('access_token', access_token);
          this.router.navigate(['/'])
      }, erroresposne =>
      {
        this.errors = ['senha/usuario invalidos'];
      }
    )
   
  }

  preparaCadastrar(event: { preventDefault: () => void; }){
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }

  cadastrar(){
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;
    this.service
        .salvar(usuario)
        .subscribe( response => {
            this.mensagemSucesso = "Cadastro realizado com sucesso! Efetue o login.";
            this.cadastrando = false;
            this.username = '';
            this.password = '';
            this.errors = []
        }, errorResponse => {
            this.errors = errorResponse.error.errors;
        })
  }

}
