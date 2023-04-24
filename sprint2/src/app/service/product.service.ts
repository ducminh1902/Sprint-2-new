import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private API = "http://localhost:8080/product"

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API)
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.API + '/' + id)
  }
}
