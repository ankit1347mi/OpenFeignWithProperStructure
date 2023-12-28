package com.tyss.StudentService.config;

import com.tyss.StudentService.dto.Address;
import com.tyss.StudentService.structure.ResponseStructure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8088/address", value = "Address-Service")
public interface AddressService {

    @GetMapping("/student/{studentId}")
    ResponseEntity<ResponseStructure<List<Address>>> getAddressByStudentRoll(@PathVariable String studentId);
}
