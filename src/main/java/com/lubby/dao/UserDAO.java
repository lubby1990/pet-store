package com.lubby.dao;

import java.util.List;
import java.util.Map;

import com.lubby.bean.User;

/**
 *     @author Lubby
 *     @date 2015年3月26日  下午1:35:59
 *
 */

public interface UserDAO {
	public List<User> getAllUser();
	public User getUserByUserName(String userName);
	public User getUserByUserNameAndPassWord(Map<String, String> parameters);
	public int addUser(User user);
}
