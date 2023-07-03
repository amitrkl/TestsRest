package com.mycompany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.user.VendorDetail;
import com.mycompany.user.VendorDetailRepository;

@Service("studentServiceImpl")
public class VendorDetailServiceImpl {

	@Autowired
	private VendorDetailRepository vendorRepository;

	public VendorDetail getVendorDetail(int id) {
		// TODO Auto-generated method stub
		return vendorRepository.findById(id).get();
	}

	public List<VendorDetail> findAllVendor() {
		// TODO Auto-generated method stub
		return (List<VendorDetail>) vendorRepository.findAll();
	}
	
	

	/*
	 * @Transactional public List<Student> saveAllStudent(List<Student> studentList)
	 * { List<Student> response = (List<Student>)
	 * studentRepository.saveAll(studentList); return response; }
	 * 
	 * @Transactional public void deleteAll() { studentRepository.deleteAll(); }
	 * 
	 * @Transactional public void deleteAllInBatch() {
	 * //studentRepository.deleteAllInBatch(); }
	 * 
	 * @Transactional(readOnly = true) public Student getStudent(int id ) {
	 * Optional<Student> studentResponse = studentRepository.findById(id); Student
	 * student = studentResponse.get(); return student; }
	 * 
	 * @Transactional public List<Student> findByAddressCity(String city) {
	 * List<Student> response = (List<Student>)
	 * studentRepository.findByAddressCity(city); return response; }
	 * 
	 * @Override public List<Student> getAllStudents(List<Integer> ids) { // TODO
	 * Auto-generated method stub return null; }
	 */

	
	
	
	

}