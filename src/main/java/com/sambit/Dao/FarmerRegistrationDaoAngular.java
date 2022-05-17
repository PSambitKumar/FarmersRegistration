package com.sambit.Dao;

import com.sambit.Model.*;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

import java.util.List;

public interface FarmerRegistrationDaoAngular {

	List<Farmer> findAllFarmerList();
//	Collection<FarmerBean> findAllFarmerList();
	Bank saveBank(Bank bank);
	Acknowledge saveAcknowledge(Acknowledge acknowledge);
	Janadhaar saveJanadhaar(Janadhaar janadhaar);
	Aadhar saveAadhar(Aadhar aadhar);
	Farmer saveFarmer(Farmer farmer);
}
