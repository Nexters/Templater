package com.templater.document.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.templater.document.model.entity.Tag;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	
	@Query("select t from Tag t where t.tag_id=?1")
	public Tag getTag(long tag_id);
	
	@Modifying
	@Query("update Tag t set t.tag_name=?2, t.tag_content=?3, t.parent_tag_id=?4 where t.tag_id=?1")
	public int updateTag(long tag_id, String tag_name, String tag_content, long parent_tag_id);
}
