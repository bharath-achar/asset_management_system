package com.capgemini.assetms.dao;

import java.util.List;

import com.capgemini.assetms.bean.Asset;
import com.capgemini.assetms.bean.AssetAllocation;

public interface AdminDAO {

	public boolean adminLogin(Integer adminId, String adminPassword);

	public Asset addAsset(Asset asset);

	Asset removeAsset(Integer assetId);

	Asset updateAsset(Integer assetId);

	List<Asset> viewAllAsset();

	List<AssetAllocation> getAllAssetAllocation();

}// End of interface
