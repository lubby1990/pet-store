package com.lubby.dao.impl;

import com.lubby.bean.Gender;
import com.lubby.bean.User;
import com.lubby.dao.UserDAO;
import com.lubby.db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	@Resource(name = "dbUtil")
	private DBUtil dbUtil;

	public List<User> getAllUser(String userName) {
		List<User> list = new ArrayList();
		User user = null;
		String sql = "select * from t_user";
		try {
			PreparedStatement ps = this.dbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userId = rs.getString(1);
				String uName = rs.getString(2);
				String uPassword = rs.getString(3);
				String nickName = rs.getString(4);

				String gender = rs.getString(5);
				String address = rs.getString(6);
				String nation = rs.getString(7);
				Gender genderE = StringUtils.isNotBlank(gender) ? null : Gender.valueOf(gender);
				user = new User(userId, uName, uPassword, nickName, genderE, address, nation);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public User getUserByUserName(String userName) {
		User user = null;
		List<User> list = new ArrayList();
		String sql = "select * from t_user where user_name = ? ";
		try {
			PreparedStatement ps = this.dbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userId = rs.getString(1);
				String uName = rs.getString(2);
				String uPassword = rs.getString(3);
				String nickName = rs.getString(4);

				String gender = rs.getString(5);
				String address = rs.getString(6);
				String nation = rs.getString(7);
				Gender genderE = StringUtils.isNotBlank(gender) ?   Gender.valueOf(gender) : null;
				user = new User(userId, uName, uPassword, nickName, genderE, address, nation);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size() == 0) {
			return null;
		}
		return (User) list.get(0);
	}

	public User getUserByUserNameAndPassWord(String userName, String password) {
		User user = null;
		List<User> list = new ArrayList();
		String sql = "select * from t_user where user_name = ? and password = ?";
		try {
			PreparedStatement ps = this.dbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userId = rs.getString(1);
				String uName = rs.getString(2);
				String uPassword = rs.getString(3);
				String nickName = rs.getString(4);

				String gender = rs.getString(5);
				String address = rs.getString(6);
				String nation = rs.getString(7);
				Gender genderE = StringUtils.isNotBlank(gender) ? null : Gender.valueOf(gender);
				user = new User(userId, uName, uPassword, nickName, genderE, address, nation);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size() == 0) {
			return null;
		}
		return (User) list.get(0);
	}

	public boolean addUser(User user) {
		int result = 0;
		String sql = "insert into t_user (user_name,password ,nick_name,gender,address,nation) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = this.dbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickName());
			ps.setString(4, user.getGender().name());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getNation());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}
}
