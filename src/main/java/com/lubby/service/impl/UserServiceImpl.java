package com.lubby.service.impl;

import com.lubby.bean.Account;
import com.lubby.bean.User;
import com.lubby.dao.AccountDAO;
import com.lubby.dao.UserDAO;
import com.lubby.dao.impl.UserDAOImpl;
import com.lubby.service.UserService;

import java.util.List;

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
		success = userDAO.addUser(user);
		User savedUser = userDAO.getUserByUserName(user.getUserName());
		Account account = new Account();
		account.setUserId(savedUser.getUserId());
		account.setCash(0L);
		success = success && accountDAO.addAccount(account);
		return success;
	}

	public List<User> getAllUser(String userName) {
		return this.userDAO.getAllUser(userName);
	}


	public User loginCheck(String userName, String password) {
		return this.userDAO.getUserByUserNameAndPassWord(userName, password);
	}
	
	public User getUserByUserName (String userName){
		return this.userDAO.getUserByUserName(userName);
	}
}
