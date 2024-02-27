package com.qa.amqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amqa.utils.ElementUtil;

public class AutomationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By breadCrumb = By.xpath("//li[@class='breadcrumb-item active']");

	public AutomationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	public String getBreadCrumbValue() {
		String text = eleUtil.doGetElementText(breadCrumb);
		System.out.println(text);
		return text;
	}
	
	
	
	
}
