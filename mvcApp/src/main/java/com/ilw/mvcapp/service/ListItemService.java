/**
 * 
 */
package com.ilw.mvcapp.service;

import com.ilw.mvcapp.model.List;
import com.ilw.mvcapp.model.ListItem;

/**
 * @author Scott
 *
 */
public interface ListItemService {
	public ListItem addListItem(List list, ListItem item);
	public java.util.List<ListItem> getListItems(List list);
	public ListItem getListItem(long itemID);
	public ListItem updateListItem(ListItem item);
	public ListItem deleteListItem(long itemID);
}
