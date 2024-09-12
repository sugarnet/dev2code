package com.dss.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dss.springdemo.dao.CustomerDAO;
import com.dss.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return this.customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		this.customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer customerId) {
		return this.customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {

		Customer customer = this.customerDAO.getCustomer(customerId);
		
		this.customerDAO.deleteCustomer(customer);
	}

}
