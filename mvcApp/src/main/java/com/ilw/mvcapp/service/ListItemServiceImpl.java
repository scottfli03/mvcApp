/**
 * 
 */
package com.ilw.mvcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilw.mvcapp.dao.CustomerDAO;
import com.ilw.mvcapp.dao.ListItemDAO;
import com.ilw.mvcapp.model.ListItem;

/**
 * @author Scott
 *
 */
@Service("listItemService")
public class ListItemServiceImpl implements ListItemService {
	
	@Autowired
	private ListItemDAO itemDAO;
	
	@Override
	public ListItem addListItem(ListItem item) {
		// TODO Auto-generated method stub
		return this.itemDAO.addListItem(item);
	}

	@Override
	public List<ListItem> getAllListItems() {
		// TODO Auto-generated method stub
		return this.itemDAO.getListItems();
	}

	@Override
	public ListItem getListItem(long itemID) {
		return this.itemDAO.getListItem(itemID);
	}

	@Override
	public ListItem updateListItem(ListItem item) {
		return this.itemDAO.updateListItem(item);
	}

	@Override
	public ListItem deleteListItem(long itemID) {
		return this.itemDAO.deleteListItem(itemID);
	}

}
