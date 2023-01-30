package web.automation.testcases;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {
	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) throws Exception {
		// 1. load data from properties file
		// location
		String propFilePath = "./ConfigFiles/config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		// 2. read data
		String value = prop.get(key).toString();
		return value;
	}
}
