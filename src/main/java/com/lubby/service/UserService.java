package com.lubby.service;

import com.lubby.bean.User;
import java.util.List;

public  interface UserService {
	public  boolean addUser(User paramUser);

	public  List<User> getAllUser(String paramString);

	public  User getUserByUserName(String paramString);

	public  User loginCheck(String paramString1, String paramString2);
}
