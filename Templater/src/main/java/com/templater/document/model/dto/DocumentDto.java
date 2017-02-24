package com.templater.document.model.dto;

import java.sql.Timestamp;

public class DocumentDto {
	private long document_id;

	private String document_type;

	private String document_name;

	private Timestamp created_date;

	private Timestamp modified_date;

	private String shared;

	private long user_id;

	private int is_deleted;

	public DocumentDto() {

	}

	public DocumentDto(com.templater.document.model.entity.Document doc) {
		this.document_id = doc.getDocument_id();
		this.document_type = doc.getDocument_type();
		this.document_name = doc.getDocument_name();
		this.created_date = doc.getCreated_date();
		this.modified_date = doc.getModified_date();
		this.shared = doc.getShared();
		this.user_id = doc.getUser_id();
		this.is_deleted = doc.getIs_deleted();
	}

	public DocumentDto(long document_id, String document_type, String document_name, Timestamp created_date,
			Timestamp modified_date, String shared, long user_id, int is_deleted) {
		this.document_id = document_id;
		this.document_type = document_type;
		this.document_name = document_name;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.shared = shared;
		this.user_id = user_id;
		this.is_deleted = is_deleted;
	}

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

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
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

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "DocumentDto [document_id=" + document_id + ", document_type=" + document_type + ", document_name="
				+ document_name + ", created_date=" + created_date + ", modified_date=" + modified_date + ", shared="
				+ shared + ", user_id=" + user_id + ", is_deleted=" + is_deleted + "]";
	}

}