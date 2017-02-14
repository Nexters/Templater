package com.templater.document.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.templater.document.model.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	@Query("select d from Document d where d.user_id=?1")
	public List<Document> getDocuments(long user_id);

	@Query("select d from Document d where d.document_id=?1")
	public Document getDocumentByDid(long document_id);

}
