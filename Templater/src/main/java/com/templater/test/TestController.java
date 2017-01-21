package com.templater.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@RequestMapping(value="/test")
	public String test(){
		return "test hello";
	}
}
