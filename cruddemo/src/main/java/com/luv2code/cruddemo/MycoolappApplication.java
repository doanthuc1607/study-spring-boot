package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.interfaces.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	// command line app
	// executed after the spring beans have been loaded
	// we have lambda expression and add our custom code
	@Bean
	//inject SudentDAO
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudents(studentDAO);
		};
	}

	private void createStudents(StudentDAO studentDAO){
		List<Student> listStudent = new ArrayList<>();
		listStudent.add(new Student("Pault", "Doe", "pault@luv2code.com"));
		listStudent.add(new Student("Marry", "Public", "marry@luv2code.com"));
		listStudent.add(new Student("Bonita", "AppleBum", "bonita@luv2code.com"));
		//create student object
		System.out.println("Creating new student object...");
		listStudent.forEach(student -> {
			studentDAO.save(student);
			System.out.println("saved this student: " + student.getFirstName());
		});

	}
}
