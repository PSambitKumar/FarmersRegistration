package com.sambit.Controller;

import com.sambit.Bean.FarmerBean;
import com.sambit.Model.Farmer;
import com.sambit.Service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/farmer/v1")
@Slf4j
public class FarmersRegistrationAngularController {

    @Autowired
    private MainService mainService;

    @ResponseBody
    @GetMapping("/farmerManagement")
    public List<Farmer> farmerRegistrationManagement(){
        System.out.println("Inside Farmer Registration Management---------------->>");
        log.info(mainService.findAllFarmersList().toString());
        return mainService.findAllFarmersList();
    }

    @PostMapping(value = "/createFarmer")
    public String createEmployee(@RequestBody FarmerBean farmerBean){
        System.out.println("Inside Create Farmer--------------->>");
        System.out.println(farmerBean);
        return null;
    }
}
