package com.example.springbootsample.controllers;

import com.example.springbootsample.entities.SignupForm;
import com.example.springbootsample.services.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("gendeMap", genderMap);
        // transición a usuario signup
        return "user/signup";
    }

    // user signup porceso
    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute SignupForm form, BindingResult bindingResult){
        //chequeo fallos en bindings
        if(bindingResult.hasErrors()){
            //NG: retorna a la pantalla de registro
            return getSignup(model, locale, form);
        }
        log.info(form.toString());
        return "redirect:/login";
    }
}
