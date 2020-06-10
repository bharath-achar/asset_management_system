package com.capgemini.assetms.services;

import java.util.List;

import com.capgemini.assetms.bean.Asset;

public interface AdminService {

	public boolean adminLogin(Integer adminId, String adminPassword);

	public Asset addAsset(Asset asset);

	public Asset removeAsset(Integer assetId);

	public Asset updateAsset(Integer assetId);

	List<Asset> viewAllAsset();


//	List<AssetAllocation> getAllAssetAllocation();

}// End of interface
