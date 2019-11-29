package com.dss.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating a new student object...");
			Student student = new Student("Sol", "Mauna", new Date(), "smauna@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + student.getId());
			
			// now get a new session and start tranasction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

}
