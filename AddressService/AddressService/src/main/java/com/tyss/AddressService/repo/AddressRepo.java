package com.tyss.AddressService.repo;

import com.tyss.AddressService.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepo extends MongoRepository<Address, String> {

    List<Address> getAddressByStudentRoll(String studentId);
}
