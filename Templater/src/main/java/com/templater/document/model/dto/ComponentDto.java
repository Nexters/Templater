package com.templater.document.model.dto;

import com.templater.document.model.entity.Component;

public class ComponentDto {
	private long component_id;

	private long format_id;

	private long tag_id;

	private long document_id;

	public ComponentDto() {
		super();
	}

	public ComponentDto(Component comp) {
		super();
		this.component_id = comp.getComponent_id();
		this.format_id = comp.getFormat_id().getFormat_id();
		this.tag_id = comp.getTag_id().getTag_id();
		this.document_id = comp.getDocument_id().getDocument_id();
	}

	public ComponentDto(long component_id, long format_id, long tag_id, long document_id) {
		super();
		this.component_id = component_id;
		this.format_id = format_id;
		this.tag_id = tag_id;
		this.document_id = document_id;
	}

	public long getComponent_id() {
		return component_id;
	}

	public void setComponent_id(long component_id) {
		this.component_id = component_id;
	}

	public long getFormat_id() {
		return format_id;
	}

	public void setFormat_id(long format_id) {
		this.format_id = format_id;
	}

	public long getTag_id() {
		return tag_id;
	}

	public void setTag_id(long tag_id) {
		this.tag_id = tag_id;
	}

	public long getDocument_id() {
		return document_id;
	}

	public void setDocument_id(long document_id) {
		this.document_id = document_id;
	}

	@Override
	public String toString() {
		return "Component [component_id=" + component_id + ", format_id=" + format_id + ", tag_id=" + tag_id
				+ ", document_id=" + document_id + "]";
	}

}
