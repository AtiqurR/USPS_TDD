package com.commonActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonMethods {

	public void hoverOver(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();

	}

	public void clickMethod(WebElement element) {
		element.click();
	}

	public void writeText(WebElement element, String value) {
		element.sendKeys(value);
	}

}
