/**
 * 
 */
package com.ilw.mvcapp.dao;

import java.util.List;

import com.ilw.mvcapp.model.Customer;

/**
 * @author Scott
 *
 */
public interface CustomerDAO {
	public void addCustomer(Customer c);
	
	public List<Customer> listCustomers();
}
