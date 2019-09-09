package com.trendyol.codility.shoppingcart.entity;

import com.trendyol.codility.shoppingcart.enums.DiscountType;

public class Campaign extends Discount {

	private Category category;
	private int quantity;
	
	public Campaign(Category category, double discountValue, int quantity, DiscountType discountType) {
		super(discountType, discountValue);
		this.category = category;
		this.quantity = quantity;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
