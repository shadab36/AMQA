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
	private By contactUsBtn = By.xpath("//a[text()='contact us']");
	private By fullName = By.name("fullname");
	private By emailId = By.name("email");
	private By phoneNumber = By.name("number");
	private By message = By.name("message");
	private By submit = By.id("contactSubmit");
	private By successMessg = By.xpath("//div[@class='thank_content msg']/p");

	// 3. public page actions/methods:
	public String sendMessage(String name, String phone, String msg) {
		eleUtil.doClick(contactUsBtn);
		eleUtil.doSendKeys(fullName, name);
		eleUtil.doSendKeys(emailId, eleUtil.getEmail());
		eleUtil.doSendKeys(phoneNumber, phone);
		eleUtil.doSendKeys(message, msg);
		eleUtil.doClick(submit);
		return getSuccessMsg();
	}
	
	private String getSuccessMsg() {
		String successMsg = eleUtil.doGetElementText(successMessg);
		System.out.println("success message:" + successMsg);
		return successMsg;
	}
}