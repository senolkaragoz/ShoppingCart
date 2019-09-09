package com.trendyol.codility.shoppingcart.enums;

public enum ProductType {

	Apple("apple"), 
	Almond("almond"),
	Jean("jean"),
	Shirt("shirt");
	
	private String title;
	
	private ProductType(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
}
