package com.example.dealership1.services;

import com.example.dealership1.domain.binding.AddEmployeeDto;
import com.example.dealership1.domain.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    void addEmployee(AddEmployeeDto addEmployeeDto);

    List<Employee> allEmployees();
    Employee findEmployeeById(Long id);
    void deleteById(Long id);


}
