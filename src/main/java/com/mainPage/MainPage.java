package com.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseClass.BaseClass;
import com.signInData.SignInData;

public class MainPage {

	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath =  "//a[@class='nav-first-element menuitem']")
	public WebElement quickTools;
	@FindBy(xpath = "(//a[@tabindex='-1'])[9]")
	public WebElement informedDelivery;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")
	public WebElement signIn;
	@FindBy(xpath = "//input[@id='username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passWord;
	@FindBy(id = "btn-submit")
	public WebElement signInElement;

	private void quickToolStep(WebDriver driver) {
		BaseClass.cMethods.hoverOver(driver, quickTools);
	}

	private void informedDeliverStep() {
		BaseClass.cMethods.clickMethod(informedDelivery);
	}

	private void signIn() {
		BaseClass.cMethods.clickMethod(signIn);
	}

	private void userNameStep(String value) {
		BaseClass.cMethods.writeText(userName, value);
	}

	private void passWordStep(String value) {
		BaseClass.cMethods.writeText(passWord, value);
	}

	private void signInElement() {
		BaseClass.cMethods.clickMethod(signInElement);
	}

	public void mainPageSteps(WebDriver driver, String userNameInput, String passWordInput) {
		quickToolStep(driver);
		informedDeliverStep();
		signIn();
		userNameStep(userNameInput);
		passWordStep(passWordInput);
		signInElement();
	}
	public void mainPageStepData(WebDriver driver, SignInData data) {
		quickToolStep(driver);
		informedDeliverStep();
		signIn();
		userNameStep(data.getUserName());
		passWordStep(data.getPassWord());
		signInElement();
	}

}
