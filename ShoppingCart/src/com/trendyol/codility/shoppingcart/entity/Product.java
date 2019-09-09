package com.trendyol.codility.shoppingcart.entity;

import com.trendyol.codility.shoppingcart.enums.ProductType;

public class Product {

	private ProductType productType;
	private double price;
	
	private Category category;

	public Product(ProductType productType, double price, Category category) {
		super();
		this.productType = productType;
		this.price = price;
		this.category = category;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
