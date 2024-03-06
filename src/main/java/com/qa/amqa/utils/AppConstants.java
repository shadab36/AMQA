package com.qa.amqa.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE_VALUE = "My Account";

	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "route=account/login";

	public static final int SHORT_DEFAULT_WAIT = 5;
	public static final int MEDIUM_DEFAULT_WAIT = 10;
	public static final int LONG_DEFAULT_WAIT = 20;

	public static final List<String> EXP_BILLING_CYCLE_LIST = Arrays.asList("Hourly", "Monthly", "Weekly",
			"Fixed Budget");

	public static final String LOGIN_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
	public static final String SUCCESS_MESSG_FRACTION_VALUE = "Your form successfully submitted";

	// ******************Sheet Names*****************//
	public static final String REGISTER_SHEET_NAME = "register";
	public static final List<String> EXP_QA_CATEGORY_LIST = Arrays.asList("Test Automation", "Manual Testing",
			"Security Testing", "Usability Testing", "Agile Testing", "Mobile Testing", "Cloud Testing",
			"Accessibility Testing");
	public static final List<String> EXP_LEVEL_LIST = Arrays.asList("Beginner", "Intermediate", "Expert");

}
