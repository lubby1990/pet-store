package com.lubby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/list" })
public class MainController {
	@RequestMapping("/hello")
	public String showPage() {
		return "hello";
	}
}
