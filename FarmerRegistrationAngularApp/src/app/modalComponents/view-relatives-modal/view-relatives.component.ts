import {Component, Inject, OnInit} from '@angular/core';
import {Relation} from "../../models/relation";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";

@Component({
  selector: 'app-view-relatives',
  templateUrl: './view-relatives.component.html',
  styleUrls: ['./view-relatives.component.css']
})
export class ViewRelativesComponent implements OnInit {
  farmerName : any;
  relativeList : Relation [] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public data : any) { }

  ngOnInit(): void {
    this.loadDataReceived();
  }

  loadDataReceived(){
    console.log(this.data);
    this.farmerName = this.data.farmerName;
    this.relativeList = this.data.relationList;
    console.log(this.farmerName);
    console.log(this.relativeList);
  }
}
