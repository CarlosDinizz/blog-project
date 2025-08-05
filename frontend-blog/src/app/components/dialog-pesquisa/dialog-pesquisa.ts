import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatDialogContent, MatDialogClose, MatDialogActions } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-pesquisa',
  imports: [FormsModule, MatDialogContent, MatDialogActions, MatDialogClose],
  templateUrl: './dialog-pesquisa.html',
  styleUrl: './dialog-pesquisa.css'
})
export class DialogPesquisa {
  readonly pesquisaUsuario: string = "";
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

  existemUsuarios(){
    return this.listaUsuarios.length > 0;
  }


}
