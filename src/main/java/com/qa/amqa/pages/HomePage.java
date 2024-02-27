package com.qa.amqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amqa.utils.AppConstants;
import com.qa.amqa.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. const. of the page class
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// 2. private By locators:
	private By fullName = By.name("fullname");
	private By emailId = By.name("email");
	private By phoneNumber = By.name("number");
	private By service = By.name("service");
	private By submit = By.xpath("(//button[text()='SUBMIT'])[1]");
	private By successMessg = By.xpath("//div[@class='thank_content msg']/p");
	private By servicesrLink = By.xpath("//li[@class='web-display ']/a");
	private By automationService = By.linkText("Test Automation");

	// 3. public page actions/methods:
	public String callbackRequest(String name, String phone, String service) {
		eleUtil.waitForElementVisible(fullName, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(fullName, name);
		eleUtil.doSendKeys(emailId, getEmail());
		eleUtil.doSendKeys(phoneNumber, phone);
		selectService(service);
		eleUtil.doClick(submit);
		String successMsg = eleUtil.doGetElementText(successMessg);
		System.out.println("success message:" + successMsg);
		return successMsg;
	}

	private void selectService(String serviceText) {
		eleUtil.doSelectDropDownByVisibleText(service, serviceText);
	}

	private String getEmail() {
		// String email "testautomation" + UUID.randomUUID() + "@gmail.com";
		String email = "test" + System.currentTimeMillis() + "@gmail.com";
		System.out.println("Email:" + email);
		return email;
	}

	Object page;

	public Object automationServices(String service) {
		navigateToServicesMenu();
		String serviceExp = service.toLowerCase();

		if (service.equalsIgnoreCase("Test Automation")) {
			eleUtil.doClick(automationService);
			page = new AutomationPage(driver);
		}
		return page;

	}

	private void navigateToServicesMenu() {
		eleUtil.doClick(servicesrLink);

	}

//
//	@Step("getting login page url")
//	public String getLoginPageURL() {
//		return eleUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE,
//				AppConstants.SHORT_DEFAULT_WAIT);
//	}
//
//	public List<String> getFooterLinksList() {
//		List<WebElement> footerLinksList = eleUtil.waitForElementsVisible(footerLinks,
//				AppConstants.MEDIUM_DEFAULT_WAIT);
//		List<String> footerTextList = new ArrayList<String>();
//		for (WebElement e : footerLinksList) {
//			String text = e.getText();
//			footerTextList.add(text);
//		}
//		return footerTextList;
//	}

}