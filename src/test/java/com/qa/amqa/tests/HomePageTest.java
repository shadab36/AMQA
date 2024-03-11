package com.qa.amqa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amqa.base.BaseTest;
import com.qa.amqa.utils.AppConstants;

public class HomePageTest extends BaseTest {

	@DataProvider
	public Object[][] servicesTestData() {
		return new Object[][] { { "Test Automation" }, { "Manual Testing" }, { "Security Testing" },
				{ "Usability Testing" }, { "Agile Testing" }, { "Mobile Testing" }, { "Cloud Testing" },
				{ "Accessibility Testing" } };
	}

	@Test(dataProvider = "servicesTestData", priority = 1)
	public void serviceTest(String service) {
		System.out.println("service name:-" + service);
		String actValue = homePage.getServiceInfo(service);
		System.out.println("Actual Bread Crumb Value" + actValue);
		Assert.assertTrue(actValue.contains(service));
	}

	@Test(priority = 2)
	public void footerLinksCountTest() {
		int actCount = homePage.getFooterLinksCount();
		Assert.assertEquals(actCount, 22);
	}

	@Test(priority = 3)
	public void callbackTest() {
		String actSucsMsg = homePage.callbackRequest("test", "9856321254", "Test Automation");
		Assert.assertTrue(actSucsMsg.contains(AppConstants.SUCCESS_MESSG_FRACTION_VALUE));
	}
}
