package com.lubby.bean;

public enum Gender {
	Male("男"), Female("女");

	private String description;

	private Gender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}