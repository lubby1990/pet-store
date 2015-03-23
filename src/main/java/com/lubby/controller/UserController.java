package com.lubby.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lubby.bean.Gender;
import com.lubby.bean.Response;
import com.lubby.bean.User;
import com.lubby.bean.viewbean.ViewUser;
import com.lubby.service.UserService;
import com.lubby.util.MD5Util;

/**
 *     @author Lubby
 *     @date 2015年3月23日  下午8:50:30
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource()
	private UserService userService;
	
	
	@RequestMapping("/registerUser")
	@ResponseBody
	public Response<User> createUser(ViewUser viewUser,HttpSession session){
		Response<User> response = new Response<User>();
		
		User selectedUser = userService.getUserByUserName(viewUser.getUserName());
		if(selectedUser == null){
			User registerUser = viewUserToUser(viewUser);
			boolean success = userService.addUser(registerUser);
			if(success){
				registerUser = userService.getUserByUserName(viewUser.getUserName());
			}
			response.setSuccess(success);
			session.setAttribute("currentUser", registerUser);
		}else{
			response.setSuccess(false);
			response.setErrorMessage("用户名已存在,请换用户名!");
		}
		return response;
	}
	private User viewUserToUser(ViewUser viewUser){
		if(viewUser == null){
			return null;
		}
		User user= new User();
		user.setAddress(viewUser.getAddress());
		user.setGender(Gender.valueOf(viewUser.getGender()));
		user.setNation(viewUser.getNation());
		user.setNickName(viewUser.getNickName());
		user.setUserName(viewUser.getUserName());
		
		//password save after MD5
		StringBuffer sb = new StringBuffer(viewUser.getPassword()).append(viewUser.getUserName());
		String password = MD5Util.getMD5(sb.toString());
		user.setPassword(password);
		return user;
	}
	

}
