package com.lubby.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.lubby.bean.Account;
import com.lubby.bean.Gender;
import com.lubby.bean.User;
import com.lubby.dao.AccountDAO;
import com.lubby.dao.UserDAO;
import com.lubby.db.DBUtil;

/**
 * @author Lubby
 * @date 2015年3月26日 下午1:48:58
 *
 */
@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@Resource(name = "dbUtil")
	private DBUtil dbUtil;

	public boolean addAccount(Account account) {
		String sql = "insert into t_account (user_id,cash) values(?,?)";
		int result = 0;
		PreparedStatement ps;
		try {
			ps = this.dbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, account.getUserId());
			ps.setLong(2, account.getCash());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result == 1;
	}

	public Account getAccountByUserId(String userId) {
		List<Account> list = new ArrayList();
		String sql = "select * from t_account where user_id = ?";
		try {
			PreparedStatement ps = this.dbUtil.getConnection()
					.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String accountId = rs.getString(1);
				String userid = rs.getString(2);
				long cash = rs.getLong(3);
				Account account = new Account(accountId, userid, cash);
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	public Account getAccountByAccountId(String accountId) {
		List<Account> list = new ArrayList();
		String sql = "select * from t_account where t_account_id = ?";
		try {
			PreparedStatement ps = this.dbUtil.getConnection()
					.prepareStatement(sql);
			ps.setString(1, accountId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String accountid = rs.getString(1);
				String userId = rs.getString(2);
				long cash = rs.getLong(3);
				Account account = new Account(accountId, userId, cash);
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	public List<Account> getAllAccount() {
		List<Account> list = new ArrayList();
		String sql = "select * from t_account";
		try {
			PreparedStatement ps = this.dbUtil.getConnection()
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String accountId = rs.getString(1);
				String userId = rs.getString(2);
				long cash = rs.getLong(3);
				Account account = new Account(accountId, userId, cash);
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
