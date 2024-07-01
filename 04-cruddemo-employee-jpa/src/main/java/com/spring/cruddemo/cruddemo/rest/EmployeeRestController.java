package com.spring.cruddemo.cruddemo.rest;

import com.spring.cruddemo.cruddemo.entity.Employee;
import com.spring.cruddemo.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService eService){
        employeeService = eService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();

    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee =  employeeService.find(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee searched is not available:"+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee savedEmployee =  employeeService.save(employee);
        return savedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee savedEmployee =  employeeService.save(employee);
        return savedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.find(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee Id is not found:"+employeeId);
        }
        employeeService.delete(employeeId);
        return "Employee Id:"+employeeId+" has been deleted";
    }
}
