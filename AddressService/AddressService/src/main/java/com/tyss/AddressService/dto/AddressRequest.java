package com.tyss.AddressService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private String studentRoll;
    private String city;
    private String state;
    private String country;
    private int pincode;
}
