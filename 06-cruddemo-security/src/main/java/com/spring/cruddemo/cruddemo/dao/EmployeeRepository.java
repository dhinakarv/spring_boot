package com.spring.cruddemo.cruddemo.dao;

import com.spring.cruddemo.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path="resources")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//No explicit code required
    //All CRUD methods of JPARepository could be inherited
}
