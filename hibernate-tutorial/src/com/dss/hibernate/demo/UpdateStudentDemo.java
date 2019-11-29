package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// id student
			int studentId = 1;
			
			// show student id
			System.out.println("id student: " + studentId);
			
			// start a transaction
			session.beginTransaction();
			
			// now get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			
			// retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get complete: " + myStudent);
			
			// update field
			System.out.println("Updating student with id: " + studentId);
			myStudent.setFirstName("Wally");
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Student updated: " + myStudent);
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n\nUpdating all email of students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

}
