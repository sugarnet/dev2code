package com.dss.springdemo.service;

import java.util.List;

import com.dss.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(Integer customerId);

	void deleteCustomer(Integer customerId);
}

