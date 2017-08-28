/**
 * 
 */
package com.ilw.mvcapp.dao;

import com.ilw.mvcapp.model.List;

/**
 * @author Scott
 *
 */
public interface ListDAO {
	 public List addList(List list);
	 public List updateList(List list);
	 public List deleteList(long listID);
	 public List getList(long listID);
	 public java.util.List<List> getLists();
	 public boolean ableToConnected();
}
