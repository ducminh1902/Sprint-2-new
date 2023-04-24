import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {LoginService} from "../../service/login.service";
import {ShareService} from "../../service/share.service";
import {TokenService} from "../../service/token.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  isLogged = false;
  productList: Product[] = [];
  user:User ;
  constructor(private productService: ProductService,private loginService:LoginService,private share:ShareService,private token:TokenService) {
  }

  ngOnInit(): void {
    this.isLogged = this.token.isLogger();
    this.loadUser()
    this.share.getClickEvent().subscribe( next => {
      this.isLogged = this.token.isLogger();
      this.loadUser()

    })
    this.getAll()
  }
 loadUser() {
    if(this.isLogged) {
      this.loginService.profile(this.token.getId()).subscribe(
        next => this.user = next
      )
    }

 }
  getAll() {
    this.productService.getAll().subscribe(next => {
      this.productList = next
    })
  }
  logout() {
    this.token.logout();
    this.share.sendClickEvent()
    this.isLogged = false;
  }
}
