import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () =>
      import('./features/components/home/home.module').then(
        (m) => m.HomeModule
      ),
  },

  {
    path: 'login',
    loadChildren: () =>
      import('./core/components/login/login.module').then((m) => m.LoginModule),
  },

  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
