package com.tyss.AddressService.dao;

import com.tyss.AddressService.dto.AddressRequest;
import com.tyss.AddressService.entity.Address;

import java.util.List;

public interface AddressDao {

    Address saveAddress(Address address);

    Address getAddressById(String addressId);

    List<Address> getAllAddress();

    boolean deleteAddressById(String addressId);

    Address updateAddress(Address address);

    List<Address> getAddressByStudentRoll(String studentId);
}
