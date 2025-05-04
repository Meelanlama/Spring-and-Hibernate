package com.luv2code.springboot.demo.mycoolapp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFunController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String workout() {
        return "I am working out for 10 minutes";
    }

    @GetMapping("/testing")
    public String testing() {
        return "Testing the new project of spring.io zip";
    }

}
