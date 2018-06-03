package ru.bagautdinov.core.shared.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/") 
	public String index() {
		return "index";
	}
	
	@GetMapping("/oc")
	public String ocModule() {
		return "without_serv";
	}
	
	@GetMapping("/os")
	public String osModule() {
		return "with_serv";
	}
	
}
