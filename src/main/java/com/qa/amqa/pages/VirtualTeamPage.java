package com.qa.amqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.amqa.utils.AppConstants;
import com.qa.amqa.utils.ElementUtil;

public class VirtualTeamPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. constructor of the page class
	public VirtualTeamPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// 2. by locators:
	private By duration = By.id("duration");
	private By billingCycle = By.name("billingCycle");
	private By amount = By.xpath("//input[contains(@placeholder,'amount')]");
	private By qaCategory = By.cssSelector(".form-select.shadow-sm.rounded-1.category");
	private By level = By.name("level[]");
	private By teamLength = By.xpath("//input[contains(@name,'member')]");
	private By fullName = By.name("fullname");
	private By emailId = By.name("email");
	private By phoneNumber = By.name("number");
	private By submitBtn = By.id("virtualTeamSubmit");
	private By successMessg = By.xpath("//div[@class='thank_content msg']/p");

	// 3. page actions:
	public String createVirtualQATeam(String time, String billing, String payAmount, String qaType, String levelOption,
			String teamSize, String name, String email, String phone) {
		enterDuration(time);
		selectBillingCycle(billing);
		enterAmount(payAmount);
		selectQACategory(qaType);
		selectLevel(levelOption);
		enterTeamSize(teamSize);
		eleUtil.doSendKeys(fullName, name);
		eleUtil.doSendKeys(emailId, email);
		eleUtil.doSendKeys(phoneNumber, phone);
		eleUtil.doClick(submitBtn);
		return getSuccessMsg();
	}

	private void enterDuration(String value) {
		if (doNumberFormatCheck(value)) {
			eleUtil.doSendKeys(duration, value);
		} else {
			System.out.println("please provide duration in numeric format");
		}
	}

	private void selectBillingCycle(String billType) {
		if (AppConstants.EXP_BILLING_CYCLE_LIST.contains(billType)) {
			eleUtil.doSelectDropDownByVisibleText(billingCycle, billType);
		} else {
			System.out.println("Please enter valid billing cycle type...");
		}
	}

	private void enterAmount(String value) {
		if (doNumberFormatCheck(value)) {
			eleUtil.doSendKeys(amount, value);
		} else {
			System.out.println("please provide amount in numeric format");
		}
	}

	private void selectQACategory(String type) {
		if (AppConstants.EXP_QA_CATEGORY_LIST.contains(type)) {
			eleUtil.doSelectDropDownByVisibleText(qaCategory, type);
		} else {
			System.out.println("Please enter valid QA category type...");
		}
	}

	private void selectLevel(String levelType) {
		if (AppConstants.EXP_LEVEL_LIST.contains(levelType)) {
			eleUtil.doSelectDropDownByVisibleText(level, levelType);
		} else {
			System.out.println("Please enter valid level type...");
		}
	}

	private void enterTeamSize(String size) {
		if (doNumberFormatCheck(size)) {
			eleUtil.doSendKeys(teamLength, size);
		} else {
			System.out.println("please provide duration in numeric format");
		}
	}

	private boolean doNumberFormatCheck(String value) {
		String regex = "\\d+";
		if (value.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	public String getPageUrl() {
		return eleUtil.waitForURLContainsAndCapture("virtual-team", AppConstants.MEDIUM_DEFAULT_WAIT);
	}

	private String getSuccessMsg() {
		String successMsg = eleUtil.doGetElementText(successMessg);
		System.out.println("success message:" + successMsg);
		return successMsg;
	}
}
