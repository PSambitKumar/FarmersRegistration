package com.sambit.Service;

import com.sambit.Bean.FarmerBean;
import com.sambit.Model.Farmer;

import java.util.Collection;
import java.util.List;

public interface MainServiceAngular {

	Farmer createFarmer(FarmerBean farmerBean);
	List<Farmer> getFarmerList();
}
