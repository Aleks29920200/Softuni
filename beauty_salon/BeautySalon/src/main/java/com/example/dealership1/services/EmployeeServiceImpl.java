package com.example.dealership1.services;

import com.example.dealership1.domain.binding.AddEmployeeDto;
import com.example.dealership1.domain.entity.Employee;
import com.example.dealership1.repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void addEmployee(AddEmployeeDto addEmployeeDto) {
        Employee employee=new Employee();
        employee.setAddress(addEmployeeDto.getAddress());
        employee.setAge(addEmployeeDto.getAge());
        employee.setFullName(addEmployeeDto.getFullName());
        employee.setStartOfWorkingDay(addEmployeeDto.getStartOfWorkingDay());
        employee.setEndOfWorkingDay(addEmployeeDto.getEndOfWorkingDay());
        employee.setIdentificationNumber(addEmployeeDto.getIdentificationNumber());
        employee.setSalary(addEmployeeDto.getSalary());
    employeeRepo.saveAndFlush(employee);
    }

    @Override
    public List<Employee> allEmployees() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return this.employeeRepo.findEmployeeById(id);
    }

    @Override
    public void deleteById(Long id) {
         this.employeeRepo.deleteById(id);
    }
}
