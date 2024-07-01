package com.spring.cruddemo.cruddemo.dao;

import com.spring.cruddemo.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//No explicit code required
    //All CRUD methods of JPARepository could be inherited
}
