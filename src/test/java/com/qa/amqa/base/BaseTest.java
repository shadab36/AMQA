package com.qa.amqa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.amqa.factory.DriverFactory;
import com.qa.amqa.pages.AboutUsPage;
import com.qa.amqa.pages.HomePage;
import com.qa.amqa.pages.VirtualTeamPage;

public class BaseTest {

	WebDriver driver;
	protected HomePage homePage;
	protected VirtualTeamPage virtualTeamPage;
	protected AboutUsPage aboutUsPage;

	protected DriverFactory df;
	protected Properties prop;

	protected SoftAssert softAssert;

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setup(String browserName, String browserVersion) {
		df = new DriverFactory();
		prop = df.initProp();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
		}
		driver = df.initDriver(prop);

		homePage = new HomePage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
