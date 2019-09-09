package com.trendyol.codility.shoppingcart.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.trendyol.codility.shoppingcart.entity.Campaign;
import com.trendyol.codility.shoppingcart.entity.Category;
import com.trendyol.codility.shoppingcart.entity.Coupon;
import com.trendyol.codility.shoppingcart.entity.Product;
import com.trendyol.codility.shoppingcart.entity.ShoppingCart;
import com.trendyol.codility.shoppingcart.enums.CategoryType;
import com.trendyol.codility.shoppingcart.enums.DiscountType;
import com.trendyol.codility.shoppingcart.enums.ProductType;

import junit.framework.TestCase;

public class ShoppingCartTest extends TestCase {
	
	Category food;
	Category clothes;
	
	Product apple;
	Product almond;
	Product jean;
	Product shirt;
	
	ShoppingCart cart;
	
	Campaign campaign1;
	Campaign campaign2;
	Campaign campaign3;
	
	List<Campaign> campaigns;
	
	List<Product> oneItemList;
	
	public ShoppingCartTest(){
		super();
	}
	
	public void setUp(){	
		food = new Category(CategoryType.Food);

		apple = new Product(ProductType.Apple, 100.0, food);
		almond = new Product(ProductType.Almond, 150.0, food);
		
		clothes = new Category(CategoryType.Clothes);

		jean = new Product(ProductType.Jean, 500.0, clothes);
		shirt = new Product(ProductType.Shirt, 350.0, clothes);
		
		oneItemList = new ArrayList<Product>();		
		oneItemList.add(apple);		
		
		cart = new ShoppingCart();
		cart.addItem(apple, 3);
		cart.addItem(almond, 10);
		cart.addItem(jean, 2);
		cart.addItem(shirt, 3);
		
		campaign1 = new Campaign(food,20.0,3,DiscountType.Rate);
		campaign2 = new Campaign(food,50.0,5,DiscountType.Rate);
		campaign3 = new Campaign(clothes,50.0,3,DiscountType.Amount);
		
		campaigns = new ArrayList<Campaign>();
		campaigns.add(campaign1);
		campaigns.add(campaign2);
		campaigns.add(campaign3);
	}
	
	@Test
	public void testApplyCoupon() {
		Coupon coupon = new Coupon(1000, 10, DiscountType.Rate);
		
		ShoppingCart cart1 = new ShoppingCart();
		
		assertEquals(0.0,cart1.applyCoupon(coupon));
		
		cart1.addItem(shirt, 3);
		assertEquals(105.0, cart1.applyCoupon(coupon));
		
	}
	
	@Test
	public void testApplyDiscounts() {
		List<Campaign> campaignList1 = new ArrayList<Campaign>();
		
		campaignList1.add(campaign1);
		
		assertEquals(0.0,cart.applyDiscounts(null));
		assertEquals(360.0, cart.applyDiscounts(campaignList1));
		
		ShoppingCart cart1 = new ShoppingCart();
		assertEquals(0.0, cart1.applyDiscounts(campaignList1));
	}
	
	@Test
	public void testGetTotalAmountOfProductList() {
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(apple);
		productList.add(almond);
		productList.add(jean);
		
		assertEquals(0.0,cart.getTotalAmountOfProductList(null));
		assertEquals(100.0, cart.getTotalAmountOfProductList(oneItemList));
		assertEquals(750.0, cart.getTotalAmountOfProductList(productList));
	}
	
	@Test
	public void testGetProductsMap() {
		assertNull(cart.getProductsMap(null));
		assertNotNull(cart.getProductsMap(oneItemList));
	}
	
	@Test
	public void testGetCategoryProductsMap() {
		assertNull(cart.getCategoryProductsMap(null));
		assertNotNull(cart.getCategoryProductsMap(oneItemList));
	}
	
	
	
}
