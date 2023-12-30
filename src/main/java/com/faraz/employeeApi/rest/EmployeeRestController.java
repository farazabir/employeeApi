package com.faraz.employeeApi.rest;

import com.faraz.employeeApi.entity.Employee;
import com.faraz.employeeApi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class EmployeeRestController {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee getbyid(@PathVariable int id){
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
  @DeleteMapping("/employees/{id}")
    public void save(@PathVariable int id){
        employeeService.deleteById(id);
    }





}
