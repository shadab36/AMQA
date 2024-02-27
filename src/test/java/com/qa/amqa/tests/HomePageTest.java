package com.qa.amqa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amqa.base.BaseTest;
import com.qa.amqa.pages.AutomationPage;

public class HomePageTest extends BaseTest {

//	@Test
//	public void callbackTest() {
//		String actSucsMsg = homePage.callbackRequest("test","9856321254", "Test Automation");
//		Assert.assertTrue(actSucsMsg.contains(AppConstants.SERVICE_SUCCESS_MESSG_FRACTION_VALUE));
//	}

	//
	@DataProvider
	public Object[][] servicesTestData() {
		return new Object[][] { { "Test Automation" }, { "Manual Testing" }, { "Performance Testing" },
				{ "Security Testing" }, { "Usability Testing" }, { "Agile Testing" } };
	}

	@Test(dataProvider = "servicesTestData")
	public void serviceTest(String service) {
		System.out.println("service name:-" + service);
		String actValue = homePage.getServiceInfo(service);
		System.out.println("Actual Bread Crumb Value" + actValue);
		Assert.assertTrue(actValue.contains(service));
	}

}
