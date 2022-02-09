package com.signInTest;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;

public class SignInTest extends BaseClass {
	
	@Test
	public void signInTest() {
		mPage.mainPageSteps(driver, "______Anik_____", "123456789");
	}

}
