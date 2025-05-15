package com.testNG;

import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class TNG_01_FirstScripts extends BaseFunction{

	// testng class doesn't have main function.

	@Test
	public void testA() {
		System.out.println("TestA ");
	}

	@Test
	public void testB() {
		System.out.println("TestB");
	}

	@Test
	public void testC() {
		System.out.println("TestC");
	}

	@Test
	public void testD() {
		System.out.println("TestD");
	}

}
