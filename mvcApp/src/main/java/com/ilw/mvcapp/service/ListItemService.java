/**
 * 
 */
package com.ilw.mvcapp.service;

import java.util.List;
import com.ilw.mvcapp.model.ListItem;

/**
 * @author Scott
 *
 */
public interface ListItemService {
	public ListItem addListItem(ListItem item);
	public List<ListItem> getAllListItems();
	public ListItem getListItem(long itemID);
	public ListItem updateListItem(ListItem item);
	public ListItem deleteListItem(long itemID);
}
