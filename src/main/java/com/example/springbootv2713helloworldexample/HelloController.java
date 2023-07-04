package com.example.springbootv2713helloworldexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String helloWorld(){
        return "Hello World!";
    }
}
