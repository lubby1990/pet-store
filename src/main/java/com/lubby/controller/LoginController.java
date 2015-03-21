package com.lubby.controller;

import com.google.gson.Gson;
import com.lubby.bean.Response;
import com.lubby.bean.User;
import com.lubby.service.UserService;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
@RequestMapping({ "/login" })
public class LoginController {
	Gson gson = new Gson();
	@Resource
	private UserService userService;

	@RequestMapping({ "" })
	public String showLoginPage(Model model) {
//		model.addAttribute(arg0, arg1)
		return "login";
	}

	@RequestMapping({ "/loginCheck" })
	@ResponseBody
	public Response<User> loginCheck(String userName, String password, Model model) {
		Response<User> response = new Response();
		User user = this.userService.loginCheck(userName, password);
		ArrayList<User> list = null;
		if (user != null) {
			list = new ArrayList();
			list.add(user);
			response.setData(list);
			response.setSuccess(true);
		} else {
			response.setErrorMessage("密码错误!");
		}
		return response;
	}

	@RequestMapping({ "/hello" })
	public String hello(String userName, Model model) {
		model.addAttribute("userName", userName);

		return "hello";
	}
}
