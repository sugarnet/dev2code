package com.dss.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dss.hibernate.demo.entity.Course;
import com.dss.hibernate.demo.entity.Instructor;
import com.dss.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// get the instructor from database
			Integer id = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "join fetch i.courses "
					+ "where i.id=:instructorId", Instructor.class);
			
			query.setParameter("instructorId", id);
			
			Instructor instructor = query.getSingleResult();
			
			// Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("dscifo => Instructor => " + instructor);
			System.out.println("dscifo => Courses => " + instructor.getCourses());
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("dscifo => session closed");
			session.close();
			
			System.out.println("\ndscifo => called after the seesion is closed\n");
			
			System.out.println("dscifo => Courses => " + instructor.getCourses());
			System.out.println("dscifo => Done!!!");
		
		} finally {
			session.close();
			sessionFactory.close();
		}
				
	}

}
