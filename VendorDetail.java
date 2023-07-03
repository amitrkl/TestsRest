package com.mycompany.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "VendorDetail")
public class VendorDetail {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false, unique = true, length = 45)
	    private String vendorName;
	    @JsonManagedReference
	    @JsonIgnore
	    @OneToMany(mappedBy="vender",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    
	    //@OneToMany(cascade = CascadeType.ALL)
	    private Set < VendorAddress > vendorAddress = new HashSet < VendorAddress > ();
	    @JsonManagedReference
	    @JsonIgnore
	   // @OneToMany(mappedBy="vendorDetail",cascade = CascadeType.ALL)
	    @OneToMany(mappedBy="vendorDetail",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    private Set < User > vendorUser = new HashSet < User > ();
	    
	    
	    
	    @Column(length = 45, nullable = false, name = "isActive")
	    private boolean status;


		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public VendorDetail() {
			super();
			// TODO Auto-generated constructor stub
		}
		@JsonIgnore
		public Set<VendorAddress> getVendorAddress() {
			return vendorAddress;
		}
		@JsonIgnore
		public void setVendorAddress(Set<VendorAddress> vendorAddress) {
			this.vendorAddress = vendorAddress;
		}
		@JsonIgnore
		public Set<User> getVendorUser() {
			return vendorUser;
		}
		@JsonIgnore
		public void setVendorUser(Set<User> vendorUser) {
			this.vendorUser = vendorUser;
		}


		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getVendorName() {
			return vendorName;
		}

		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}

		/*
		 * @Column(length = 15, nullable = false) private String noOfUsers;
		 * 
		 * @Column(length = 45, nullable = false, name = "first_name") private String
		 * noOfAdress;
		 */

}
