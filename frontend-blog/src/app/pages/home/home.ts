import { Component, inject } from '@angular/core';
import { Header } from "../../components/header/header";
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [Header, RouterLink],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  private router = inject(Router)

  irParaLogin() {
    this.router.navigate(
      ['/login']
    );
  }
}
