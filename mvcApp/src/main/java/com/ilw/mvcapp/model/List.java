/**
 * 
 */
package com.ilw.mvcapp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Scott
 *
 */

@Entity
@Table(name = "List")
public class List {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "List [listID=" + listID + ", title=" + title + ", listItems=" + listItems.toString() + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "listID")
	private long listID;
	
	@Column(name = "title")
	private String title;
	
	@OneToMany(
			mappedBy = "list",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL, 
	        orphanRemoval = true)
//	@Transient
	private Collection<ListItem> listItems = new ArrayList<ListItem>();

	/**
	 * @return the itemID
	 */
	public long getListID() {
		return listID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setListID(long listID) {
		this.listID = listID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the listItems
	 */
	public Collection<ListItem> getListItems() {
		return listItems;
	}

	/**
	 * @param listItems the listItems to set
	 */
	public void setListItems(ArrayList<ListItem> listItems) {
		this.listItems = listItems;
	}
	
    public void addListItem(ListItem item) {
    	this.listItems.add(item);
    	item.setList(this);
    }
 
    public void removeListItem(ListItem item) {
        this.listItems.remove(item);
        item.setList(null);
    }
}
