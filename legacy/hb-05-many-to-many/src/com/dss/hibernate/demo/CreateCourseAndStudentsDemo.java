package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Course;
import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;
import com.dss.hibernate.demo.entity.Review;
import com.dss.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// create a course
			Course course = new Course("Como decorar floreros...");
			
			// save course
			session.save(course);
			
			// create students
			Student student1 = new Student("Diego", "Scifo", "diegoscifo@gmail.com");
			Student student2 = new Student("Alma", "Scifo", "almascifo@gmail.com");
			Student student3 = new Student("Soledad", "Mauna", "soledadmauna@gmail.com");
			
			// add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			course.addStudent(student3);
			
			// save students
			System.out.println("\nSaving the students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println("\nSaved students" + course.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} finally {
			session.close();
			sessionFactory.close();
		}
				
	}

}
