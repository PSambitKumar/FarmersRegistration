import {Component, Inject, OnInit} from '@angular/core';
import {FarmerBean} from "../../beans/farmerBean";
import * as $ from 'jquery'
import {FarmerService} from "../../services/farmer.service";
import {Farmer} from "../../models/farmer";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ModalService} from "../../services/modal.service";
import {data} from "jquery";
import {HomeComponent} from "../home/home.component";

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent implements OnInit{

  farmerBean : FarmerBean = new FarmerBean();
  farmer : Farmer = new Farmer();
  farmerList : Farmer[] = [];

  constructor(private farmerService : FarmerService, private modalService : ModalService, public matDialog: MatDialog) { }

  ngOnInit(): void {
    this.hideUniqueIdInput();
    this.addFarmer();
    this.getFarmerList();
  }

  // Methods Part
  farmerForm(){
    console.log(this.farmerBean);
    console.log("Inside FarmerBean Form Submit-------------->>");
    this.farmerService.createFarmer(this.farmerBean).subscribe(data => {
      console.log(data);
      console.log("Resposnse Data : " + data);//Check Difference In Console
      this.farmer = data;
      console.log(this.farmer)
    });
  }

  getFarmerList(){
    console.log("Inside Get Farmers List-------------->>")
    this.farmerService.getFarmerList().subscribe(data => {
      this.farmerList = data;
      console.log(this.farmerList);
    })
  }

  editFarmer(id : any){
    console.log("Farmer Id :" + id);
  }

  deleteFarmer(id : any){
    console.log("Farmer Id :" + id);
  }

  showBankDetails(id : any){
    console.log("Farmer Id :" + id);
  }

  // openModal(){
  //   console.log("Inside Open Modal Method----------->>");
  //   this.modalService.openModalExample({text: "Hello, Sambit Kumar Pradhan."}).subscribe(data =>{
  //     console.log(data);
  //   });
  // }

  openModal() {
    const dialogRef = this.matDialog.open(FarmerComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

  // JQuery Part
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

  addFarmer(){
    $('#add').show();
    $('#view').hide();
  }
  viewFarmer(){
    $('#add').hide();
    $('#view').show();
  }
}
