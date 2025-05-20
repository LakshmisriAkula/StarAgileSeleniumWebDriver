package com.testNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TNG_08_Assertions {
	@Test
	public void AssertionTypes() {
		// Hard Assertion
//		System.out.println("A");
//		Assert.assertTrue(4 >= 4);
//		System.out.println("B");
//		assertEquals("Nitin", "Nitin");
//		System.out.println("C");
//		assertTrue(0 > 4);
//		System.out.println("D");

		// Soft Assertion

		SoftAssert sa = new SoftAssert();

		System.out.println("A");
		Assert.assertTrue(4 >= 4);
		System.out.println("B");
		assertEquals("Nitin", "Nitin");
		System.out.println("C");
		sa.assertTrue(0 > 4, "this is not valid condition");
		System.out.println("D");

		sa.assertAll(); // this function acts as bag, keep storing all exception and log into the report
						// at the end.
	}

}
