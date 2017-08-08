package com.ilw.mvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilw.mvcapp.dao.CustomerDAO;
import com.ilw.mvcapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public void addCustomer(Customer c) {
		this.customerDAO.addCustomer(c);
	}
}
