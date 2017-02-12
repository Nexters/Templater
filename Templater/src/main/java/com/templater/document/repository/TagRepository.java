package com.templater.document.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.templater.document.model.entity.Tag;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	
	@Query("select t from Tag t where t.tag_id=?1")
	public Tag getTag(long tag_id);
}
