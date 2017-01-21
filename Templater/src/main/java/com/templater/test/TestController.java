package com.templater.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/test")
	public String test(){
		return "test hello";
	}
	
	
	@RequestMapping(value="/test2")
	public Map<String,Object> test2(){
		return testService.test();
	}
	
	
}
