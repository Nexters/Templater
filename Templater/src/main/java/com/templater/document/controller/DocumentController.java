package com.templater.document.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.templater.common.domain.ApiResponse;
import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.request.GetDocumentRequest;
import com.templater.document.model.request.SetDocumentRequest;
import com.templater.document.model.response.GetComponentResponse;
import com.templater.document.model.response.GetDocumentResponse;
import com.templater.document.model.response.SetDocumentResponse;
import com.templater.document.service.DocumentService;
import com.templater.user.service.UserService;

@RestController
@RequestMapping(value = "/doc")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/doclist", method = RequestMethod.GET)
	public ApiResponse<List<DocumentDto>> getDocumentsList(String loginId) {

		long user_id = userService.getUserIdByLoginId(loginId);
		if (user_id == 0) {
			return new ApiResponse<List<DocumentDto>>(HttpStatus.BAD_REQUEST.value(), "Not Found User");
		}
		List<DocumentDto> docList = documentService.getDocuments(user_id);
		if (docList == null) {
			return new ApiResponse<List<DocumentDto>>(HttpStatus.OK.value(), "Not Found Document");
		}
		return new ApiResponse<List<DocumentDto>>(docList);
	}

	@RequestMapping(value = "/comlist", method = RequestMethod.GET)
	public ApiResponse<List<ComponentDto>> getComponents(long document_id) {
		List<ComponentDto> comList = documentService.getComponents(document_id);
		if (comList == null) {
			return new ApiResponse<List<ComponentDto>>(HttpStatus.OK.value(), "Not Found Component");
		}
		return new ApiResponse<List<ComponentDto>>(comList);
	}

	@RequestMapping(value = "/document", method = RequestMethod.GET)
	public ApiResponse<GetDocumentResponse> getDocument(GetDocumentRequest documentRequest) {
		List<GetComponentResponse> componentResponses = null;
		long document_id = documentRequest.getDocument_id();
		DocumentDto documentDto = documentService.getDocumentByDid(document_id);

		if (documentDto == null) {
			return new ApiResponse<GetDocumentResponse>(HttpStatus.OK.value(), "Not Found Document");
		}

		componentResponses = documentService.getAllComponents(document_id);

		if (componentResponses == null) {
			return new ApiResponse<GetDocumentResponse>(HttpStatus.NOT_FOUND.value(), "Not Found Component");
		}

		GetDocumentResponse documentResponse = new GetDocumentResponse(documentDto, componentResponses);

		return new ApiResponse<GetDocumentResponse>(documentResponse);
	}

	@RequestMapping(value = "/document", method = RequestMethod.POST)
	public ApiResponse<SetDocumentResponse> setDocument(SetDocumentRequest documentRequest) {
		SetDocumentResponse documentResponse = new SetDocumentResponse();
		int result = documentService.setDocument(documentRequest);
		if (result == -1) {
			return new ApiResponse<SetDocumentResponse>(HttpStatus.BAD_REQUEST);
		}
		return new ApiResponse<SetDocumentResponse>(documentResponse);
	}

	@RequestMapping(value = "/document", method = RequestMethod.PUT)
	public ApiResponse<SetDocumentResponse> updateDocument(@RequestBody SetDocumentRequest documentRequest) {
		System.out.println(documentRequest);
		int result = documentService.updateDocument(documentRequest);
		if (result == -1) {
			return new ApiResponse<SetDocumentResponse>(HttpStatus.BAD_REQUEST);
		}
		return new ApiResponse<SetDocumentResponse>(HttpStatus.OK);
	}

	@RequestMapping(value = "/document/deldoc", method = RequestMethod.DELETE)
	public ApiResponse<SetDocumentResponse> deleteDocument(long document_id) {
		int result = documentService.deleteDocument(document_id);
		if (result == 0) {
			return new ApiResponse<SetDocumentResponse>(HttpStatus.NOT_FOUND.value(), "Not Found Document");
		}
		if (result == -1) {
			return new ApiResponse<SetDocumentResponse>(HttpStatus.BAD_REQUEST);
		}
		return new ApiResponse<SetDocumentResponse>(HttpStatus.OK);
	}

	@RequestMapping(value = "/document/delcomp", method = RequestMethod.DELETE)
	public ApiResponse<SetDocumentResponse> deleteComponent(long component_id) {
		int result = documentService.deleteComponent(component_id);
		if (result == 0) {
			return new ApiResponse<SetDocumentResponse>(HttpStatus.NOT_FOUND.value(), "Not Found Component");
		}
		if (result == -1) {
			return new ApiResponse<SetDocumentResponse>(HttpStatus.BAD_REQUEST);
		}
		return new ApiResponse<SetDocumentResponse>(HttpStatus.OK);
	}
}
