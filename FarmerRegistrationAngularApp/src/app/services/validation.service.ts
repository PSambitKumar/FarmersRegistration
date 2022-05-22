import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import * as $ from "jquery";
import {animate} from "@angular/animations";
import {angularFontawesomeVersion, iconPackVersion} from "@fortawesome/angular-fontawesome/schematics/ng-add/versions";
import {CONTROL} from "@angular/cdk/keycodes";

@Injectable({
  providedIn: 'root'
})
export class ValidationService {

  response : any;

  constructor() { }

  // Name Validation
  validateName(name : any, inputId : any, alertId : any){
    const alphaRegX = /^[a-z A-Z.]*$/;
    if (name == null || name == ""){
      this.response = "EmptyName";
      console.log("Empty Name!");
      $(alertId).text("Name Mustn't be Empty!").css('color', 'red');
      // $(alertId).css('border', '1px solid red'),focus();
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(inputId).focus();
      return this.response;
    }else if (name.length < 5){
      this.response = "ShortName";
      console.log("Name must be More Than 5 Characters.");
      $(alertId).text("Atleat 5 Characters!").css('color', 'red');
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(inputId).focus();
      return this.response;
    }else if (!name.match(alphaRegX)){
      this.response = "InvalidName";
      console.log("Must be Alphabetic!");
      $(alertId).text("Must be Alphabetic!").css('color', 'red');
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(inputId).focus();
      return this.response;
    }else {
      this.response = "Valid";
      console.log("Valid Name.")
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green');
      return this.response;
    }
  }

  // Age Validation
  validateAge(age : any, inputId : any, alertId : any){
    if (age == null || age == ""){
      this.response = "EmptyAge";
      console.log("Empty Age!");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Age Mustn't be Empty!").css('color', 'red');
      $(inputId).focus();
      return this.response;
    }else if (age.length < 2){
      this.response = "InvalidAge";
      console.log("Invalid Age!");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Age Mustn't be Empty!").css('color', 'red');
      $(inputId).focus();
    } else {
      this.response = "Valid";
      console.log("Valid Age.");
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green')
      this.response = "Valid";
      return this.response;
    }

  }

  // Radio Validation Gender
  validateRadio(gender : any, inputId1 : any, inputId2 : any, alertId : any){
    if (gender == null || gender == ""){
      this.response = "EmptyRadio.";
      console.log("Empty Radio!");
      $(inputId1).removeClass("is-valid").addClass("is-invalid");
      $(inputId1).css('border', '2px solid red');
      $(inputId2).removeClass("is-valid").addClass("is-invalid");
      $(inputId2).css('border', '2px solid red');
      $(alertId).text("Must Select Gender!").css('color', 'red');
      $(inputId1).focus();
      return this.response;
    }else {
      this.response = "Valid.";
      console.log("Valid Gender.");
      $(inputId1).removeClass("is-invalid").addClass("is-valid");
      $(inputId2).removeClass("is-invalid").addClass("is-valid");
      $(alertId).text("Looks Good,").css('color', 'green');
      $(inputId1).css('border', '2px solid green');
      $(inputId2).css('border', '2px solid green');
      return this.response;
    }
  }

  // Validatr Dropdown for Relation Only Self
  validateRelationDropdown(select : any, inputId : any, alertId : any){
    if (select == null || select == ""){
      this.response = "EmptyRelation";
      console.log("Empty Relation!");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Must Select").css('color', 'red');
      $(alertId).focus();
      return this.response;
    }else {
      this.response = "Valid";
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green');
      return this.response;
    }
  }

  // Validate Bank Account Number
  validateBankAccountNumber(accountNumber : any, inputId : any, alertId : any){
    const bankAccountNoRegx = /^\d{9,18}$/;
    if (accountNumber == null || accountNumber == ""){
      this.response = "EmptyAccountNumber";
      console.log("Empty Account Number.")
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Account Number Mustn't be Empty!").css('color', 'red');
      $(inputId).focus();
      return this.response;
    }else if (!accountNumber.match(bankAccountNoRegx)){
      this.response = "InvalidAccountNumber";
      console.log("Invalid Account Number.")
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(alertId).text("Invalid Account Number!").css('color', 'red');
      $(inputId).css('border', '2px solid red');
      $(inputId).focus();
      return this.response;
    }
    else {
      this.response = "Valid";
      console.log("Valid Account Number.");
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green');
      this.response;
    }
  }

  // Validate IFSC Code
  validateIFSCode(ifscCode : any, inputId : any, alertId : any){
    const ifscCodeRegX = /^[A-Za-z]{4}\d{7}$/;
    if (ifscCode == null || ifscCode == ""){
      this.response = "Empty IFSC Code!";
      console.log("Empty IFSC Code!");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(alertId).text("IFSC Code Mustn't be Empty!").css('color', 'red');
      $(inputId).css('border', '2px solid red');
      $(inputId).focus();
      return this.response;
    }else if (!ifscCode.match(ifscCodeRegX)){
      this.response = "InvalidIFSCCode";
      console.log("Invalid IFSC Code!");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(alertId).text("Invalid IFSC Code!").css('color', 'red');
      $(inputId).css('border', '2px solid red');
      $(inputId).focus();
      return this.response;
    }else {
      this.response = "Valid";
      console.log("Valid IFSC Code.");
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green');
      return this.response;
    }
  }

  // Validate Mobile Number
  validateMobileNumber(mobile : any, inputId : any, alertId : any){
    if (mobile == null || mobile == ""){
      this.response = "EmptyMobileNumber";
      console.log("Empty Mobile Number.");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Mobile No. Mustn't be Empty!");
      $(inputId).focus();
      return this.response;
    }else if (mobile.length != 10){
      this.response = "ShortMobileNumber";
      console.log("Invalid Mobile Number!");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Invalid Mobile Number!");
      $(inputId).focus();
      return this.response;
    }else {
      this.response = "Valid";
      console.log("Valid Mobile Number");
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green');
      return this.response;
    }
  }

  // ValidateDropdown
  validateDropdown(dropDownValue : any, inputId : any, alertId : any){
    console.log("X");
    console.log(dropDownValue);
    if (dropDownValue == 0 || dropDownValue == null || dropDownValue == ""){
      this.response = "EmptyDropDownValue";
      console.log("Empty Dropdown Value.");
      $(inputId).removeClass("is-valid").addClass("is-invalid");
      $(inputId).css('border', '2px solid red');
      $(alertId).text("Must Select!").css('color', 'red');
      $(inputId).focus();
      return this.response;
    }else {
      this.response = "Valid";
      console.log("Valid Drop Down Value.");
      $(inputId).removeClass("is-invalid").addClass("is-valid");
      $(inputId).css('border', '2px solid green');
      $(alertId).text("Looks Good.").css('color', 'green ');
      $(inputId).focus();
      return this.response;
    }
  }

  // Validate Acknowledgement Number
  validateAcknowlwdge(){

  }

  // Validate Aadhar Number
  validateAadhar(){

  }

  // Validate Janaadhar Number
  validateJanaAadhar(){

  }


}

