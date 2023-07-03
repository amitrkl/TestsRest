package com.mycompany;

import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import com.mycompany.user.VendorAddress;
import com.mycompany.user.VendorAddressRepository;
import com.mycompany.user.VendorDetail;
import com.mycompany.user.VendorDetailRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class VendorDetailRepositoryTest {
    @Autowired private VendorDetailRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private VendorAddressRepository vrepo;

    @Test
    public void testAddNew() {
    	VendorDetail vd = new VendorDetail();
    	vd.setVendorName("TCS");
    	repo.save(vd);
    	User user1 = new User("alex.stevenson@gmail.com", "alex123456","Alex", "Stevenson", true);
    	user1.setVendorDetail(vd);
        User user2 = new User("amit.stevenson@gmail.com", "amit123456","amit", "amit", true);
        user2.setVendorDetail(vd);
        User user3 = new User("asit.stevenson@gmail.com", "asit123456","asit", "asit", true);
        User user4 = new User("user.stevenson@gmail.com", "user123456","user", "user", true);
        user3.setVendorDetail(vd);
        user4.setVendorDetail(vd);
        userRepo.saveAll(Set.of(user1,user2,user3,user4));
       // vd.setVendorUser(  Set.of(user1,user2,user3,user4));
        
        VendorAddress adre1 = new VendorAddress("ADR-1", "ADR-1", "ADR-1", "ADR-1", true);
        VendorAddress adre2 = new VendorAddress("ADR-2", "ADR-2", "ADR-2", "ADR-5", true);
        VendorAddress adre3 = new VendorAddress("ADR-3", "ADR-4", "ADR-4", "ADR-6", true);
        adre1.setVendor(vd);  adre2.setVendor(vd);  adre3.setVendor(vd);
       // vd.setVendorAddress(  Set.of(adre1,adre2,adre3));
        //VendorDetail savedUser = repo.save(vd);
        vrepo.saveAll(Set.of(adre1,adre2,adre3));
        //Assertions.assertThat(savedUser).isNotNull();
        //Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    
    @Test
    public void testAddNew2() {
    	VendorDetail vd = new VendorDetail();
    	vd.setVendorName("Wipro");
    	vd.setStatus(true);
    	repo.save(vd);
    	User user1 = new User("alex.Wipro@gmail.com", "alex123456","Alex", "Stevenson", true);
    	user1.setVendorDetail(vd);
        User user2 = new User("amit.Wipro@gmail.com", "amit123456","amit", "amit", true);
        user2.setVendorDetail(vd);
        User user3 = new User("asit.Wipro@gmail.com", "asit123456","asit", "asit", true);
        User user4 = new User("user.Wipro@gmail.com", "infy123456","user", "user", true);
        user3.setVendorDetail(vd);
        user4.setVendorDetail(vd);
        userRepo.saveAll(Set.of(user1,user2,user3,user4));
       // vd.setVendorUser(  Set.of(user1,user2,user3,user4));
        
        VendorAddress adre1 = new VendorAddress("Wipro-ADR-1", "Wipro-ADR-1", "Wipro-ADR-1", "ADR-1", true);
        VendorAddress adre2 = new VendorAddress("Wipro-ADR-2", "Wipro-ADR-2", "Wipro-ADR-2", "ADR-5", true);
        VendorAddress adre3 = new VendorAddress("Wipro-ADR-3", "Wipro-ADR-4", "Wipro-ADR-4", "ADR-6", true);
        adre1.setVendor(vd);  adre2.setVendor(vd);  adre3.setVendor(vd);
       // vd.setVendorAddress(  Set.of(adre1,adre2,adre3));
        //VendorDetail savedUser = repo.save(vd);
        vrepo.saveAll(Set.of(adre1,adre2,adre3));
        //Assertions.assertThat(savedUser).isNotNull();
        //Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    
    

    @Test
    public void testListAll() {
        Iterable<VendorDetail> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (VendorDetail user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<VendorDetail> optionalUser = repo.findById(userId);
		/*
		 * VendorDetail user = optionalUser.get(); user.setPassword("hello2000");
		 * repo.save(user);
		 * 
		 * User updatedUser = repo.findById(userId).get();
		 */
        //Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello2000");
    }

    @Test
    public void testGet() {
        Integer userId = 2;
        //Optional<User> optionalUser = repo.findById(userId);
       // Assertions.assertThat(optionalUser).isPresent();
       // System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        repo.deleteById(userId);

       // Optional<User> optionalUser = repo.findById(userId);
       // Assertions.assertThat(optionalUser).isNotPresent();
    }
}
