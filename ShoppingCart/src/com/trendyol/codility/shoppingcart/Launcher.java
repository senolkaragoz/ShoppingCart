package com.trendyol.codility.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.trendyol.codility.shoppingcart.entity.Campaign;
import com.trendyol.codility.shoppingcart.entity.Category;
import com.trendyol.codility.shoppingcart.entity.Coupon;
import com.trendyol.codility.shoppingcart.entity.Product;
import com.trendyol.codility.shoppingcart.entity.ShoppingCart;
import com.trendyol.codility.shoppingcart.enums.CategoryType;
import com.trendyol.codility.shoppingcart.enums.DiscountType;
import com.trendyol.codility.shoppingcart.enums.ProductType;

public class Launcher {

	public static void main(String[] args) {
		Category food = new Category(CategoryType.Food);

		Product apple = new Product(ProductType.Apple, 100.0, food);
		Product almond = new Product(ProductType.Almond, 150.0, food);
		
		Category clothes = new Category(CategoryType.Clothes);

		Product jean = new Product(ProductType.Jean, 500.0, clothes);
		Product shirt = new Product(ProductType.Shirt, 350.0, clothes);
		
		Campaign campaign1 = new Campaign(food,20.0,3,DiscountType.Rate);
		Campaign campaign2 = new Campaign(food,50.0,5,DiscountType.Rate);
		Campaign campaign3 = new Campaign(clothes,50.0,3,DiscountType.Amount);
		
		List<Campaign> campaigns = new ArrayList<Campaign>();
		campaigns.add(campaign1);
		campaigns.add(campaign2);
		campaigns.add(campaign3);
		
		Coupon coupon = new Coupon(1000, 10, DiscountType.Rate);
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.addItem(apple, 3);
		cart.addItem(almond, 10);
		cart.addItem(jean, 2);
		cart.addItem(shirt, 3);
		
		cart.applyDiscounts(campaigns);
		
		cart.applyCoupon(coupon);
		
		cart.print();
		
		System.out.println("TotalAmountAfterDiscounts: " + cart.getTotalAmountAfterDiscounts());
		
		System.out.println("CouponDiscount: " + cart.getCouponDiscount());
		
		System.out.println("CampaignDiscount: " + cart.getCampaignDiscount());
		
		System.out.println("DeliveryCost:  " + cart.getDeliveryCost());
	}

}
