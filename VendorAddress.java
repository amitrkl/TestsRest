package com.mycompany.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "VendorAddress")
public class VendorAddress {
	

	public VendorAddress(String adressLine1, String adressLine2, String state, String country, boolean enabled) {
		super();
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.state = state;
		this.country = country;
		this.enabled = enabled;
	}

	public VendorAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45,name = "adressLine1")
    private String adressLine1;

    @Column(length = 15, nullable = true,name = "adressLine2")
    private String adressLine2;

    @Column(length = 45, nullable = false, name = "state")
    private String state;

    @Column(length = 45, nullable = false, name = "country")
    private String country;
    @JsonIgnore
    public VendorDetail getVendor() {
		return vender;
	}

	public void setVendor(VendorDetail vendorDetail) {
		this.vender = vendorDetail;
	}

	@Column(length = 45, nullable = false, name = "isActive")
    private boolean enabled;
	 @JsonBackReference
	 @ManyToOne//(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	
	 @JoinColumn(name = "vendor_id",nullable = false)
    private VendorDetail vender;
    
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdressLine1() {
		return adressLine1;
	}

	public void setAdressLine1(String adressLine1) {
		this.adressLine1 = adressLine1;
	}

	public String getAdressLine2() {
		return adressLine2;
	}

	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

    
    
}