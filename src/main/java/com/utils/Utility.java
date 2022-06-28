package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.files.FileManager;

public class Utility {
	private static Logger log = Utility.getLog(Utility.class);
	
	
	@DataProvider(name="username")
	public static Object[][]getdata() {
		//String [][] test1= {{"user1","pass1"},{"user2","pass2"},{"user3","pass3"}};
		    Object [] [] obj=   FileManager.readExcelFile("C:\\Users\\Mohammed D Hossain\\Desktop\\FileRead.xlsx", "Safa");
		return obj;
	}

	public static void verify(String expectedValue, String actualValue) {
		if (expectedValue.equalsIgnoreCase(actualValue)) {
			log.info("The Test is passed");
		} else {
			log.info("The Test is failed");
			log.info("ExpectedValue : " + expectedValue);
			log.info("ActualedValue : " + actualValue);
			Assert.assertEquals(expectedValue, actualValue);
		}
	}

	public static Logger getLog(Class clazz) {
		Logger log = Logger.getLogger(clazz);
		PropertyConfigurator.configure("\\src\\test\\resources\\log4j.properties");
		return log;
	}
	
	public static void takeScreenShot(WebDriver dr,String methodName) {
		try {
			TakesScreenshot ts=((TakesScreenshot)dr);
			File sf=ts.getScreenshotAs(OutputType.FILE);	
		    Calendar calendar = Calendar.getInstance();
			File df=new File(System.getProperty("user.dir")+"\\target\\Images\\"+methodName+"sImage"+calendar.getTimeInMillis()+".png");
			FileUtils.copyFile(sf, df);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
}
	

