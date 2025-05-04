package com.milan.ThymeleafDemo.Controllers;

import com.milan.ThymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programming_languages}")
    private List<String> languages;

    @Value("${Operating_System}")
    private List<String> os;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        //add a list
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("os", os);
        return  "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        return "student-result";
    }
}
