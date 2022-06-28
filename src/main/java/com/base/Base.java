package com.base;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.utils.Utility;

public class Base {
	public static HashMap<String,WebDriver>map=new HashMap<String,WebDriver>();
	private static Logger log = Utility.getLog(Base.class);
	public WebDriver dr;

	@BeforeSuite
	public void bSuite() {
		System.out.println(" B Suite ");
	}

	@AfterSuite
	public void aSuite() {
		System.out.println(" A Suite ");
	}

	@BeforeTest
	public void bTest() {
		System.out.println(" B Test ");
	}

	@AfterTest
	public void aTest() {
		System.out.println(" A Test ");
	}

	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browser) {
		dr = Browser.openB(browser);
		String url = "https://www.osaconsultingtech.com/";
		log.info("Navigate to :" + url);
		dr.get(url);
		map.put("driver", dr);
	}

	@AfterMethod
	public void closeBrowser() {
		log.info("We are closing the browser");
		dr.quit();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("+++ The Method is running before Class +++ ");
	}

	@AfterClass
	public void afterClass() {
		System.out.println(" +++ The Method is running After Class +++  ");
	}

}
