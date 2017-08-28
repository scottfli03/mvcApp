/**
 * 
 */
package com.ilw.mvcapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Scott
 *
 */

@Entity
@Table(name = "ListItem")
public class ListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemID")
	private long itemID;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listID", nullable=false)
    @JsonIgnore
	private List list;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "completed")
	private Boolean completed;
	
	/**
	 * @param listID
	 * @param title
	 * @param description
	 * @param completed
	 */
	public ListItem(List list, String title, String description, Boolean completed) {
		this.list = list;
//	public ListItem(String title, String description, Boolean completed) {
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	
	public ListItem() { }

	/**
	 * @return the itemID
	 */
	public long getItemID() {
		return this.itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the listID
	 */
	public List getList() {
		return this.list;
	}

	/**
	 * @param listID the listID to set
	 */
	public void setList(List list) {
		this.list = list;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the completed
	 */
	public Boolean getCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
