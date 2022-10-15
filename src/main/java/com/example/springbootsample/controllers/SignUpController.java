package com.example.springbootsample.controllers;

import com.example.springbootsample.services.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class SignUpController {
    @Autowired
    private UserApplicationService userApplicationService;

    // mostrar pantalla de registro
    @GetMapping("/signup")
    public String getSignup(Model model){
        // obtener genero
        Map<String, Integer> gernderMap = userApplicationService.getGenderMap();
        model.addAttribute("gendeMap", gernderMap);

        // transición a usuario signup
        return "user/signup";
    }

    // user signup porceso
    @PostMapping("/signup")
    public String postSignup(){
        return "redirect:login";
    }
}
