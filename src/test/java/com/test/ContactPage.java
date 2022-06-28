package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.base.Base;
import com.utils.Utility;

public class ContactPage extends Base{
	@Test
	public void verifyContactPageTitle() {
		dr.findElement(By.xpath("//a[@href='contact.html']")).click();
		String aCPT=dr.getTitle();
		String eCPT="OSA Consulting Tech - Contact for any question.";
		Utility.verify(eCPT, aCPT);
	    
	}

}
