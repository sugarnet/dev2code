package com.dss.hibernate.demo;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			// retrieve instructor
			Instructor instructor = session.get(Instructor.class, 1);
			
			if (Objects.nonNull(instructor)) {
				System.out.println("Deleting instructor: " + instructor);
				session.delete(instructor);
				
			}
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

}
