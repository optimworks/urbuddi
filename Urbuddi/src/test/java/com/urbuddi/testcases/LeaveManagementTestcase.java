package com.urbuddi.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.urbuddi.steps.UrbuddiSteps;
import com.urbuddi.utilities.RoleCredsLoader;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.util.EnvironmentVariables;

@RunWith(SerenityRunner.class)
public class LeaveManagementTestcase {
	@Managed
	WebDriver driver;

	@Steps
	UrbuddiSteps urbuddy;

	EnvironmentVariables environment = ConfiguredEnvironment.getEnvironmentVariables();
	RoleCredsLoader memberCredentials = new RoleCredsLoader(environment);

	Faker faker = new Faker();
	String reason = "Request For Reason" + faker.lorem().sentence();

	String[] roles = { "hr", "lead", "employee" };

	private String username;
	private String password;
	private String lusername, ausername;

	@Title("Apply leave for a day")
	@Test
	public void applyLeave() {
		for (String roleName : roles) {
			username = memberCredentials.getUsername(roleName);
			password = memberCredentials.getPassword(roleName);

			lusername = memberCredentials.getUsername("lead");
			ausername = memberCredentials.getUsername("admin");

			System.out.println(lusername);
			System.out.println(ausername);

			urbuddy.launchURL();
			urbuddy.verifyIsLoginPageDisplayed();
			urbuddy.inputCredentials(username, password);
			urbuddy.clickOnLoginButton();
			urbuddy.verifyIsHomePageDisplayed();
			urbuddy.goToYourProfile();
			urbuddy.verifyIsProfilePageDisplayed();
			urbuddy.goToEmploymentDetails();
			urbuddy.verifyAreEmploymentDetailsDisplayed();
			String Role = urbuddy.getRole();
			urbuddy.goToLeaveManagementMenu();
			urbuddy.verifyIsLeaveManagementPageDisplayed();
			urbuddy.clickOnApplyLeave();
			urbuddy.handleLeaveWarningClickOk();
			urbuddy.selectDate();

			if ("Employee".equals(Role)) {
				urbuddy.selectLead(lusername);
			} else if ("HR".equals(Role)) {
				urbuddy.selectLead(ausername);
			} else if ("Lead".equals(Role)) {
				urbuddy.selectLead(ausername);
			}

			urbuddy.inputReasonForRequest(reason);
			urbuddy.selectLeaveRequestType();
			urbuddy.clickOnSubmitButton();
			urbuddy.clickOnLogoutButton();
			urbuddy.verifyIsLoginPageDisplayed();
		}
	}
}
