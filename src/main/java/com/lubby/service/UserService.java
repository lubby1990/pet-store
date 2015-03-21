package com.lubby.service;

import com.lubby.bean.User;
import java.util.List;

public abstract interface UserService {
	public abstract boolean addUser(User paramUser);

	public abstract List<User> getAllUser(String paramString);

	public abstract User getUserByUserName(String paramString);

	public abstract User loginCheck(String paramString1, String paramString2);
}
