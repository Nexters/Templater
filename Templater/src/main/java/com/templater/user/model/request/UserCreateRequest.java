package com.templater.user.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class UserCreateRequest {
	
	@NotNull
	private String loginId;
	
	//@Email
	private String email;
	
	@NotNull
	private String pw;

	public UserCreateRequest(){
		
	}

	public UserCreateRequest(String loginId, String pw) {
		super();
		this.loginId = loginId;
		this.pw = pw;
	}

	public UserCreateRequest(String loginId, String email, String pw) {
		super();
		this.loginId = loginId;
		this.email = email;
		this.pw = pw;
	}


	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "UserCreateRequest [loginId=" + loginId + ", email=" + email + ", pw=" + pw + "]";
	}
}
