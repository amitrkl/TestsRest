package com.mycompany.user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "vendorDetail", "noOfUsers", "noOfAddress"})

public class ViewVendorDetailDTO {
	private VendorDetail vendorDetail;
	private  int noOfUsers;
	private int noOfAddress;
	public VendorDetail getVendorDetail() {
		return vendorDetail;
	}
	public void setVendorDetail(VendorDetail vendorDetail) {
		this.vendorDetail = vendorDetail;
	}
	public int getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(int noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public int getNoOfAddress() {
		return noOfAddress;
	}
	public void setNoOfAddress(int noOfAddress) {
		this.noOfAddress = noOfAddress;
	}

}
