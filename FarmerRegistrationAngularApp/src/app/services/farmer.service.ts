import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FarmerBean} from "../beans/farmerBean";
import {Observable} from "rxjs";
import {Bank} from "../models/bank";
import {Relation} from "../models/relation";
import {Farmer} from "../models/farmer";

@Injectable({
  providedIn: 'root'
})
export class FarmerService {
  private baseUrl = "http://localhost:8088/farmer/v1";

  constructor(private httpClient : HttpClient) { }

  createFarmer(farmerBean : FarmerBean) : Observable<Farmer>{
    console.log("From Service : " + JSON.stringify(farmerBean));
    return this.httpClient.post<Farmer>(`${this.baseUrl +"/createFarmer"}`, farmerBean);
  }

  getFarmerList() : Observable<Farmer[]>{
    return this.httpClient.get<Farmer[]>(`${this.baseUrl + "/getFarmerList"}`);
  }

  // getRelationList() : Observable<Relation[]>{
  //   return this.httpClient.get<Relation[]>(`${this.baseUrl + "/relationList"}`);
  // }

}
