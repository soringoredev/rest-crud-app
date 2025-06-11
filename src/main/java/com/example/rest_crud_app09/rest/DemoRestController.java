package com.example.rest_crud_app09.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class DemoRestController {

    // adaugam codul pentru endpointu-ul
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
