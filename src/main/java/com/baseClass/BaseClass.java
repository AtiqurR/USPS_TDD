package com.baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.commonActions.CommonMethods;
import com.commonActions.CommonWaits;
import com.mainPage.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import usps.qa.utilities.ConfigSingleToneClass;

public class BaseClass {

	public WebDriver driver;
	public static WebDriverWait wait;
	public MainPage mPage;
	public static CommonMethods cMethods;
	public static CommonWaits cWaits;
	public ConfigSingleToneClass config;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		initializedMethods();
		driver.get(config.getUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(config.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
	

	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

	public void initializedMethods() {
		mPage = new MainPage(driver);
		wait = new WebDriverWait(driver, 20);
		cMethods = new CommonMethods();
		cWaits = new CommonWaits();
		config = ConfigSingleToneClass.getInstance();
	}

}
