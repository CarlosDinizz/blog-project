import { Component, inject } from '@angular/core';
import { Header } from "../../components/header/header";
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-registro',
  imports: [Header, ReactiveFormsModule],
  templateUrl: './registro.html',
  styleUrl: './registro.css'
})
export class Registro {

  private router = inject(Router);

  form = new FormGroup({
    nome: new FormControl('', Validators.required),
    sobrenome: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    senha: new FormControl('', [Validators.required, Validators.minLength(8)]),
    confirmarSenha: new FormControl('', [Validators.required, Validators.minLength(8)])
  });

  get senha (){
    return this.form.get('senha');
  }

  get confirmarSenha(){
    return this.form.get('confirmarSenha');
  }

  senhasIguais(){
    if (this.senha?.hasError('required') || this.confirmarSenha?.hasError('required')){
      return false;
    }

    return this.senha?.value == this.confirmarSenha?.value;
  }

  submit(){
    alert('Você foi registrado!');
    this.router.navigateByUrl('/login');
  }
}
