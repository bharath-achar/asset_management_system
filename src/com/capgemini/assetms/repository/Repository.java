package com.capgemini.assetms.repository;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.assetms.bean.Admin;
import com.capgemini.assetms.bean.Asset;
import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.bean.Department;
import com.capgemini.assetms.bean.Employee;
import com.capgemini.assetms.bean.Manager;

public class Repository {

	public HashMap<Integer, String> adminInfo = new HashMap<>();
	public HashMap<Integer, String> managerInfo = new HashMap<>();
	public HashMap<Integer, Asset> assetInfo = new HashMap<>();
	public HashMap<Integer, Employee> empInfo = new HashMap<>();
	public HashMap<Integer, Department> deptInfo = new HashMap<>();
	public Map<Integer, AssetAllocation> assetAllocationInfo = new HashMap<Integer, AssetAllocation>();
	public HashMap<Integer, String> assetStatusInfo = new HashMap<Integer, String>();

	// Contructor
	public Repository() {

		// Admin
		Admin admin = new Admin();
		admin.setAdminId(9538);
		admin.setAdminPassword("Bharath123");
		adminInfo.put(admin.getAdminId(), admin.getAdminPassword());

		// Manager 1
		Manager manager1 = new Manager();
		manager1.setManagerId(12345);
		manager1.setManagerName("Manager1");
		manager1.setPassword("manager123");
		managerInfo.put(manager1.getManagerId(), manager1.getPassword());

		// Manager 2
		Manager manager2 = new Manager();
		manager2.setManagerId(12346);
		manager2.setManagerName("Manager2");
		manager2.setPassword("manager124");

		// Manager 3
		Manager manager3 = new Manager();
		manager3.setManagerId(12347);
		manager3.setManagerName("Manager3");
		manager3.setPassword("manager125");

		// Asset 1
		Asset asset1 = new Asset();
		asset1.setAssetId(101);
		asset1.setAssetName("Computer");
		asset1.setAssetDes("Available");
		asset1.setQuantity(20);
		asset1.setStatus("available");
		assetInfo.put(asset1.getAssetId(), asset1);

		// Asset 2
		Asset asset2 = new Asset();
		asset2.setAssetId(102);
		asset2.setAssetName("Laptop");
		asset2.setAssetDes("Not Available");
		asset2.setQuantity(15);
		asset2.setStatus("available");
		assetInfo.put(asset2.getAssetId(), asset2);

		// Employee 1
		Employee employee1 = new Employee();
		employee1.setEmpNo(1);
		employee1.setEmpName("Bharath");
		employee1.setJob("Software developer");
		employee1.setMgrNo(201);
		employee1.setHireDate("15-10-2019");
		employee1.setDepId(1);
		empInfo.put(employee1.getEmpNo(), employee1);

		// Employee 2
		Employee employee2 = new Employee();
		employee2.setEmpNo(2);
		employee2.setEmpName("Ramya");
		employee2.setJob("Technical Support");
		employee2.setMgrNo(2);
		employee2.setHireDate("20-10-2019");
		employee2.setDepId(2);
		empInfo.put(employee2.getEmpNo(), employee2);

		// Department
		Department department1 = new Department();
		department1.setDeptId(1);
		department1.setDeptName("Computer");
		deptInfo.put(department1.getDeptId(), department1);

		// Department
		Department department2 = new Department();
		department2.setDeptId(2);
		department2.setDeptName("Electricals");
		deptInfo.put(department2.getDeptId(), department2);

	}// End of Constructor

}// End of class
