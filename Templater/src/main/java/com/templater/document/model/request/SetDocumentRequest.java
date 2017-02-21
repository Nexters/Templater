package com.templater.document.model.request;

import java.util.List;

import com.templater.document.model.dto.DocumentDto;

public class SetDocumentRequest {

	private DocumentDto document;
	private List<SetComponentRequest> components;

	public DocumentDto getDocument() {
		return document;
	}

	public void setDocument(DocumentDto document) {
		this.document = document;
	}

	public List<SetComponentRequest> getComponents() {
		return components;
	}

	public void setComponents(List<SetComponentRequest> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "SetDocumentRequest [document=" + document + ", components=" + components + "]";
	}

}
