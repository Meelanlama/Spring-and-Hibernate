package com.milan.ThymeleafDemo.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "formdata";
    }

    @RequestMapping("/processFormTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String name = request.getParameter("StudentName");
        String upperCaseName = name.toUpperCase();
        String message = upperCaseName + " Hello bro.. V3";

        model.addAttribute("message", message);
        return "formdata";
    }

    @PostMapping("/processFormThree")
    public String processFormThree(@RequestParam("StudentName") String name, Model model){
        String upperCaseName = name.toUpperCase();
        String message = "Hello mate.. " + upperCaseName;

        model.addAttribute("message", message);
        return "formdata";
    }
}
