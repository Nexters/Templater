package com.templater.document.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.templater.common.domain.ApiResponse;
import com.templater.common.domain.ApiResponseBody;
import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.request.GetDocumentRequest;
import com.templater.document.model.request.SetDocumentRequest;
import com.templater.document.model.response.GetComponentResponse;
import com.templater.document.model.response.GetDocumentResponse;
import com.templater.document.model.response.SetDocumentResponse;
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
	public ApiResponse<GetDocumentRequest, ApiResponseBody<GetDocumentResponse>> getDocument(
			GetDocumentRequest documentRequest) {
		List<GetComponentResponse> componentResponses = null;
		long document_id = documentRequest.getDocument_id();
		DocumentDto documentDto = documentService.getDocumentByDid(document_id);

		if (documentDto == null) {
			return new ApiResponse<GetDocumentRequest, ApiResponseBody<GetDocumentResponse>>(documentRequest,
					new ApiResponseBody<GetDocumentResponse>(HttpStatus.OK.value(), "Not Found Document"));
		}

		componentResponses = documentService.getAllComponents(document_id);

		if (componentResponses == null) {
			return new ApiResponse<GetDocumentRequest, ApiResponseBody<GetDocumentResponse>>(documentRequest,
					new ApiResponseBody<GetDocumentResponse>(HttpStatus.NOT_FOUND.value(), "Not Found Component"));
		}

		GetDocumentResponse documentResponse = new GetDocumentResponse(documentDto, componentResponses);

		return new ApiResponse<GetDocumentRequest, ApiResponseBody<GetDocumentResponse>>(documentRequest,
				new ApiResponseBody<GetDocumentResponse>(documentResponse));
	}

	@RequestMapping(value = "/document", method = RequestMethod.POST)
	public ApiResponse<SetDocumentRequest, ApiResponseBody<SetDocumentResponse>> setDocument(
			SetDocumentRequest documentRequest) {
		SetDocumentResponse documentResponse = new SetDocumentResponse();
		documentService.setDocument(documentRequest);
		return new ApiResponse<SetDocumentRequest, ApiResponseBody<SetDocumentResponse>>(documentRequest,
				new ApiResponseBody<SetDocumentResponse>(documentResponse));
	}

	@RequestMapping(value = "/document", method = RequestMethod.PUT)
	public ApiResponseBody<SetDocumentResponse> updateDocument(@RequestBody SetDocumentRequest documentRequest) {
		System.out.println(documentRequest);
		int result = documentService.updateDocument(documentRequest);
		if(result == -1){
			return new ApiResponseBody<SetDocumentResponse>(HttpStatus.BAD_REQUEST);
		}
		return new ApiResponseBody<SetDocumentResponse>(HttpStatus.OK);
	}

	@RequestMapping(value = "/document", method = RequestMethod.DELETE)
	public ApiResponse<GetDocumentRequest, ApiResponseBody<GetDocumentResponse>> deleteDocument(
			GetDocumentRequest documentRequest) {
		return null;
	}
}
