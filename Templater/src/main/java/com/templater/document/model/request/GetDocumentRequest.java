package com.templater.document.model.request;

public class GetDocumentRequest {
	private long document_id;

	public GetDocumentRequest() {
		super();
	}

	public GetDocumentRequest(long document_id) {
		super();
		this.document_id = document_id;
	}

	public long getDocument_id() {
		return document_id;
	}

	public void setDocument_id(long document_id) {
		this.document_id = document_id;
	}

	@Override
	public String toString() {
		return "DocumentRequest [document_id=" + document_id + "]";
	}

}
