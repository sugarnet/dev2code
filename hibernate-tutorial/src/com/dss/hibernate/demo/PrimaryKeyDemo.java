package com.dss.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create 3 students objects
			System.out.println("Creating 3 students objects...");
			Student s1 = new Student("Alma", "Scifo", new Date(), "alma@gmail.com");
			Student s2 = new Student("Pedro", "Rodriguez", new Date(), "pedro@gmail.com");
			Student s3 = new Student("Carlos", "Mesa", new Date(), "carlos@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the students
			System.out.println("Saving the students...");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
