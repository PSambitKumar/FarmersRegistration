import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Farmer} from "../models/farmer";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FarmerService {
  private baseUrl = "http://localhost:8088/farmer/v1"

  constructor(private httpClient : HttpClient) { }
  createFarmer(farmer : Farmer) : Observable<object>{
    return this.httpClient.get<object>(`${this.baseUrl+"/createFarmer"}`);
  }
}
