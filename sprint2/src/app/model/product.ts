import {ProductType} from "./product-type";
import {Flavor} from "./flavor";
import {Brand} from "./brand";

export interface Product {
  id?: number;
  productName?: string;
  productPrice?: number;
  productDescripe?: string;
  productImg?: string;
  productType?:ProductType;
  flavor?:Flavor;
  brand?: Brand;
}
