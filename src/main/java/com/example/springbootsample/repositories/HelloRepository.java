package com.example.springbootsample.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class HelloRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object>findById(String id){
        //Select statment
        String query = "SELECT * FROM employee WHERE id=?";

        //Search execution
        Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);

        return employee;
    }
}
