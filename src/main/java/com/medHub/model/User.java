package com.medHub.model;

import java.util.Date;

public class User {
	private int userId;
	private String Username;
	private String address;
	private String userMail;
	private long userMobile;
	private int points;
	private String userPassword;
	private double wallet;
	private String accountStatus;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		 this.points = points;
	}
	public long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return Username;
	}
	public void setName(String name) {
		this.Username = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User( String username, String address ,String userPassword,double wallet,String userMail,int points,long userMobile) {
		super();
		
		this.Username = username;
		this.address = address;
		this.userMail = userMail;
		this.userMobile = userMobile;
		this.points = points;
		this.userPassword = userPassword;
		this.wallet = wallet;
	}
	public User(String username,long userMobile, String userMail, String userPassword) {
		super();
		Username = username;
		this.userMail = userMail;
		this.userMobile = userMobile;
		this.userPassword = userPassword;
	}
	
	public User( int userId,String fullname, String address, String password, double wallet, String email,
			long mobile,String accountStatus,int points) {
		// TODO Auto-generated constructor stub
		super();
		this.userId=userId;
		this.Username=fullname;
		this.address=address;
		this.userPassword=password;
		this.wallet=wallet;
		this.userMail=email;
		this.points=points;
		this.userMobile=mobile;
		this.accountStatus=accountStatus;
		
	}
	
	
	public User(String email, String password) {
		this.userMail=email;
		this.userPassword=password;
	}
	public User(String name, String password, Long mobileNo, String address) {
		// TODO Auto-generated constructor stub
		this.Username= name;
		this.userPassword=password;
		this.userMobile=mobileNo;
		this.address=address;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "userId " + userId + "    name " + Username + "    address " + address
				+ "    userMail " + userMail + "    userPassword " + userPassword + "    wallet " + wallet ;
	}
	
	

}
