package com.templater.document.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.templater.document.model.dto.DocumentDto;

@Entity
@Table(name = "document", catalog = "templater")
public class Document {
	@Id
	@Column(name = "document_id")
	private long document_id;

	@Column(name = "document_type")
	private String document_type;

	@Column(name = "document_name")
	private String document_name;

	@Column(name = "created_date")
	private String created_date;

	@Column(name = "modified_date")
	private String modified_date;

	@Column(name = "shared")
	private String shared;

	@Column(name = "user_id")
	private long user_id;

	@OneToMany(mappedBy = "document_id", cascade = CascadeType.ALL)
	private List<Component> component;

	public Document() {
		super();
	}

	public Document(DocumentDto documentDto) {
		this.document_id = documentDto.getDocument_id();
		this.document_name = documentDto.getDocument_name();
		this.document_type = documentDto.getDocument_type();
		this.created_date = documentDto.getCreated_date();
		this.modified_date = documentDto.getModified_date();
		this.shared = documentDto.getShared();
		this.user_id = documentDto.getUser_id();

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

	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "Document [document_id=" + document_id + ", document_type=" + document_type + ", document_name="
				+ document_name + ", created_date=" + created_date + ", modified_date=" + modified_date + ", shared="
				+ shared + ", user_id=" + user_id + ", component=" + component + "]";
	}

}
