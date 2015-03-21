package com.lubby.service.impl;

import com.lubby.bean.User;
import com.lubby.dao.UserDAO;
import com.lubby.service.UserService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDAO userDAO;

	public boolean addUser(User user) {
		return this.userDAO.addUser(user).booleanValue();
	}

	public List<User> getAllUser(String userName) {
		return this.userDAO.getAllUser(userName);
	}

	public User getUserByUserName(String userName) {
		return this.userDAO.getUserByUserName(userName);
	}

	public User loginCheck(String userName, String password) {
		return this.userDAO.getUserByUserNameAndPassWord(userName, password);
	}
}
