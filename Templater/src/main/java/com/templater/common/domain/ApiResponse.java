package com.templater.common.domain;

public class ApiResponse<T1, T2> {
	private T1 request;
	private T2 response;

	public ApiResponse(T1 request, T2 response) {
		this.request = request;
		this.response = response;
	}

	public ApiResponse() {
		super();
	}

	public T1 getRequest() {
		return request;
	}

	public void setRequest(T1 request) {
		this.request = request;
	}

	public T2 getResponse() {
		return response;
	}

	public void setResponse(T2 response) {
		this.response = response;
	}

}
