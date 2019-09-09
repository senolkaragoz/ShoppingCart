package com.trendyol.codility.shoppingcart.entity;

import com.trendyol.codility.shoppingcart.enums.DiscountType;

public class Discount {

	private DiscountType discountType;
	private double discountValue;
	
	
	public Discount(DiscountType discountType, double discountValue) {
		super();
		this.discountType = discountType;
		this.discountValue = discountValue;
	}
	
	public double calculateAmountAfterDiscount(double amount){
		double discountAmount = calculateDiscountAmount(amount);
		
		return amount - discountAmount;
	}
	
	public double calculateDiscountAmount(double amount){
		double result = 0;
		if(DiscountType.Rate.equals(discountType)){
			result = calculateDiscountAmountByRate(amount);
		}else if(DiscountType.Amount.equals(discountType)){
			result = discountValue;
		}
		
		return result;
	}
	
	public double calculateDiscountAmountByRate(double amount){
		return amount * discountValue / 100;
	}
	
	public DiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	public double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
}
