package com.sambit.ServiceImpl;

import com.sambit.Bean.FarmerBean;
import com.sambit.Dao.FarmerRegistrationDaoAngular;
import com.sambit.Model.*;
import com.sambit.Service.MainServiceAngular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class MainServiceImplAngular implements MainServiceAngular {

	@Autowired
	private FarmerRegistrationDaoAngular farmerRegistrationDaoAngular;

	@Override
	public Farmer createFarmer(FarmerBean farmerBean) {
		Farmer farmer = null;
		Farmer saveFarmer = null;
		try {
			farmer = null;
			if (farmerBean != null){
				Bank bank = new Bank();
				bank.setBankName(farmerBean.getBank());
				bank.setAccountNumber(farmerBean.getAccountNumber());
				bank.setMobileNumber(farmerBean.getMobile());
				bank.setIfscCode(farmerBean.getIfscCode());
				Bank savedBank = farmerRegistrationDaoAngular.saveBank(bank);

				farmer = new Farmer();
				farmer.setName(farmerBean.getName());
				farmer.setFathersName(farmerBean.getFathersName());
				farmer.setAge(Integer.parseInt(farmerBean.getAge()));
				farmer.setGender(farmerBean.getGender());
				farmer.setRelation(farmerBean.getRelation());
				farmer.setMobile(farmerBean.getMobile());
				farmer.setBank(savedBank);

				int uniqueId = Integer.parseInt(farmerBean.getUniqueId());
				if (uniqueId == 1){
					System.out.println("Ack Id Recieved. " + farmerBean.getAcknowledge());
					Acknowledge acknowledge = new Acknowledge();
					acknowledge.setAcknowledgeId(farmerBean.getAcknowledge());
					acknowledge.setAcknowledgeId(farmerBean.getAcknowledge());
					Acknowledge savedAcknowledge = farmerRegistrationDaoAngular.saveAcknowledge(acknowledge);
					farmer.setAcknowledge(savedAcknowledge);
				} else if (uniqueId == 2){
					System.out.println("Janadhaar Id Recieved. " + farmerBean.getJanAdhaar());
					Janadhaar janAdhaar = new Janadhaar();
					janAdhaar.setJanadhaarId(farmerBean.getJanAdhaar());
					Janadhaar savedJanadhaar = farmerRegistrationDaoAngular.saveJanadhaar(janAdhaar);
					farmer.setJanAdhaar(savedJanadhaar);
				} else if (uniqueId == 3){
					System.out.println("Adhaar Id Recieved. " + farmerBean.getAadhar());
					Aadhar aadhar = new Aadhar();
					aadhar.setAadharId(farmerBean.getAadhar());
					Aadhar savedAadhar = farmerRegistrationDaoAngular.saveAadhar(aadhar);
					farmer.setAadhar(savedAadhar);
				} else {
					System.out.println("Something Went Wrong!!");
				}
			}else {
				System.out.println("FarmerBean Bean Is Empty!");
			}
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
		saveFarmer = farmerRegistrationDaoAngular.saveFarmer(farmer);
		return saveFarmer;
	}

	@Override
	public List<Farmer> getFarmerList() {
		return farmerRegistrationDaoAngular.findAllFarmerList();
	}

	@Override
	public String deleteFarmerById(int id) {
		return farmerRegistrationDaoAngular.deleteFarmerById(id);
	}

	@Override
	public Farmer getFarmerById(int id) {
		return farmerRegistrationDaoAngular.getFarmerById(id);
	}
}
