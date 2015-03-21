package com.lubby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/main" })
public class MainController {
	public String showPage() {
		return "hello";
	}
}
