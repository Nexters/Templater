package com.templater.test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer>{

	@Query(value="select t from TestEntity t")
	List<TestEntity> findTest();
	
}
