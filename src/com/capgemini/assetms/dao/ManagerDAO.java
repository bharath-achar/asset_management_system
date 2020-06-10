package com.capgemini.assetms.dao;

import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.bean.Employee;

public interface ManagerDAO {

	public Boolean managerLogin(Integer managerId, String password);

	public Employee addEmployee(Employee employee);

	AssetAllocation raiseAllocation(AssetAllocation assetAllocation);

}// End of interface
