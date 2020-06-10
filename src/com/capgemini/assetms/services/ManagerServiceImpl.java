package com.capgemini.assetms.services;

import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.bean.Employee;
import com.capgemini.assetms.dao.ManagerDAO;
import com.capgemini.assetms.dao.ManagerDAOIml;

public class ManagerServiceImpl implements ManagerService {

	ManagerDAO dao = new ManagerDAOIml();

	@Override
	public Boolean managerLogin(int managerId, String password) {
		return dao.managerLogin(managerId, password);
	}// End of managerLogin()

	@Override
	public Employee addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}

	@Override
	public AssetAllocation raiseAllocation(AssetAllocation assetAllocation) {
		return dao.raiseAllocation(assetAllocation);
	}

}// End of class
