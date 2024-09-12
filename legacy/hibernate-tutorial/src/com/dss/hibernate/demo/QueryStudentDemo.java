package com.dss.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query all students
			System.out.println("\n\nDisplay all students");
			List<Student> students = session.createQuery("from Student", Student.class).getResultList();
			displayStudents(students);
			
			// query who students last name is Scifo
			System.out.println("\n\nDisplay students with lastName='Scifo'");
			students = session.createQuery("from Student s where s.lastName='Scifo'", Student.class).getResultList();
			displayStudents(students);
			
			// query students who last name is scifo or firstName is 'Diego'
			System.out.println("\n\nDisplay students with lastName Scifo or firstName Diego");
			students = session.createQuery("from Student s where s.lastName='Scifo' or s.firstName = 'Pedro'", Student.class).getResultList();
			displayStudents(students);
			
			// query students who email address ends with gmail.com
			System.out.println("\n\nDisplay students with email address ends with 'gmail.com'");
			students = session.createQuery("from Student s where s.email like '%gmail.com'", Student.class).getResultList();
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			sessionFactory.close();
			session.close();
		}
				
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
