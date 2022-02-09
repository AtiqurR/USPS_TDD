package usps.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class ConfigSingleToneClass {

	static ConfigSingleToneClass config;
	private String path = "./configuration/config.properties";
	private Properties properties;
	private String url;
	private int pageLoadWait;
	private int implicitWait;

	private ConfigSingleToneClass() {

	}

	public static ConfigSingleToneClass getInstance() {
		if (config == null) {
			config = new ConfigSingleToneClass();
		}
		config.loadProperties();
		return config;
	}

	private void loadProperties() {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(path);
			properties = new Properties();
			properties.load(fileInputStream);
			url = properties.getProperty("url");
			try {
				pageLoadWait = Integer.parseInt(properties.getProperty("pageLoadWait"));
				implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				Assert.fail();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String getUrl() {
		return url;
	}

	public int getPageLoadWait() {
		return pageLoadWait;
	}

	public int getImplicitWait() {
		return implicitWait;
	}

}
