package com.dss.crud;

import com.dss.crud.dao.StudentDAO;
import com.dss.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO) {
		return runner -> {
			createStudent(theStudentDAO);
			createMultipleStudents(theStudentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Create new student object");

		Student student = new Student("Diego", "Scifo", "dscifo@mail.com");

		System.out.println("Calling DAO to save student object");
		studentDAO.save(student);

		System.out.println("Done! Student saved with id = " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Create 3 student objects");

		Student student1 = new Student("Sol", "Mauna", "smauna@mail.com");
		Student student2 = new Student("Valen", "Scifo", "vscifo@mail.com");
		Student student3 = new Student("Alma", "Scifo", "ascifo@mail.com");

		System.out.println("Calling DAO to save student objects");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}
}
