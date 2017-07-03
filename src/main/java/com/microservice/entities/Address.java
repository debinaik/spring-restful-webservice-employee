package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Address Embedded Entity
 *
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name = "ADDRESS_STREET",length=250)
	private String street;
	
	@Column(name = "ADDRESS_CITY", length=100)
	private String city;
	
	@Column(name = "ADDRESS_STATE", length=100)
	private String state;
	
	@Column(name = "ADDRESS_ZIPCODE", length=100)
	private int zipcode;

	public Address() {
		super();
	}

	public Address(String street, String city, String state, int zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
