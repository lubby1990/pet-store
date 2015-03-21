package com.lubby.bean;

public class User {
	private String userId;
	private String userName;
	private String password;
	private String nickName;
	private Gender gender;
	private String address;
	private String nation;

	public User() {
	}

	public User(String userId, String userName, String password, String nickName, Gender gender, String address,
			String nation) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.gender = gender;
		this.address = address;
		this.nation = nation;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
}
