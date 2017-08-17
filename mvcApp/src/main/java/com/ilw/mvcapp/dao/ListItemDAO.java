/**
 * 
 */
package com.ilw.mvcapp.dao;

import com.ilw.mvcapp.model.ListItem;

/**
 * @author Scott
 *
 */
public interface ListItemDAO {

	public ListItem addListItem(ListItem listItem);
	public ListItem updateListItem(ListItem listItem);
	public ListItem deleteListItem(long listItemID);
	public ListItem getListItem(long listItemID);
	public java.util.List<ListItem> getListItems();
}