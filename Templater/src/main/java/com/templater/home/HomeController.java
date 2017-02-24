package com.templater.home;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.templater.user.service.UserServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/")
	public void index(HttpServletResponse response) throws IOException{
		response.sendRedirect("/web/index.html");
	}
	
}
