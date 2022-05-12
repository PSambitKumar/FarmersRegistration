package com.sambit.Service;

import com.sambit.Model.*;
import com.sambit.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private FarmerRepository farmerRepository;
    @Autowired
    private JanadhaarRepository janadhaarRepository;
    @Autowired
    private AadharRepository aadharRepository;
    @Autowired
    private AcknowledgeRepository acknowledgeRepository;


    @Override
    public Bank saveBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public Acknowledge saveAcknowledge(Acknowledge acknowledge) {
        return acknowledgeRepository.saveAndFlush(acknowledge);
    }

    @Override
    public Janadhaar saveJanAdhaar(Janadhaar janAdhaar) {
        return janadhaarRepository.saveAndFlush(janAdhaar);
    }

    @Override
    public Aadhar saveAadhar(Aadhar aadhar) {
        return aadharRepository.saveAndFlush(aadhar);
    }

    @Override
    public Farmer saveFarmer(Farmer farmer) {
        return farmerRepository.saveAndFlush(farmer);
    }

    @Override
    public Farmer findFarmerByAckId(String ackId) {
        return farmerRepository.findFarmerByAcknowledge_AcknowledgeId(ackId);
    }

    @Override
    public Farmer findFarmerByJanadhaar(String janadharId) {
        return farmerRepository.findFarmerByJanAdhaar_JanadhaarId(janadharId);
    }

    @Override
    public Farmer findFarmerByAadhar(String aadharId) {
        return farmerRepository.findFarmerByAadhar_AadharId(aadharId);
    }

    @Override
    public Farmer findFarmerById(int id) {
        return farmerRepository.findFarmerById(id);
    }
}
