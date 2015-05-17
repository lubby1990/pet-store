package com.lubby.test.impl;

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
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Resource(name = "dbUtil")
	private DBUtil dbUtil;
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<User> getAllUser() {
		List<User> list = new ArrayList();
		User user = null;
		String sql = "select * from t_user";
		try {
			PreparedStatement ps = this.dbUtil.getConnection()
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userId = rs.getString(1);
				String uName = rs.getString(2);
				String uPassword = rs.getString(3);
				String nickName = rs.getString(4);

				String gender = rs.getString(5);
				String address = rs.getString(6);
				String nation = rs.getString(7);
				Gender genderE = StringUtils.isNotBlank(gender) ? null : Gender
						.valueOf(gender);
				user = new User(userId, uName, uPassword, nickName, genderE,
						address, nation);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public User getUserByUserName(String userName) {
		final User user = new User();
		List<User> list = new ArrayList();
		String sql = "select * from t_user where user_name = ? ";
		try {
			// PreparedStatement ps = this.dbUtil.getConnection()
			// .prepareStatement(sql);
			Object[] objs = { userName };
			jdbcTemplate.query(sql, objs, new RowCallbackHandler() {
				public void processRow(ResultSet rs) throws SQLException {
					user.setAddress(rs.getString(6));
					user.setGender(StringUtils.isNotBlank(rs.getString(5)) ? Gender
							.valueOf(rs.getString(5)) : null);
					user.setNation(rs.getString(7));
					user.setNickName(rs.getString(4));
					user.setPassword(rs.getString(3));
					user.setUserId(rs.getString(1));
					user.setUserName(rs.getString(2));
				}

				/*
				 * ,new RowMapper() {
				 * 
				 * public Object mapRow(ResultSet rs, int rowNum) throws
				 * SQLException { User getUser = new User();
				 * getUser.setAddress(rs.getString(6));
				 * getUser.setGender(StringUtils.isNotBlank(rs.getString(5)) ?
				 * Gender .valueOf(rs.getString(5)) : null);
				 * getUser.setNation(rs.getString(7));
				 * getUser.setNickName(rs.getString(4));
				 * getUser.setPassword(rs.getString(3));
				 * getUser.setUserId(rs.getString(1));
				 * getUser.setUserName(rs.getString(2)); return getUser; }
				 */
			});
			/*
			 * ps.setString(1, userName);
			 * 
			 * ResultSet rs = ps.executeQuery(); while (rs.next()) { String
			 * userId = rs.getString(1); String uName = rs.getString(2); String
			 * uPassword = rs.getString(3); String nickName = rs.getString(4);
			 * 
			 * String gender = rs.getString(5); String address =
			 * rs.getString(6); String nation = rs.getString(7); Gender genderE
			 * = StringUtils.isNotBlank(gender) ? Gender .valueOf(gender) :
			 * null; user = new User(userId, uName, uPassword, nickName,
			 * genderE, address, nation); list.add(user); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		// if (list.size() == 0) {
		// return null;
		// }
		// return (User) list.get(0);
		return user.getUserId() == null ? null : user;
	}

	public User getUserByUserNameAndPassWord(String userName, String password) {
		User user = null;
		List<User> list = new ArrayList();
		String sql = "select * from t_user where user_name = ? and password = ?";
		try {
			PreparedStatement ps = this.dbUtil.getConnection()
					.prepareStatement(sql);
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
				Gender genderE = StringUtils.isNotBlank(gender) ? null : Gender
						.valueOf(gender);
				user = new User(userId, uName, uPassword, nickName, genderE,
						address, nation);
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

	public int addUser(User user) {
		int result = 0;
		String sql = "insert into t_user (user_name,password ,nick_name,gender,address,nation) values(?,?,?,?,?,?)";
		// Connection conn = dbUtil.getConnection();
		try {
			// conn.setAutoCommit(false);
			// PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setString(1, user.getUserName());
			// ps.setString(2, user.getPassword());
			// ps.setString(3, user.getNickName());
			// ps.setString(4, user.getGender().name());
			// ps.setString(5, user.getAddress());
			// ps.setString(6, user.getNation());
			Object[] ojbs = { user.getUserName(), user.getPassword(),
					user.getNickName(), user.getGender().name(),
					user.getAddress(), user.getNation() };

			// result = ps.executeUpdate();
			// conn.commit();
			result = jdbcTemplate.update(sql, ojbs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public User getUserByUserNameAndPassWord(Map<String, String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}
}
