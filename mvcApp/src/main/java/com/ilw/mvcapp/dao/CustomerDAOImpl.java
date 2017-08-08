/**
 * 
 */
package com.ilw.mvcapp.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ilw.mvcapp.model.Customer;

/**
 * @author Scott
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addCustomer(Customer c) {
		em.persist(c);
	}

}
