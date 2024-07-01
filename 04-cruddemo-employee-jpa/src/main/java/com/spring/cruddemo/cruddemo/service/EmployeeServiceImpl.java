package com.spring.cruddemo.cruddemo.service;

import com.spring.cruddemo.cruddemo.dao.EmployeeRepository;
import com.spring.cruddemo.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        System.out.println("through Service Call:findAll");
        return employeeRepository.findAll();
    }

    @Override
    public Employee find(int id) {
        System.out.println("through Service Call:find:"+id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee theEmployee  = null;
        if (employeeOptional.isPresent()){
            theEmployee = employeeOptional.get();
        }
        else{
            throw new RuntimeException("Employee Id "+id + " is not found");
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee employee) {
        System.out.println("through Service Call:save:"+employee);
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        System.out.println("through Service Call:delete:"+id);
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
