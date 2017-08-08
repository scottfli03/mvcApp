/**
 * 
 */
package com.ilw.mvcapp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

	@Override
	public List<Customer> listCustomers() {
	      CriteriaQuery<Customer> criteriaQuery = em.getCriteriaBuilder().createQuery(Customer.class);
	      @SuppressWarnings("unused")
	      Root<Customer> root = criteriaQuery.from(Customer.class);
	      return em.createQuery(criteriaQuery).getResultList();
	}

}
