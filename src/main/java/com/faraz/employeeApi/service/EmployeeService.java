package com.faraz.employeeApi.service;

import com.faraz.employeeApi.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
      Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);


}
