package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Course;
import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;
import com.dss.hibernate.demo.entity.Review;
import com.dss.hibernate.demo.entity.Student;

public class AddCoursesForDiegoDemo {

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

			// retrieve student from database
			Student student = session.get(Student.class, 1);
			System.out.println("Student => " + student);
			System.out.println("Courses => " + student.getCourses());
			
			// create more courses
			Course course1 = new Course("Manualidades...");
			Course course2 = new Course("Super choco torta...");
			
			// add the student to courses
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} finally {
			session.close();
			sessionFactory.close();
		}
				
	}

}
