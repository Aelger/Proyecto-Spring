package com.example.springbootsample.services;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserApplicationService {
    // Generamos un gender map
    public Map<String, Integer> getGenderMap() {
        Map<String, Integer> genderMap = new LinkedHashMap<>();
        genderMap.put("male", 1);
        genderMap.put("female", 2);
        return genderMap;
    }
}
