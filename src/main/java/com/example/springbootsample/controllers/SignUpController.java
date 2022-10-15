package com.example.springbootsample.controllers;

import com.example.springbootsample.entities.SignupForm;
import com.example.springbootsample.services.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignUpController {
    @Autowired
    private UserApplicationService userApplicationService;

    // mostrar pantalla de registro
    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form){
        // obtener genero
        Map<String, Integer> gernderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("gendeMap", gernderMap);

        // transición a usuario signup
        return "user/signup";
    }

    // user signup porceso
    @PostMapping("/signup")
    public String postSignup(@ModelAttribute SignupForm form){
        log.info(form.toString());
        return "redirect:login";
    }
}
