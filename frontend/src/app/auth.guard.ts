import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UsuarioService } from "./user/UserService";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
 constructor(
    private service: UsuarioService,
    private router: Router
  ){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {

    const authenticated =  this.service.isAuthenticated();

    if(authenticated){
      return true;
    }else{
      this.router.navigate(['/login'])
      return false;
    }

  }
  
}
