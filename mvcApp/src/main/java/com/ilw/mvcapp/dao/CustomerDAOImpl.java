/**
 * 
 */
package com.ilw.mvcapp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ilw.mvcapp.model.Customer;

/**
 * @author Scott
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional(readOnly=false)
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}
	
	@Transactional(readOnly=false)
	public Customer updateCustomer(Customer customer) {
		entityManager.merge(customer);
		return customer;
	}
	
	@Transactional(readOnly=false)
	public Customer deleteCustomer(long customerID) {
		Customer customer = getCustomer(customerID);
		entityManager.remove(customer);
		return customer;
	}
	
	@Transactional(readOnly=true)
	public Customer getCustomer(long customerID) {
		System.out.println("select customer from Customer customer where customer.customerId="+customerID);
		String sql = "select customer from Customer customer where customer.customerId="+customerID;
		try{
			return (Customer) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}
	
	@Transactional(readOnly=true)
	public List<Customer> getCustomers() {
		return entityManager.createQuery("select customer from Customer customer").getResultList();
	}
}
