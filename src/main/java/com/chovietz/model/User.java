package com.chovietz.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private String rolename;
	private String email;
	private String address;
	private String birthday;
	private String name;
	private String phoneNumber;
	private String status;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	public User(String id, String username, String password, String rolename) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rolename = rolename;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User(String id, String username, String password, String rolename, String email, String address, String birthday, String name, String phoneNumber, String status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.rolename = rolename;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
	
	public User() {
		super();
	}
}
