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
public class NewLoginTestCase {

	@Managed
	WebDriver driver;

	@Steps
	UrbuddiSteps urbuddy;

	EnvironmentVariables environment = ConfiguredEnvironment.getEnvironmentVariables();
	RoleCredsLoader memberCredentials = new RoleCredsLoader(environment);

	String[] roles = { "admin", "hr", "lead", "employee" };

	private String username;
	private String password;

	Faker faker = new Faker();
	private String iusername = faker.name().firstName().toLowerCase() + "@yopmail.com";
	private String ipassword = "Password" + faker.number().numberBetween(1, 1000);

	@Title("Login with valid credentials")
	@Test
	public void loginWithValidCreds() {
		for (String roleName : roles) {
			username = memberCredentials.getUsername(roleName);
			password = memberCredentials.getPassword(roleName);

			System.out.println("Role: " + roleName);
			System.out.println("Username: " + username);
			System.out.println("Password: " + password);

			urbuddy.launchURL();
			urbuddy.verifyIsLoginPageDisplayed();
			urbuddy.inputCredentials(username, password);
			urbuddy.clickOnLoginButton();
			urbuddy.verifyIsHomePageDisplayed();
			urbuddy.goToYourProfile();
			urbuddy.verifyIsProfilePageDisplayed();
			urbuddy.goToEmploymentDetails();
			urbuddy.verifyAreEmploymentDetailsDisplayed();

			if (urbuddy.getRole() == "Admin") {
				urbuddy.verifyAdminMenuItems();
			} else if (urbuddy.getRole() == "HR") {
				urbuddy.verifyHRMenuItems();
			} else if (urbuddy.getRole() == "Lead") {
				urbuddy.verifyLeadMenuItems();
			} else if (urbuddy.getRole() == "Employee") {
				urbuddy.verifyEmployeeMenuItems();
			}
			urbuddy.clickOnLogoutButton();
			urbuddy.verifyIsLoginPageDisplayed();
		}
	}

	@Title("Login with empty creds")
	@Test
	public void loginWithEmptyCreds() {
		urbuddy.launchURL();
		urbuddy.verifyIsLoginPageDisplayed();
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsRequiredTextDisplayed();
	}

	@Title("Login with invalid creds")
	@Test
	public void loginWithInvalidCreds() {
		urbuddy.launchURL();
		urbuddy.verifyIsLoginPageDisplayed();
		urbuddy.inputCredentials(iusername, ipassword);
		urbuddy.clickOnLoginButton();
		urbuddy.verifyIsInvalidCredTextDisplayed();
	}

}