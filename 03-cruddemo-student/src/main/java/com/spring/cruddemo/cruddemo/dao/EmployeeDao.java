package com.spring.cruddemo.cruddemo.dao;

import com.spring.cruddemo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee save(Employee employee);
    List<Employee> findAll();

    Employee find(int id);

    Employee findByLastName(String lastName);

    void delete(int id);

    int deleteAll();


}
