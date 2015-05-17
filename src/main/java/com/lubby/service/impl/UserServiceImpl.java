package com.lubby.service.impl;

import com.lubby.bean.Account;
import com.lubby.bean.User;
import com.lubby.dao.AccountDAO;
import com.lubby.dao.UserDAO;
import com.lubby.service.UserService;
import com.lubby.test.impl.UserDAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDAO")
	private UserDAO userDAO;
	@Resource(name="accountDAO")
	private AccountDAO accountDAO;

	public boolean addUser(User user) {
		boolean success = false;
		success = userDAO.addUser(user) == 1;
		User savedUser = userDAO.getUserByUserName(user.getUserName());
		Account account = new Account();
		account.setUserId(savedUser.getUserId());
		account.setCash(0L);
		success = success && accountDAO.addAccount(account) == 1;
		return success;
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}


	public User loginCheck(String userName, String password) {
		Map<String, String> parameters = new HashMap<String, String> ();
		parameters.put("userName", userName);
		parameters.put("password", password);
		return this.userDAO.getUserByUserNameAndPassWord(parameters);
	}
	
	public User getUserByUserName (String userName){
		return this.userDAO.getUserByUserName(userName);
	}
}
