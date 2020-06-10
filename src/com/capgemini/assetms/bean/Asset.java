package com.capgemini.assetms.bean;

public class Asset {

	private Integer assetId;
	private String assetName;
	private String assetDes;
	private Integer quantity;
	private String status;

	// Getters and Setters
	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetDes() {
		return assetDes;
	}

	public void setAssetDes(String assetDes) {
		this.assetDes = assetDes;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetName=" + assetName + ", assetDes=" + assetDes + ", quantity="
				+ quantity + ", status=" + status + "]";
	}// End of toString()

}// End of class
