import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [{ path: '' }];

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [CommonModule, RouterModule.forChild(routes)],
})
export class HomeModule {}
