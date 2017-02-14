package com.templater.document.model.response;

import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;

public class ComponentResponse {
	private long component_id;
	private FormatDto format;
	private TagDto tag;

	public ComponentResponse() {
		super();
	}

	public ComponentResponse(long component_id) {
		super();
		this.component_id = component_id;
	}

	public ComponentResponse(long component_id, FormatDto format, TagDto tag) {
		super();
		this.component_id = component_id;
		this.format = format;
		this.tag = tag;
	}

	public long getComponent_id() {
		return component_id;
	}

	public void setComponent_id(long component_id) {
		this.component_id = component_id;
	}

	public FormatDto getFormat() {
		return format;
	}

	public void setFormat(FormatDto format) {
		this.format = format;
	}

	public TagDto getTag() {
		return tag;
	}

	public void setTag(TagDto tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "ComponentResponse [component_id=" + component_id + ", format=" + format + ", tag=" + tag + "]";
	}

}
