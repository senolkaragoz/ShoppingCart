package com.trendyol.codility.shoppingcart.util;

import java.util.HashMap;
import java.util.List;

import com.trendyol.codility.shoppingcart.entity.Product;
import com.trendyol.codility.shoppingcart.entity.ShoppingCart;
import com.trendyol.codility.shoppingcart.enums.CategoryType;
import com.trendyol.codility.shoppingcart.enums.ProductType;

public class DeliveryCostCalculator {

	private double costPerDelivery;
	private double costPerProduct;
	private double fixedCost;	
	
	public DeliveryCostCalculator(double costPerDelivery, double costPerProduct, double fixedCost) {
		super();
		this.costPerDelivery = costPerDelivery;
		this.costPerProduct = costPerProduct;
		this.fixedCost = fixedCost;
	}

	public double calculateFor(ShoppingCart cart){
		double result = 0;
		if(null != cart){
			result = (costPerDelivery * getNumberOfDeliveries(cart)) 
					+ (costPerProduct * getNumberOfProducts(cart))
					+ fixedCost; 
		}		
		
		return result;
	}
	
	public int getNumberOfDeliveries(ShoppingCart cart){
		int result = 0;
		if(null != cart){
			HashMap<CategoryType, List<Product>> map = cart.getCategoryProductsMap(cart.getItems());
			result = map.keySet().size();
		}
		return result;
	}
	
	public int getNumberOfProducts(ShoppingCart cart){
		int result = 0;
		if(null != cart){
			HashMap<CategoryType, List<Product>> map = cart.getCategoryProductsMap(cart.getItems());
			for (CategoryType categoryType : map.keySet()) {
				List<Product> productListByCategory = map.get(categoryType);
				HashMap<ProductType, List<Product>> productsMap = cart.getProductsMap(productListByCategory);
				result += productsMap.keySet().size();
			}
		}		
		return result;
	}
	
	public double getCostPerDelivery() {
		return costPerDelivery;
	}

	public void setCostPerDelivery(double costPerDelivery) {
		this.costPerDelivery = costPerDelivery;
	}

	public double getCostPerProduct() {
		return costPerProduct;
	}

	public void setCostPerProduct(double costPerProduct) {
		this.costPerProduct = costPerProduct;
	}

	public double getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(double fixedCost) {
		this.fixedCost = fixedCost;
	}
	
	
}
