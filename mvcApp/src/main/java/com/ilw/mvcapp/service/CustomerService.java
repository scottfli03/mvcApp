package com.ilw.mvcapp.service;

import java.util.List;

import com.ilw.mvcapp.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomer(long customerID);
	public Customer updateCustomer(Customer c);
	public Customer deleteCustomer(long customerID);
}
