import { Component, inject } from '@angular/core';
import { Header } from "../../components/header/header";
import { Router, RouterLink } from '@angular/router';
import {FormControl, FormGroup, Validators, ReactiveFormsModule} from '@angular/forms';
import { Validator } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [Header, ReactiveFormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  private router = inject(Router);

  formulario = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      senha: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  get email(){
    return this.formulario.get('email');
  }

  get senha(){
    return this.formulario.get('senha');
  }

  acessarHomeUsuario(){
    if(this.email?.value !== '' && this.senha?.value !== ''){
      this.router.navigateByUrl('/home-usuario');
    }
  }
}
