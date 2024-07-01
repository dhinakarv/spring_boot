package com.spring.cruddemo.cruddemo.dao;

import com.spring.cruddemo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> student = entityManager.createQuery("from Student order by id desc", Student.class);
        return student.getResultList();
    }
    @Override
    @Transactional
    public int deleteAll(){
        int entriesDeleted =  entityManager.createQuery("DELETE from Student").executeUpdate();
        return entriesDeleted;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> student = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        student.setParameter("theData", lastName);
        return student.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
