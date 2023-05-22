package com.signInTest;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.signInData.SignInData;

public class SignInTest extends BaseClass {
	
	@DataProvider(name="SignInData")
	public Iterator<SignInData> getSignInData(){
		ArrayList<SignInData> aList=new ArrayList<SignInData>();
		aList.add(new SignInData("anik", "12345"));
		return aList.iterator();
	}
	
	@Test(enabled = false)
	public void signInTest() {
		mPage.mainPageSteps(driver, "______Anik_____", "123456789");
	}
	
	@Test(dataProvider = "SignInData")
	public void signInTest1(SignInData data) {
		mPage.mainPageStepData(driver, data);
	}

}
