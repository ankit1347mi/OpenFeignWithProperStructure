package com.tyss.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {


    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private long phone;
}
