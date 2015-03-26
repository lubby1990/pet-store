package com.lubby.dao;

import java.util.List;

import com.lubby.bean.Account;

/**
 *     @author Lubby
 *     @date 2015年3月26日  下午1:39:24
 *
 */

public interface AccountDAO {
	public boolean addAccount(Account account);
	public Account getAccountByUserId(String userId);
	public Account getAccountByAccountId(String accountId);
	public List<Account> getAllAccount();
	public boolean updateAccount(Account account);

}
