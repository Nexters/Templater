package com.templater.document.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.templater.document.model.dto.ComponentDto;
import com.templater.document.model.dto.DocumentDto;
import com.templater.document.model.dto.FormatDto;
import com.templater.document.model.dto.TagDto;
import com.templater.document.model.entity.Component;
import com.templater.document.model.entity.Document;
import com.templater.document.model.entity.Format;
import com.templater.document.model.entity.Tag;
import com.templater.document.model.request.SetComponentRequest;
import com.templater.document.model.request.SetDocumentRequest;
import com.templater.document.model.response.GetComponentResponse;
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
		List<DocumentDto> documentList = null;
		List<Document> documents = documentRepository.getDocuments(user_id);
		if (documents != null && documents.size() != 0) {
			documentList = new ArrayList<>();
			for (Document document : documents) {
				DocumentDto documentDto = new DocumentDto(document);
				documentList.add(documentDto);
			}
		}
		return documentList;
	}

	@Override
	public List<ComponentDto> getComponents(long document_id) {
		List<ComponentDto> componentList = null;
		Document document = new Document();
		document.setDocument_id(document_id);
		List<Component> components = componentRepository.getComponents(document);
		if (components != null && components.size() != 0) {
			componentList = new ArrayList<>();
			for (Component component : components) {
				ComponentDto componentDto = new ComponentDto(component);
				componentList.add(componentDto);
			}
		}
		return componentList;
	}

	@Override
	public FormatDto getFormat(long format_id) {
		Format format = formatRepository.getFormat(format_id);
		FormatDto formatDto = null;
		if (format != null) {
			formatDto = new FormatDto(format);
		}
		return formatDto;
	}

	@Override
	public TagDto getTag(long tag_id) {
		Tag tag = tagRepository.getTag(tag_id);
		TagDto tagDto = null;
		if (tag != null) {
			tagDto = new TagDto(tag);
		}
		return tagDto;
	}

	@Override
	public DocumentDto getDocumentByDid(long document_id) {
		Document document = documentRepository.getDocumentByDid(document_id);
		DocumentDto documentDto = null;
		if (document != null) {
			documentDto = new DocumentDto(document);
		}
		return documentDto;
	}

	@Override
	public List<GetComponentResponse> getAllComponents(long document_id) {
		List<GetComponentResponse> componentResponses = null;
		List<ComponentDto> componentDtos = getComponents(document_id);
		if (componentDtos != null && componentDtos.size() != 0) {
			componentResponses = new ArrayList<>();
			for (ComponentDto componentDto : componentDtos) {
				FormatDto formatDto = getFormat(componentDto.getFormat_id());
				TagDto tagDto = getTag(componentDto.getTag_id());
				GetComponentResponse componentResponse = new GetComponentResponse(componentDto.getComponent_id());
				if (formatDto != null) {
					componentResponse.setFormat(formatDto);
				}
				if (tagDto != null) {
					componentResponse.setTag(tagDto);
				}
				componentResponses.add(componentResponse);
			}
		}
		return componentResponses;
	}

	@Override
	public int setDocument(SetDocumentRequest setDocumentRequest) {
		Document document = new Document(setDocumentRequest.getDocument());
		documentRepository.save(document);

		for (SetComponentRequest componentRequest : setDocumentRequest.getComponents()) {
			setFormat(componentRequest.getFormat());
			setTag(componentRequest.getTag());
			setComponent(
					new ComponentDto(componentRequest.getComponent_id(), componentRequest.getFormat().getFormat_id(),
							componentRequest.getTag().getTag_id(), setDocumentRequest.getDocument().getDocument_id()));
		}
		return 0;
	}

	@Override
	public int setComponent(ComponentDto componentDto) {
		Component component = new Component(componentDto);
		componentRepository.save(component);
		return 0;
	}

	@Override
	public int setFormat(FormatDto formatDto) {
		Format format = new Format(formatDto);
		formatRepository.save(format);
		return 0;
	}

	@Override
	public int setTag(TagDto tagDto) {
		Tag tag = new Tag(tagDto);
		tagRepository.save(tag);
		return 0;
	}

	@Override
	public int updateDocument(SetDocumentRequest documentRequest){
		//1 성공, -1 에러, 0 값이404(update시 찾는조건이없을때)
		try{
			DocumentDto d = documentRequest.getDocument();
			Timestamp time = new Timestamp(System.currentTimeMillis());
			documentRepository.updateDocument(d.getDocument_id(), d.getDocument_type(), d.getDocument_name(),time ,d.getShared());
			List<SetComponentRequest> components = documentRequest.getComponents();
			for(SetComponentRequest r : components){
				FormatDto f = r.getFormat();
				formatRepository.updateFormat(f.getFormat_id(), f.getFormat_name(), f.getFormat_type(), f.getFormat_prop());
				TagDto t = r.getTag();
				tagRepository.updateTag(t.getTag_id(), t.getTag_name(), t.getTag_content(), t.getParent_tag_id());
			}
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
}
