package com.qa.amqa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amqa.base.BaseTest;
import com.qa.amqa.utils.AppConstants;

public class HomePageTest extends BaseTest {

	@Test
	public void callbackTest() {
		String actSucsMsg = homePage.callbackRequest("test", "9856321254", "Test Automation");
		Assert.assertTrue(actSucsMsg.contains(AppConstants.SERVICE_SUCCESS_MESSG_FRACTION_VALUE));
	}

	@DataProvider
	public Object[][] serviceTestData() {
		return new Object[][] { { "Test Automation" } };

	}

	@Test(dataProvider = "serviceTestData")
	public void automationServiceTest(String service) {
		automationPage = homePage.automationServices();
		String actValue = automationPage.getBreadCrumbValue();
		Assert.assertTrue(actValue.contains(service));
	}
}
