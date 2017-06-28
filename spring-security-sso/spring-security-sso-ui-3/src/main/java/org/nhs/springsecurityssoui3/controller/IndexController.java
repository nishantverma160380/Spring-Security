package org.nhs.springsecurityssoui3.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", " NHS Leeds !!");
		return "index";
	}
	
	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		return "next";
	}

	@RequestMapping("/nhs")
	public String nhs(Map<String, Object> model) {
		model.put("message", "Leeds NHS !!");
		return "LeedsNHS";
	}
}