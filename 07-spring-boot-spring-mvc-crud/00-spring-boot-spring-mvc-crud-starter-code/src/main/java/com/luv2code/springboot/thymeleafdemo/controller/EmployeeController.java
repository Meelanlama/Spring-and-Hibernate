package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        // Get employees from db
        List<Employee> employees = employeeService.findAll();

        // add to spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {

        //create a model attribute to bind form data
        model.addAttribute("employee", new Employee());

        return "employees/add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employeeObj) {
        //save employee
        employeeService.save(employeeObj);

        // use a redirect to prevent duplicate submission
        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int theId, Model model) {

        //get the employee from service and id from embedded url
        Employee theEmployee = employeeService.findById(theId);

        //set the employee in model to prepopulate the form
        model.addAttribute("employee", theEmployee);

        //send over to our form
        return "employees/add-employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        //delete employee
        employeeService.deleteById(theId);

        //redirect to employee list
        return "redirect:/employees/list";
    }
}
