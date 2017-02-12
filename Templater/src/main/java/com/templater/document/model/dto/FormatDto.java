package com.templater.document.model.dto;

import com.templater.document.model.entity.Format;

public class FormatDto {

	private long format_id;

	private String format_name;

	private String format_type;

	private String format_prop;

	public FormatDto() {
		super();
	}

	public FormatDto(Format fmt) {
		super();
		this.format_id = fmt.getFormat_id();
		this.format_name = fmt.getFormat_name();
		this.format_type = fmt.getFormat_type();
		this.format_prop = fmt.getFormat_prop();
	}

	public FormatDto(long format_id, String format_name, String format_type, String format_prop) {
		super();
		this.format_id = format_id;
		this.format_name = format_name;
		this.format_type = format_type;
		this.format_prop = format_prop;
	}

	public long getFormat_id() {
		return format_id;
	}

	public void setFormat_id(long format_id) {
		this.format_id = format_id;
	}

	public String getFormat_name() {
		return format_name;
	}

	public void setFormat_name(String format_name) {
		this.format_name = format_name;
	}

	public String getFormat_type() {
		return format_type;
	}

	public void setFormat_type(String format_type) {
		this.format_type = format_type;
	}

	public String getFormat_prop() {
		return format_prop;
	}

	public void setFormat_prop(String format_prop) {
		this.format_prop = format_prop;
	}

	@Override
	public String toString() {
		return "Format [format_id=" + format_id + ", format_name=" + format_name + ", format_type=" + format_type
				+ ", format_prop=" + format_prop + "]";
	}

}
