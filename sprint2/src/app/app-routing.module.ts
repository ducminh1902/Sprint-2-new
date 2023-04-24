import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from "./component/home-page/home-page.component";
import {LoginComponent} from "./component/login/login.component";
import {ProductDetailComponent} from "./component/product-detail/product-detail.component";
import {CartComponent} from "./component/cart/cart.component";


const routes: Routes = [
  { path: "", component: HomePageComponent},
  {path: "login", component: LoginComponent},
  {path: "detail/:id", component: ProductDetailComponent},
  {path: "cart", component: CartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
