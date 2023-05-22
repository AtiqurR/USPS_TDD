package com.signInData;


public class SignInData {
	
	private String userName;
	private String passWord;
	
	
	public SignInData(String userName,String passWord) {
		this.userName=userName;
		this.passWord=passWord;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}

}
