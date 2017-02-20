package com.templater.document.service;

import java.util.List;

import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;
import com.templater.document.model.request.SetComponentRequest;
import com.templater.document.model.request.SetDocumentRequest;
import com.templater.document.model.response.GetComponentResponse;

public interface DocumentService {
	public List<DocumentDto> getDocuments(long user_id);

	public List<ComponentDto> getComponents(long document_id);

	public DocumentDto getDocumentByDid(long document_id);

	public FormatDto getFormat(long format_id);

	public TagDto getTag(long tag_id);

	public List<GetComponentResponse> getAllComponents(long document_id);

	public int setDocument(SetDocumentRequest setDocumentRequest);

	public int setComponent(ComponentDto componentDto);

	public int setFormat(FormatDto formatDto);

	public int setTag(TagDto tagDto);
}
