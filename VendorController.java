package com.mycompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.user.AddVendorDTO;
import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import com.mycompany.user.VendorAddress;
import com.mycompany.user.VendorAddressRepository;
import com.mycompany.user.VendorDetail;
import com.mycompany.user.VendorDetailRepository;
import com.mycompany.user.ViewVendorDetailDTO;

@RestController
@RequestMapping(value = "/vendor")
public class VendorController {
	
	@Autowired VendorDetailServiceImpl service;
	@Autowired UserRepository urepo;
	@Autowired VendorAddressRepository vrepo;
	@Autowired VendorDetailRepository vdrepo;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AddVendorDTO getVendorDetail(@PathVariable int id) {
		VendorDetail vendorDetail = (VendorDetail) service.getVendorDetail(id);
		System.out.println(vendorDetail.getVendorAddress().size());
		System.out.println(vendorDetail.getVendorUser().size());
		//List<Integer> ids = Arrays.asList(1,2,3);
		//System.out.println("exist object  :  " + repo.existsById(id));
		AddVendorDTO a = new AddVendorDTO();
		a.setVendorDetail(vendorDetail);
		a.setVendorAddress(vendorDetail.getVendorAddress());
		a.setUser(vendorDetail.getVendorUser());
		return a;
	}
	@RequestMapping(value = "/loadVendors", method = RequestMethod.GET)
	@ResponseBody
	public List<ViewVendorDetailDTO> getVendorDetail() {
		List<ViewVendorDetailDTO> dto  = new ArrayList<>();
		List<VendorDetail> vendorDetail =  service.findAllVendor();
		System.out.println(vendorDetail.size());
	//	System.out.println(vendorDetail.getVendorUser().size());
		//List<Integer> ids = Arrays.asList(1,2,3);
		//System.out.println("exist object  :  " + repo.existsById(id));
		 for(VendorDetail v :vendorDetail) {
			 ViewVendorDetailDTO a = new ViewVendorDetailDTO();
		a.setVendorDetail(v);
		a.setNoOfAddress(v.getVendorAddress().size());
		a.setNoOfUsers(v.getVendorUser().size());
		//a.setStatus(v.isStatus());
		dto.add(a);
		 }
		return dto;
	}
	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	public String saveVendor(@RequestBody AddVendorDTO addVendorDTO) {
		VendorDetail obj = vdrepo.save(addVendorDTO.getVendorDetail());
		 Set<User> user = addVendorDTO.getUser();
		 user =  user.stream().map(x ->funcEmpToString.apply(x,obj)).collect(Collectors.toSet());
			/*
			 * for (User u:user) { u.setVendorDetail(obj);
			 * 
			 * }
			 */
		 Set<VendorAddress> address = addVendorDTO.getVendorAddress();
		 for (VendorAddress u:address) {
			 u.setVendor(obj);
			 
		 }
		 urepo.saveAll(user);
		 vrepo.saveAll(address);
		 
		 VendorDetail vendorDetail = (VendorDetail) service.getVendorDetail(obj.getId());
			System.out.println(vendorDetail.getVendorAddress().size());
			System.out.println(vendorDetail.getVendorUser().size());
			//List<Integer> ids = Arrays.asList(1,2,3);
			//System.out.println("exist object  :  " + repo.existsById(id));
			AddVendorDTO a = new AddVendorDTO();
			a.setVendorDetail(vendorDetail);
			a.setVendorAddress(vendorDetail.getVendorAddress());
			a.setUser(vendorDetail.getVendorUser());
			return "Vendor with id : "+obj.getId() +"  sucessfully saved ";
		
	}
	
	/*
	 * @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public AddVendorDTO getUserDetail(@PathVariable int id) { User
	 * user = (User) urepo.findById(id).get();
	 * System.out.println(user.getVendorDetail()); return null; }
	 */
	
	
	BiFunction<User,VendorDetail, User> funcEmpToString= (User e,VendorDetail v)-> {
		e.setVendorDetail(v);
		return e;
				};
    

}
