package com.trendyol.codility.shoppingcart.tests;

import org.junit.Test;

import com.trendyol.codility.shoppingcart.entity.Discount;
import com.trendyol.codility.shoppingcart.enums.DiscountType;

import junit.framework.TestCase;

public class DiscountTest extends TestCase {
	
	Discount discountRate;
	Discount discountAmount;
	
	public DiscountTest(){
		super();
	}
	
	public void setUp(){		
		discountRate = new Discount(DiscountType.Rate, 20.0);
		discountAmount = new Discount(DiscountType.Amount, 20.0);
	}
	
	@Test
	public void testCalculateAmountAfterDiscountForDiscountRate() {
		assertEquals(800.0, discountRate.calculateAmountAfterDiscount(1000));
	}
	
	@Test
	public void testCalculateAmountAfterDiscountForDiscountAmount() {
		assertEquals(980.0, discountAmount.calculateAmountAfterDiscount(1000));
	}
	
	@Test
	public void testCalculateDiscountAmountForDiscountRate() {
		assertEquals(200.0, discountRate.calculateDiscountAmount(1000));
	}
	
	@Test
	public void testCalculateDiscountAmountForDiscountAmount() {
		assertEquals(20.0, discountAmount.calculateDiscountAmount(1000));
	}

	@Test
	public void testCalculateDiscountAmountByRateForDiscountRate() {
		assertEquals(200.0, discountRate.calculateDiscountAmountByRate(1000));
	}
	
	
}
