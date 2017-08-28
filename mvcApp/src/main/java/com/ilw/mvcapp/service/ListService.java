/**
 * 
 */
package com.ilw.mvcapp.service;

import com.ilw.mvcapp.model.List;

/**
 * @author Scott
 *
 */
public interface ListService {
	public List addList(List c);
	public java.util.List<List> getAllLists();
	public List getList(long listID);
	public List updateList(List c);
	public List deleteList(long listID);
	public boolean ableToConnect();
}
