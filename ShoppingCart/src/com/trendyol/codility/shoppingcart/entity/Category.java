package com.trendyol.codility.shoppingcart.entity;

import com.trendyol.codility.shoppingcart.enums.CategoryType;

public class Category {

	private CategoryType categoryType;
	private Category parent;
	
	public Category(CategoryType categoryType) {
		super();
		this.categoryType = categoryType;
	}
	
	
	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	
	
}
