package com.sambit.Dao;

import com.sambit.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FarmerRegistrationDaoImplAngular implements FarmerRegistrationDaoAngular{

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Farmer> findAllFarmerList() {
		return entityManager.createQuery("SELECT f FROM Farmer f", Farmer.class).getResultList();
	}

//	This is Also Working and also without @Override	@Transactional
//	public Collection<FarmerBean> findAllFarmerList() {
//		Query query = entityManager.createQuery("SELECT f FROM FarmerBean f");
//		return (Collection<FarmerBean>) query.getResultList();
//	}

	@Override
	@Transactional
	public Bank saveBank(Bank bank) {
		entityManager.persist(bank);
		return bank;
	}

	@Override
	@Transactional
	public Acknowledge saveAcknowledge(Acknowledge acknowledge) {
		entityManager.persist(acknowledge);
		return acknowledge;
	}

	@Override
	@Transactional
	public Janadhaar saveJanadhaar(Janadhaar janadhaar) {
		entityManager.persist(janadhaar);
		return janadhaar;
	}

	@Override
	@Transactional
	public Aadhar saveAadhar(Aadhar aadhar) {
		entityManager.persist(aadhar);
		return aadhar;
	}

	@Override
	@Transactional
	public Farmer saveFarmer(Farmer farmer) {
		entityManager.persist(farmer);
		return farmer;
	}
}
