package com.qa.amqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amqa.utils.AppConstants;
import com.qa.amqa.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. constructor of the page class
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
	private By servicesLink = By.xpath("//nav[@id='navbar']//a");
	private By breadCrumb = By.xpath("//li[@class='breadcrumb-item active']");
	private By footerLinks = By.xpath("//footer//div[@class='container py-lg-5 py-3 mid-footer']//a");
	private By virtualTeam = By.xpath("//nav[@id='navbar']//a[text()=' Virtual Team']");
	private By aboutUs = By.xpath("//nav[@id='navbar']//a[text()=' About']");
	
	// 3. public page actions/methods:
	public String callbackRequest(String name, String phone, String service) {
		eleUtil.waitForElementVisible(fullName, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(fullName, name);
		eleUtil.doSendKeys(emailId, eleUtil.getEmail());
		eleUtil.doSendKeys(phoneNumber, phone);
		selectService(service);
		eleUtil.doClick(submit);
		return getSuccessMsg();
	}

	private String getSuccessMsg() {
		String successMsg = eleUtil.doGetElementText(successMessg);
		System.out.println("success message:" + successMsg);
		return successMsg;
	}

	private void selectService(String serviceText) {
		eleUtil.doSelectDropDownByVisibleText(service, serviceText);
	}

	public String getServiceInfo(String service) {
		String value = null;
		navigateToServicesMenu();
		System.out.println("service in page class:" + service);
		By serviceLocator = By.linkText(service);
		eleUtil.doClick(serviceLocator);
		value = getBreadCrumbValue();
		return value;
	}

	private void navigateToServicesMenu() {
		eleUtil.doClick(servicesLink);

	}

	public String getBreadCrumbValue() {
		String text = eleUtil.doGetElementText(breadCrumb);
		System.out.println("Bread crum value in page class" + text);
		return text;
	}

	public int getFooterLinksCount() {
		return eleUtil.getElementsCount(footerLinks);
	}

	public VirtualTeamPage navigateToVirtualQAPage() {
		eleUtil.doClick(virtualTeam);
		return new VirtualTeamPage(driver);

	}

	public AboutUsPage navigateToAboutUsPage() {
		eleUtil.doClick(aboutUs);
		return new AboutUsPage(driver);
	}
}