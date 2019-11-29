package com.dss.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			String theDateOfBirthStr = "16/05/1987";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			// create student object
			System.out.println("Creating a new student object...");
			Student student = new Student("Sol", "Mauna", theDateOfBirth, "smauna@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} catch(ParseException exception) {
			exception.printStackTrace();
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

}
