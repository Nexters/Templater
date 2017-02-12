package com.templater.document.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.templater.document.model.entity.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {
	
	@Query("select f from Format f where f.format_id=?1")
	public Format getFormat(long format_id);
}
