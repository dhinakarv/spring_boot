package com.spring.cruddemo.cruddemo;

import com.spring.cruddemo.cruddemo.dao.StudentDao;
import com.spring.cruddemo.cruddemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	//@Bean
/*	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		//return runner->{createStudent(studentDao);
		//return runner->{createStudent(studentDao);
		//return runner->{queryForStudents(studentDao);
		return runner->createMultipleStudents(studentDao);
			// return runner->{createStudent(studentDao);
		//return runner->{delete(studentDao);
		//return runner->{updateStudent(studentDao);
		//return runner->{deleteAll(studentDao);

	}*/

	private void updateStudent(StudentDao studentDao) {
		Student s1 = studentDao.findById(1);
		System.out.println("Before Updating: FirstName:"+s1);

		s1.setFirstName("Dhinakar");
		studentDao.update(s1);
		System.out.println("Updated FirstName:"+s1);
	}

	private void delete(StudentDao studentDao) {
		studentDao.delete(4);
	}

	private void deleteAll(StudentDao studentDao) {
		int studentsDeleted = studentDao.deleteAll();
		System.out.println("Number of Students removed from db:"+studentsDeleted);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		List<Student> students = studentDao.findByLastName("Viswanathan");
		students.stream().forEach(System.out::println);
	}

	private void queryForStudents(StudentDao studentDao) {
		System.out.println("Retrieve all student Objects");
		List<Student> students = studentDao.findAll();
		students.stream().forEach(System.out::println);

	}

	@Transactional
	private void createMultipleStudents(StudentDao studentDao) {
		System.out.println("Create student Object");
		Student student1 = new Student("Dhina1","Viswanathan1","dhina4u1@gmail.com");
		Student student2 = new Student("Dhina2","Viswanathan2","dhina4u2@gmail.com");

		Student student3 = new Student("Dhina3","Viswanathan3","dhina4u3@gmail.com");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
		System.out.println("Saved student Object:"+student3.getId());
	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("Create student Object");
		Student student1 = new Student("Dhina","Viswanathan","dhina4u@gmail.com");
		studentDao.save(student1);
		System.out.println("Saved student Object:"+student1.getId());
	}

	private void readStudents(StudentDao studentDao){
		System.out.println("Retrieving the existing student");
		Student s1 = studentDao.findById(3);
		System.out.println("Retrieved student:2:"+s1);
	}



}
