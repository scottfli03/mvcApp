/**
 * 
 */
package com.ilw.mvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilw.mvcapp.dao.ListDAO;
import com.ilw.mvcapp.model.List;

/**
 * @author Scott
 *
 */
@Service("listService")
public class ListServiceImpl implements ListService{

	@Autowired
	private ListDAO listDAO;
	
	@Override
	public List addList(List list) {
		return listDAO.addList(list);
	}

	@Override
	public java.util.List<List> getAllLists() {
		return listDAO.getLists();
	}

	@Override
	public List getList(long listID) {
		return listDAO.getList(listID);
	}

	@Override
	public List updateList(List list) {
		return listDAO.updateList(list);
	}

	@Override
	public List deleteList(long listID) {
		return listDAO.deleteList(listID);
	}
	
	@Override
	public boolean ableToConnect() {
		return listDAO.ableToConnected();
	}
	
}
