/**
 * 
 */
package com.ilw.mvcapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Scott Flischel
 * 
 * Customer Entity for Customer Table of Fencing Schema.
 * 
 */

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerID;
	
	@Column(name = "fName")
	private String fName;
	
	@Column(name = "lName")
	private String lName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "addr1")
	private String addr1;
	
	@Column(name = "addr2")
	private String addr2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;
	
	public Customer() {	}
	

	
	/**
	 * @param fName
	 * @param lName
	 * @param email
	 * @param phone
	 * @param addr1
	 * @param addr2
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Customer(String fName, String lName, String email, String phone, String addr1, String addr2, String city,
			String state, String zip) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}



	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", phone=" + phone + ", addr1=" + addr1 + ", addr2=" + addr2 + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}
	
	/**
	 * @return the customerID
	 */
	public long getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the addr1
	 */
	public String getAddr1() {
		return addr1;
	}

	/**
	 * @param addr1 the addr1 to set
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	/**
	 * @return the addr2
	 */
	public String getAddr2() {
		return addr2;
	}

	/**
	 * @param addr2 the addr2 to set
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
}
