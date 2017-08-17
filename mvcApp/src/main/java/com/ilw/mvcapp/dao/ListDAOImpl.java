/**
 * 
 */
package com.ilw.mvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ilw.mvcapp.model.List;

/**
 * @author Scott
 *
 */
@Repository
public class ListDAOImpl implements ListDAO {
	final Logger logger = LoggerFactory.getLogger(ListDAOImpl.class);
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional(readOnly=false)
	public List addList(List list) {
		this.entityManager.persist(list);
		return list;
	}

	@Transactional(readOnly=false)
	public List updateList(List list) {
		entityManager.merge(list);
		return list;
	}

	@Transactional(readOnly=false)
	public List deleteList(long listID) {
		List list = getList(listID);
		entityManager.remove(list);
		return list;
	}

	@Transactional(readOnly=true)
	public List getList(long listID) {
		System.out.println("select list from List list where list.listId="+listID);
		String sql = "select list from List list where list.listId="+listID;
		try{
			return (List) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@Transactional(readOnly=true)
	public java.util.List<List> getLists() {
		return entityManager.createQuery("select list from List list").getResultList();
	}
}
