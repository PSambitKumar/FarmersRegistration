package com.sambit.Service;

import com.sambit.Model.*;
import com.sambit.Repository.*;
import org.jboss.jandex.Main;
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
        return bankRepository.save(bank);
    }

    @Override
    public Acknowledge saveAcknowledge(Acknowledge acknowledge) {
        return acknowledgeRepository.save(acknowledge);
    }

    @Override
    public JanAdhaar saveJanAdhaar(JanAdhaar janAdhaar) {
        return janadhaarRepository.save(janAdhaar);
    }

    @Override
    public Aadhar saveAadhar(Aadhar aadhar) {
        return aadharRepository.save(aadhar);
    }

    @Override
    public Farmer saveFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }
}
