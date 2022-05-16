import { Component, OnInit } from '@angular/core';
import {Farmer} from "../../models/farmer";
import * as $ from 'jquery'
import {FarmerService} from "../../services/farmer.service";

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent implements OnInit{

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
    console.log(this.farmer);
    this.farmerService.createFarmer(this.farmer.age);
  }
}
