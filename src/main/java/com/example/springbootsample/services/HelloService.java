package com.example.springbootsample.services;

import com.example.springbootsample.entities.Employee;
import com.example.springbootsample.repositories.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    public Employee getEmployee(String id){
        Map<String, Object> map = helloRepository.findById(id);
        String employeeID = (String) map.get("id");
        String name = (String) map.get("name");
        int age = (int) map.get("age");

        Employee employee = new Employee();
        employee.setEmployeeId(employeeID);
        employee.setEmployeeName(name);
        employee.setEmployeeAge(age);
        return employee;
    }
}
