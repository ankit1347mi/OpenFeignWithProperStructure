package com.tyss.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private long phone;
    private List<Address> addresses;
}
