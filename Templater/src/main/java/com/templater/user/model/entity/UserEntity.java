package com.templater.user.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="user", catalog="templater")
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="login_id")
	private String loginId;
	
	@Column(name="pw")
	private String pw;
	
	@Column(name="email")
	private String email;
	
	@Column(name="certificated")
	private int certificated;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="edited_date")
	private String editedDate;
	
	@Column(name="withdraw")
	private int withDraw;
	
	@Column(name="auth")
	private String auth;
	
	public UserEntity(){
		
	}
	
	

	public UserEntity(String loginId, String pw, String email,String auth) {
		this.loginId = loginId;
		this.pw = pw;
		this.email = email;
		this.auth=auth;
	}


	public UserEntity(String loginId, String pw, String email, String createdDate, String auth) {
		this.loginId = loginId;
		this.pw = pw;
		this.email = email;
		this.createdDate = createdDate;
		this.auth = auth;
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

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
