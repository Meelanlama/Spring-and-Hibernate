package com.milan.ValidationDemo.controllers;

import com.milan.ValidationDemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, "lastName",stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showPage(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-page";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult result) {

        System.out.println("Last Name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding results: " + result.toString());

        System.out.println("\n");

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "customer-page";
        }else {
            return "customer-result";
        }
    }

}
