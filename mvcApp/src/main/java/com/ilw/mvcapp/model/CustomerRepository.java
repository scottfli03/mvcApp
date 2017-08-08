/**
 * 
 */
package com.ilw.mvcapp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Scott
 *
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
