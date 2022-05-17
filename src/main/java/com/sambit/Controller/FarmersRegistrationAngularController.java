package com.sambit.Controller;

import com.sambit.Bean.FarmerBean;
import com.sambit.Model.Acknowledge;
import com.sambit.Model.Bank;
import com.sambit.Model.Farmer;
import com.sambit.Model.Relation;
import com.sambit.Service.MainService;
import com.sambit.Service.MainServiceAngular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/checking")
    public String checking(){
        System.out.println("Inside Checking Method------------------->>");
        return null;
    }

    @ResponseBody
    @GetMapping("/relationList")
    public List<Relation> getBankDetails(){
        System.out.println("Inside Bank Details-------------------->>");
        return mainService.findAllRelationList();
    }

    @PostMapping( "/createFarmer")
    public ResponseEntity<Farmer> createEmployee(@RequestBody FarmerBean farmerBean){
        System.out.println("Inside Create FarmerBean--------------->>");
        System.out.println(farmerBean);
//        Farmer farmer = mainServiceAngular.createFarmer(farmerBean);
        Farmer farmer  = mainService.findFarmerById(1);
        System.out.println(farmer);
        return ResponseEntity.ok(farmer);
    }

}
