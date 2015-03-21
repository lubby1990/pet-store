package com.lubby.bean;

public class SingleCat {
	private String name;
	private static SingleCat cat;

	public static synchronized SingleCat getInstance() {
		if (cat == null) {
			cat = new SingleCat();
		}
		return cat;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
