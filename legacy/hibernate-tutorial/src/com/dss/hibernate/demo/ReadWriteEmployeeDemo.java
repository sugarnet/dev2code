package com.dss.hibernate.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.hibernate.demo.entity.Employee;

public class ReadWriteEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating a list of Employees...");
			/*List<Employee> employees = Arrays.asList(
					new Employee("Bill", "Gates", "Microsoft"),
					new Employee("Larry", "Page", "Google"),
					new Employee("Mark", "Zuckerberg", "Facebook"),
					new Employee("Serguéi", "Brin", "Google"),
					new Employee("Steve", "Jobs", "Apple"),
					new Employee("Steve", "Wozniak", "Apple"),
					new Employee("Ronald", "Wayne", "Apple"),
					new Employee("Paul", "Allen", "Microsoft")
			);*/
			
			// start a transaction
			session.beginTransaction();
			
			// save the employees list
			// System.out.println("Saving the employees...");
			
			/*for (Employee employee : employees) {
				session.save(employee);
			}*/
			
			Employee employee = session.get(Employee.class, 1);
			System.out.println("The employee with id 1 is: " + employee);
			
			List<Employee> employees = session
					.createQuery("from Employee e where e.company = 'Apple'",
							Employee.class).getResultList();
			
			for (Employee e : employees) {
				System.out.println(e);
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
