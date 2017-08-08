package com.ilw.mvcapp.service;

import java.util.List;

import com.ilw.mvcapp.model.Customer;

public interface CustomerService {
	public void addCustomer(Customer c);
	public List<Customer> listCustomers();
}
