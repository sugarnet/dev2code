package com.dss.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dss.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get current session factory
		Session session = this.sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = 
				session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query
		List<Customer> customers = query.getResultList();
		
		// return customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = this.sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(Customer customer) {

		Session session = this.sessionFactory.getCurrentSession();
		session.delete(customer);
		
	}

}
