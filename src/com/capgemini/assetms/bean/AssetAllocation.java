package com.capgemini.assetms.bean;

public class AssetAllocation {

	private Integer allocationId;
	private Integer assetId;
	private Integer empNo;
	private String allocationDate;
	private String releaseDate;
	private Integer quantity;

	// Getters and Setters
	public Integer getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(Integer allocationId) {
		this.allocationId = allocationId;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(String allocationDate) {
		this.allocationDate = allocationDate;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "AssetAllocation [allocationId=" + allocationId + ", assetId=" + assetId + ", empNo=" + empNo
				+ ", allocationDate=" + allocationDate + ", releaseDate=" + releaseDate + "]";
	}// End of toString()

}// End of class
