package com.lsantana.CucumberSelenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;

	static {
		try {
			properties = new Properties();
			FileInputStream file = new FileInputStream("src/test/resources/config.properties");
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties");
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
