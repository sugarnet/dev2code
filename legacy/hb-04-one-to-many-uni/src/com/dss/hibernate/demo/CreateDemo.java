package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			
			// create the objects
			/*Instructor instructor = 
					new Instructor("Diego", "Scifo", "diegoscifo@yahoo.com.ar");
			InstructorDetail instructorDetail = 
					new InstructorDetail("Sin canal...", "programar!");*/
			
			// create the objects
			Instructor instructor = 
					new Instructor("Alma", "Scifo", "alma@yahoo.com.ar");
			InstructorDetail instructorDetail = 
					new InstructorDetail("Sin canal...", "jugar!");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

}
