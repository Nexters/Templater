package com.templater.document.model.response;

import java.util.List;

public class DocumentResponse {
	
	private long document_id;
	private String document_type;
	private String document_name;
	private String created_date;
	private String modified_date;
	private String shared;
	private long user_id;
	private List<ComponentResponse> components;

	public long getDocument_id() {
		return document_id;
	}

	public void setDocument_id(long document_id) {
		this.document_id = document_id;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getShared() {
		return shared;
	}

	public void setShared(String shared) {
		this.shared = shared;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public List<ComponentResponse> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentResponse> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "DocumentResponse [document_id=" + document_id + ", document_type=" + document_type + ", document_name="
				+ document_name + ", created_date=" + created_date + ", modified_date=" + modified_date + ", shared="
				+ shared + ", user_id=" + user_id + ", components=" + components + "]";
	}

}
