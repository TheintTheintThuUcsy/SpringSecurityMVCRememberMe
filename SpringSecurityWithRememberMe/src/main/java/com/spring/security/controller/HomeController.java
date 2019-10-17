package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String firstPage() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)  
    public String login() {  
        return "login";  
    }  
    @RequestMapping(value = "/admin", method = RequestMethod.GET)  
    public String admin() {  
        return "admin";  
    }  
}
