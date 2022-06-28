package com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.base.Base;
import com.files.FileManager;
import com.utils.Utility;

public class HomePage extends Base {
	@Test (priority=3)
	public void test1VerifyHomePageTitle() {
		String ahpt=dr.getTitle();
		String ehpt="OSA Consulting Tech Corp || Best Available Resources For Software Industry";
		Utility.verify(ehpt, ahpt);
		}
	@Test (priority=2)
	public void test2VerifyForumPageTitle() {
		dr.findElement(By.xpath("//a[text()='Forum']")).click();
		String afpt=dr.getTitle();
		String efpt="OSA Consulting Tech - All the projects.";
		Utility.verify(efpt, afpt);
		}
	@Test(dataProvider="username",dataProviderClass=Utility.class)
	public void Test3VerifyForumLogin(String user,String pass) throws IOException, InterruptedException  {
		dr.findElement(By.xpath("//a[text()='Forum']")).click();
		dr.findElement(By.id("username")).sendKeys(user);
		dr.findElement(By.name("password")).sendKeys(pass);
		dr.findElement(By.id("login_button")).click();
		Thread.sleep(10000);
	//	String aspt=dr.getTitle();
	//	String espt="OSA Consulting Tech - All the projects.";
		//Utility.verify(espt, aspt);
	}
	

}
