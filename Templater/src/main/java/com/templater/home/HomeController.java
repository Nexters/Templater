package com.templater.home;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public void index(HttpServletResponse response) throws IOException{
		response.sendRedirect("/web/index.html");
	}
}
