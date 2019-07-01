package com.example.demo.controller;

import com.example.demo.dto.response.A;
import com.example.demo.dto.response.B;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test")
    public A test() {
        A<B> a = new A<>();
        a.setB(new B());
        return a;
    }



    
}
