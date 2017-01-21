package com.templater.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	
	@Autowired
	private TestRepository testRepository;
	
	public Map<String,Object> test(){
		
		List<TestEntity> testList = testRepository.findTest();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("test", testList);
		return map;
	}
	
	
}
