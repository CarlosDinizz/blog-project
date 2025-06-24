import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Login } from './pages/login/login';
import { Registro } from './pages/registro/registro';
import { HomeUsuario } from './pages/home-usuario/home-usuario';

export const routes: Routes = [
  {
    path: '',
    component: Home,
    title: 'Início'
  },
  {
    path: 'home',
    redirectTo: ''
  },
  {
    path: 'login',
    component: Login,
    title: 'Login'
  },
  {
    path: 'register',
    component: Registro,
    title: 'Registro'
  },
  {
    path: 'home-usuario',
    component: HomeUsuario,
    title: 'Página usuário'
  }
];
