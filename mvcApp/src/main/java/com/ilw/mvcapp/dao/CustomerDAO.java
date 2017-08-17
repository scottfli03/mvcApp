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
	 public Customer addCustomer(Customer customer);
	 public Customer updateCustomer(Customer customer);
	 public Customer deleteCustomer(long customerID);
	 public Customer getCustomer(long customerID);
	 public List<Customer> getCustomers();
}
