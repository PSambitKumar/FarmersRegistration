package com.sambit.Service;

import com.sambit.Model.*;

public interface MainService {
    Bank saveBank(Bank bank);
    Acknowledge saveAcknowledge(Acknowledge acknowledge);
    JanAdhaar saveJanAdhaar(JanAdhaar janAdhaar);
    Aadhar saveAadhar(Aadhar aadhar);
    Farmer saveFarmer(Farmer farmer);
}
