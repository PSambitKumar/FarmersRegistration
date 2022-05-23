package com.sambit.Controller;

import com.google.gson.Gson;
import com.sambit.Bean.BankDetailsBean;
import com.sambit.Bean.FarmerBean;
import com.sambit.Bean.ResponseBean;
import com.sambit.Model.Acknowledge;
import com.sambit.Model.Bank;
import com.sambit.Model.Farmer;
import com.sambit.Model.Relation;
import com.sambit.Service.MainService;
import com.sambit.Service.MainServiceAngular;
import com.sambit.Validation.AadharValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/farmer/v1")
public class FarmersRegistrationAngularController {

    @Autowired
    private MainService mainService;
    @Autowired
    private MainServiceAngular mainServiceAngular;

    @ResponseBody
    @GetMapping("/farmerManagement")
    public List<Farmer> farmerRegistrationManagement(){
        System.out.println("Inside FarmerBean Registration Management---------------->>");
//        log.info(mainService.findAllFarmersList().toString());
        return mainService.findAllFarmersList();
    }

    @ResponseBody
    @GetMapping("/relationList")
    public List<Relation> getRelationList(){
        System.out.println("Inside Relation List Method-------------------->>");
        return mainService.findAllRelationList();
    }

    @PostMapping( "/createFarmer")
    public ResponseEntity<Farmer> createEmployee(@RequestBody FarmerBean farmerBean){
        System.out.println("Inside Create FarmerBean--------------->>");
        System.out.println(farmerBean);
        Farmer farmer = mainServiceAngular.createFarmer(farmerBean);
//        Farmer farmer  = mainService.findFarmerById(1);//Just Checking Full Data
        System.out.println(farmer);
        return ResponseEntity.ok(farmer);
    }

    @ResponseBody
    @GetMapping(value = "/getFarmerList")
    public List<Farmer> getFarmerList(){
        System.out.println("Inside Get Farmers List---------------->>");
        return mainServiceAngular.getFarmerList();
    }


    @GetMapping(value = "/getBankUsingIFSCCode/{ifscCode}")
    public ResponseEntity<BankDetailsBean> getBankUsingIFSCCode(@PathVariable("ifscCode")String ifscCode){
        System.out.println("Inside Get Bank Details Using IFSC Code----------------------->>");
        System.out.println("IFSC Code : " + ifscCode);
        Gson gson = new Gson();
        RestTemplate restTemplate = new RestTemplate();
        String bankDetails = restTemplate.getForObject("https://ifsc.razorpay.com/"+ifscCode, String.class);
        System.out.println(bankDetails);

        //        Converting JSON String to ModeL Class
        BankDetailsBean bankDetailsBean = gson.fromJson(bankDetails, BankDetailsBean.class);
        System.out.println("Bank Details are : " + bankDetailsBean);
        return ResponseEntity.ok(bankDetailsBean);
    }

    @GetMapping(value = "/getValidateAadhar/{aadharId}")
    public ResponseEntity<ResponseBean> getValidateAadhar(@PathVariable("aadharId")String aadharId, ResponseBean responseBean){
        System.out.println("Inside Get Validate Aadhar Id--------------->>");
        System.out.println(aadharId);
        if (AadharValidation.validateAadhar(aadharId)){
            responseBean.setStatus("Success");
        }else {
            responseBean.setStatus("Failed");
        }
        return ResponseEntity.ok(responseBean);
    }



}
