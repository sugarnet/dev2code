package com.dss.crud;

import com.dss.crud.dao.StudentDAO;
import com.dss.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO) {
		return runner -> {
			// createStudent(theStudentDAO);
			// createMultipleStudents(theStudentDAO);
			// readStudent(theStudentDAO);
			// queryForStudents(theStudentDAO);
			// queryForStudentsByLastName(theStudentDAO);
			updateStudent(theStudentDAO);
		};

	}

	private void updateStudent(StudentDAO theStudentDAO) {
		int studentId = 1;
		Student student = theStudentDAO.findById(studentId);
		student.setFirstName("John");
		student.setLastName("Doe");
		theStudentDAO.update(student);

		Student studentUpdated = theStudentDAO.findById(studentId);
		System.out.println(studentUpdated);
	}

	private void queryForStudentsByLastName(StudentDAO theStudentDAO) {
		List<Student> students = theStudentDAO.findByLastName("Scifo");
		students.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO theStudentDAO) {
		List<Student> students = theStudentDAO.findAll();

		students.forEach(System.out::println);
	}

	private void readStudent(StudentDAO theStudentDAO) {
		System.out.println("Create a new student...");
		Student student = new Student("Diego", "Scifo", "dscifo@mail.com");

		System.out.println("Save the student...");
		theStudentDAO.save(student);
		System.out.println("The created id Student: " + student.getId());

		System.out.println("Retrieving the student...");
		Student retrievedStudent = theStudentDAO.findById(student.getId());
		System.out.println("The retrieved Student: " + retrievedStudent);
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
