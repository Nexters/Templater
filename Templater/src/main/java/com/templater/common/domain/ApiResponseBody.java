package com.templater.common.domain;

import org.springframework.http.HttpStatus;

public class ApiResponseBody<T> {
	
	private T data;
	private Integer statusCode;
	private String statusText;
	
	public ApiResponseBody(T data) {
		this.data = data;
		this.statusCode = HttpStatus.OK.value();
		this.statusText = HttpStatus.OK.toString();
	}
	
	public ApiResponseBody(Integer statusCode, String statusText) {
		this.statusCode = statusCode;
		this.statusText = statusText;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	@Override
	public String toString() {
		return "ApiResponseBody [data=" + data + ", statusCode=" + statusCode + ", statusText=" + statusText + "]";
	}
}
