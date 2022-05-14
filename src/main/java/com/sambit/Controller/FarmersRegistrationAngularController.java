package com.sambit.Controller;

import com.sambit.Model.Farmer;
import com.sambit.Service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
