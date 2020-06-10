package com.capgemini.assetms.app;

import java.util.Scanner;

import com.capgemini.assetms.bean.Admin;
import com.capgemini.assetms.bean.Asset;
import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.bean.Employee;
import com.capgemini.assetms.bean.Manager;
import com.capgemini.assetms.exception.AssetException;
import com.capgemini.assetms.exception.EmployeeException;
import com.capgemini.assetms.exception.LoginException;
import com.capgemini.assetms.repository.Repository;
import com.capgemini.assetms.services.AdminService;
import com.capgemini.assetms.services.AdminServiceImpl;
import com.capgemini.assetms.services.ManagerService;
import com.capgemini.assetms.services.ManagerServiceImpl;
import com.capgemini.assetms.validation.Validation;

public class App {

	public static void main(String[] args) {

		AdminService adminService = new AdminServiceImpl();
		ManagerService managerService = new ManagerServiceImpl();
		Validation valid = new Validation();

		Repository repository = new Repository();

		Scanner scanner = new Scanner(System.in);
		int adminId;
		String adminPassword;
		Integer tempId;
		Integer asset_id1;
		Integer tempAssetId;
		Integer tempAssetId1;
		Integer tempAssetQuantity;
		Integer asset_quantity1;
		int managerId;
		String managerPassword;

		int flag = 9;
		block: while (true) {
			System.out.println("Welcome to Asset Management System");
			System.out.println("*****************************************************");
			System.out.println("Please Login to begin");
			System.out.println("1. Login as Admin");
			System.out.println("2. Login as Manager");
			System.out.println("3. Close");

			Integer choiceA = valid.numValidate(scanner.next());
			if (choiceA != null) {
				flag = 0;
			} else {
				System.err.println("Choice should be number !");
				continue block;
			}

			switch (choiceA) {
			case 1:
				Boolean b = true;
				blockC: while (true) {
					Admin admin = new Admin();
					try {
						System.out.println("Enter Admin Id:");
						tempId = valid.numValidate(scanner.next());
						if (tempId != null) {
							adminId = tempId;
							admin.setAdminId(adminId);
							b = false;
						} else {
							System.err.println("Admin id should be number !");
							continue blockC;
						}

						System.out.println("Enter Admin Password");
						adminPassword = scanner.next();

					} catch (Exception e) {
						throw new LoginException();
					}
					b = adminService.adminLogin(tempId, adminPassword);
					if (b == false) {
						System.out.println("ID / Password are incorrect... Please try again");
						continue blockC;
					} else {
						System.out.println("Login Successful");
						System.out.println("******************************************************");
						System.out.println("You are logged in as Admin...");
						System.out.println("******************************************************");

						block2: while (true) {

							System.out.println("Please choose an option");
							System.out.println("1. Add Asset");
							System.out.println("2. Remove Asset");
							System.out.println("3. Update Asset");
							System.out.println("4. View all Asset");
							System.out.println("5. View all request raised ");
							System.out.println("6. Set allocation status");
							System.out.println("7. Logout");

							Integer adminChoice = valid.numValidate(scanner.next());
							if (adminChoice != null) {
								flag = 0;
							} else {
								System.err.println("Choice should be number !");
								continue block2;
							}

//							int adminChoice = scanner.nextInt();
							block1: while (true) {
								switch (adminChoice) {
								case 1:
									blockAsset: while (true) {
										Asset asset = new Asset();

										System.out.println("Enter the Asset Id to be added");

										tempAssetId = valid.numValidate(scanner.next());
										if (tempAssetId != null) {
											asset_id1 = tempAssetId;
											asset.setAssetId(asset_id1);
											b = false;
										} else {
											System.err.println("Asset id should be number !");
											continue blockAsset;
										}

//										Integer asset_id1 = scanner.nextInt();

										if (repository.assetInfo.containsKey(asset_id1)
												&& repository.assetInfo.containsValue(null)) {
											System.out.println("Asset " + asset_id1 + "already present");
										} else {
											asset.setAssetId(asset_id1);
											System.out.println("Enter the Asset Name to be added");
											asset.setAssetName(scanner.next());

											System.out.println("Enter the Asset Description");
											asset.setAssetDes(scanner.next());
											scanner.nextLine();

											System.out.println("Enter the Asset Quantity");
											tempAssetQuantity = valid.numValidate(scanner.next());
											if (tempAssetQuantity == null) {
												System.err.println("Asset quantity should be number!");
												System.out.println("Please add again with proper values");
												continue blockAsset;
											} else {
												asset_quantity1 = tempAssetQuantity;
												asset.setQuantity(asset_quantity1);
												b = false;
//												asset.setQuantity(scanner.nextInt());

												System.out.println("Enter the Asset Status");
												asset.setStatus(scanner.next());

												repository.assetInfo.put(asset_id1, asset);

											}
//										} catch (Exception e) {
//											throw new AssetException();
//										}
											System.out.println("****************************************************");
											System.out.println("Added asset is : " + adminService.addAsset(asset));
											System.out.println("****************************************************");

											blockA: while (true) {
												System.out.println("***********************************");
												System.out.println("Do you want to add further assets");
												System.out.println("Press 1 to add");
												System.out.println("Press 0 to return back");
												System.out.println("***********************************");

												Integer choice1 = valid.numValidate(scanner.next());
												if (choice1 != null) {
													if (choice1 == 1) {
														continue block1;
													} else if (choice1 == 0) {
														continue block2;
													} else if (choice1 > 1) {
														System.err.println("Please enter a valid option!!!");
													}
												} else {
													System.err.println("Please enter a valid option!!!");
												}
												continue blockA;
											}
										}
									}

								case 2:
									block3: while (true) {

										Asset asset1 = new Asset();
										try {
											System.out.println("Enter the Asset Id to be removed : ");

											tempAssetId1 = valid.numValidate(scanner.next());
											if (tempAssetId1 != null) {
												asset_id1 = tempAssetId1;
												asset1.setAssetId(asset_id1);
												b = false;
											} else {
												System.err.println("Asset id should be number !");
												continue block3;
											}

//											Integer asset_id = scanner.nextInt();
											if (repository.assetInfo.containsKey(asset_id1)) {
												asset1 = adminService.removeAsset(asset_id1);
												if (asset1 != null) {
													System.out.println("*********************************************");
													System.out.println("Removed Asset is : " + asset1);
													System.out.println("*********************************************");
												} else {
													System.out
															.println("**********************************************");
													System.out.println("Asset Id " + asset_id1 + " is not present");
													System.out
															.println("**********************************************");
												}
											} else {
												System.out
														.println("**************************************************");
												System.out.println("Asset Id " + asset_id1 + " is not present");
												System.out.println("**********************************************");
											}
										} catch (Exception e) {
											throw new AssetException();
										}

										block12: while (true) {
											System.out.println("***********************************");

											System.out.println("Do you want to delete further assets");
											System.out.println("Press 1 to delete");
											System.out.println("Press 0 to return back");
											System.out.println("***********************************");

											Integer choice2 = valid.numValidate(scanner.next());
											if (choice2 != null) {
												if (choice2 == 1) {
													continue block3;
												} else if (choice2 == 0) {
													continue block2;
												} else if (choice2 > 1) {
													System.err.println("Please enter a valid option");
												}
											} else {
												System.err.println("Please enter a valid option!!!");
											}

											continue block12;
										}
									}

								case 3:
									block4: while (true) {
										Asset asset3 = new Asset();
										Integer asset_id12;
										try {
											System.out.println("Enter Asset Id to be Updated");

											Integer asset_id2 = valid.numValidate(scanner.next());
											if (asset_id2 != null) {
												asset_id12 = asset_id2;
												asset3 = adminService.updateAsset(asset_id12);
												b = false;
											} else {
												System.out.println("Asset id should be number !");
												continue block4;
											}

										} catch (Exception e) {
											throw new AssetException();
										}
										if (asset3 != null) {
											System.out.println("**************************************************");
											System.out.println("Updated asset is " + asset3);
											System.out.println("**************************************************");
											System.out.println("Do you want to update further assets");
											System.out.println("Press 1 to update");
											System.out.println("Press 0 to return back");
											System.out.println("***********************************");
											Integer choice2 = valid.numValidate(scanner.next());
											if (choice2 != null) {
												if (choice2 == 1) {
													continue block4;
												} else if (choice2 == 0) {
													continue block2;
												} else if (choice2 > 1) {
													System.err.println("Please enter a valid option!!!");
												}
											} else {
												System.err.println("Please enter a valid option!!!");
											}

										} else {
											continue block2;
										}
										break;
									}
								case 4:
									try {
										System.out.println("All Assets are : ");
										adminService.viewAllAsset();
									} catch (Exception e) {
										throw new AssetException();
									}
									continue block2;
								case 5:
									try {
										if (!repository.assetAllocationInfo.isEmpty()) {
											System.out.println("**************************************************");
											System.out.println(repository.assetAllocationInfo.values());
											System.out.println("**************************************************");
										} else {
											System.out.println("**************************************************");
											System.out.println("No asset allocation request has been raised");
											System.out.println("**************************************************");
										}
									} catch (Exception e) {
										throw new AssetException();
									}
									continue block2;
								case 6:
									block3: while (true) {
										try {
											System.out.println("Enter Allocation Id to set status");
											Integer allocationId = valid.numValidate(scanner.next());
											if (allocationId != null) {
												if (repository.assetStatusInfo.containsKey(allocationId)) {
													System.out.println("1. Accept status");
													System.out.println("2. Reject status");
													System.out.println("3. Return back");
													System.out.println("4. Return to Home Page");
													Integer choice3 = scanner.nextInt();
													switch (choice3) {
													case 1:
														repository.assetStatusInfo.put(allocationId, "accept");
														break;
													case 2:
														repository.assetStatusInfo.put(allocationId, "reject");
														break;
													case 3:
														continue block3;
													case 4:
														continue block2;
													default:
														System.out.println("Please enter a valid option!!!");
														break;
													}
													System.out.println(
															"**************************************************");
													System.out.println("Asset allocation status are : ");
													System.out.println(repository.assetStatusInfo);
													System.out.println(
															"**************************************************");
												} else {
													System.out.println(
															"**************************************************");
													System.out.println(
															"Allocation Id " + allocationId + " is not present");
													System.out.println(
															"**************************************************");
												}
											} else {
												System.err.println("Allocation id should be an integer");
												continue block3;
											}
										} catch (Exception e) {
											throw new AssetException();
										}

										blockB: while (true) {
											System.out.println("***********************************");
											System.out.println(
													"Do you want to set status for further allocation request");
											System.out.println("Press 1 to continue");
											System.out.println("Press 0 to return back");
											Integer choice2 = valid.numValidate(scanner.next());
											if (choice2 != null) {
												if (choice2 == 1) {
													continue block3;
												} else if (choice2 == 0) {
													continue block2;
												} else if (choice2 > 1) {
													System.err.println("Please choose a valid option");
													continue blockB;
												}
											} else {
												System.err.println("Please enter a valid option!!!");
												continue blockB;
											}
										}
									}

								case 7:
									System.out.println("******************************************************");
									System.out.println("Admin logged out successfully");
									System.out.println("******************************************************");
									continue block;

								default:
									System.out.println("Please enter a valid option");
									break;
								}// End of switch
							}
						}

					} // End of if-else
				}

			case 2:
				Manager manager = new Manager();
				boolean a = true;
				while (a) {

					try {

						System.out.println("Enter Manager Id:");
						tempId = valid.numValidate(scanner.next());
						if (tempId != null) {
							managerId = tempId;
							manager.setManagerId(managerId);
							b = false;
						} else {
							System.out.println("Manager id should be number !");
							continue;
						}

						System.out.println("Enter Manager Password");
						managerPassword = scanner.next();
						b = managerService.managerLogin(tempId, managerPassword);

					} catch (Exception e) {
						throw new LoginException();
					}
					if (b == false) {
						System.out.println("ID / Password are incorrect... Please try again");
					} else {

						System.out.println("Login Successful");
						System.out.println("*******************************************************");
						System.out.println("You are logged in as Manager");
						System.out.println("*******************************************************");

						block4: while (true) {
							System.out.println("Please choose an option");
							System.out.println("1. Add Employee");
							System.out.println("2. Raise asset allocation");
							System.out.println("3. View status");
							System.out.println("4. Logout");

							Integer choice1 = valid.numValidate(scanner.next());
							if (choice1 != null) {
								flag = 0;
							} else {
								System.err.println("Choice should be number");
								continue block4;
							}

							switch (choice1) {
							case 1:
								Employee employee = new Employee();
								try {
									blockC: while (true) {
										System.out.println("Enter Employee Id");
										Integer emp_id = valid.numValidate(scanner.next());
										if (emp_id != null) {
											if (repository.empInfo.containsKey(emp_id)) {
												System.out.println("Employee " + emp_id + " already present");
											} else {
												employee.setEmpNo(emp_id);
												System.out.println("Enter Employee Name");
												employee.setEmpName(scanner.next());
												System.out.println("Enter Employee Job");
												employee.setJob(scanner.next());
												System.out.println("Enter Manager Number");
												Integer mgrno = valid.numValidate(scanner.next());
												employee.setMgrNo(mgrno);
												System.out.println("Enter Employee HireDate");
												String hireDate = scanner.next();
												if (valid.dateValidate(hireDate)) {
													employee.setHireDate(hireDate);
												} else {
													System.out.println("Please enter date in YYYY-MM-DD format");
													break;
												}
												System.out.println("Enter Department Id");
												Integer deptid = valid.numValidate(scanner.next());
												employee.setDepId(deptid);
												System.out
														.println("**************************************************");
												System.out.println(
														"Added Employee is : " + managerService.addEmployee(employee));
												System.out
														.println("**************************************************");
											}
										} else {
											System.err.println("Employee id should be number");
											continue blockC;
										}
									}
								} catch (Exception e) {
									throw new EmployeeException();
								}
								continue block4;

							case 2:
								AssetAllocation assetAllocation = new AssetAllocation();
								AdminService adminService2 = new AdminServiceImpl();

								block5: while (true) {
									try {
										System.out.println("Available Assets are : " + adminService2.viewAllAsset());
										System.out.println("Press 0 to raise a request for asset allocation ");
										System.out.println("Press 1 to return");
										Integer choice2 = valid.numValidate(scanner.next());
										if (choice2 != null) {
//											switch (choice2) {
											if (choice2 == 0) {
												System.out.println("Enter Asset Id ");
												Integer asset_Id = valid.numValidate(scanner.next());
												if (asset_Id != null) {
													if (repository.assetInfo.containsKey(asset_Id)) {
														assetAllocation.setAssetId(asset_Id);
													} else {
														System.err.println("Asset id should be number");
													}
													System.out.println("Enter Employee number ");
													Integer employee_no = valid.numValidate(scanner.next());

													if (repository.empInfo.containsKey(employee_no)) {
														assetAllocation.setEmpNo(employee_no);

														System.out.println("Enter Allocation date");
														String allocationDate = scanner.next();
														if (valid.dateValidate(allocationDate)) {
															assetAllocation.setAllocationDate(allocationDate);
															System.out.println("Enter Release date ");
															String releaseDate = scanner.next();
															if (valid.dateValidate(releaseDate)) {
																assetAllocation.setReleaseDate(releaseDate);
																System.out.println("Enter the quantity ");
																assetAllocation.setQuantity(scanner.nextInt());
																System.out.println(
																		"Raised allocation request : " + managerService
																				.raiseAllocation(assetAllocation));
																Integer asset_status_no = assetAllocation
																		.getAllocationId();
																System.out.println(
																		"**************************************************");
																System.out.println(
																		"Allocation Id raised for the asset is "
																				+ asset_status_no);
																System.out.println(
																		"**************************************************");

																repository.assetAllocationInfo.put(
																		assetAllocation.getAllocationId(),
																		assetAllocation);
//										System.out.println(repository.assetAllocationInfo.values());
																repository.assetStatusInfo.put(asset_status_no,
																		"pending");
															} else {
																System.out.println(
																		"Please enter date in YYYY-MM-DD format");
																break;
															}
														} else {
															System.out
																	.println("Please enter date in YYYY-MM-DD format");
															break;
														}
													} else {
														System.out.println(
																"Employee number " + employee_no + " is not present");
													}
												} else {
													System.out.println(
															"**************************************************");
													System.out.println("Asset " + asset_Id + " is not present");
													System.out.println(
															"**************************************************");
												}
												System.out.println("***********************************");
												System.out.println("Do you want to raise further asset request");
												System.out.println("Press 1 to continue");
												System.out.println("Press 0 to return back");
												System.out.println("***********************************");
												int choice3 = scanner.nextInt();
												if (choice3 == 1) {
													continue block5;
												} else if (choice3 == 0) {
													continue block4;
												} else {
													System.out.println("Please enter a valid option!!!");
												}

												break;
											} else if (choice2 == 1) {
//											case 1:
												continue block4;
											} else if (choice2 > 1) {
												System.err.println("Please choose a valid option");
												continue block5;
											}
										} else {
											System.err.println("Choice should be a number");
											continue block5;
										}

									} catch (Exception e) {
										throw new AssetException();
									}
									continue block4;
								}

							case 3:
								if (!repository.assetStatusInfo.isEmpty()) {
									System.out.println("**************************************************");
									System.out.println("Asset allocation status are :");
									System.out.println(repository.assetStatusInfo);
									System.out.println("**************************************************");
								} else {
									System.out.println("**************************************************");
									System.out.println("There are not assets added");
									System.out.println("**************************************************");
								}
								continue block4;
							case 4:
								System.out.println("****************************************");
								System.out.println("Manager logged out Successfully!!!");
								System.out.println("****************************************");
								continue block;
							default:
								System.out.println("Please enter a valid option!!!");
								break;
							}
						}

					} // End of if-else
				}
				break;
			case 3:
//				flag = 0;
				System.out.println("Thank you... Visit again!!!");
//				scanner.close();
				break;
			default:
				System.out.println("Please enter a valid option!!!");
				break;
			}// End of switch
		} // End of while
	}// End of main()
}// End of class
