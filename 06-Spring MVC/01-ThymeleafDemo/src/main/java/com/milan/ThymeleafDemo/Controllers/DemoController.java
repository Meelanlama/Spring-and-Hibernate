package com.milan.ThymeleafDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //Create a mapping for "/hello"
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("date", java.time.LocalDate.now());
        return "helloworld";
    }
}
