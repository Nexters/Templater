package com.templater.document.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.templater.document.model.dto.ComponentDto;

@Entity
@Table(name = "component", catalog = "templater")
public class Component {
	@Id
	@Column(name = "component_id")
	private long component_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "format_id")
	private Format format_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tag_id")
	private Tag tag_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	private Document document_id;

	public Component() {
		super();
	}
	public Component(ComponentDto componentDto) {
		this.component_id = componentDto.getComponent_id();
		this.format_id.setFormat_id(componentDto.getFormat_id());
		this.tag_id.setTag_id(componentDto.getTag_id());
	}

	public long getComponent_id() {
		return component_id;
	}

	public void setComponent_id(long component_id) {
		this.component_id = component_id;
	}

	public Format getFormat_id() {
		return format_id;
	}

	public void setFormat_id(Format format_id) {
		this.format_id = format_id;
	}

	public Tag getTag_id() {
		return tag_id;
	}

	public void setTag_id(Tag tag_id) {
		this.tag_id = tag_id;
	}

	public Document getDocument_id() {
		return document_id;
	}

	public void setDocument_id(Document document_id) {
		this.document_id = document_id;
	}

	@Override
	public String toString() {
		return "Component [component_id=" + component_id + ", format_id=" + format_id + ", tag_id=" + tag_id
				+ ", document_id=" + document_id + "]";
	}

}
