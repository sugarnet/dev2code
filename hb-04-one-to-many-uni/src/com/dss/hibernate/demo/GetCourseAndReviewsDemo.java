package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Course;
import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;
import com.dss.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

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

			// get course
			Course course = session.get(Course.class, 10);
			
			// print course
			System.out.println("Course => " + course);
			
			// get reviews and print
			System.out.println("Reviews => " + course.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		
		} finally {
			session.close();
			sessionFactory.close();
		}
				
	}

}
