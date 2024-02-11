package com.example.testspring2.service;

import com.example.testspring2.entity.EmployeeEntity;
import com.example.testspring2.error.EmployeeNotFoundException;
import com.example.testspring2.model.Employee;
import com.example.testspring2.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getEmpId() == null){
            employee.setEmpId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> entityList = employeeRepository.findAll();
        List<Employee> empList = entityList.stream().map(employeeEntity -> {
            Employee emp = new Employee();
            BeanUtils.copyProperties(employeeEntity,emp);
            return emp;
        }).collect(Collectors.toList());
        return empList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity emp = employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee Not Found with id: " + id));
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee Not Found with id: " + id));
        employeeRepository.delete(employee);
        return "Employee deleted successfully with id: " + id;
    }

    @Override
    public String updateEmployeeById(String id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee Not Found with id: " + id));
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee updated successfully with id: " + id;
    }
}
