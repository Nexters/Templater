package com.templater.document.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;
import com.templater.document.model.entity.Component;
import com.templater.document.model.entity.Document;
import com.templater.document.repository.ComponentRepository;
import com.templater.document.repository.DocumentRepository;
import com.templater.document.repository.FormatRepository;
import com.templater.document.repository.TagRepository;

@Service
public class DocmentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private ComponentRepository componentRepository;

	@Autowired
	private FormatRepository formatRepository;

	@Autowired
	private TagRepository tagRepository;

	@Override
	public List<DocumentDto> getDocuments(long user_id) {
		List<DocumentDto> documentList = new ArrayList<>();

		for (Document document : documentRepository.getDocuments(user_id)) {
			DocumentDto documentDto = new DocumentDto(document);
			documentList.add(documentDto);
		}

		return documentList;
	}

	@Override
	public List<ComponentDto> getComponents(long document_id) {
		List<ComponentDto> componentList = new ArrayList<>();
		Document document = new Document();
		document.setDocument_id(document_id);
		for (Component component : componentRepository.getComponents(document)) {
			ComponentDto componentDto = new ComponentDto(component);
			componentList.add(componentDto);
		}
		return componentList;
	}

	@Override
	public FormatDto getFormat(long format_id) {

		FormatDto formatDto = new FormatDto(formatRepository.getFormat(format_id));
		return formatDto;
	}

	@Override
	public TagDto getTag(long tag_id) {

		TagDto tagDto = new TagDto(tagRepository.getTag(tag_id));
		return tagDto;
	}

}
