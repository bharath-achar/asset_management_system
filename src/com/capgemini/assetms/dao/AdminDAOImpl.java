package com.capgemini.assetms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.capgemini.assetms.bean.Asset;
import com.capgemini.assetms.bean.AssetAllocation;
import com.capgemini.assetms.repository.Repository;
import com.capgemini.assetms.validation.Validation;

public class AdminDAOImpl implements AdminDAO {

	Repository repository = new Repository();
	Scanner scanner = new Scanner(System.in);
	Validation valid = new Validation();
	int flag = 9;

	private HashMap<Integer, String> adminInfo = repository.adminInfo;

	@Override
	public boolean adminLogin(Integer adminId, String adminPassword) {

		if (adminInfo.containsKey(adminId) && adminInfo.containsValue(adminPassword)) {
			return true;
		} else {
			return false;
		} // end of if-else

	}// End of adminLogin()

	@Override
	public Asset addAsset(Asset asset) {

		repository.assetInfo.put(asset.getAssetId(), asset);
		return asset;
	}// End of addAsset()

	@Override
	public Asset removeAsset(Integer assetId) {

		Asset asset = new Asset();
		if (repository.assetInfo.containsKey(assetId)) {
			asset = repository.assetInfo.remove(assetId);
			return asset;
		}
		return null;

	}// End of removeAsset()

	@Override
	public Asset updateAsset(Integer assetId) {

		Asset asset1 = repository.assetInfo.get(assetId);
		if (repository.assetInfo.containsKey(assetId)) {
			block: while (true) {
				System.out.println("Please choose an option");
				System.out.println("1. Update Asset name");
				System.out.println("2. Update Asset description");
				System.out.println("3. Update Asset quantity");
				System.out.println("4. Update Asset status");

				Integer choice = valid.numValidate(scanner.next());
				if (choice != null) {
					if (choice > 4) {
						System.out.println("Please choose a valid choice");
					} else
						flag = 0;
				} else {
					System.err.println("Choice should be number !");
					continue block;
				}

				switch (choice) {
				case 1:

					System.out.println("Enter Asset name to be updated");
					asset1.setAssetName(scanner.next());
					return asset1;

				case 2:
					System.out.println("Enter Asset description to be updated");
					asset1.setAssetDes(scanner.next());
					return asset1;

				case 3:
					System.out.println("Enter Asset quantity to be updated");
					asset1.setQuantity(scanner.nextInt());
					return asset1;

				case 4:
					System.out.println("Enter Asset status to be updated");
					asset1.setStatus(scanner.next());
					return asset1;
				}
			}
		} else {
			System.out.println("Asset " + assetId + "is not present");
		}
		return asset1;

	}

	@Override
	public List<Asset> viewAllAsset() {
		if (!repository.assetInfo.isEmpty()) {
			List<Asset> allAssets = new ArrayList<>(repository.assetInfo.values());
			ListIterator<Asset> al = allAssets.listIterator();
			while (al.hasNext()) {
				System.out.println(al.next());
			}
			return allAssets;
		}
		return null;
	}

	@Override
	public List<AssetAllocation> getAllAssetAllocation() {
		if (!repository.assetAllocationInfo.isEmpty()) {
			List<AssetAllocation> allAssets = new ArrayList<>();
			allAssets.addAll(repository.assetAllocationInfo.values());
			Iterator<AssetAllocation> all = allAssets.iterator();
			while (all.hasNext()) {
				System.out.println(all.next());
			}
			return allAssets;
		} else {

			return null;
		}
	}

}// End of class