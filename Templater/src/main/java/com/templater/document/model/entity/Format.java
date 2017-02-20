package com.templater.document.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.templater.document.model.dto.FormatDto;

@Entity
@Table(name = "format", catalog = "templater")
public class Format {
	@Id
	@Column(name = "format_id")
	private long format_id;

	@Column(name = "format_name")
	private String format_name;

	@Column(name = "format_type")
	private String format_type;

	@Column(name = "format_prop")
	private String format_prop;

	@OneToMany(mappedBy = "format_id", cascade = CascadeType.ALL)
	private List<Component> component;

	public Format() {
		super();
	}

	public Format(FormatDto formatDto) {
		this.format_id = formatDto.getFormat_id();
		this.format_name = formatDto.getFormat_name();
		this.format_type = formatDto.getFormat_type();
		this.format_prop = formatDto.getFormat_prop();
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

	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "Format [format_id=" + format_id + ", format_name=" + format_name + ", format_type=" + format_type
				+ ", format_prop=" + format_prop + ", component=" + component + "]";
	}

}
