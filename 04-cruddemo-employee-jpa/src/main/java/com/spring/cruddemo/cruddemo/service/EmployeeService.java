package com.spring.cruddemo.cruddemo.service;

import com.spring.cruddemo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
   List<Employee> findAll();

   Employee find(int id);

   Employee save(Employee employee);

    void delete(int id);

   void deleteAll();


}
