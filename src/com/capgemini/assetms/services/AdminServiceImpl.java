
package com.capgemini.assetms.services;

import java.util.List;

import com.capgemini.assetms.bean.Asset;
import com.capgemini.assetms.dao.AdminDAO;
import com.capgemini.assetms.dao.AdminDAOImpl;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao = new AdminDAOImpl();

	@Override
	public boolean adminLogin(Integer adminId, String adminPassword) {
		return dao.adminLogin(adminId, adminPassword);
	}// End of adminLogin()

	@Override
	public Asset addAsset(Asset asset) {
		return dao.addAsset(asset);
	}// End of addAsset()

	@Override
	public Asset removeAsset(Integer assetId) {
		return dao.removeAsset(assetId);
	}// End of removeAsset()

	@Override
	public Asset updateAsset(Integer assetId) {
		return dao.updateAsset(assetId);
	}

	@Override
	public List<Asset> viewAllAsset() {
		return dao.viewAllAsset();
	}

}// End of class
