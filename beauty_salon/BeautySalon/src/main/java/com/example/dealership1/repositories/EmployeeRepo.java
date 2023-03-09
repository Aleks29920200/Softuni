package com.example.dealership1.repositories;

import com.example.dealership1.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
Employee findEmployeeByIdentificationNumber(String number);
    Employee findEmployeeById(Long id);
    void deleteById(Long id);
}
