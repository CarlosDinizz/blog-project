import { Component, inject } from '@angular/core';
import { Header } from "../../components/header/header";
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { DialogPesquisa } from '../../components/dialog-pesquisa/dialog-pesquisa';

@Component({
  selector: 'app-home-usuario',
  imports: [Header, FormsModule],
  templateUrl: './home-usuario.html',
  styleUrl: './home-usuario.css'
})
export class HomeUsuario {

  constructor(){this.configurarDialog()}

  private router = inject(Router);
  readonly dialog = inject(MatDialog);


  dialogConfig = new MatDialogConfig();

  posts = [
    {
      id: 1,
      titulo: 'Teste post',
      conteudo: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequuntur mollitia tenetur culpa magni optio quas fugiat harum. Voluptatibus, inventore asperiores quam quidem similique soluta sunt dignissimos, repudiandae dolor deleniti autem?'
    }
  ]

  configurarDialog(){
    this.dialogConfig.maxWidth = '500px';
    this.dialogConfig.width = '100%';
    this.dialogConfig.minWidth = '100px'
    this.dialogConfig.position = {
      top: '8%'
    }
  }

  openDialog(){
    this.dialog.open(DialogPesquisa, this.dialogConfig);
  }

  abrirPaginaPost = () => {
    this.router.navigateByUrl("/post/criar")
  }
}
