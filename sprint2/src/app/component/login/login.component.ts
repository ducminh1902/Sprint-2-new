import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {TokenService} from "../../service/token.service";
import {Router} from "@angular/router";
import {ShareService} from "../../service/share.service";
import {LoginService} from "../../service/login.service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form = new FormGroup({
    username: new FormControl(),
    password: new FormControl(),
    rememberMe: new FormControl(true),
  });
  message = ''
  islogged = false;
  constructor( private title: Title, private loginService: LoginService, private token: TokenService, private router: Router, private share: ShareService) { }

  ngOnInit(): void {
    window.scroll(0, 340)


    this.title.setTitle('Trang Đăng Nhập');
    this.islogged = this.token.isLogger();
    if (this.islogged) {
      this.router.navigateByUrl('/')
    }
  }
  async login() {
    if(this.islogged || this.token.isLogger()) {
      return
    }
    this.loginService.login(this.form.value).subscribe(next => {
        if (this.form.controls.rememberMe.value) {
          this.token.rememberMe(next.token, next.id, next.name, next.email,
           next.roles, 'local');

        } else {
          this.token.rememberMe(next.token, next.id, next.name, next.email,
            next.roles, 'session');
        }
        this.islogged = true


        this.share.sendClickEvent();
          this.router.navigateByUrl('')
      }, error => {
        console.log(error)
        if (error.error) {
          for (let i = 0; i < error.error.length; i++) {
            this.message = error.error[i].defaultMessage
          }
        }
        if (error.error.message) {
          this.message = error.error.message
        }
      }
    )

  }

}
