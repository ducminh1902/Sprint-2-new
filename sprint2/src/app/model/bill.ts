import {User} from "./user";
import {Product} from "./product";

export interface Bill {
  id?:number;
  buyDate?:string;
  totalPayment?:number;
  nameUser?: string;
  email?: string;
  totalProduct?: string;
  user?: User;
  product?: Product;
}
