package com.templater.document.model.request;

import java.util.List;

import com.templater.document.model.dto.DocumentDto;

public class SetDocumentRequest {

	private DocumentDto document;
	private List<SetComponentRequest> Components;

	public DocumentDto getDocument() {
		return document;
	}

	public void setDocument(DocumentDto document) {
		this.document = document;
	}

	public List<SetComponentRequest> getComponents() {
		return Components;
	}

	public void setComponents(List<SetComponentRequest> components) {
		Components = components;
	}

	@Override
	public String toString() {
		return "SetDocumentRequest [document=" + document + ", Components=" + Components + "]";
	}

}
