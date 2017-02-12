package com.templater.document.service;

import java.util.List;

import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;

public interface DocumentService {
	public List<DocumentDto> getDocuments(long user_id);

	public List<ComponentDto> getComponents(long document_id);

	public FormatDto getFormat(long format_id);

	public TagDto getTag(long tag_id);
}
