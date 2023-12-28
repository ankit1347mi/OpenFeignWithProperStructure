package com.tyss.AddressService.dao.impl;

import com.tyss.AddressService.dao.AddressDao;
import com.tyss.AddressService.entity.Address;
import com.tyss.AddressService.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressDaoImpl implements AddressDao {
    @Autowired
    private AddressRepo addressRepo;


    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address getAddressById(String addressId) {
        Optional<Address> address = addressRepo.findById(addressId);
        if (address.isPresent()) {
            return address.get();
        }
        return null;
    }

    @Override
    public List<Address> getAllAddress() {
        List<Address> addresses = addressRepo.findAll();
        if (!addresses.isEmpty()) {
            return addresses;
        }
        return null;
    }

    @Override
    public boolean deleteAddressById(String addressId) {
        Optional<Address> address = addressRepo.findById(addressId);
        if (address.isPresent()) {
            addressRepo.deleteById(addressId);
            return true;
        }
        return false;
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> optional = addressRepo.findById(address.getAddressId());
        if (optional.isPresent()) {
            return addressRepo.save(address);
        }
        return null;
    }

    public List<Address> getAddressByStudentRoll(String studentId) {
        List<Address> address = addressRepo.getAddressByStudentRoll(studentId);
        if (address != null) {
            return address;
        }
        return null;
    }
}

