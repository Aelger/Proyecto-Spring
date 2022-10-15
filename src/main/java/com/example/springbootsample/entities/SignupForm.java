package com.example.springbootsample.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class SignupForm {
    private String userId;
    private String password;
    private String userName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    private Integer age;
    private Integer gender;
}
