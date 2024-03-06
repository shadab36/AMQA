package com.qa.amqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amqa.utils.AppConstants;
import com.qa.amqa.utils.ElementUtil;

public class AboutUsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. constructor of the page class
	public AboutUsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// 2. private By locators:
	private By fullName = By.name("fullname");
	private By emailId = By.name("email");
	private By phoneNumber = By.name("number");
	private By message = By.name("service");
	private By submit = By.xpath("(//button[text()='SUBMIT'])[1]");
	private By successMessg = By.xpath("//div[@class='thank_content msg']/p");

	// 3. public page actions/methods:
	public void sendMessage(String name, String phone, String service) {
//		eleUtil.waitForElementVisible(fullName, AppConstants.MEDIUM_DEFAULT_WAIT);
//		eleUtil.doSendKeys(fullName, name);
//		eleUtil.doSendKeys(emailId, eleUtil.getEmail());
//		eleUtil.doSendKeys(phoneNumber, phone);
//		selectService(service);
//		eleUtil.doClick(submit);
//		return getSuccessMsg();
	}





	

	

	

	

}
