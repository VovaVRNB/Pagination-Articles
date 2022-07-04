import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ArticlesComponent } from './articles/articles.component';
import { CreateComponent } from './create/create.component';
import { StatisticComponent } from './statistic/statistic.component';

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "articles", component: ArticlesComponent},
  {path: "create", component: CreateComponent},
  {path: "statistic", component: StatisticComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
