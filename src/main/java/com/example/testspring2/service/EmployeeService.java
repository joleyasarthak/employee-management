package com.example.testspring2.service;

import com.example.testspring2.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);

    String updateEmployeeById(String id, Employee employee);
}
