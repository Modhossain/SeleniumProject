package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	
	//@Test
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Driver\\chromedriver.exe");
	     WebDriver dr= new ChromeDriver();
	     dr.get("https://www.osaconsultingtech.com/");
	    TakesScreenshot shot= ((TakesScreenshot)dr);
	   File file= shot.getScreenshotAs(OutputType.FILE);
	    File files=new File(System.getProperty("user.dir")+"\\target\\Images\\image1.png");
	    FileUtils.copyFile(file, files);
	
	}

}
