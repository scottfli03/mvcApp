package com.ilw.mvcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilw.mvcapp.dao.CustomerDAO;
import com.ilw.mvcapp.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public Customer addCustomer(Customer c) {
		System.out.println("customer: "+c.toString());
		return this.customerDAO.addCustomer(c);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return this.customerDAO.getCustomers();
	}

	@Override
	public Customer updateCustomer(Customer c) {
		return this.customerDAO.updateCustomer(c);
	}

	@Override
	public Customer deleteCustomer(long customerID) {
		return this.customerDAO.deleteCustomer(customerID);
		
	}

	@Override
	public Customer getCustomer(long customerID) {
		return this.customerDAO.getCustomer(customerID);
	}
}
