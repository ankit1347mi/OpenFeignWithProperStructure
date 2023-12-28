package com.tyss.AddressService.controller;

import com.tyss.AddressService.dto.AddressRequest;
import com.tyss.AddressService.dto.AddressResponse;
import com.tyss.AddressService.entity.Address;
import com.tyss.AddressService.service.AddressService;
import com.tyss.AddressService.structure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<AddressResponse>> saveAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.saveAddress(addressRequest);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<ResponseStructure<Address>> getAddressById(@PathVariable String addressId) {
        return addressService.getAddressById(addressId);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<AddressResponse>>> getAllAddress() {
        return addressService.getAllAddress();
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<ResponseStructure<String>> deleteAddressById(@PathVariable String addressId) {
        return addressService.deleteAddressById(addressId);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(addressRequest);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ResponseStructure<List<AddressResponse>>> getAddressByStudentId(@PathVariable String studentId) {
        return addressService.getAddressByStudentRoll(studentId);
    }

}
