package com.milan.CrudDemo.Rest;

import com.milan.CrudDemo.DAO.EmployeeDAO;
import com.milan.CrudDemo.Entity.Employee;
import com.milan.CrudDemo.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //Quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null) {
            throw  new RuntimeException("Employee not found or not available...");
        }
        return employee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // also just in case they pass an id in JSON. set id to 0
        // this is to force a save of new item. instead of updating
        employee.setId(0);
        Employee saveEmployee =  employeeService.save(employee);
        return saveEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee saveEmployee = employeeService.save(employee);
        return saveEmployee;
    }

    // add mapping for DELETE /employees - DELETE existing employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        //throw exception if null
        if(employee == null) {
            throw  new RuntimeException("Employee not found or not available...");
        }

        //if not null delete
        employeeService.deleteById(employeeId);

        return "Employee deleted of id: " + employeeId;
    }
}
