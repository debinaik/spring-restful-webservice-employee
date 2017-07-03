package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : UserDetails Entity
 *
 */
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USERSDETAILS")
public class UserDetails {
		
	@Column(name = "userId" ,unique = true, nullable = false)
	@Id @GeneratedValue(generator = "userIdGenerator")
	@GenericGenerator(name = "userIdGenerator", strategy = "com.microservice.entities.UserIdGenerator")
	private String userId;
	
	@Column(name="USER_NAME", unique = true, nullable = false,length=50)
	private String username;
	
	@Column(name="PASSWORD",nullable = false,length=50)
	private String password;
	
	@Column(name="firstName",length=200)
	private String firstName;
	
	@Column(name="lastName",length=200)
	private String lastName;
	
	@Column(name = "mobileNumber", unique = true,length=15)
	private long mobileNumber;
	
	@Column(name = "emailId", unique = true,length=50)
	private String emailId;
	
	@Column(name = "imageName",length=50)
	private String imageName;
	
	@Column(name = "imageData")
	private byte[] imageData;
	
	@Embedded
	private Address address;

	public UserDetails() {
		super();
	}

	public UserDetails(String userId, String username, String password, String firstName, String lastName, long mobileNumber,
			String emailId, String imageName, byte[] imageData, Address address) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.imageName = imageName;
		this.imageData = imageData;
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
