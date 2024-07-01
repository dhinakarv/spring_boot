package com.spring.cruddemo.cruddemo.dao;

import com.spring.cruddemo.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    EntityManager entityManager;

    @Autowired
    EmployeeDaoImpl(EntityManager theEntityManager){
        entityManager= theEntityManager;
    }
    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;

    }

    @Override
    public List<Employee> findAll() {
        TypedQuery query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee findByLastName(String lastName) {
        return entityManager.find(Employee.class, lastName);
    }

    @Override
    public void delete(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        System.out.println("Found Employee to be deleted:"+employee);
        entityManager.remove(employee);
        System.out.println("Removed Employee from Database");
    }

    @Override
    public int deleteAll() {
       // entityManager.

        return 0;
    }
}
