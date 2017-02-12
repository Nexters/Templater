package com.templater.document.model.response;

import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;

public class ComponentResponse {
	private long Component_id;
	private FormatDto format;
	private TagDto tag;

	public long getComponent_id() {
		return Component_id;
	}

	public void setComponent_id(long component_id) {
		Component_id = component_id;
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
		return "ComponentResponse [Component_id=" + Component_id + ", format=" + format + ", tag=" + tag + "]";
	}

}
