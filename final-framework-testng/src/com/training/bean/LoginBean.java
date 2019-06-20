package com.training.bean;

public class LoginBean {
	private String userName;
	private String password;
	private String stuserName;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String stpassword;

	public LoginBean() {
	}

	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//------------------------------
	public String getFirstName() {
		return this.firstName;			     
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;			     
		
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;			     
		
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegUserName() {
		return this.stuserName;			     
	}
	
	public void setRegUserName(String regusername) {
		this.stuserName = regusername;
	}
	
	public String getRegPassword() {
		return this.stpassword;			     
		
	}
	public void setRegPassword(String stpassword) {
		this.stpassword = stpassword;
	}

	public String getPhone() {
		return this.phone;			     
		
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}

}
