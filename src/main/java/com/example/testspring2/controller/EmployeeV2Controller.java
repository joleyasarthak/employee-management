package com.example.testspring2.controller;

import com.example.testspring2.model.Employee;
import com.example.testspring2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee emp){
        return employeeService.saveEmployee(emp);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public String updateEmployeeById(@PathVariable String id, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(id, employee);
    }
}
