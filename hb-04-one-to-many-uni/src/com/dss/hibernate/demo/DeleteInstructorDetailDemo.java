package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get Instructor detail
			InstructorDetail instructorDetail = 
					session.get(InstructorDetail.class, 3);
			
			// print instructor detail
			System.out.println("Instructor detail => " + instructorDetail);
			
			// print instructor
			System.out.println("Instructor associated => " 
					+ instructorDetail.getInstructor());
			
			// remove associations
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			// deleting the instructor detail and the instructor
			System.out.println("Deleting...");
			session.delete(instructorDetail);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} catch (Exception exception) {
			exception.printStackTrace();
			
		} finally {
			session.close();
			sessionFactory.close();
		}
				
	}

}
