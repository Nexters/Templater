package com.templater.document.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.templater.common.domain.ApiResponse;
import com.templater.common.domain.ApiResponseBody;
import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.request.DocumentRequest;
import com.templater.document.model.response.ComponentResponse;
import com.templater.document.model.response.DocumentResponse;
import com.templater.document.service.DocumentService;

@RestController
@RequestMapping(value = "/doc")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@RequestMapping(value = "/doclist")
	public ApiResponseBody<List<DocumentDto>> getDocumentsList() {
		List<DocumentDto> docList = new ArrayList<>();
		long user_id = 3;
		docList = documentService.getDocuments(user_id);

		return new ApiResponseBody<List<DocumentDto>>(docList);
	}

	@RequestMapping(value = "/comlist")
	public ApiResponseBody<List<ComponentDto>> getComponents() {
		List<ComponentDto> comList = new ArrayList<>();
		long document_id = 4;
		comList = documentService.getComponents(document_id);
		return new ApiResponseBody<List<ComponentDto>>(comList);
	}

	@RequestMapping(value = "/document", method = RequestMethod.GET)
	public ApiResponse<DocumentRequest, ApiResponseBody<DocumentResponse>> getDocument(
			DocumentRequest documentRequest) {
		List<ComponentResponse> componentResponses = null;
		long document_id = documentRequest.getDocument_id();
		DocumentDto documentDto = documentService.getDocumentByDid(document_id);

		if (documentDto == null) {
			return new ApiResponse<DocumentRequest, ApiResponseBody<DocumentResponse>>(documentRequest,
					new ApiResponseBody<DocumentResponse>(HttpStatus.OK.value(), "Not Found Document"));
		}

		componentResponses = documentService.getAllComponents(document_id);

		if (componentResponses == null) {
			return new ApiResponse<DocumentRequest, ApiResponseBody<DocumentResponse>>(documentRequest,
					new ApiResponseBody<DocumentResponse>(HttpStatus.NOT_FOUND.value(), "Not Found Component"));
		}

		DocumentResponse documentResponse = new DocumentResponse(documentDto, componentResponses);

		return new ApiResponse<DocumentRequest, ApiResponseBody<DocumentResponse>>(documentRequest,
				new ApiResponseBody<DocumentResponse>(documentResponse));
	}

}
