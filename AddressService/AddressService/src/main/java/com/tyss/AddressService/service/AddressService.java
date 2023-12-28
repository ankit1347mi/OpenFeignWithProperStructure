package com.tyss.AddressService.service;

import com.tyss.AddressService.dto.AddressRequest;
import com.tyss.AddressService.dto.AddressResponse;
import com.tyss.AddressService.entity.Address;
import com.tyss.AddressService.structure.ResponseStructure;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {

    ResponseEntity<ResponseStructure<AddressResponse>> saveAddress(AddressRequest addressRequest);

    ResponseEntity<ResponseStructure<Address>> getAddressById(String addressId);

    ResponseEntity<ResponseStructure<List<AddressResponse>>> getAllAddress();

    ResponseEntity<ResponseStructure<String>> deleteAddressById(String addressId);

    ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(AddressRequest addressRequest);

    ResponseEntity<ResponseStructure<List<AddressResponse>>> getAddressByStudentRoll(String studentId);
}
