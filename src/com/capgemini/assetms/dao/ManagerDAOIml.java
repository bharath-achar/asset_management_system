package com.capgemini.assetms.dao;

import java.util.HashMap;

import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.bean.Employee;
import com.capgemini.assetms.repository.Repository;

public class ManagerDAOIml implements ManagerDAO {

	Repository repository = new Repository();

	private HashMap<Integer, String> managerInfo = repository.managerInfo;

	@Override
	public Boolean managerLogin(Integer managerId, String password) {
		try {

			if (managerInfo.containsKey(managerId) && managerInfo.containsValue(password)) {
				return true;
			} else {
				return false;
			} // End of if-else
		} catch (Exception e) {
			e.printStackTrace();
		} // End of try-catch
		return null;

	}// End of managerLogin()

	@Override
	public Employee addEmployee(Employee employee) {
		repository.empInfo.put(employee.getEmpNo(), employee);
		return employee;
	}

	@Override
	public AssetAllocation raiseAllocation(AssetAllocation assetAllocation) {
		Integer max = repository.assetAllocationInfo.keySet().size();

		assetAllocation.setAllocationId(max + 1);
		repository.assetAllocationInfo.put(max + 1, assetAllocation);
		repository.assetStatusInfo.put(max + 1, "pending");
		return assetAllocation;
	}
}// End of class
