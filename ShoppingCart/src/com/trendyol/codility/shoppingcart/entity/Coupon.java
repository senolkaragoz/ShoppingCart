package com.trendyol.codility.shoppingcart.entity;

import com.trendyol.codility.shoppingcart.enums.DiscountType;

public class Coupon extends Discount {

	private double minimumAmount;
	
	public Coupon(double minimumAmount, double discountValue, DiscountType discountType) {
		super(discountType, discountValue);
		this.minimumAmount = minimumAmount;
	}

	public double getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(double minimumAmount) {
		this.minimumAmount = minimumAmount;
	}
	
	
	
}
