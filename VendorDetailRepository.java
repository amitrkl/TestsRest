package com.mycompany.user;

import org.springframework.data.repository.CrudRepository;

public interface VendorDetailRepository extends CrudRepository<VendorDetail, Integer> {
    //public Long countById(Integer id);
}
