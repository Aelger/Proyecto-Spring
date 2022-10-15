package com.example.springbootsample.controllers;

import com.example.springbootsample.entities.Employee;
import com.example.springbootsample.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // inyeccion de dependencia
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String getHello() {
        // renderiza hello.html
        return "hello";
    }

    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str, Model model) {
        // registra el string recibido desde el input al modelo de th
        model.addAttribute("sample", str);
        // renderiza la vista con el screen
        return "Hello/response";
    }

    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2") String id, Model model){
        // usamos el service para buscar por id
        Employee employee = helloService.getEmployee(id);
        // seteamos el model con el atributo employee que es un objeto
        model.addAttribute("employee", employee);
        return "Hello/db";
    }
}
