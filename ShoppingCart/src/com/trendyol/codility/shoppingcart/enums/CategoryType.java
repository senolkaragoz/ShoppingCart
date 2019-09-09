package com.trendyol.codility.shoppingcart.enums;

public enum CategoryType {

	Food("food"),
	Clothes("clothes");
	
	private String title;
	
	private CategoryType(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
}
