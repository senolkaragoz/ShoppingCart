package com.trendyol.codility.shoppingcart.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.trendyol.codility.shoppingcart.enums.CategoryType;
import com.trendyol.codility.shoppingcart.enums.ProductType;
import com.trendyol.codility.shoppingcart.util.DeliveryCostCalculator;

public class ShoppingCart {
	
	private List<Product> items = new ArrayList<Product>();
	private double couponDiscount;
	private double campaignDiscount;
	
	private DeliveryCostCalculator calculator = new DeliveryCostCalculator(2.0, 1.5, 2.99);
	
	public List<Product> getItems() {
		return items;
	}
	
	public void addItem(Product product, int quantity){
		for (int i = 0; i < quantity; i++) {
			items.add(product);
		}		
	}
	
	//applyDiscounts takes list to be dynamic
	public double applyDiscounts(List<Campaign> list){
		HashMap<CategoryType, List<Product>> map = null;
		if(null != list){
			map = getCategoryProductsMap(getItems());
			for (Campaign campaign : list) {
				List<Product> products = map.get(campaign.getCategory().getCategoryType());
				if(null != products){
					if(campaign.getQuantity() <= products.size()){
						double amountOfCategory = getTotalAmountOfProductList(products);
						double discountAmount = campaign.calculateDiscountAmount(amountOfCategory);
						setCampaignDiscount(getCampaignDiscount() + discountAmount);					
					}	
				}						
			}
		}
		return getCampaignDiscount();
	}
	
	public double applyCoupon(Coupon coupon){
		double totalAmountOfCart = getTotalAmountOfProductList(getItems());
		if(totalAmountOfCart >= coupon.getMinimumAmount()){
			double discountedAmount = coupon.calculateDiscountAmount(totalAmountOfCart);
			setCouponDiscount(discountedAmount);
		}
		return getCouponDiscount();
	}
	
	public void print(){
		HashMap<CategoryType, List<Product>> map = getCategoryProductsMap(getItems());
		for (CategoryType categoryType : map.keySet()) {
			List<Product> productListByCategory = map.get(categoryType);
			HashMap<ProductType, List<Product>> productsMap = getProductsMap(productListByCategory);
			for (ProductType productType : productsMap.keySet()) {
				List<Product> products = productsMap.get(productType);
				Product product = products.get(0);
				System.out.println("CategoryName: " + categoryType.getTitle() 
						+ " ProductName: " + product.getProductType().getTitle() 
						+ " Quantity: " + products.size() 
						+ " Unit Price: " + product.getPrice() 
						+ " Total Price: " + getTotalAmountOfProductList(products));
			}
			
		}
	}
	
	public HashMap<CategoryType, List<Product>> getCategoryProductsMap(List<Product> list){
		HashMap<CategoryType, List<Product>> map = null;
		
		if(null != list){
			map = new HashMap<CategoryType, List<Product>>();
			for (Product product : list) {
				CategoryType categoryType = product.getCategory().getCategoryType();
				if(!map.containsKey(categoryType)){
					map.put(categoryType, new ArrayList<Product>());
				}
				map.get(categoryType).add(product);
			}
		}
		
		return map;
	}
	
	public HashMap<ProductType, List<Product>> getProductsMap(List<Product> list){
		HashMap<ProductType, List<Product>> map = null;
		
		if(null != list){
			map = new HashMap<ProductType, List<Product>>();
			for (Product product : list) {
				ProductType productType = product.getProductType();
				if(!map.containsKey(productType)){
					map.put(productType, new ArrayList<Product>());
				}
				map.get(productType).add(product);
			}
		}		
		
		return map;
	}
	
	public double getTotalAmountOfProductList(List<Product> list){
		double result = 0;
		if(null != list){
			for (Product product : list) {
				result += product.getPrice();
			}
		}		
		return result;
	}
	
	public double getDeliveryCost(){		
		return calculator.calculateFor(this);
	}

	public double getTotalAmountAfterDiscounts() {
		double totalAmount = getTotalAmountOfProductList(getItems());
		return totalAmount - getCampaignDiscount() - getCouponDiscount();
	}

	public double getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public double getCampaignDiscount() {
		return campaignDiscount;
	}

	public void setCampaignDiscount(double campaignDiscount) {
		this.campaignDiscount = campaignDiscount;
	}
	
	
}
