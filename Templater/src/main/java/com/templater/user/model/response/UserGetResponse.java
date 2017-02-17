package com.templater.user.model.response;

public class UserGetResponse {
	
	
	private String loginId;
	private String email;
	private int certificated;
	private String createdDate;
	private String editedDate;
	
	public UserGetResponse(String loginId, String email, int certificated, String createdDate,
			String editedDate) {
		this.loginId = loginId;
		this.email = email;
		this.certificated = certificated;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
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
	public int isCertificated() {
		return certificated;
	}
	public void setCertificated(int certificated) {
		this.certificated = certificated;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getEditedDate() {
		return editedDate;
	}
	public void setEditedDate(String editedDate) {
		this.editedDate = editedDate;
	}
	
	

}
