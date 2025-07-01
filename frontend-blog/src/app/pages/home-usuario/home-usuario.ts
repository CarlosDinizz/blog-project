import { Component, inject } from '@angular/core';
import { Header } from "../../components/header/header";
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-usuario',
  imports: [Header, FormsModule],
  templateUrl: './home-usuario.html',
  styleUrl: './home-usuario.css'
})
export class HomeUsuario {

  private router = inject(Router);

  pesquisaUsuario: string = '';

  listaUsuarios = [
    {
      id: 1,
      nome: 'luiz'
    },
    {
      id: 2,
      nome: 'luiza'
    },
    {
      id: 3,
      nome: 'carlos'
    }
  ];


  posts = [
    {
      id: 1,
      titulo: 'Teste post',
      conteudo: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur mollitia tenetur culpa magni optio quas fugiat harum. Voluptatibus, inventore asperiores quam quidem similique soluta sunt dignissimos, repudiandae dolor deleniti autem?'
    }
  ]

  abrirPaginaPost = () => {
    this.router.navigateByUrl("/post/criar")
  }
}
