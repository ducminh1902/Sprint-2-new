import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ProductType} from "../../model/product-type";
import {Product} from "../../model/product";
import {ActivatedRoute} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  productForm :FormGroup = new FormGroup({
    id : new FormControl(),
    productName : new FormControl(),
    productPrice : new FormControl(),
    productDescripe : new FormControl(),
    productImg : new FormControl(),
    productType : new FormControl(),
    flavor : new FormControl(),
    brand : new FormControl(),
  })

  constructor(private productService: ProductService,
              private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.getProduct()
  }

getProduct(){
    this.activatedRoute.paramMap.subscribe(param =>{
      const id = parseInt(param.get("id"));
      this.productService.findById(id).subscribe(next =>{
        this.productForm.patchValue(next)
        console.log(next)
      })
    })
}
}
