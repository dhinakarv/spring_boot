package com.spring.cruddemo.cruddemo.service;

import com.spring.cruddemo.cruddemo.dao.EmployeeDao;
import com.spring.cruddemo.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    @Autowired
    EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        System.out.println("through Service Call:findAll");
        return employeeDao.findAll();
    }

    @Override
    public Employee find(int id) {
        System.out.println("through Service Call:find:"+id);

        return employeeDao.find(id);
    }

    @Override
    public Employee findByLastName(String lastName) {
        System.out.println("through Service Call:findByLastName:"+lastName);
        return employeeDao.findByLastName(lastName);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        System.out.println("through Service Call:save:"+employee);
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        System.out.println("through Service Call:delete:"+id);
        employeeDao.delete(id);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
