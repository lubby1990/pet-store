package com.lubby.bean;

/**
 * @author Lubby
 * @date 2015年3月26日 下午1:38:13
 *
 */

public class Account {
	private String accountId;
	private String userId;
	private long cash;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountId, String userId) {
		super();
		this.accountId = accountId;
		this.userId = userId;
	}
	public Account(String accountId, String userId, long cash) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.cash = cash;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getCash() {
		return cash;
	}
	public void setCash(long cash) {
		this.cash = cash;
	}

	

}
