package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Course;
import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;
import com.dss.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// create a course
			Course course = new Course("Como decorar floreros...");
			
			// add reviews a course
			course.addReview(new Review("Que curso tan lindo..."));
			course.addReview(new Review("Gracias, le decoré el florero a mi esposo..."));
			course.addReview(new Review("Que curso tan feo..."));
			
			// save course
			session.save(course);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		
		} finally {
			session.close();
			sessionFactory.close();
		}
				
	}

}
