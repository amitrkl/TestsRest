package com.mycompany.user;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({ "vendorDetail", "user", "vendorAddress"})

public class AddVendorDTO {
	private Set<User> user;
	private Set<VendorAddress> vendorAddress;
	private VendorDetail vendorDetail;
	
	
	public VendorDetail getVendorDetail() {
		return vendorDetail;
	}
	public void setVendorDetail(VendorDetail vendorDetail) {
		this.vendorDetail = vendorDetail;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public Set<VendorAddress> getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(Set<VendorAddress> vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	


}
