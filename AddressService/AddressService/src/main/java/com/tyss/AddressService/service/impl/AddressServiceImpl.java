package com.tyss.AddressService.service.impl;

import com.tyss.AddressService.dao.AddressDao;
import com.tyss.AddressService.dto.AddressRequest;
import com.tyss.AddressService.dto.AddressResponse;
import com.tyss.AddressService.entity.Address;
import com.tyss.AddressService.service.AddressService;
import com.tyss.AddressService.structure.ResponseStructure;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private ModelMapper modelMapper;
    private AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(ModelMapper modelMapper, AddressDao addressDao) {
        this.modelMapper = modelMapper;
        this.addressDao = addressDao;
    }


    @Override
    public ResponseEntity<ResponseStructure<AddressResponse>> saveAddress(AddressRequest addressRequest) {
        Address address = modelMapper.map(addressRequest, Address.class);
        Address address1 = addressDao.saveAddress(address);
        AddressResponse addressResponse = modelMapper.map(address1, AddressResponse.class);
        ResponseStructure<AddressResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Success");
        structure.setData(addressResponse);
        return new ResponseEntity<ResponseStructure<AddressResponse>>(structure, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseStructure<Address>> getAddressById(String addressId) {
        Address address = addressDao.getAddressById(addressId);
//        AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
        ResponseStructure<Address> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(address);
        return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<List<AddressResponse>>> getAllAddress() {
        List<Address> addresses = addressDao.getAllAddress();
        List<AddressResponse> addressResponses = addresses.stream().map(address -> modelMapper.map(address, AddressResponse.class)).toList();
        ResponseStructure<List<AddressResponse>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(addressResponses);
        return new ResponseEntity<ResponseStructure<List<AddressResponse>>>(structure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<String>> deleteAddressById(String addressId) {
        boolean address = addressDao.deleteAddressById(addressId);
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData("Address Removed Successfully");
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(AddressRequest addressRequest) {
        Address address = modelMapper.map(addressRequest, Address.class);
        Address address1 = addressDao.updateAddress(address);
        AddressResponse addressResponse = modelMapper.map(address1, AddressResponse.class);
        ResponseStructure<AddressResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(addressResponse);
        return new ResponseEntity<ResponseStructure<AddressResponse>>(structure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<List<AddressResponse>>> getAddressByStudentRoll(String studentId) {

        List<Address> addressess = addressDao.getAddressByStudentRoll(studentId);
        List<AddressResponse> addressResponse = addressess.stream().map(address -> modelMapper.map(address, AddressResponse.class)).collect(Collectors.toList());
        ResponseStructure<List<AddressResponse>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(addressResponse);
        return new ResponseEntity<ResponseStructure<List<AddressResponse>>>(structure, HttpStatus.OK);
    }
}



