import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { SignupPageComponent } from './components/signup-page/signup-page.component';
import { ResultPageComponent } from './components/result-page/result-page.component';
import { ReviewPageComponent } from './review-page/review-page.component';
import { AddReviewPageComponent } from './add-review-page/add-review-page.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'signin',
    component: LoginPageComponent,
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component: SignupPageComponent,
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'result',
    component: ResultPageComponent,
    pathMatch: 'full'
  },
  {
    path: 'reviews',
    component: ReviewPageComponent,
    pathMatch: 'full'
  },
  {
    path: 'addreview',
    component: AddReviewPageComponent,
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
