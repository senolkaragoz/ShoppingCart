package com.trendyol.codility.shoppingcart.tests;

import org.junit.Test;

import com.trendyol.codility.shoppingcart.entity.Category;
import com.trendyol.codility.shoppingcart.entity.Product;
import com.trendyol.codility.shoppingcart.entity.ShoppingCart;
import com.trendyol.codility.shoppingcart.enums.CategoryType;
import com.trendyol.codility.shoppingcart.enums.ProductType;
import com.trendyol.codility.shoppingcart.util.DeliveryCostCalculator;

import junit.framework.TestCase;

public class DeliveryCostCalculatorTest extends TestCase {
	
	DeliveryCostCalculator calculator;
	
	Category food;
	Category clothes;
	
	Product apple;
	Product almond;
	Product jean;
	Product shirt;
	
	ShoppingCart cart;	
	
	public DeliveryCostCalculatorTest(){
		super();
	}
	
	public void setUp(){
		calculator = new DeliveryCostCalculator(2.0, 1.5, 2.99);
		
		food = new Category(CategoryType.Food);

		apple = new Product(ProductType.Apple, 100.0, food);
		almond = new Product(ProductType.Almond, 150.0, food);
		
		clothes = new Category(CategoryType.Clothes);

		jean = new Product(ProductType.Jean, 500.0, clothes);
		shirt = new Product(ProductType.Shirt, 350.0, clothes);
		
		cart = new ShoppingCart();
		cart.addItem(apple, 3);
		cart.addItem(almond, 10);
		cart.addItem(jean, 2);
		cart.addItem(shirt, 3);
	}
	
	@Test
	public void calculateFor() {
		assertEquals(0, calculator.calculateFor(null));
		assertEquals(12.99, calculator.calculateFor(cart));
		
	}
	
	@Test
	public void testGetNumberOfDeliveries() {
		assertEquals(0, calculator.getNumberOfDeliveries(null));
		assertEquals(2, calculator.getNumberOfDeliveries(cart));
		
	}
	
	@Test
	public void testGetNumberOfProducts() {
		assertEquals(0, calculator.getNumberOfProducts(null));
		assertEquals(4, calculator.getNumberOfProducts(cart));
		
	}
	
}
