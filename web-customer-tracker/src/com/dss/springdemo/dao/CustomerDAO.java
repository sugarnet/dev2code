package com.dss.springdemo.dao;

import java.util.List;

import com.dss.springdemo.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(Integer customerId);

	void deleteCustomer(Customer customer);
}
