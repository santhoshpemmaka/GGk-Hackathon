package com.GGK;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	public static String getProperties(String key) throws IOException{
		InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties.getProperty(key);
	}

}
