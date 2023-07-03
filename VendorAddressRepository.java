package com.mycompany.user;

import org.springframework.data.repository.CrudRepository;

public interface VendorAddressRepository extends CrudRepository<VendorAddress, Integer> {
    public Long countById(Integer id);
}
