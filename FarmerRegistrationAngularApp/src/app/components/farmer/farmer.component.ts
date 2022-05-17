import { Component, OnInit } from '@angular/core';
import {FarmerBean} from "../../beans/farmerBean";
import * as $ from 'jquery'
import {FarmerService} from "../../services/farmer.service";
import {Farmer} from "../../models/farmer";

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent implements OnInit{

  farmerBean : FarmerBean = new FarmerBean();
  farmer : Farmer = new Farmer();

  constructor(private farmerService : FarmerService) { }

  ngOnInit(): void {
    this.hideUniqueIdInput();
  }

  // For Hiding of Unique Id Inouts
  hideUniqueIdInput() {
    $('#id1').hide();
    $('#id2').hide();
    $('#id3').hide();
  }

  // When Unique Dropdown Changes This Function Calls
  uniqueDropDownChange(uniqueId : any){
    // alert(uniqueId);
    if (uniqueId == 1){
      $('#id1').show();
      $('#id2').hide();
      $('#id3').hide();
    }else if (uniqueId == 2){
      $('#id2').show();
      $('#id1').hide();
      $('#id3').hide();
    }else if (uniqueId == 3){
      $('#id3').show();
      $('#id1').hide();
      $('#id2').hide();
    }else {
      $('#id1').hide();
      $('#id2').hide();
      $('#id3').hide();
    }
  }

  farmerForm(){
    console.log(this.farmerBean);
    console.log("Inside FarmerBean Form Submit.");
    this.farmerService.createFarmer(this.farmerBean).subscribe(data => {
      console.log(data);
      console.log("Resposnse Data : " + data);//Check Difference In Console
      this.farmer = data;
      console.log(this.farmer)
    });
  }
}
