import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FarmerBean} from "../beans/farmerBean";
import {Observable} from "rxjs";
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

  getBankDetailsUsingIFSC(ifscCode : any) : Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl + "/getBankUsingIFSCCode/"}` + ifscCode)
  }

  getValidateAadharId(aadharId : any) : Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl + "/getValidateAadhar/"}` + aadharId);
  }

  // getRelationList() : Observable<Relation[]>{
  //   return this.httpClient.get<Relation[]>(`${this.baseUrl + "/relationList"}`);
  // }

}
