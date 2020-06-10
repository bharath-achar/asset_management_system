package com.capgemini.assetms.services;

import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.bean.Employee;

public interface ManagerService {

	public Boolean managerLogin(int managerId, String password);

	public Employee addEmployee(Employee employee);

	public AssetAllocation raiseAllocation(AssetAllocation assetAllocation);

}// End of interface
