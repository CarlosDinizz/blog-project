import { Component, inject } from '@angular/core';
import { Header } from "../../../components/header/header";
import {AutosizeModule} from 'ngx-autosize'
import { Router } from '@angular/router';
import { FormBuilder, Validators, ReactiveFormsModule, FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-criar-post',
  imports: [Header, AutosizeModule, ReactiveFormsModule],
  templateUrl: './criar-post.html',
  styleUrl: './criar-post.css'
})
export class CriarPost {
  private router = inject(Router);
  private formBuilder = inject(FormBuilder);

  protected formPost = this.formBuilder.group({
    titulo: ['', Validators.required],
    conteudo: ['', Validators.required]
  })

  protected voltarHomeUsuario() {
    console.log("Criando post...");

    if (!(this.formPost.get("titulo")?.errors && this.formPost.get("conteudo")?.errors)){
      console.log("Post criado!");
      alert('Post criado!')
      this.router.navigateByUrl('/home-usuario');
    }
    else {
      console.log("Não foi possível criar um post!");
      alert('Preencha os campos necessários!');
    }


  }
}
