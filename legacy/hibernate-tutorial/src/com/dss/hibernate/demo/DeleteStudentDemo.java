package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// deleting record method delete
			// session.delete(myStudent);
			
			studentId = 2;
			// delete record with query
			System.out.println("Deleting student with id: " + studentId);
			session.createQuery("delete Student where id=" + studentId).executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!");
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

}
