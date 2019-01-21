package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControl {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	@RequestMapping("/employee")
	public String Employee(){
		return "employee";
	}
	
	@RequestMapping("/department")
	public String Department(){
		return "department";
	}
	
	@RequestMapping("/role")
	public String Role(){
		return "role";
	}
	
}
