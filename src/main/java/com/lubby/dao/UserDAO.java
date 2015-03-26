package com.lubby.dao;

import java.util.List;

import com.lubby.bean.User;

/**
 *     @author Lubby
 *     @date 2015年3月26日  下午1:35:59
 *
 */

public interface UserDAO {
	public List<User> getAllUser(String userName);
	public User getUserByUserName(String userName);
	public User getUserByUserNameAndPassWord(String userName, String password);
	public boolean addUser(User user);
}
