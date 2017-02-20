package com.templater.document.model.request;

import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;

public class SetComponentRequest {
	private long component_id;
	private FormatDto format;
	private TagDto tag;

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
		return "SetComponentRequest [component_id=" + component_id + ", format=" + format + ", tag=" + tag + "]";
	}

}
