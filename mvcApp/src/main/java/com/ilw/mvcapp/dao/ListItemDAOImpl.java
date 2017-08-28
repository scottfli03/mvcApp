/**
 * 
 */
package com.ilw.mvcapp.dao;

import com.ilw.mvcapp.model.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public ListItem addListItem(List list, ListItem listItem) {
		listItem.setList(list);
		this.entityManager.persist(listItem);
		return listItem;
	}

	@Transactional(readOnly=false)
	public ListItem updateListItem(ListItem listItem) {
		entityManager.merge(listItem);
		return listItem;
	}

	@Transactional(readOnly=false)
	public ListItem deleteListItem(long itemID) {
		ListItem listItem = getListItem(itemID);
		entityManager.remove(listItem);
		return listItem;
	}

	@Transactional(readOnly=true)
	public ListItem getListItem(long itemID) {
		System.out.println("select listItem from ListItem listItem where listItem.itemID="+itemID);
		String sql = "select listItem from ListItem listItem where listItem.itemID="+itemID;
		try{
			return (ListItem) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@Transactional(readOnly=true)
	public java.util.List<ListItem> getListItems(List list) {
		Query sql = this.entityManager.createQuery("select listItem from ListItem listItem where listItem.list = :list");
		sql.setParameter("list", list);
		return sql.getResultList();
	}
}
