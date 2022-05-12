package com.sambit.Service;

import com.sambit.Model.*;

public interface MainService {
    Bank saveBank(Bank bank);
    Acknowledge saveAcknowledge(Acknowledge acknowledge);
    Janadhaar saveJanAdhaar(Janadhaar janAdhaar);
    Aadhar saveAadhar(Aadhar aadhar);
    Farmer saveFarmer(Farmer farmer);
    Farmer findFarmerByAckId(String ackId);
    Farmer findFarmerByJanadhaar(String janadharId);
    Farmer findFarmerByAadhar(String aadharId);
    Farmer findFarmerById(int id);
}
