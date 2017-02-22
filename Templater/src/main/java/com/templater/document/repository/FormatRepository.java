package com.templater.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.templater.document.model.entity.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {
	
	@Query("select f from Format f where f.format_id=?1")
	public Format getFormat(long format_id);

	@Modifying
	@Transactional
	@Query("update Format f set f.format_name=?2, f.format_type=?3, f.format_prop=?4 where f.format_id=?1")
	public int updateFormat(long format_id, String format_name, String format_type, String format_prop);

}
