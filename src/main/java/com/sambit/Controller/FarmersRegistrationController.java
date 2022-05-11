package com.sambit.Controller;

import com.sambit.Model.*;
import com.sambit.Service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FarmersRegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(FarmersRegistrationController.class);

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/farmerRegistration")
    public String home(){
        return "FarmerRegistration";
    }

    @PostMapping(value = "/saveFarmer")
    public String saveFarmer(@ModelAttribute("farmer")Farmer farmer,
                             @RequestParam("bankName")String bankName,
                             @RequestParam("ifscCode")String ifscCode,
                             @RequestParam("accountNumber")String accountNumber,
                             @RequestParam("uniqueId")String uniqueId,
                             @RequestParam("ackId")String ackId,
                             @RequestParam("janadhaarId")String janadhaarId,
                             @RequestParam("adhaarId")String adhaarId,
                             @RequestParam("mobile")String mobile){
        System.out.println("Inside Save Farmer----------->>");
        logger.info("Details : " + farmer + ", Bank Name : " + bankName + ", Account Number :" + accountNumber + ", IFSC Code : " + ifscCode + ", Mobile : " + mobile);
        logger.info("Unique ID : " + uniqueId + ", Ack ID : " + ackId + ", Janadhaar ID : " + janadhaarId + ", Adhar ID : " + janadhaarId);

        try {
            Bank bank = new Bank();
            bank.setBankName(bankName);
            bank.setAccountNumber(accountNumber);
            bank.setIfscCode(ifscCode);
            bank.setMobileNumber((mobile));
            Bank saveBank = mainService.saveBank(bank);
            if (saveBank != null){
                System.out.println("Bank Saved Successfully.");
                farmer.setBank(bank);
                if (uniqueId.equalsIgnoreCase("Ack Id")){
                    System.out.println("Ack Id Recieved. " + ackId);
                    Acknowledge acknowledge = new Acknowledge();
                    acknowledge.setAcknowledgeId(ackId);
                    if (mainService.saveAcknowledge(acknowledge) != null){
                        System.out.println("Acknowledge ID Saved Successfully.");
                        farmer.setAcknowledge(acknowledge);
                        if (mainService.saveFarmer(farmer) != null){
                            System.out.println("Farmer Saved Successfully.");
                        }
                    }
                }
                else if (uniqueId.equalsIgnoreCase("Janadhaar Id")){
                    System.out.println("Janadhaar Id Recieved. " + janadhaarId);
                    JanAdhaar janAdhaar = new JanAdhaar();
                    janAdhaar.setJanadhaarId(janadhaarId);
                    if (mainService.saveJanAdhaar(janAdhaar) != null){
                        System.out.println("Janadhaar ID Saved Successfully.");
                        farmer.setJanAdhaar(janAdhaar);
                        if (mainService.saveFarmer(farmer) != null){
                            System.out.println("Farmer Saved Successfully.");
                        }
                    }
                }
                else if (uniqueId.equalsIgnoreCase("Adhaar Id")){
                    System.out.println("Adhaar Id Recieved. " + adhaarId);
                    Aadhar aadhar = new Aadhar();
                    aadhar.setAadharId(adhaarId);
                    if (mainService.saveAadhar(aadhar) != null){
                        System.out.println("Aadhar ID Saved Successfully.");
                        farmer.setAadhar(aadhar);
                        if (mainService.saveFarmer(farmer) != null){
                            System.out.println("Farmer Saved Successfully.");
                        }
                    }
                }
                else {
                    System.out.println("Something Went Wrong!!");
                }
            }else {
                System.out.println("Failed to Save Bank!");
            }

            System.out.println(farmer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "FarmerRegistrationUniqueId";
    }

    @GetMapping(value = "/searchFarmer")
    public String searchFarmer(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("data", "NoData");
        return "FarmerRegistrationUniqueId";
    }

    @PostMapping(value = "/searchFarmer")
    public String searchFarmer(@RequestParam("uniqueId")String uniqueId,
                               @RequestParam("ackId")String ackId,
                               @RequestParam("janadhaarId")String janadhaarId,
                               @RequestParam("adhaarId")String adhaarId,
                               Model model, RedirectAttributes redirectAttributes){
        System.out.println(uniqueId + ackId + janadhaarId + adhaarId);
        try {
            Farmer farmer;
            if (uniqueId.equalsIgnoreCase("Ack Id")){
                System.out.println("Ack Id Recieved. " + ackId);
                farmer = mainService.findFarmerByAckId(ackId);
                System.out.println(farmer);
                model.addAttribute("farmer", farmer);
                redirectAttributes.addFlashAttribute("data", "Data");
            }
            else if (uniqueId.equalsIgnoreCase("Janadhaar Id")){
                System.out.println("Janadhaar Id Recieved. " + janadhaarId);
                farmer = mainService.findFarmerByJanadhaar(janadhaarId);
                System.out.println(farmer);
                model.addAttribute("farmer", farmer);
                redirectAttributes.addFlashAttribute("data", "Data");
            }
            else if (uniqueId.equalsIgnoreCase("Adhaar Id")){
                System.out.println("Adhaar Id Recieved. " + adhaarId);
                farmer = mainService.findFarmerByAadhar(adhaarId);
                System.out.println(farmer);
                model.addAttribute("farmer", farmer);
                redirectAttributes.addFlashAttribute("data", "Data");
                redirectAttributes.addFlashAttribute("farmer", farmer);
                return "redirect:/searchFarmer";
            }
            else {
                redirectAttributes.addFlashAttribute("data", "Data");
                System.out.println("Something Went Wrong!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "FarmerRegistrationUniqueId";
    }


}
