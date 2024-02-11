package com.example.testspring2.service;

import com.example.testspring2.error.EmployeeNotFoundException;
import com.example.testspring2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> empList = new ArrayList<>();
    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getEmpId() == null){
            employee.setEmpId(UUID.randomUUID().toString());
        }
        empList.add(employee);
        return employee;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return empList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return empList.
                stream()
                .filter(employee -> employee.getEmpId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with id: " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee emp = empList.
                        stream().
                        filter(employee -> employee.getEmpId().equals(id)).
                        findFirst()
                        .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with id: " + id));
        empList.remove(emp);
        return "Employee Deleted with id: " + id;
    }

    @Override
    public String updateEmployeeById(String id, Employee employee) {
        return null;
    }

}
