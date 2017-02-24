package com.templater.document.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.templater.document.model.entity.Component;
import com.templater.document.model.entity.Document;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {

	@Query("select c from Component c where c.document_id=?1")
	public List<Component> getComponents(Document document);

	@Query("select c from Component c where c.component_id=?1")
	public Component getComponent(long component_id);
	
	@Query("delete from Component c where c.component_id=?1")
	public void deleteComponent(long component_id);
}
