package com.qa.amqa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amqa.base.BaseTest;
import com.qa.amqa.utils.AppConstants;
import com.qa.amqa.utils.ExcelUtil;

public class AboutUsPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		aboutUsPage = homePage.navigateToAboutUsPage();
	}

	public String getRandomEmailID() {
		return "testautomation" + System.currentTimeMillis() + "@gmail.com";
		// return "testautomation" + UUID.randomUUID()+"@gmail.com";

	}

	@Test
	public void contactUsMsgTest() {
		
	}

}
