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

import com.ilw.mvcapp.model.ListItem;

/**
 * @author Scott
 *
 */
@Repository
public class ListItemDAOImpl implements ListItemDAO{
	final Logger logger = LoggerFactory.getLogger(ListItemDAOImpl.class);
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional(readOnly=false)
	public ListItem addListItem(ListItem listItem) {
		this.entityManager.persist(listItem);
		return listItem;
	}

	@Transactional(readOnly=false)
	public ListItem updateListItem(ListItem listItem) {
		entityManager.merge(listItem);
		return listItem;
	}

	@Transactional(readOnly=false)
	public ListItem deleteListItem(long listItemID) {
		ListItem listItem = getListItem(listItemID);
		entityManager.remove(listItem);
		return listItem;
	}

	@Transactional(readOnly=true)
	public ListItem getListItem(long listItemID) {
		System.out.println("select listItem from ListItem listItem where listItem.listItemId="+listItemID);
		String sql = "select listItem from ListItem listItem where listItem.listItemId="+listItemID;
		try{
			return (ListItem) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@Transactional(readOnly=true)
	public List<ListItem> getListItems() {
		return entityManager.createQuery("select listItem from ListItem listItem").getResultList();
	}
}
