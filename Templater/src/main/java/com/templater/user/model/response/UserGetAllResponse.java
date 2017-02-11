package com.templater.user.model.response;

public class UserGetAllResponse {

	private long userId;
	private String loginId;
	private String pw;
	private String email;
	private int certificated;
	private String createdDate;
	private String editedDate;
	private int withDraw;
	
	public UserGetAllResponse(){
		
	}
	
	public UserGetAllResponse(long userId, String loginId, String pw, String email, int certificated, String createdDate,
			String editedDate, int withDraw) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.pw = pw;
		this.email = email;
		this.certificated = certificated;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
		this.withDraw = withDraw;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCertificated() {
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
	public int getWithDraw() {
		return withDraw;
	}
	public void setWithDraw(int withDraw) {
		this.withDraw = withDraw;
	}
	
}
