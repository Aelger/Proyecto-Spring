package com.example.springbootsample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    // Mostrar pantalla login
    @GetMapping("/login")
    public String getLogin(){
        return "login/login";
    }
}
