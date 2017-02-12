package com.templater.document.model.dto;

import com.templater.document.model.entity.Tag;

public class TagDto {

	private long tag_id;

	private String tag_name;

	private String tag_content;

	private long parent_tag_id;

	public TagDto() {
		super();
	}

	public TagDto(Tag tg) {
		super();
		this.tag_id = tg.getTag_id();
		this.tag_name = tg.getTag_name();
		this.tag_content = tg.getTag_content();
		this.parent_tag_id = tg.getParent_tag_id();
	}

	public TagDto(long tag_id, String tag_name, String tag_content, long parent_tag_id) {
		super();
		this.tag_id = tag_id;
		this.tag_name = tag_name;
		this.tag_content = tag_content;
		this.parent_tag_id = parent_tag_id;
	}

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

	@Override
	public String toString() {
		return "Tag [tag_id=" + tag_id + ", tag_name=" + tag_name + ", tag_content=" + tag_content + ", parent_tag_id="
				+ parent_tag_id + "]";
	}

}
