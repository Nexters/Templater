package com.templater.user.model.response;

public class UserGetResponse {
	
	
	private String loginId;
	private String email;
	private boolean certificated;
	private String createdDate;
	private String modifiedDate;
	
	public UserGetResponse(String loginId, String email, boolean certificated, String createdDate,
			String modifiedDate) {
		super();
		this.loginId = loginId;
		this.email = email;
		this.certificated = certificated;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
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
	public boolean isCertificated() {
		return certificated;
	}
	public void setCertificated(boolean certificated) {
		this.certificated = certificated;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	

}
