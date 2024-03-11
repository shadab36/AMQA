package com.qa.amqa.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.amqa.base.BaseTest;
import com.qa.amqa.pages.VirtualTeamPage;
import com.qa.amqa.utils.AppConstants;

public class VirtualTeamPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		virtualTeamPage = homePage.navigateToVirtualQAPage();
	}

	@Test
	public void virtualTeamTest() {
		String actSucsMsg = virtualTeamPage.createVirtualQATeam("10", "Monthly", "10", "Agile Testing", "Beginner",
				"10", "test", "test@gmail.com", "8956231254");
		Assert.assertTrue(actSucsMsg.contains(AppConstants.SUCCESS_MESSG_FRACTION_VALUE));
	}

	@Test
	public void virtualTeamPageUrlTest() {
		String url = virtualTeamPage.getPageUrl();
		Assert.assertTrue(url.contains("virtual-team"));
	}
}
