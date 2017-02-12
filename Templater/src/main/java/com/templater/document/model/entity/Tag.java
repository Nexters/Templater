package com.templater.document.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tag", catalog = "templater")
public class Tag {

	@Id
	@Column(name = "tag_id")
	private long tag_id;

	@Column(name = "tag_name")
	private String tag_name;

	@Column(name = "tag_content")
	private String tag_content;

	@Column(name = "parent_tag_id")
	private long parent_tag_id;

	@OneToMany(mappedBy = "tag_id", cascade = CascadeType.ALL)
	private List<Component> component;

	public long getTag_id() {
		return tag_id;
	}

	public void setTag_id(long tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public String getTag_content() {
		return tag_content;
	}

	public void setTag_content(String tag_content) {
		this.tag_content = tag_content;
	}

	public long getParent_tag_id() {
		return parent_tag_id;
	}

	public void setParent_tag_id(long parent_tag_id) {
		this.parent_tag_id = parent_tag_id;
	}

	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "Tag [tag_id=" + tag_id + ", tag_name=" + tag_name + ", tag_content=" + tag_content + ", parent_tag_id="
				+ parent_tag_id + ", component=" + component + "]";
	}

}
