package org.web.automation.tescases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Time_ibm {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader filereader = new FileReader("");
		
		Properties property = new Properties();
		
		property.load(filereader);
		
		System.out.println(property.getProperty("chromeBrowser"));
		System.out.println(property.getProperty("firefoxBrowser"));
		System.out.println(property.getProperty("testurl"));
		System.out.println(property.getProperty("email"));
		System.out.println(property.getProperty("password"));
		
		
	}

}
