package com.templater.user.security;

public class AuthenticationRequest {

	
	private String loginId;
	private String pw;
	
	public AuthenticationRequest() {
	}
	public AuthenticationRequest(String loginId, String pw) {
		this.loginId = loginId;
		this.pw = pw;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
